package com.iciot.service;

import com.iciot.domain.User;

import java.sql.SQLException;

public interface UserService {
    void register(User user) throws SQLException;
    User login(User user) throws SQLException;
}