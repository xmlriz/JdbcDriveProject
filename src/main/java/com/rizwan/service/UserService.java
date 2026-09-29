package com.rizwan.service;

import com.rizwan.model.Users;

import java.util.List;

public interface UserService
{
    public int createNewUser(Users user);
    public List<Users> getAllUsers();
    public Users getUserById(int id);
}
