package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.TagOwner;

import java.util.List;

/**
 * Created by dominik on 2017-04-02.
 */


public interface TagOwnerDao {
    List<TagOwner> fetchAll();
    TagOwner findById(Long id);
    void saveTagOwner(TagOwner tagOwner);
}
