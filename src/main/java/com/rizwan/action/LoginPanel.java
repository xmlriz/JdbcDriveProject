package com.rizwan.action;

import com.rizwan.service.LoginService;

import java.util.Scanner;
/**
 *
 * Hello this is testing ..
 *
 */

public class LoginPanel
{
    public static void letsLogin()
    {
        try(Scanner sc = new Scanner(System.in))
        {
            System.out.println("========================");
            System.out.println("========================");
            System.out.println(" Welcome to my system !! ");
            System.out.println("========================");
            System.out.println("========================");

            System.out.print("Enter the Username: ");
            String username = sc.nextLine();

            System.out.print("Enter the password: ");
            String password = sc.nextLine();


            if(LoginService.isUserValid(username,password))
            {
                Menu menu =  new Menu();
                System.out.println("Login Success:");
                menu.playManu();

            }
            else
            {
                System.err.println("Username and password is not correct");
                System.err.println("*************************************\n");
                letsLogin();
            }
        }
    }
}
