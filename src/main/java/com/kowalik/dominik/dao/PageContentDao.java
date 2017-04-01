package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.PageContent;

import java.util.List;

/**
 * Created by dominik on 2017-03-24.
 */
public interface PageContentDao {
        PageContent findById(long id);
        void savePageContent(PageContent pageContent);
        void deletePageContent(PageContent pageContent);
        List<PageContent> findAllPageContent();
        Boolean ifPageContentExists(PageContent pageContent);
}
