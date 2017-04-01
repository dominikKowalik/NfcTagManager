package com.kowalik.dominik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dominik on 2017-03-12.
 */
@Controller

@RequestMapping("/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        System.out.println("mainController:index");
        return "index";
    }
}
