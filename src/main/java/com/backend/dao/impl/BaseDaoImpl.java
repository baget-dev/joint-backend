package com.backend.dao.impl;

import com.backend.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDaoImpl implements BaseDao {

    protected SessionFactory sessionFactory;

    public BaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }
}
