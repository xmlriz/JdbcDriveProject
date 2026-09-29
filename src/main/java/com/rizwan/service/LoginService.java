package com.rizwan.service;

import com.rizwan.dbConnection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService
{
    public static boolean isUserValid(String username , String password)
    {
        String sql = "select 1 from users where username = ? and password = ?";
        Connection connection = DbConnection.getConnection();

        try(
                PreparedStatement ps = connection.prepareStatement(sql);
                )
        {
            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next())
                return true;
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
