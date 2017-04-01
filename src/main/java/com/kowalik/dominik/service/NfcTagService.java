package com.kowalik.dominik.service;

import com.kowalik.dominik.model.NfcTag;

import java.util.List;

/**
 * Created by dominik on 2017-03-14.
 */
public interface NfcTagService {
    NfcTag findById(long id);
    void saveNfcTag(NfcTag nfcTag);
    void updateNfcTag(NfcTag nfcTag);
    List<NfcTag> findAllNfcTags();
    void deleteNfcTag(NfcTag nfcTag);
    Boolean ifNfcTagExists(NfcTag nfcTag);
    Long numberOfTagsInGroup(Integer group);
    List<NfcTag> tagsFromSpecifiedGroup(Integer group);
    List<NfcTag> findByIsAdminTag(Boolean isAdmin);
}
