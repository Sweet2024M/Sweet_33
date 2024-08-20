package ProductionCode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import ProductionCode.*;

public class MyApp {

    // Define constants for file paths
    private static final String USERS_FILE_PATH = "files/users.txt";
    private static final String STORE_OWNERS_FILE_PATH = "files/store_owners.txt";
    private static final String MATERIAL_SUPPLIERS_FILE_PATH = "files/material_suppliers.txt";
    private static final String ADMIN_FILE_PATH = "files/admin.txt";
    private static final String PRODUCTS_FILE_PATH = "files/products.txt";
    private static final String ORDERS_FILE_PATH = "files/orders.txt";
    private static final String MESSAGES_TO_USERS_FILE_PATH = "files/messagesToUsers.txt";
    private static final String MESSAGES_TO_SUPPLIERS_FILE_PATH = "files/messagesToSuppliers.txt";
    private static final String MESSAGES_TO_OWNER_FILE_PATH = "files/messagesToOwner.txt";
    private static final String PURCHASED_PRODUCTS_FILE_PATH = "files/purchasedProducts.txt";

    private String filePath = "";
    public boolean isUserLoggedIn;
    public boolean isSignedUp;

    public ArrayList<User> users;
    public ArrayList<Admin> admin;
    public ArrayList<StoreOwner> store_owners;
    public ArrayList<MaterialSupplier> material_suppliers;
    public ArrayList<Product> Products;
    private boolean UserLoggedIn;
    public boolean StoreOwnerLoggedIn;
    private boolean MaterialSupplierLoggedIn;
    public boolean AdminLoggedIn;
    public boolean userDashOpen;
    public boolean adminDashbordOpen;
    public boolean userManagementPageOpen;
    public boolean isUserListVisible;
    public boolean addUserChoise;
    public boolean isSigndUp;
    public boolean addedSuccessfully;
    public boolean updatedSuccessfully;
    public boolean deletedSuccessfully;
    private String ownerName;
    public boolean updateMessage;
    public boolean deletedProductSuccessfully;
    public boolean reportGenerated;
    public boolean discountMessagepos;
    public boolean messageSentToUser;
    public boolean messageSentToSupplier;
    public static String loggedName;
    private String ROLE;
    private String loggedPassword;
    private ArrayList<Order> orders;
    private String currentPage;
    public boolean contentManagementPageOpen;

    private Order currentOrder;
    public boolean reportShown;

    public ContentManagement contentmanagement;

    public User user;

    public MyApp() throws FileNotFoundException, IOException {
        super();
        this.user = new User();
        this.user.setApp(this); 
        contentmanagement = new ContentManagement();
        user = new User();
        this.users = new ArrayList<>();
        this.store_owners = new ArrayList<>();
        this.material_suppliers = new ArrayList<>();
        this.admin = new ArrayList<>();
        this.Products = new ArrayList<>();
        this.orders = new ArrayList<>();

        loadData(USERS_FILE_PATH, "user");
        loadData(STORE_OWNERS_FILE_PATH, "Store_owner");
        loadData(MATERIAL_SUPPLIERS_FILE_PATH, "Material_supplier");
        loadData(ADMIN_FILE_PATH, "Admin");
        loadProducts();
        loadOrders();
    }

    private void loadData(String fileName, String role) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    String password = parts[1];
                    switch (role) {
                        case "user":
                            this.users.add(new User(name, password));
                            break;
                        case "Store_owner":
                            this.store_owners.add(new StoreOwner(name, password));
                            break;
                        case "Material_supplier":
                            this.material_suppliers.add(new MaterialSupplier(name, password));
                            break;
                        case "Admin":
                            this.admin.add(new Admin(name, password));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SignUp(String username, String password, String role) {
        switch (role) {
            case "user":
                filePath = USERS_FILE_PATH;
                users.add(new User(username, password));
                break;
            case "Store_owner":
                filePath = STORE_OWNERS_FILE_PATH;
                store_owners.add(new StoreOwner(username, password));
                break;
            case "Material_supplier":
                filePath = MATERIAL_SUPPLIERS_FILE_PATH;
                material_suppliers.add(new MaterialSupplier(username, password));
                break;
            case "Admin":
                filePath = ADMIN_FILE_PATH;
                admin.add(new Admin(username, password));
                break;
        }

        updateFile(filePath, username, password, false);
        isSignedUp = true;
        System.out.println(role + " added successfully!");
        isSigndUp = true;
    }

    private void updateFile(String filePath, String username, String password, boolean isDelete) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (!isDelete) {
                writer.write(username + "," + password);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while updating the file: " + filePath + " " + e.getMessage());
        }
    }

    private void rewriteFile(String filePath, ArrayList<?> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (Object obj : list) {
                if (obj instanceof User) {
                    writer.write(((User) obj).getUsername() + "," + ((User) obj).getPassword());
                } else if (obj instanceof StoreOwner) {
                    writer.write(((StoreOwner) obj).getUsername() + "," + ((StoreOwner) obj).getPassword());
                } else if (obj instanceof MaterialSupplier) {
                    writer.write(((MaterialSupplier) obj).getUsername() + "," + ((MaterialSupplier) obj).getPassword());
                } else if (obj instanceof Admin) {
                    writer.write(((Admin) obj).getUsername() + "," + ((Admin) obj).getPassword());
                } else if (obj instanceof Product) {
                    writer.write(((Product) obj).getProductName() + "," + ((Product) obj).getPrice() + "," + ((Product) obj).getExpDate());
                } else if (obj instanceof Order) {
                    writer.write(((Order) obj).orderNum + "," + ((Order) obj).senderName + "," + ((Order) obj).reciver + "," + ((Order) obj).productName + "," + ((Order) obj).getStatus());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while rewriting the file: " + filePath + " " + e.getMessage());
        }
    }

    public void login(String username, String password, String role) {
        if (role.equals("user")) {
            for (User a : users) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                    isUserLoggedIn = true;
                    UserLoggedIn = true;
                    openUserDash();
                    loggedName = username;
                    ROLE = "user";
                    loggedPassword = password;
                    return;
                }
            }
        }

        if (role.equals("Store_owner")) {
            for (StoreOwner a : store_owners) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                    isUserLoggedIn = true;
                    StoreOwnerLoggedIn = true;
                    loggedName = username;
                    ROLE = "Store_owner";
                    loggedPassword = password;
                    return;
                }
            }
        }
        if (role.equals("Material_supplier")) {
            for (MaterialSupplier a : material_suppliers) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                    isUserLoggedIn = true;
                    MaterialSupplierLoggedIn = true;
                    loggedName = username;
                    ROLE = "Material_supplier";
                    loggedPassword = password;
                    return;
                }
            }
        }
        if (role.equals("Admin")) {
            for (Admin a : admin) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                    isUserLoggedIn = true;
                    AdminLoggedIn = true;
                    loggedName = username;
                    ROLE = "Admin";
                    loggedPassword = password;
                    return;
                }
            }
        }

    }

    public void openUserDash() {
        if (!UserLoggedIn) return;
        userDashOpen = true;
        System.out.println("Welcome user");
    }

    public void viewAllUsers() {
        System.out.println("List of all users:");
        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
        }
        for (StoreOwner storeOwner : store_owners) {
            System.out.println("Store Owner: " + storeOwner.getUsername());
        }
        for (MaterialSupplier supplier : material_suppliers) {
            System.out.println("Material Supplier: " + supplier.getUsername());
        }
        for (Admin admin : admin) {
            System.out.println("Admin: " + admin.getUsername());
        }
    }

    // Additional methods for managing users, products, orders, etc. should be updated similarly.

}
