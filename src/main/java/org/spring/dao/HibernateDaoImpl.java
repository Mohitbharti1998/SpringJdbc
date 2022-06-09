package org.spring.dao;


import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public int getCircleCount(){
        String sql = "select count(*) from circle";
        Query query = getSessionFactory().openSession().createQuery(sql);
        return ((Long) query.uniqueResult()).intValue();

    }
}
