package com.kgisl.SampleQuickstart.dao;

import java.util.List;

import com.kgisl.SampleQuickstart.model.User;



public interface UserDao {
    void insertUsers(List<User> userList);
}