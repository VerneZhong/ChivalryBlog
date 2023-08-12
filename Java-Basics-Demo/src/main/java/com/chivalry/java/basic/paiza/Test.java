package com.chivalry.java.basic.paiza;

import java.util.Scanner;

/**
 * @author verne.zhong
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 入力された情報を配列や変数に格納
        int N = sc.nextInt(); // 予約済みの座席数
        int H = sc.nextInt(); // 座席の縦の数
        int W = sc.nextInt(); // 座席の横の数
        int P = sc.nextInt(); // 最も見やすい席のp座標
        int Q = sc.nextInt(); // 最も見やすい席のq座標

        boolean[][] reserved = new boolean[H][W];
        for (int i = 0; i < N; i++) {
            int p = sc.nextInt(); //　予約済みの座席のp座標
            int q = sc.nextInt(); // 予約済みの座席のq座標
            reserved[p][q] = true;
        }
        sc.close();

        int max = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            for (int i1 = 0; i1 < W; i1++) {
                // 予約されていない場合
                if (!reserved[i][i1]) {
                    // マンハッタン距離を計算する
                    int dist = calculateManhattanDistance(i, i1, P, Q);
                    // 最小距離より小さい場合
                    if (dist < max) {
                        // 最小距離を更新する
                        max = dist;
                    }
                }
            }
        }

        // 最も見やすい席とのマンハッタン距離が最小となる席を探索し、出力する
        for (int i = 0; i < H; i++) {
            for (int i1 = 0; i1 < W; i1++) {
                if (!reserved[i][i1]) {
                    // マンハッタン距離を計算する
                    int dist = calculateManhattanDistance(i, i1, P, Q);
                    // 最小距離と等しい場合
                    if (dist == max) {
                        // 座標を出力する
                        System.out.println(i + " " + i1);
                    }
                }
            }
        }
    }

    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    public static boolean isGreaterThan1(int b) {
        return b >= 1;
    }

    public static boolean isGreaterThan0(int b) {
        return b >= 0;
    }

    public static boolean isLessN(int b, int n) {
        return b <= n;
    }
}
