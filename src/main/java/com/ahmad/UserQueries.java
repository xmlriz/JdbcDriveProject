package com.ahmad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserQueries
{
    public boolean registerUser(User user)
    {
        String query = "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?,?)";

        try
                (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(query)
                )
        {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            return ps.executeUpdate() > 0;
        }
        catch (SQLException e)
            {
            e.printStackTrace();
            return false;
            }
    }

    public User findUserByEmail(String email)
    {
        String query = "SELECT * FROM users WHERE email = ?";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
                )
        {
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return null;
    }

    public List<User> findAllUsers()
    {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try
                (
                        Connection con = DBConnection.getConnection();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(query)
                        )
        {
            while (rs.next())
            {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                        );
                users.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println("SQLException: " + e.getMessage());
        }
        return users;
    }

    public boolean deleteUser(int id)
    {
        String query = "DELETE FROM users WHERE id = ?";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
                )
        {
            ps.setInt(1,id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        }
    }
}
