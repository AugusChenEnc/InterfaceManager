package com.augus.controller;

import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Welcome Controller
 * @author Augus
 * @date 2018/07/06
 */
@RestController
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(){
        throw new TokenExpiredException("token is Expired");
    }

}
