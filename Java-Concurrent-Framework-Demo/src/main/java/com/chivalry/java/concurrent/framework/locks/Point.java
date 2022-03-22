package com.chivalry.java.concurrent.framework.locks;

import java.util.concurrent.locks.StampedLock;

/**
 * 基于Java Lock API {@link StampedLock} examples class
 *
 * @author Mr.zxb
 * @date 2022-03-22 14:55
 */
public class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    /**
     * an exclusively locked method
     * @param deltaX
     * @param deltaY
     */
    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * a read-only method
     * upgrade from optimistic read to read lock
     * @return
     */
    double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        try {
            for (; ; stamp = sl.readLock()) {
                if (stamp == 0L) {
                    continue;
                }

                // possibly racy reads
                double currentX = x;
                double currentY = y;
                if (!sl.validate(stamp)) {
                    continue;
                }
                return Math.hypot(currentX, currentY);
            }
        } finally {
            // since 10
            if (StampedLock.isReadLockStamp(stamp)) {
                sl.unlockRead(stamp);
            }
        }
    }

    /**
     * upgrade from optimistic read to write lock
     * @param newX
     * @param newY
     */
    void moveIfAtOriginOptimistic(double newX, double newY) {
        long stamp = sl.tryOptimisticRead();
        try {
            for (; ; stamp = sl.writeLock()) {
                if (stamp == 0L) {
                    continue;
                }
                // possibly racy reads
                double currentX = x;
                double currentY = y;
                if (!sl.validate(stamp)) {
                    continue;
                }
                if (currentX != 0.0 || currentY != 0.0) {
                    break;
                }
                stamp = sl.tryConvertToWriteLock(stamp);
                if (stamp == 0L) {
                    continue;
                }
                // exclusive access
                x = newX;
                y = newY;
            }
        } finally {
            if (StampedLock.isWriteLockStamp(stamp)) {
                sl.unlockWrite(stamp);
            }
        }
    }

    /**
     * Upgrade read lock to write lock
     * @param newX
     * @param newY
     */
    void moveIfAtOrigin(double newX, double newY) {
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }
                else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}
