package com.rizwan.action;

import com.rizwan.model.Users;
import com.rizwan.service.UserService;
import com.rizwan.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Menu
{
    public void playManu()
    {


        UserService userService = new UserServiceImpl();

        while(true)
        {
            System.out.println("\t 1-> Create new user");
            System.out.println("\t 2-> view all users");
            System.out.println("\t 3-> Search user by id");
            System.out.println("\t 4-> Remove user by id");
            System.out.println("\t 5-> edit user by id");
            System.out.println("\t 6->Exit/logout");

            Scanner in = new Scanner(System.in);

            System.out.print("Enter your choice : ");
            int ch = in.nextInt();
        switch (ch) {
            case 1:
                System.out.print("Enter the new Username : ");
                String username = in.next();
                System.out.print("Enter the new Password : ");
                String password1 = in.next();
                System.out.print("Enter the Re-Password : ");
                String password2 = in.next();
                while (!password1.equals(password2)) {
                    System.out.print("Password mismatch enter again \nEnter the new Password : ");
                    password1 = in.next();
                    System.out.print("Enter the Re-Password : ");
                    password2 = in.next();
                }
                Users user = new Users(username, password1);
                int row = userService.createNewUser(user);
                if (row > 0)
                    System.out.println("User created succesfully ");
                else
                    System.err.println("Something went wrong!");
                break;
            case 2:
                List<Users> allUsers = userService.getAllUsers();
                System.out.println("\tUsername\tPassword");
                allUsers.forEach(x->System.out.println("\t"+x.getUsername()+"\t"+x.getPassword()));
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Enter the valid input");
            }
        }
    }
}
/**
 *
 *
 * tjis is just test
 */