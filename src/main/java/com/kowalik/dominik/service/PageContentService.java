package com.kowalik.dominik.service;

import com.kowalik.dominik.model.PageContent;

import java.util.List;

/**
 * Created by dominik on 2017-03-24.
 */
public interface PageContentService {
    PageContent findById(long id);
    void saveNfcTag(PageContent pageContent);
    void updateNfcTag(PageContent pageContent);
    List<PageContent> findAllPageContent();
    void deletePageContent(PageContent pageContent);
    Boolean ifPageContentExists(PageContent pageContent);
}
