/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.deployIt.dao;

import com.mabdylon.deployIt.concept.IEntite;
import com.mabdylon.deployIt.dao.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mabdylon
 */
public class GenericDao <T extends IEntite> {

    private final Class<T> classe;
    public static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public GenericDao(Class classe) {
        this.classe = classe;
    }

    public T loadFirst() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(classe);
        T result = (T) criteria.uniqueResult();
        session.close();
        return result;
    }
    
    public List<T> loadAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(classe);
        List<T> results = criteria.list();
        session.close();
        return results;
    }
}
