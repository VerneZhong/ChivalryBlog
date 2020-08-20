package com.chivalry.spring.look.dependency.domain;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 用户 class
 *
 * @author Mr.zxb
 * @date 2020-01-05 15:23
 */
public class User implements BeanNameAware {

    private Long id;
    private String name;

    private UserHolder userHolder;

    /**
     * 当前 Bean 的名称
     */
    private transient String beanName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBeanName() {
        return beanName;
    }

    public UserHolder getUserHolder() {
        return userHolder;
    }

    public void setUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userHolder=" + userHolder +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("用户 Bean ["+ beanName +"] 初始化...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("用户 Bean [" + beanName + "] 销毁...");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
