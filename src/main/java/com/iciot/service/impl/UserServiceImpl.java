package com.iciot.service.impl;

import com.iciot.dao.UserDao;
import com.iciot.domain.User;
import com.iciot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) throws SQLException {
        userDao.register(user);
    }

    @Override
    public User login(User user) throws SQLException {
        return userDao.login(user);
    }
}