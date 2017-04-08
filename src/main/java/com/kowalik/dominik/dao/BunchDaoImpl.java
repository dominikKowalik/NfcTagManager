package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.Bunch;
import org.apache.commons.codec.binary.BaseNCodec;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by dominik on 2017-04-08.
 */
@Repository("bunchDao")
public class BunchDaoImpl extends AbstractDao<Long,Bunch> implements BunchDao {

    @Override
    public Bunch findByNumber(Integer number) {
        Query query = getSession().createQuery("from Bunch");
        List<Bunch> bunchList = query.list();
        Optional<Bunch> bunch =  bunchList.stream().filter(a ->  a.getNumber().equals(number)).findFirst();
        return bunch.get();
    }

    @Override
    public List<Bunch> findAll(){
        return getSession().createQuery("from Bunch").list();
    }

}
