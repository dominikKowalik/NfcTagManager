package com.kowalik.dominik.service;

import com.kowalik.dominik.dao.NfcTagDao;
import com.kowalik.dominik.model.NfcTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dominik on 2017-03-14.
 */

@Service("nfcTagService")
@Transactional
public class NfcTagServiceImpl implements NfcTagService {

    @Autowired
    NfcTagDao nfcTagDao;

    @Override
    public NfcTag findById(long id) {
        return nfcTagDao.findById(id);
    }

    @Override
    public void saveNfcTag(NfcTag nfcTag) {
        nfcTagDao.saveNfcTag(nfcTag);
    }


    /**
     * Because this method is running with transaction there is no need to call hibernate update explicitly
     *
     * @param nfcTag
     */
    @Override
    public void updateNfcTag(NfcTag nfcTag) {
        NfcTag nfcTag1 = nfcTagDao.findById(nfcTag.getId());
        Optional.ofNullable(nfcTag1).ifPresent( a -> {
            nfcTag1.setIsAdminTag(nfcTag.getIsAdminTag());
            nfcTag1.setGroupNumber(nfcTag.getGroupNumber());
            nfcTag1.setNfcId(nfcTag.getNfcId());
        });
    }

    @Override
    public List<NfcTag> findAllNfcTags() {
        return nfcTagDao.findAllNfcTag();
    }

    @Override
    public void deleteNfcTag(NfcTag nfcTag) {
        nfcTagDao.deleteNfcTag(nfcTag);
    }

    @Override
    public Boolean ifNfcTagExists(NfcTag nfcTag) {
        return nfcTagDao.ifNfcTagExists(nfcTag);
    }

    @Override
    public Long numberOfTagsInGroup(Integer group) {
        List<NfcTag> nfcTagList = nfcTagDao.findAllNfcTag();
        return nfcTagList.stream().filter(a -> a.getGroupNumber().equals(group)).count();
    }

    @Override
    public List<NfcTag> tagsFromSpecifiedGroup(Integer group){
        List<NfcTag> nfcTagList = nfcTagDao.findAllNfcTag();
        return nfcTagList.stream().filter(a -> a.getGroupNumber().equals(group)).collect(Collectors.toList());
    }

    @Override
    public List<NfcTag> findByIsAdminTag(Boolean isAdminTag) {
        List<NfcTag> nfcTagList = nfcTagDao.findByIsAdminTag(isAdminTag);
        return nfcTagList;
    }
}
