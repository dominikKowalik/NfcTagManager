package com.kowalik.dominik.service;

import com.kowalik.dominik.model.Bunch;

import java.util.List;

/**
 * Created by dominik on 2017-04-08.
 */

public interface BunchService {
    Bunch findBunchByNumber(Integer number);
    List<Bunch> findAll();
}
