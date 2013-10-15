/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mabdylon.deployIt.dao.util;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.testng.PowerMockTestCase;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author Mabdylon
 */

@SuppressStaticInitializationFor("com.mabdylon.deployIt.dao.util.HibernateUtil")
public class HibernateUtilNGTest extends PowerMockTestCase {
    
    public HibernateUtilNGTest() {
    }
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
    
    @AfterMethod
    public void tearDownMethod() throws Exception {
        
    }
    
    @Test(groups = {"integration"})
    public void testGetSessionFactory() {
        Configuration configuration = new Configuration()
            .configure("hibernate_test.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery("SELECT 'TEST'");
        String result = (String) query.list().iterator().next();
        assertEquals(result, "TEST");
        System.out.println("AAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAAA");
    }
    
    @Test(groups = {"unit"})
    public void testBidon() {
        Configuration configuration = new Configuration()
            .configure("hibernate_test.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery("SELECT 'TEST'");
        String result = (String) query.list().iterator().next();
        assertEquals(result, "TEST");
        System.out.println("BBBBBBBBBBBBB");
        System.out.println("BBB");
        System.out.println("BBBBBBBBBBBBB");
    }
    
}
