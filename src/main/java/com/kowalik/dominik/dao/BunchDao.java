package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.Bunch;

import java.util.List;

/**
 * Created by dominik on 2017-04-08.
 */
public interface BunchDao {
 Bunch findByNumber(Integer number);
 List<Bunch> findAll();
}
