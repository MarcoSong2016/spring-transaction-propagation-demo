package com.example.springtx.mapper;

import com.example.springtx.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Marco Song
 * @since 1.0.0
 */
public interface UserMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id") //回写自增的主键ID
    @Insert("insert into users (username,password,status)values(#{username},#{password},#{status})")
    public Integer addUser(User user);

    @Delete("delete from users where id=#{0}")
    public Integer deleteUserById(Integer id);

    @Update("update users set username=#{username},password=#{password},status=#{status} where id=#{id}")
    public Integer updateUser(User user);

    @Select("select * from users where id=#{0}")
    public User getById(Integer id);

    @Select("select * from users")
    public List<User> queryUserList();
}

