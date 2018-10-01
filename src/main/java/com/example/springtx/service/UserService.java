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
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private InnerService innerService;


    public void required(){
        User user = new User();
        user.setUsername("111");
        userMapper.addUser(user);
        innerService.required();
        User user1 = new User();
        user1.setUsername("222");
        userMapper.addUser(user1);
    }

    @Transactional
    public void supportsWithTx(){
        User user = new User();
        user.setUsername("supportsWithTx");
        userMapper.addUser(user);
        innerService.supports();
        User user2 = new User();
        user2.setUsername("supportsWithTx2");
        userMapper.addUser(user2);
    }

    public void supportsWithoutTx(){
        User user = new User();
        user.setUsername("supportsWithoutTx");
        userMapper.addUser(user);
        innerService.supports();
        User user2 = new User();
        user2.setUsername("supportsWithoutTx2");
        userMapper.addUser(user2);
    }

    @Transactional
    public void mandatory(){
        User user = new User();
        user.setUsername("mandatory");
        userMapper.addUser(user);
        innerService.mandatory();
    }

    @Transactional
    public void notSupported(){
        User user = new User();
        user.setUsername("not-supported");
        userMapper.addUser(user);
        innerService.notSupported();
    }


    public void exception(){
        throw new RuntimeException("outside 异常");
    }

}
