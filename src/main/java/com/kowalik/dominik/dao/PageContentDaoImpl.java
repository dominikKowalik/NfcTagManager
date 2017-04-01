package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.PageContent;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dominik on 2017-03-24.
 */

@Repository(value = "pageContentDao")
public class PageContentDaoImpl extends AbstractDao<Long, PageContent> implements PageContentDao {
    @Override
    public PageContent findById(long id) {
        return findById(id);
    }

    @Override
    public void savePageContent(PageContent pageContent) {
        persist(pageContent);
    }

    @Override
    public void deletePageContent(PageContent pageContent) {
        Query query = getSession().createQuery("delete from PageContent where id := id");
        query.setParameter("id", pageContent.getId());
        query.executeUpdate();
    }

    @Override
    public List<PageContent> findAllPageContent() {
        Query query = getSession().createQuery("from PageContent");
        return query.list();    }

    @Override
    public Boolean ifPageContentExists(PageContent pageContent) {
        Query hql = getSession().createQuery("select from PageContent PAGECONTENT where PAGECONTENT.id = :id");
        hql.setParameter("id", pageContent.getId());
        Object o = hql.uniqueResult();
        return  o != null;
    }


}
