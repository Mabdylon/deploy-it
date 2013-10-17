/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.deployIt.dao;

import com.mabdylon.deployIt.concept.Article;
import com.mabdylon.deployIt.concept.IEntite;
import com.mabdylon.deployIt.dao.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mabdylon
 */
public class GenericDao <T extends IEntite> {

    private final Class<T> classe;
    private final SessionFactory sessionFactory;

    public GenericDao(Class classe, SessionFactory sessionFactory) {
        this.classe = classe;
        this.sessionFactory = sessionFactory;
    }
    
    public static <E extends IEntite> GenericDao<E> newDao(Class<E> classe) {
        return new GenericDao<E>(classe, HibernateUtil.getSessionFactory());
    }

    public T loadFirst() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(classe);
        T result = (T) criteria.setMaxResults(1).uniqueResult();
        transaction.commit();
        session.close();
        return result;
    }
    
    public List<T> loadAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(classe);
        List<T> results = criteria.list();
        transaction.commit();
        session.close();
        return results;
    }

    public Long save(T entite) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long id = (Long)session.save(entite);
        transaction.commit();
        session.close();
        return id;
    }

}
