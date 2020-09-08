package com.chivalry.spring.bean;

import com.chivalry.spring.look.dependency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-08-24 16:48
 */
public class BeanScopeDemo {

    @Autowired
    private User user;

//    private User

//    @Bean
    public User user() {
        return new User();
    }

    @Bean
    @Scope("prototype")
    public User userPrototype() {
        return new User();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanScopeDemo.class);

        applicationContext.refresh();

        BeanScopeDemo bean = applicationContext.getBean(BeanScopeDemo.class);

        System.out.println(bean.user);
//        System.out.println(bean);


        applicationContext.close();
    }
}
