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

    public List<NfcTag> findByIsAdminTag(Boolean isAdminTag){
        Query query = getSession().createQuery("select NFCTAG from NfcTag NFCTAG where NFCTAG.isAdminTag = :isAdminTag");
        query.setParameter("isAdminTag", isAdminTag);
        return query.list();
    }

    @Override
    public void saveNfcTag(NfcTag nfcTag) {
        persist(nfcTag);
    }

    @Override
    public void deleteNfcTag(NfcTag nfcTag) {
        Query query = getSession().createQuery("delete from NfcTag where id= :id");
        query.setParameter("id",nfcTag.getId());
        query.executeUpdate();
    }

    @Override
    public List<NfcTag> findAllNfcTag() {
        Query query = getSession().createQuery("from NfcTag");
        return query.list();
    }

    @Override
    public Boolean ifNfcTagExists(NfcTag nfcTag) {
        Query query = getSession().createQuery("select NFCTAG from NfcTag NFCTAG where NFCTAG.id = :id");
        query.setParameter("id", nfcTag.getId());
        Object object = query.uniqueResult();
        return object != null;
    }
}
