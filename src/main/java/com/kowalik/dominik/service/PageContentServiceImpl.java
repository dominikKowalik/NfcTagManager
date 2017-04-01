package com.kowalik.dominik.service;

import com.kowalik.dominik.dao.PageContentDao;
import com.kowalik.dominik.model.PageContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by dominik on 2017-03-24.
 */
@Transactional
@Service("pageContentService")
public class PageContentServiceImpl implements PageContentService {

    @Autowired
    PageContentDao pageContentDao;

    @Override
    public PageContent findById(long id) {
        return pageContentDao.findById(id);
    }

    @Override
    public void saveNfcTag(PageContent pageContent) {
        pageContentDao.savePageContent(pageContent);
    }

    @Override
    public void updateNfcTag(PageContent pageContent) {
        PageContent pageContent1 = pageContentDao.findById(pageContent.getId());
        Optional.ofNullable(pageContent1).ifPresent(p -> {
            pageContent1.setHeader(pageContent.getHeader());
            pageContent1.setPhotos(pageContent.getPhotos());
            pageContent1.setText(pageContent.getText());
            pageContent1.setTitle(pageContent.getTitle());
        });
    }

    @Override
    public List<PageContent> findAllPageContent() {
        return pageContentDao.findAllPageContent();
    }

    @Override
    public void deletePageContent(PageContent pageContent) {
        pageContentDao.deletePageContent(pageContent);
    }

    @Override
    public Boolean ifPageContentExists(PageContent pageContent) {
        return pageContentDao.ifPageContentExists(pageContent);
    }
}
