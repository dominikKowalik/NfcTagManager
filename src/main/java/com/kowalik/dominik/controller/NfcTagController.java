package com.kowalik.dominik.controller;

import com.kowalik.dominik.model.NfcTag;
import com.kowalik.dominik.service.NfcTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by dominik on 2017-03-14.
 */

@RestController
@RequestMapping("nfc_tag")
public class NfcTagController {
    @Autowired
    NfcTagService nfcTagService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createNfcTag(@RequestBody NfcTag nfcTag) {
        System.out.println("createNfcTag");
        System.out.println(nfcTag.toString());
        if (nfcTagService.ifNfcTagExists(nfcTag)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        nfcTagService.saveNfcTag(nfcTag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
   //if is admin variable is true following method returns all admin tags in other case it returns all non admin tags
    @RequestMapping(path = "filter_by_is_admin/{isAdmin}" ,method = RequestMethod.GET)
    public ResponseEntity<List<NfcTag>> getTagsFilteredByIsAdminTag(@PathVariable("isAdmin") Boolean isAdmin){
        System.out.println("listAdminTags");
        List<NfcTag> nfcTagList = nfcTagService.findByIsAdminTag(isAdmin);
        if(nfcTagList.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(nfcTagList, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<List<NfcTag>> listAllNfcTags() {
        List<NfcTag> nfcTagList = nfcTagService.findAllNfcTags();
        if (nfcTagList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nfcTagList, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<List<NfcTag>> deleteNfcTag(@PathVariable("id") long id) {
        NfcTag nfcTag = nfcTagService.findById(id);
        System.out.println(nfcTag);
        if (nfcTagService.ifNfcTagExists(nfcTag)) {
            nfcTagService.deleteNfcTag(nfcTag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public ResponseEntity<NfcTag> getNfcTag(@PathVariable("id") Long id) {
        NfcTag nfcTag = nfcTagService.findById(id);
        System.out.println(id.toString());
        if  (Optional.ofNullable(nfcTag).isPresent()) {
            System.out.println(nfcTag);
            return new ResponseEntity<>(nfcTag, HttpStatus.OK);
        }
        System.out.println("not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
