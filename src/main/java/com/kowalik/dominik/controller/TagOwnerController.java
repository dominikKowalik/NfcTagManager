package com.kowalik.dominik.controller;

import com.kowalik.dominik.service.TagOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dominik on 2017-04-02.
 */

@RestController
@RequestMapping("tag_owner")
public class TagOwnerController {
    @Autowired
    TagOwnerService tagOwnerService;
}
