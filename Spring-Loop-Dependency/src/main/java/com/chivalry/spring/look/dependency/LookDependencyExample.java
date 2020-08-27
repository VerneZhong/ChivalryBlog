package com.chivalry.spring.look.dependency;

import com.chivalry.spring.look.dependency.domain.User;
import com.chivalry.spring.look.dependency.domain.UserHolder;
import com.chivalry.spring.look.dependency.domain.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Look Dependency Examples
 *
 * @author Mr.zxb
 * @date 2020-08-19 09:22
 */
public class LookDependencyExample {

    // 构造器注入会抛出 throw UnsatisfiedDependencyException
//    public LookDependencyExample(UserHolder userHolder) {
//        this.userHolder = userHolder;
//    }

    public UserHolder userHolder(UserHolder userHolder) {
        return new UserHolder();
    }

    public User user(User user) {
        return new User();
    }

//    @Autowired
//    private User user;

//    @Autowired
//    private UserHolder userHolder;

    @Bean
    @Scope(value = "prototype")
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("zxb-user");

        UserHolder userHolder = new UserHolder();
        userHolder.setName("zxb-userHolder");
        user.setUserHolder(userHolder);
        return user;
    }

    @Bean
    @Scope(value = "prototype")
    public UserHolder userHolder() {
        UserHolder userHolder = new UserHolder();
        User user = new User();
        user.setId(1L);
        user.setName("zxb-user");
        userHolder.setUser(user);
        userHolder.setName("user-holder");
        return userHolder;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public UserProcessor userProcessor() {
        UserProcessor userProcessor = new UserProcessor();
        userProcessor.setId(1L);
        userProcessor.setName("zxb");
        return userProcessor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(LookDependencyExample.class);

        applicationContext.refresh();

//        LookDependencyExample user = applicationContext.getBean(LookDependencyExample.class);

//        System.out.println(user.user);
//        System.out.println(user.userHolder);

//        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
//        System.out.println(userHolder);

//        User user = applicationContext.getBean(User.class);
//        System.out.println(user);

        UserProcessor userProcessor = applicationContext.getBean(UserProcessor.class);
        System.out.println(userProcessor);

        applicationContext.close();
    }

}
