package com.kowalik.dominik.service;

import com.kowalik.dominik.model.TagOwner;

import java.util.List;

/**
 * Created by dominik on 2017-04-02.
 */
public interface TagOwnerService {
    TagOwner findById(long id);

    void saveTagOwner(TagOwner tagOwner);

    List<TagOwner> findAllTagOwner();


}
