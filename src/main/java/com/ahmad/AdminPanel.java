package com.ahmad;

import java.util.List;

public class AdminPanel
{
    private final UserQueries userQueries;
    public AdminPanel()
    {
        userQueries = new UserQueries();
    }

    public void show()
    {
        while(true)
        {
            System.out.println("\n==================== ADMIN PANEL ===================");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. LogOut");

            int choice = InputUtil.getInt("Enter your choice : ");

            switch(choice)
                {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    deleteUser();
                    break;

                    case 3:
                        System.out.println("Logging out...");
                        return;

                    default:
                        System.out.println("Invalid choice.");

                }
        }
    }

    public void viewAllUsers()
    {
        List<User> users = userQueries.findAllUsers();
        System.out.println("==================== USERS LIST =====================");
        for(User user : users)
        {
            System.out.println(user);
        }
    }

public void deleteUser()
    {
        int userId = InputUtil.getInt("Enter user ID : ");
        if (userQueries.deleteUser(userId))
        {
        System.out.println("User deleted successfully.");
        }
        else
        {
            System.out.println("User not found.");
        }
    }
    }
