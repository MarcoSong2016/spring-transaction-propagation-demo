package com.example.springtx.service;

import com.example.springtx.bean.User;
import com.example.springtx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marco Song
 * @since 1.0.0
 */
@Service
public class InnerService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void required(){
        User user = new User();
        user.setUsername("inner-required");
        userMapper.addUser(user);
        exceptionMd();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("update-fail");
        userMapper.updateUser(user1);
    }

    public void exceptionMd(){
        throw new RuntimeException("人工异常");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports() {
        User user = new User();
        user.setUsername("inner-support");
        userMapper.addUser(user);
        exceptionMd();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("update-666");
        userMapper.updateUser(user1);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory() {
        User user = new User();
        user.setUsername("inner-mandatory");
        userMapper.addUser(user);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported() {
        User user = new User();
        user.setUsername("inner-not-support");
        userMapper.addUser(user);
        exceptionMd();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("update-not-supported");
        userMapper.updateUser(user1);
    }
}
