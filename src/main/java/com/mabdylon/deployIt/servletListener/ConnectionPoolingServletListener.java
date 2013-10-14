/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.deployIt.servletListener;

import com.mabdylon.deployIt.dao.util.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author Mabdylon
 */
public class ConnectionPoolingServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        try {
//            HibernateUtil.getSessionFactory().close();
//            Context envContext = new InitialContext();
//            DataSource datasource
//                    = (DataSource) envContext.lookup("java:comp/env/jdbc/deploy-it");
//            datasource.close(true);
//        } catch (NamingException ex) {
//            Logger.getLogger(ConnectionPoolingServletListener.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
