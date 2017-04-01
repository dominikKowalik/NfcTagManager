package com.kowalik.dominik.dao;

import com.kowalik.dominik.model.NfcTag;

import java.util.List;

/**
 * Created by dominik on 2017-03-14.
 */
public interface NfcTagDao {
    NfcTag findById(long id);
    void saveNfcTag(NfcTag nfcTag);
    void deleteNfcTag(NfcTag nfcTag);
    List<NfcTag> findAllNfcTag();
    Boolean ifNfcTagExists(NfcTag nfcTag);
    List<NfcTag> findByIsAdminTag(Boolean isAdminTag);
}
