package ProductionCode;

import java.util.ArrayList;

public class MyApp {

    private ArrayList<User> users;
    private boolean loggedIn;
    private boolean successMessageDisplayed;
    private boolean errorMessageDisplayed;

    public MyApp() {
        // Initialize the ArrayList and add users
        this.users = new ArrayList<>();
        this.users.add(new User("mohammad", "123"));
        this.users.add(new User("jawad", "password1"));
        this.users.add(new User("bashar", "password2"));
        this.users.add(new User("rami", "password3"));
        this.users.add(new User("diana", "password4"));
        
        // Initialize other fields
        this.loggedIn = false;
        this.successMessageDisplayed = false;
        this.errorMessageDisplayed = false;
    }

    public void login(String username, String password) {
        for (User u : users) //for(the type of arraylist : the name of arraylist)
       {
            if (u.getName().equals(username) && u.getPassword().equals(password)) {
                loggedIn = true;
                successMessageDisplayed = true;
                errorMessageDisplayed = false;
                return;// to brake the for loop and the function 
            }
        }
        loggedIn = false;
        successMessageDisplayed = false;
        errorMessageDisplayed = true;
    }

    public void logout() {
        loggedIn = false;
        successMessageDisplayed = false;
        errorMessageDisplayed = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessageDisplayed;
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessageDisplayed;
    }
}
