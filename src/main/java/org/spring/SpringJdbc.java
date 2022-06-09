package org.spring;

import org.spring.dao.HibernateDaoImpl;
import org.spring.dao.JdbcDaoImpl;
import org.spring.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbc {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        HibernateDaoImpl doo = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);

//        Circle circle = doo.getCircle(1);
//        System.out.println(circle.getName());


        //Post Circle
//        doo.insetCircle(new Circle(3,"Third Circle"));

        //Get Circle
//        System.out.println(doo.getAllCircle().toString());

        System.out.println(doo.getCircleCount());
    }
}
