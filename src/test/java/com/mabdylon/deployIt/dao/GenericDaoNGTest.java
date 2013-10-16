/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mabdylon.deployIt.dao;

import com.mabdylon.deployIt.concept.Article;
import com.mabdylon.deployIt.concept.ArticleBuilder;
import com.mabdylon.deployIt.dao.util.HibernateUtilMock;
import java.io.Serializable;
import java.util.List;
import static org.testng.Assert.*;
import static org.mockito.Mockito.*;
import org.hibernate.SessionFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Mabdylon
 */
public class GenericDaoNGTest {

    private GenericDao<Article> genericDao;
    
    public GenericDaoNGTest() {
    }

    @BeforeTest
    public void setUpTest() throws Exception {
        genericDao = new GenericDao<Article>(Article.class, HibernateUtilMock.getSessionFactory());
    }

    @AfterTest
    public void tearDownTest() throws Exception {
        HibernateUtilMock.getSessionFactory().close();
    }

    @Test(groups = {"integration"})
    public void testLoadFirst() {
        Article article = genericDao.loadFirst();
        assertEquals(article, null);
    }

    @Test(groups = {"integration"})
    public void testLoadAll() {
        List<Article> articles = genericDao.loadAll();
        assertEquals(articles.size(), 0);
    }
    
    @Test(groups = {"integration"})
    public void testSave() {
        Article articleToSave = new ArticleBuilder()
                .setContent("Contenu")
                .setTitle("Titre").createArticle();
        Long id = genericDao.save(articleToSave);
        Article articleLoaded = genericDao.loadFirst();
        
        assertNotNull(articleLoaded.getCreated().getTime());
        assertEquals(id, new Long(1));
        assertEquals(id, articleLoaded.getId());
        assertEquals(articleLoaded.getTitle(), "Titre");
        assertEquals(articleLoaded.getContent(), "Contenu");
        assertEquals(articleToSave.getCreated().getTime()/1000, articleLoaded.getCreated().getTime()/1000);
    }
    
}
