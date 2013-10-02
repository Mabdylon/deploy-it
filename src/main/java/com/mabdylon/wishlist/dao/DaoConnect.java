/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.wishlist.dao;

import com.google.common.collect.Maps;
import java.lang.String;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author Mabdylon
 */
public class DaoConnect {
    
    public static DaoConnect INSTANCE = new DaoConnect(); 

    private DaoConnect() {
    }
    
    public Map testRetrieve() {
        Map<String,String> results = Maps.newHashMap();
        try {
            Connection con = null;
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource datasource = (DataSource) envContext.lookup("jdbc/deploy-it");
            Future<Connection> future = datasource.getConnectionAsync();
            while (!future.isDone()) {
                System.out.println("Connection is not yet available. Do some background work");
                try {
                    Thread.sleep(100); //simulate work
                } catch (InterruptedException x) {
                    Thread.currentThread().interrupt();
                }
            }
            con = future.get(); //should return instantly
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                results.put(rs.getString("USER"), rs.getString("NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DaoConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(DaoConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(DaoConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
