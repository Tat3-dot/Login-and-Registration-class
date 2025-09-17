package poepart1;

import java.util.Scanner;

public class LOGIN {

    String passMessage;
    String nameMessage;
    String phoneNumMessage;

    // Check username (underscore + min 5 chars)
    public boolean checkUserNameEntry(String userName) {
        return userName.contains("_") && userName.length() >= 5;
    }

    // Check SA phone number (+27xxxxxxxxx OR 0xxxxxxxxx)
    public boolean checkPhonenumberEntry(String phonenumber) {
        return phonenumber.matches("^(\\+27|0)\\d{9}$");
    }

    // Check password complexity
    public boolean checkPasswordEntryComplexity(String password) {
        boolean hasNumber = false, hasCap = false, hasChar = false;

        //only check characters if password has at least 8 chars
        if (password.length() >= 8) {
            for (char current : password.toCharArray()) {
                if (Character.isDigit(current)) hasNumber = true;
                else if (Character.isUpperCase(current)) hasCap = true;
                else if (!Character.isLetterOrDigit(current)) hasChar = true;
            }
        }
        return password.length() >= 8 && hasNumber && hasCap && hasChar;
    }

    // Registration feedback
    public void registerUserPassword(String passwordEntry) {
        if (checkPasswordEntryComplexity(passwordEntry)) {
            passMessage = "Password successfully captured.";
        } else {
            passMessage = "Password is not correctly formatted. It must contain:\n" +
                          "- At least 8 characters\n" +
                          "- A capital letter\n" +
                          "- A number\n" +
                          "- A special character";
        }
    }

    public void registerUserUsername(String userNameEntry) {
        if (checkUserNameEntry(userNameEntry)) {
            nameMessage = "Username successfully captured.";
        } else {
            nameMessage = "Username not formatted correctly. It must:\n" +
                          "- Contain an underscore\n" +
                          "- Be at least 5 characters long";
        }
    }

    public void registerUserPhonenumber(String phoneNumEntry) {
        if (checkPhonenumberEntry(phoneNumEntry)) {
            phoneNumMessage = "Phone number successfully captured.";
        } else {
            phoneNumMessage = "Phone number is not correctly formatted. It must:\n" +
                              "- Start with +27 or 0\n" +
                              "- Be followed by 9 digits";
        }
    }

    // Login flow
    public boolean loginUser(String regUsername, String regPassword) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n *** LOGIN *** ");

        String username;
        do {
            System.out.print("Enter username: ");
            username = input.nextLine();
            if (!username.equals(regUsername)) {
                System.out.println("Username not found, try again.");
            }
        } while (!username.equals(regUsername));

        String password;
        do {
            System.out.print("Enter password: ");
            password = input.nextLine();
            if (!password.equals(regPassword)) {
                System.out.println("Incorrect password, try again.");
            }
        } while (!password.equals(regPassword));

        return true; // login successful
    }

    public String returnLoginStatus(boolean regStatus, String Firstname, String Lastname) {
        if (regStatus) {
            return "Welcome, " + Firstname + " " + Lastname + ", it is great to see you again.";
        } else {
            return "Login failed. Please check your username or password.";
        }
    }
}

