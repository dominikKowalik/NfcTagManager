package com.kowalik.dominik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by dominik on 2017-03-12.
 */
public abstract class AbstractDao<primaryKey extends Serializable, T> {

    private final Class<T> persistentClass;

    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() { return sessionFactory.getCurrentSession(); }

    public T getByKey(primaryKey pk) {
        return getSession().get(persistentClass, pk);
    }

    public void persist(T t) {
        getSession().persist(t);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected CriteriaBuilder createEntityCriteria() {
        return getSession().getCriteriaBuilder();
    }


}
