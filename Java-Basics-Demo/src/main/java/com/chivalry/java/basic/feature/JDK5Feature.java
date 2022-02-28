package com.chivalry.java.basic.feature;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

/**
 * @author Mr.zxb
 * @date 2020-09-13 20:38:54
 */
public class JDK5Feature {

    /**
     * 枚举
     */
    enum Type {
        MQTT(1), COAP(2), HTTP(3), WS(4), RPC(5);

        private int type;

        Type(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }


    public static void main(String[] args) {
        // 静态导入   static
        sort(asList(1, 2, 3).toArray());

//        print("a");
//        print("a", "b");
//        print("a", "b", "c");
//        print("a", "b", "c", "d");

//        if (Type.MQTT.getType() == 1) {

//        }

        // 格式化参数
//        String format = String.format("key: %s, value: %s", "hello", "world");
//        System.out.println(format);
        // log.info ("info  (%s)", value);

        // ProcessBuilder bat 脚本
//        ProcessBuilder processBuilder = new ProcessBuilder("calc");
//        try {
//            Process process = processBuilder.start();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        User user = new User();
//        user.setName("王海宾");
//        try {
//            PropertyDescriptor descriptor = new PropertyDescriptor("name", User.class);
//            // 获得属性的Class对象
//            System.out.println(descriptor.getPropertyType().getName());
//            Method readMethod = descriptor.getReadMethod();
//            System.out.println(readMethod.invoke(user));
//        } catch (IntrospectionException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println(memoryMXBean.getHeapMemoryUsage().getMax());

        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
            System.out.println("当前垃圾收集器的名字: " + garbageCollectorMXBean.getName());
            System.out.println("当前垃圾收集器累计回收总次数: " + garbageCollectorMXBean.getCollectionCount());
            System.out.println("当前垃圾收集器累计回收总时间: " + garbageCollectorMXBean.getCollectionTime());
        }
    }

    /**
     * 可变参数 Var args
     *
     * @param args
     */
    public static void print(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    static class User {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
