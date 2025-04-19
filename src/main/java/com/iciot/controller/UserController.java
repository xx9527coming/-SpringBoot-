package com.iciot.controller;

import com.iciot.domain.User;
import com.iciot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 用户注册
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        try {
            userService.register(user);
            return "注册成功";
        } catch (SQLException e) {
            return "注册失败: " + e.getMessage();
        }
    }

    // 用户登录
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        try {
            User result = userService.login(user);
            if (result != null) {
                return "登录成功";
            } else {
                return "用户名或密码错误";
            }
        } catch (SQLException e) {
            return "登录失败: " + e.getMessage();
        }
    }
}