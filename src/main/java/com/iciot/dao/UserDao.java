package com.iciot.dao;

import com.iciot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface UserDao {
    // 用户注册
    @Insert("INSERT INTO user (username, password, tel, email) VALUES (#{username}, #{password}, #{tel}, #{email})")
    void register(User user) throws SQLException;

    // 用户登录
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User login(User user) throws SQLException;
}