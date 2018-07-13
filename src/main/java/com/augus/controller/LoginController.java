package com.augus.controller;

import com.alibaba.fastjson.JSON;
import com.augus.annotation.IgnoreSecurity;
import com.augus.common.StandardResponse;
import com.augus.pojo.Users;
import com.augus.service.UserService;
import com.augus.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Login Controller
 * @author Augus
 * @date 2018/07/06
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @IgnoreSecurity
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public StandardResponse login(@RequestBody Users users) {
        StandardResponse response = new StandardResponse();
        Users user = userService.findUsersByAccountAndPassword(users);

        String token = JwtTokenUtil.createToken(user.getId());
        log.info("userId:{}, token:{}",user.getId(), token);
        return response.success("{\"token\": \""+token+"\",\"account\":\""+ user.getAccount() +"\"}");
    }

}
