/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.deployIt.dao;

import com.mabdylon.deployIt.concept.ServerConnectionInformation;
import com.mabdylon.deployIt.dao.util.HibernateUtil;
import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mabdylon
 */
public class DaoConnect {

    public static DaoConnect INSTANCE = new DaoConnect();

    private DaoConnect() {
    }

    public List<String> testRetrieve() {
        List<String> liste = new ArrayList<String>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return liste;
    }
}
