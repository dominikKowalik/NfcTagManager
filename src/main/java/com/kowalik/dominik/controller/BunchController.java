package com.kowalik.dominik.controller;

import com.kowalik.dominik.model.Bunch;
import com.kowalik.dominik.service.BunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dominik on 2017-04-08.
 */

@RestController
@RequestMapping("/bunch")
public class BunchController {
    @Autowired
    BunchService bunchService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Bunch>> listAllBunch() {
        List<Bunch> bunchList = bunchService.findAll();
        return new ResponseEntity<>(bunchList, HttpStatus.OK);
    }

}
