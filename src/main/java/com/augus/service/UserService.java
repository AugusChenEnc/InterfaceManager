package com.augus.service;

import com.augus.mapper.UsersMapper;
import com.augus.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Augus
 * @date 2018/7/6 15:16
 */
@Service
public class UserService {

    @Autowired
    private UsersMapper usersMapper;

    public Users findUsersByAccountAndPassword(Users users){
        return usersMapper.selectByAccountAndPassword(users.getAccount(),users.getPassword());
    }

    public Users findUsersById(String id){
        return usersMapper.selectByPrimaryKey(id);
    }

}
