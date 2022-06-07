package org.spring;

import org.spring.dao.JdbcDaoImpl;
import org.spring.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbc {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcDaoImpl doo = context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);

        Circle circle = doo.getCircle(1);
        System.out.println(circle.getName());
    }
}
