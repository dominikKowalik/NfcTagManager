package com.kowalik.dominik.controller;

import com.kowalik.dominik.model.NfcTag;
import com.kowalik.dominik.service.NfcTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<List<NfcTag>> listAllNfcTags() {
        List<NfcTag> nfcTagList = nfcTagService.findAllNfcTags();
        if (nfcTagList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nfcTagList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<List<NfcTag>> deleteNfcTag(NfcTag nfcTag) {
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
        System.out.println(nfcTag);
        if (nfcTag == null) {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("println");
        return new ResponseEntity<>(nfcTag, HttpStatus.OK);
    }
}
