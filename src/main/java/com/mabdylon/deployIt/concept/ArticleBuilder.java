/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mabdylon.deployIt.concept;

import java.sql.Date;


public class ArticleBuilder {
    private Long id;
    private String title = "";
    private String content = "";
    private Date created;

    public ArticleBuilder() {
    }

    public ArticleBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ArticleBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public Article createArticle() {
        return new Article(null, title, content, new java.sql.Timestamp(System.currentTimeMillis()));
    }
    
}
