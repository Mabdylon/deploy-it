/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mabdylon.deployIt.concept;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Mabdylon
 */
@Entity
public class ServerConnectionInformation implements Serializable {
    
    @Id @GeneratedValue
    private long id;
    private String serverName;
    private String url;
    private int port;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
}
