/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mabdylon.deployIt.ws;

import com.mabdylon.deployIt.concept.Article;
import com.mabdylon.deployIt.dao.GenericDao;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mabdylon
 */
@Path("/entite")
public class RestEntite {
    
    @GET
    @Path("/article")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticle() { 
        GenericDao<Article> articleDao = GenericDao.newDao(Article.class);
        return Response.ok(articleDao.loadFirst()).build();
    }
    
}
