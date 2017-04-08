package com.kowalik.dominik.service;

import com.kowalik.dominik.dao.BunchDao;
import com.kowalik.dominik.model.Bunch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dominik on 2017-04-08.
 */

@Service("bunchService")
@Transactional
public class BunchServiceImpl implements BunchService {

    @Autowired
    BunchDao bunchDao;

    @Override
    public List<Bunch> findAll(){
        return bunchDao.findAll();
    }

    @Override
    public Bunch findBunchByNumber(Integer number) {
        return bunchDao.findByNumber(number);
    }
}
