package ProductionCode;

import java.util.ArrayList;

public class Login {
    private ArrayList<User> users;
    private ArrayList<UserType> user_type;
    private ArrayList<RawMaterialSupplier> supplier;
    private ArrayList<StoreOwner> owner;
    private ArrayList<Admin> admin;
    static public boolean login_page;
    static public boolean admin_page;
    public String type_user;
    public boolean loggedIn;
    private boolean successMessageDisplayed;
    private boolean errorMessageDisplayed;

    public Login() {
        // Initialize the ArrayList and add users
        this.users = new ArrayList<>();
        this.users.add(new User("mohammad", "123"));
        this.users.add(new User("jawad", "123"));
        this.users.add(new User("bashar", "123"));
        this.users.add(new User("rami", "123"));
        this.users.add(new User("diana", "123"));
        
        // Initialize the ArrayList and add admin
        this.admin = new ArrayList<>();
        this.admin.add(new Admin("Hamode", "123"));

        // Initialize the ArrayList and add user types
        this.user_type = new ArrayList<>();
        this.user_type.add(new UserType("Admin"));
        this.user_type.add(new UserType("Store Owner"));
        this.user_type.add(new UserType("Raw Material Supplier"));
        this.user_type.add(new UserType("Beneficiary User"));
        
        // Initialize the ArrayList and add suppliers
        this.supplier = new ArrayList<>();
        this.supplier.add(new RawMaterialSupplier("khaled", "123"));
        
        // Initialize the ArrayList and add owners
        this.owner = new ArrayList<>();
        this.owner.add(new StoreOwner("ahmad", "123"));
        
        // Initialize other fields
        this.loggedIn = false;
        this.successMessageDisplayed = false;
        this.errorMessageDisplayed = false;
        this.type_user = "Unknown"; // Default value to avoid null
    }

    public void user_login(String username, String password) {
        if (type_user == null) {
            throw new IllegalStateException("User type is not set.");
        }
        if (type_user.equals("Beneficiary User")) {
            for (User u : users) {
                if (u.getName().equals(username) && u.getPassword().equals(password)) {
                    loggedIn = true;
                    successMessageDisplayed = true;
                    errorMessageDisplayed = false;
                    login_page = false;
                    return;
                }
            }
            loggedIn = false;
            successMessageDisplayed = false;
            errorMessageDisplayed = true;
        }
    }
    
    public void admin_login(String username, String password) {
        if (type_user == null) {
            throw new IllegalStateException("User type is not set.");
        }
        if (type_user.equals("Admin")) {
            for (Admin a : admin) {
                if (a.getName().equals(username) && a.getPassword().equals(password)) {
                    loggedIn = true;
                    successMessageDisplayed = true;
                    errorMessageDisplayed = false;
                    login_page = false;
                    return;
                }
            }
            loggedIn = false;
            successMessageDisplayed = false;
            errorMessageDisplayed = true;
        }
    }
    
    public void supplier_login(String username, String password) {
        if (type_user == null) {
            throw new IllegalStateException("User type is not set.");
        }
        if (type_user.equals("Raw Material Supplier")) {
            for (RawMaterialSupplier s : supplier) {
                if (s.getName().equals(username) && s.getPassword().equals(password)) {
                    loggedIn = true;
                    successMessageDisplayed = true;
                    errorMessageDisplayed = false;
                    login_page = false;
                    return;
                }
            }
            loggedIn = false;
            successMessageDisplayed = false;
            errorMessageDisplayed = true;
        }
    }
    
    public void owner_login(String username, String password) {
        if (type_user == null) {
            throw new IllegalStateException("User type is not set.");
        }
        if (type_user.equals("Store Owner")) {
            for (StoreOwner o : owner) {
                if (o.getName().equals(username) && o.getPassword().equals(password)) {
                    loggedIn = true;
                    successMessageDisplayed = true;
                    errorMessageDisplayed = false;
                    login_page = false;
                    return;
                }
            }
            loggedIn = false;
            successMessageDisplayed = false;
            errorMessageDisplayed = true;
        }
    }

    public void userType(String type) {
        boolean validType = false;
        for (UserType t : user_type) {
            if (t.getType().equals(type)) {
                type_user = type;
                validType = true;
                break;
            }
        }
        if (!validType) {
            System.out.println("Invalid user type: " + type);
            type_user = "Unknown"; // Reset to default if type is invalid
        } else {
            System.out.println("User type set to: " + type_user);
        }
    }

    public void logout() {
        loggedIn = false;
        successMessageDisplayed = false;
        errorMessageDisplayed = false;
        login_page = true;
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
