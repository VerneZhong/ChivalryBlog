package com.chivalry.java.basic.question;

/**
 * 传递
 * @author Mr.zxb
 * @date 2020-09-13 11:10:29
 */
public class RefernceTransferDemo {

    static class User {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
//        int v = 1;
//        change(v);
//        System.out.println(v);

        User user = new User();
        changeUser(user);
        System.out.println(user);
    }

    private static void changeUser(User user) {
//        user = new User();
        user.setName("王海宾");
    }

    // 虚拟机栈 -> 栈帧 （v ）
    private static void change(int v) {
        v = 2;
    }

}
