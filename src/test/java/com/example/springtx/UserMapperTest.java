package com.example.springtx;

import com.example.springtx.bean.User;
import com.example.springtx.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Marco Song
 * @since 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testDeleteUserById() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        Integer count = userMapper.deleteUserById(user.getId());
        Assert.assertEquals(new Integer(1), count);
    }

    @Test
    public void testUpdateUser() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        user.setUsername("hr");
        userMapper.updateUser(user);
        Assert.assertEquals("hr", user.getUsername());
    }

    @Test
    public void testGetById() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);

        User obj = userMapper.getById(user.getId());
        Assert.assertEquals("admin", obj.getUsername());
        Assert.assertEquals("123", obj.getPassword());
        Assert.assertEquals(new Integer(1), obj.getStatus());
    }

}
