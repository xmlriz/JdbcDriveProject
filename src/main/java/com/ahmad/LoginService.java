package com.ahmad;

public class LoginService
{
    public final UserQueries userQueries;

    public LoginService()
    {
        userQueries = new UserQueries();
    }

    public User login(String email, String password)
    {
        User user = userQueries.findUserByEmail(email);

        if (user == null)
        {
            return  null;
        }

        if (user.getPassword().equals(password))
        {
            return user;
        }
        return null;
    }
}
