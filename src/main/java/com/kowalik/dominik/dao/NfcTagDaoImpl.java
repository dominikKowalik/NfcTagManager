package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.NfcTag;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dominik on 2017-03-14.
 */

@Repository("nfcTagDao")
public class NfcTagDaoImpl extends AbstractDao<Long, NfcTag> implements NfcTagDao {
    @Override
    public NfcTag findById(long id) {
        return getByKey(id);
    }

    @Override
    public void saveNfcTag(NfcTag nfcTag) {
        persist(nfcTag);
    }

    @Override
    public void deleteNfcTag(NfcTag nfcTag) {
        Query query = getSession().createQuery("delete from NfcTag where nfcUidHex = :nfcUidHex");
        query.setParameter("nfcUidHex",nfcTag.getNfcUidHex());
        query.executeUpdate();
    }

    @Override
    public List<NfcTag> findAllNfcTag() {
        Query query = getSession().createQuery("from NfcTag");
        return query.list();
    }

    @Override
    public Boolean ifNfcTagExists(NfcTag nfcTag) {
        String hql = "select NFCTAG from NfcTag NFCTAG where NFCTAG.nfcUidHex = :nfcUidHex";
        Query query = getSession().createQuery(hql);
        query.setParameter("nfcUidHex", nfcTag.getNfcUidHex());
        Object object = query.uniqueResult();
        return object == null ? false : true;
    }
}
