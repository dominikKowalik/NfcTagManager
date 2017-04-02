package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.TagOwner;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dominik on 2017-04-02.
 */
@Repository
public class TagOwnerDaoImpl extends AbstractDao<Long, TagOwner> implements TagOwnerDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<TagOwner> fetchAll() {
        Query query = getSession().createQuery("from TagOwner");
        return query.list();
    }

    @Override
    public TagOwner findById(Long id) {
        return this.findById(id);
    }

    @Override
    public void saveTagOwner(TagOwner tagOwner) {
        persist(tagOwner);
    }
}
