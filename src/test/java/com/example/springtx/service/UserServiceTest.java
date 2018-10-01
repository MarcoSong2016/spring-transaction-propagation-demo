package com.example.springtx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Marco Song
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void required() {
        userService.required();
    }

    @Test
    public void supportsWithTx(){
        userService.supportsWithTx();
    }

    @Test
    public void supportsWithoutTx(){
        userService.supportsWithoutTx();
    }

    @Test
    public void mandatory(){
        userService.mandatory();
    }

    @Test
    public void notSupported(){
        userService.notSupported();
    }
}