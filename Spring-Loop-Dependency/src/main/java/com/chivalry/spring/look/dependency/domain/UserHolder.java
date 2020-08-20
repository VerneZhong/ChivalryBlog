package com.chivalry.spring.look.dependency.domain;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-08-19 09:41
 */
public class UserHolder {
    private User user;

    private String name;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", name='" + name + '\'' +
                '}';
    }
}
