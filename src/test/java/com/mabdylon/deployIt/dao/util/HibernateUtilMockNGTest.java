/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mabdylon.deployIt.dao.util;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mabdylon
 */
public class HibernateUtilMockNGTest {
    
    public HibernateUtilMockNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testGetSessionFactory() {
        Session session = HibernateUtilMock.getSessionFactory().openSession();
        SQLQuery query = session.createSQLQuery("SELECT 'TEST'");
        String result = (String) query.list().iterator().next();
        assertEquals(result, "TEST");
    }
    
}
