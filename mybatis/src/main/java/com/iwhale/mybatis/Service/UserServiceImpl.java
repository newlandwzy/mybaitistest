package com.iwhale.mybatis.Service;

import com.iwhale.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;
    public void getAllUsers(){
        userMapper.getAllUser();
    }
}
