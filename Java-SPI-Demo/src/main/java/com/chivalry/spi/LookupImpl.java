package com.chivalry.spi;

/**
 * lookup implement
 *
 * @author Mr.zxb
 * @date 2020-08-14 14:42
 */
public class LookupImpl implements Lookup {
    @Override
    public void look(String message) {
        System.out.println("Spi say " + message);
    }
}
