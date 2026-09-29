package com.rizwan.service;

import com.rizwan.dbConnection.DbConnection;
import com.rizwan.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public int createNewUser(Users user)
    {
        String sql = "INSERT into users(username,password) VALUES(?,?)";
        Connection connection = DbConnection.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sql);)
        {
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            int row = ps.executeUpdate();
            return row;
        }
        catch (Exception e) { e.printStackTrace();}
        return 0;
    }

    @Override
    public List<Users> getAllUsers() {

        String sql = "SELECT username , password from users";
        List<Users> users = new ArrayList<>();

        Connection connection = DbConnection.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                users.add(new Users(rs.getString("username"),rs.getString("password")));
            }
        }
        catch (Exception e) { e.printStackTrace();}

        return users;
    }

    @Override
    public Users getUserById(int id) {
        return null;
    }
}
