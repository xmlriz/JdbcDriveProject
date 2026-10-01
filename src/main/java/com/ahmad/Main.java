package com.ahmad;

public class Main
{
    public static void main(String[] args)
    {
        UserServive userServive = new UserServive();
        LoginService loginService = new LoginService();

        while(true)
        {
            System.out.println("\n=========================================");
            System.out.println("======== USER MANAGEMENT SYSTEM ===========");
            System.out.println("======================================");

            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Exit.");

            int choice = InputUtil.getInt("Enter your choice  : ");
            switch(choice)
                {
                case 1:
                        String name = InputUtil.getString("Enter your name: ");
                        String email = InputUtil.getString("Enter your email: ");
                        String password = InputUtil.getString("Enter your password: ");
                        boolean registered = userServive.registerUser(name, email, password);

                        if(registered)
                        {
                            System.out.println("User successfully registered.");
                        }
                        else
                        {
                            System.out.println("User not registered.");
                        }
                        break;
                case 2:
                    email = InputUtil.getString("Enter email: ");

                    password = InputUtil.getString("Enter password: ");

                    User user = loginService.login(email, password);

                    if(user == null)
                        {
                        System.out.println("User not found.");
                        }
                    else
                    {
                        System.out.println("User successfully logged in.");
                    }

                    if (user.getRole().equalsIgnoreCase("ADMIN"))
                    {
                        new AdminPanel().show();
                    }
                    else
                    {
                        new UserPanel().show(user);
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using our application.");
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Invalid choice.");

                }
        }
    }
}
