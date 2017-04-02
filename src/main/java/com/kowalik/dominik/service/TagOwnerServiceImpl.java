package com.kowalik.dominik.service;


import com.kowalik.dominik.dao.TagOwnerDaoImpl;
import com.kowalik.dominik.model.TagOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dominik on 2017-04-02.
 */

@Service
@Transactional
public class TagOwnerServiceImpl implements TagOwnerService {

    @Autowired
    TagOwnerDaoImpl tagOwnerDao;

    @Override
    public TagOwner findById(long id) {
        return tagOwnerDao.findById(id);
    }

    @Override
    public void saveTagOwner(TagOwner tagOwner) {
        tagOwnerDao.persist(tagOwner);
    }

    @Override
    public List<TagOwner> findAllTagOwner() {
        return tagOwnerDao.fetchAll();
    }
}
