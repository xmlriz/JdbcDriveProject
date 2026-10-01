package com.ahmad;

public class UserServive
{
    public final UserQueries userQueries;
    public final UserValidationService userValidation;

    public UserServive()
    {
        userQueries = new UserQueries();
        userValidation = new UserValidationService();
    }

    public boolean registerUser(String name ,String email , String password)
    {
        if(!userValidation.isValidName(name))
        {
            System.out.println("Invalid name provided");
            return false;
        }
        if(!userValidation.isValidEmail(email))
        {
            System.out.println("Invalid email provided");
            return false;
        }
        if(!userValidation.isValidPassword(password))
        {
            System.out.println("Invalid password provided");
            return false;
        }

        User existingUser = userQueries.findUserByEmail(email);

        if(existingUser != null)
        {
            System.out.println("User already exists");
            return false;
        }

        User user = new User(name,email,password,"User");
        return userQueries.registerUser(user);
    }
}
