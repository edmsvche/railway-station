package com.example.railwaystation.service;

import com.example.railwaystation.model.User;

import java.util.List;

public interface UserService {

    void create(User user);

    List<User> readAll();

    User read(long id);

    boolean update(User user, long id);

    boolean delete(long id);
}
