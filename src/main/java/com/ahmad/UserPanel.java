package com.ahmad;

public class UserPanel
{
    public void show(User user)
    {
        while (true)
        {
            System.out.println("\n=============== USER PANEL ===============");
            System.out.println("Welcome "+user.getName());
            System.out.println("=============================");
            System.out.println("1. View Profile");
            System.out.println("2. LogOut");

            int choice = InputUtil.getInt("Enter your choice : ");

            switch(choice)
                {
                    case 1:
                        System.out.println("\n================= USER PROFILE ================");
                        System.out.println("ID : "+user.getId());
                        System.out.println("Name : "+user.getName());
                        System.out.println("Email : "+user.getEmail());
                        System.out.println("Role : "+user.getRole());
                        System.out.println("===================================================");
                        break;

                    case 2 :
                        System.out.println("\nLogging Out.....");
                        break;

                    default:
                        System.err.println("Invalid choice....");

                }
        }
    }
}
