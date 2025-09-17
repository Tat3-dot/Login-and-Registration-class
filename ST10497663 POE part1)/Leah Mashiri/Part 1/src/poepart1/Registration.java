package poepart1;

import java.util.Scanner;

public class Registration {

    // variables user details (instance, not static)
    private String UserName;
    private String PassWord;
    private String Firstname;
    private String Lastname;
    private String Phonenumber;

    // Setters and Getters for user
    public void setUserName(String username){ UserName = username; }
    public String getUserName(){ return UserName; }

    public void setPhonenumber(String phonenumber){ Phonenumber = phonenumber; }
    public String getPhonenumber(){ return Phonenumber; }

    public void setPassword(String password){ PassWord = password; }
    public String getPassword(){ return PassWord; }

    public void setFirstname(String firstname){ Firstname = firstname; }
    public String getFirstname(){ return Firstname; }

    public void setLastname(String lastname){ Lastname = lastname; }
    public String getLastname(){ return Lastname; }

    public static void main(String[] args) {
        LOGIN MyLogin = new LOGIN();
        Registration reg = new Registration();
        Scanner input = new Scanner(System.in);

        System.out.println(" *** REGISTRATION *** ");

        System.out.print("Please enter your Firstname: ");
        reg.setFirstname(input.nextLine());

        System.out.print("Please enter your Lastname: ");
        reg.setLastname(input.nextLine());

        // Username loop
        do {
            System.out.print("Please enter your username: ");
            reg.setUserName(input.nextLine());
            MyLogin.registerUserUsername(reg.getUserName());
            System.out.println(MyLogin.nameMessage);
        } while(!MyLogin.checkUserNameEntry(reg.getUserName()));

        // Phone number loop
        do {
            System.out.print("Please enter your phone number: ");
            reg.setPhonenumber(input.nextLine());
            MyLogin.registerUserPhonenumber(reg.getPhonenumber());
            System.out.println(MyLogin.phoneNumMessage);
        } while(!MyLogin.checkPhonenumberEntry(reg.getPhonenumber()));

        // Password loop
        do {
            System.out.print("Please enter your password: ");
            reg.setPassword(input.nextLine());
            MyLogin.registerUserPassword(reg.getPassword());
            System.out.println(MyLogin.passMessage);
        } while(!MyLogin.checkPasswordEntryComplexity(reg.getPassword()));

        System.out.println("Successfully Registered");

        // Call loginUser method
        boolean regStatus = MyLogin.loginUser(reg.getUserName(), reg.getPassword());

        // Print login status message
        System.out.println(MyLogin.returnLoginStatus(regStatus, reg.getFirstname(), reg.getLastname()));

        input.close();
    }
}
