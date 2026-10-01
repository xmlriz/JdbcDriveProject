package com.ahmad;

public class UserValidationService
{
    public boolean isValidName(String name)
    {
        return name!=null &&
                !name.trim().isEmpty();
    }

    public boolean isValidEmail(String email) {

        return email != null
                && email.contains("@")
                && email.contains(".")
                && !email.startsWith("@")
                && !email.endsWith("@")
                && !email.contains(" ");
    }

    public boolean isValidPassword(String password)
    {
        return password != null &&
                password.length() >= 6;
    }
}
