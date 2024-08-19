package MainPackage;

import java.io.IOException;
import java.util.Scanner;
import ProductionCode.MyApp;
import ProductionCode.User;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MyApp app = new MyApp();
            System.out.println("Welcome to the Alternative Sweet Management System!");

            while (true) {
                displayMainMenu();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        signUp(app, scanner);
                        break;
                    case "2":
                        login(app, scanner);
                        break;
                    case "3":
                        System.out.println("Exiting the system. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayMainMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    private static void signUp(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        System.out.println("Enter Role (user, Store_owner, Material_supplier, Admin):");
        String role = scanner.nextLine();
        app.SignUp(username, password, role);
    }

    private static void login(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        System.out.println("Enter Role (user, Store_owner, Material_supplier, Admin):");
        String role = scanner.nextLine();
        app.login(username, password, role);

        if (app.isUserLoggedIn) {
            User user = app.user; // Assuming `app.user` gives the current logged-in user
            user.setApp(app); // Set the MyApp instance in the user for any necessary references

            switch (role) {
                case "Admin":
                    adminDashboard(app, scanner);
                    break;
                case "Store_owner":
                    storeOwnerDashboard(app, scanner);
                    break;
                case "Material_supplier":
                    supplierDashboard(app, scanner);
                    break;
                default:
                    userDashboard(user, app, scanner); // Pass the MyApp instance here
                    break;
            }
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }

    private static void adminDashboard(MyApp app, Scanner scanner) throws IOException {
        while (true) {
            app.AdminDashboardpage();
            System.out.println("Enter your choice:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    app.AdminDashboardOptiones("1");
                    userManagement(app, scanner);
                    break;
                case "2":
                    app.AdminDashboardOptiones("2");
                    handleReports(app, scanner);
                    break;
                case "3":
                    app.AdminDashboardOptiones("3");
                    contentManagement(app, scanner);
                    break;
                default:
                    System.out.println("Returning to main menu.");
                    return;
            }
        }
    }

    private static void handleReports(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Generate Financial Report or view Best Selling Products:");
        String reportOption = scanner.nextLine();
        if (reportOption.equalsIgnoreCase("Generate Financial Report")) {
            app.getSalesReport();
        } else if (reportOption.equalsIgnoreCase("Best Selling Product")) {
            app.getBestSellingProduct();
        }
    }

    private static void userManagement(MyApp app, Scanner scanner) throws IOException {
        while (true) {
            displayUserManagementMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    app.viewAllUsers();
                    break;
                case "2":
                    addUser(app, scanner);
                    break;
                case "3":
                    deleteUser(app, scanner);
                    break;
                case "4":
                    updateUser(app, scanner);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void displayUserManagementMenu() {
        System.out.println("User Management Options:");
        System.out.println("1. View All Users");
        System.out.println("2. Add User");
        System.out.println("3. Delete User");
        System.out.println("4. Update User");
        System.out.println("5. Back to Admin Dashboard");
    }

    private static void addUser(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter new Username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter Password:");
        String newPassword = scanner.nextLine();
        System.out.println("Enter Role:");
        String newRole = scanner.nextLine();
        app.addUser(newUsername, newPassword, newRole);
    }

    private static void deleteUser(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter Username to delete:");
        String deleteUsername = scanner.nextLine();
        app.deleteUser(deleteUsername);
    }

    private static void updateUser(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter current Username:");
        String oldUsername = scanner.nextLine();
        System.out.println("Enter new Username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new Password:");
        String newPassword = scanner.nextLine();
        app.updateUser(oldUsername, newUsername, newPassword);
    }

    private static void storeOwnerDashboard(MyApp app, Scanner scanner) throws IOException {
        while (true) {
            displayStoreOwnerMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manageProducts(app, scanner);
                    break;
                case "2":
                    app.listOrders();
                    break;
                case "3":
                    createSpecialRequest(scanner);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayStoreOwnerMenu() {
        System.out.println("Store Owner Dashboard:");
        System.out.println("1. Manage Products");
        System.out.println("2. View Orders");
        System.out.println("3. Create Special Request");
        System.out.println("4. Back to Main Menu");
    }

    private static void createSpecialRequest(Scanner scanner) {
        System.out.println("Enter request details:");
        String requestDetails = scanner.nextLine();
        // Implement the method to handle special requests
        System.out.println("Special request feature not implemented yet.");
    }

    private static void manageProducts(MyApp app, Scanner scanner) throws IOException {
        while (true) {
            displayProductManagementMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addProduct(app, scanner);
                    break;
                case "2":
                    editProduct(app, scanner);
                    break;
                case "3":
                    deleteProduct(app, scanner);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayProductManagementMenu() {
        System.out.println("Product Management:");
        System.out.println("1. Add Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Back to Store Owner Dashboard");
    }

    private static void addProduct(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter Product Name:");
        String productName = scanner.nextLine();
        System.out.println("Enter Product Price:");
        String productPrice = scanner.nextLine();
        System.out.println("Enter Product Expiration Date:");
        String expDate = scanner.nextLine();
        app.addProduct(productName, productPrice, expDate);
    }

    private static void editProduct(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter Product Name to Edit:");
        String productName = scanner.nextLine();
        System.out.println("Enter new Price:");
        String productPrice = scanner.nextLine();
        System.out.println("Enter new Expiration Date:");
        String expDate = scanner.nextLine();
        app.editProduct(productName, productPrice, expDate);
    }

    private static void deleteProduct(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter Product Name to Delete:");
        String productName = scanner.nextLine();
        app.deleteProduct(productName);
    }

    private static void supplierDashboard(MyApp app, Scanner scanner) throws IOException {
        while (true) {
            displaySupplierMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    app.listOrders();
                    break;
                case "2":
                    processOrder(app, scanner);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displaySupplierMenu() {
        System.out.println("Material Supplier Dashboard:");
        System.out.println("1. View Orders");
        System.out.println("2. Process Order");
        System.out.println("3. Back to Main Menu");
    }

    private static void processOrder(MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter Order Number to Process:");
        String orderNum = scanner.nextLine();
        app.processOrder(orderNum, "Process");
    }

    private static void userDashboard(User user, MyApp app, Scanner scanner) {
        user.UserDashboard();
        while (true) {
            user.printDashboard(); // Assuming this prints the available options
            System.out.println("Enter your choice:");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    postAndShareDessert(user, scanner);
                    break;
                case "2":
                    browseDessertRecipes(user, scanner);
                    break;
                case "3":
                    filterRecipes(user, scanner);
                    break;
                case "4":
                    purchaseProduct(user, scanner);
                    break;
                case "5":
                    communicate(user, scanner);
                    break;
                case "6":
                    sendFeedback(user, scanner);
                    break;
                case "7":
                    try {
                        manageAccount(user, app, scanner); // Pass MyApp instance
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void postAndShareDessert(User user, Scanner scanner) {
        System.out.println("Enter the name of your dessert:");
        String dessertName = scanner.nextLine();
        System.out.println("Enter the ingredients and preparation details:");
        String components = scanner.nextLine();
        user.PostAndSharePersonalDessert(dessertName, components);
    }

    private static void browseDessertRecipes(User user, Scanner scanner) {
        System.out.println("Enter the name of the recipe you want to search for:");
        String recipeName = scanner.nextLine();
        user.SearchDessertRecipes(recipeName);
    }

    private static void filterRecipes(User user, Scanner scanner) {
        System.out.println("Enter the dietary needs or ingredients to filter recipes:");
        String ingredient = scanner.nextLine();
        user.filterRecipes(ingredient);
    }

    private static void purchaseProduct(User user, Scanner scanner) {
        System.out.println("Enter Product Name to Purchase:");
        String productName = scanner.nextLine();
        System.out.println("Enter Quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
        user.purchaseProduct(productName, quantity);
    }

    private static void communicate(User user, Scanner scanner) {
        System.out.println("Enter 'owner' or 'supplier' to communicate with:");
        String userType = scanner.nextLine();
        System.out.println("Enter your message:");
        String message = scanner.nextLine();
        user.chatWithOwner_Supplier(userType, message);
    }

    private static void sendFeedback(User user, Scanner scanner) {
        System.out.println("Enter your feedback:");
        String feedback = scanner.nextLine();
        user.sendFeedback(feedback);
    }

    private static void manageAccount(User user, MyApp app, Scanner scanner) throws IOException {
        while (true) {
            displayAccountManagementMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    updateAccount(user, app, scanner);
                    break;
                case "2":
                    deleteAccount(user, app, scanner);
                    return; // Exit after deleting the account
                case "3":
                    System.out.println("Returning to User Dashboard...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayAccountManagementMenu() {
        System.out.println("Manage Personal Account:");
        System.out.println("1. Update Account Information");
        System.out.println("2. Delete Account");
        System.out.println("3. Back to User Dashboard");
    }

    private static void updateAccount(User user, MyApp app, Scanner scanner) throws IOException {
        System.out.println("Enter your current username:");
        String currentUsername = scanner.nextLine();
        
        if (!currentUsername.equals(app.loggedName)) {
            System.out.println("Incorrect username. Cannot update account.");
            return;
        }

        System.out.println("Enter new Username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new Password:");
        String newPassword = scanner.nextLine();

        app.updateUser(currentUsername, newUsername, newPassword);

        // Update the User object with new details
        user.setUsername(newUsername);
        user.setPassword(newPassword);

        System.out.println("Account updated successfully.");
    }

    private static void deleteAccount(User user, MyApp app, Scanner scanner) throws IOException {
        System.out.println("Are you sure you want to delete your account? This action cannot be undone. (yes/no)");
        String confirmation = scanner.nextLine();

        if ("yes".equalsIgnoreCase(confirmation)) {
            app.deleteUser(user.getUsername());
            System.out.println("Account deleted successfully. Logging out...");
            user.setUsername(null); // Clear the current user session
            user.setPassword(null);
        } else {
            System.out.println("Account deletion canceled.");
        }
    }

    private static void contentManagement(MyApp app, Scanner scanner) throws IOException {
        // This would depend on how ContentManagement is handled
        // Assuming it uses similar methods as before
    }
}
