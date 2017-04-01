package com.kowalik.dominik.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dominik on 2017-04-01.
 */

@RestController
@RequestMapping("account")
public class AccountController {



    @RequestMapping(value = "/create_account/{username}/{password}", method = RequestMethod.POST)
    public void createAccount(@PathVariable("username") String username, @PathVariable("password") String password) {

    }


}
