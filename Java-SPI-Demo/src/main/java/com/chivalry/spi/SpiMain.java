package com.chivalry.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Java SPI {@link java.util.ServiceLoader} 示例
 * SPI机制已经定义好了加载服务的流程框架, 你只需要按照约定, 在META-INF/services目录下面,
 * 以接口的全限定名称为名创建一个文件夹(com.chivalry.spi.Lookup),
 * 文件夹下再放具体的实现类的全限定名称(ccom.chivalry.spi.LookupImpl),
 * 系统就能根据这些文件,加载不同的实现类.这就是SPI的大体流程.
 *
 * @author Mr.zxb
 * @date 2020-08-14 14:45
 */
public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<Lookup> serviceLoader = ServiceLoader.load(Lookup.class);
        Iterator<Lookup> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Lookup lookup = iterator.next();
            lookup.look("hello");
        }
    }
}
