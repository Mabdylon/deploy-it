/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.deployIt.dao.util;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Mabdylon
 */
public class HibernateUtilTest {
    private SessionFactory sessionFactory;
    private Session session;
    
    public HibernateUtilTest() {
    }
    
    @Before
    public void setUp() {
         // rcarver - setup the jndi context and the datasource
        try {
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES, 
                "org.apache.naming");            
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:comp");
            ic.createSubcontext("java:comp/env");
            ic.createSubcontext("java:comp/env/jdbc");
           
            // Construct DataSource
            MysqlDataSource ds = new MysqlConnectionPoolDataSource();
            ds.setURL("jdbc:mysql://localhost:3306/deploy-it");
            ds.setUser("mabdylon");
            ds.setPassword("deploy-it");
            
            ic.bind("java:comp/env/jdbc/deploy-it", ds);
        } catch (NamingException ex) {
            Logger.getLogger(HibernateUtilTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }
    
    @After
    public void tearDown() {
        session.close();
        sessionFactory.close();
    }

//    @Test
    public void testGetSessionFactory() {
        Query query = session.createSQLQuery("SELECT 'TEST'");
        Object result = query.uniqueResult();
        System.out.println("results : ");
        System.out.println(result);
        assertEquals(result, "TEST");
    }
}
