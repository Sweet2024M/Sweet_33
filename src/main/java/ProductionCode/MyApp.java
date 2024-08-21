  package ProductionCode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyApp {

    private static final String USER_FILE = "files/users.txt";
	private static final String STORE_OWNER_FILE = "files/store_owners.txt";
	private static final String MATERIAL_SUPPLIER_FILE = "files/material_suppliers.txt";
	private static final String ADMIN_FILE = "files/admin.txt";
	private static final String USER_MAIN = "user";
	private static final String STORE_OWNER = "Store_owner";
	private static final String MATERAIL_SUPPLIER = "Material_supplier";
	private static final String ADMIN = "Admin";
	private String filePath = "";
    public boolean isUserLoggedIn;
    public boolean isSignedUp;

    public ArrayList<User> users;
     ArrayList<Admin> adminList;
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
    private String role;
    private String loggedPassword;
    private ArrayList<Order> orders;
	private String currentPage;
    public boolean    contentManagementPageOpen ;

	 private Order currentOrder;
	public boolean reportShown;
	
	public ContentManagement contentmanagement;
	
	    public User user;

    public MyApp() throws FileNotFoundException, IOException {
        super();
        this.user = new User();
        this.user.setApp(this); 
        contentmanagement = new ContentManagement();
        user =new User();
        this.users = new ArrayList<>();
        this.store_owners = new ArrayList<>();
        this.material_suppliers = new ArrayList<>();
        this.adminList = new ArrayList<>();
        this.Products = new ArrayList<>();
        this.orders = new ArrayList<>();

        loadData(USER_FILE, USER_MAIN);
        loadData(STORE_OWNER_FILE, STORE_OWNER);
        loadData(MATERIAL_SUPPLIER_FILE, MATERAIL_SUPPLIER);
        loadData(ADMIN_FILE, ADMIN);
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
                        case USER_MAIN:
                            this.users.add(new User(name, password));
                            break;
                        case STORE_OWNER:
                            this.store_owners.add(new StoreOwner(name, password));
                            break;
                        case MATERAIL_SUPPLIER:
                            this.material_suppliers.add(new MaterialSupplier(name, password));
                            break;
                        case ADMIN:
                            this.adminList.add(new Admin(name, password));
                            break;
                            
                        default:
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
            case USER_MAIN:
                filePath = USER_FILE;
                users.add(new User(username, password));
                break;
            case STORE_OWNER:
                filePath = STORE_OWNER_FILE;
                store_owners.add(new StoreOwner(username, password));
                break;
            case MATERAIL_SUPPLIER:
                filePath = MATERIAL_SUPPLIER_FILE;
                material_suppliers.add(new MaterialSupplier(username, password));
                break;
            case ADMIN:
                filePath = ADMIN_FILE;
                adminList.add(new Admin(username, password));
                break;
                
                default:break;
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
        switch (role) {
            case USER_MAIN:
                authenticateAndSetUser(username, password, users, USER_MAIN, () -> {
                    UserLoggedIn = true;
                    openUserDash();
                });
                break;
            case STORE_OWNER:
                authenticateAndSetUser(username, password, store_owners, STORE_OWNER, () -> StoreOwnerLoggedIn = true);
                break;
            case MATERAIL_SUPPLIER:
                authenticateAndSetUser(username, password, material_suppliers, MATERAIL_SUPPLIER, () -> MaterialSupplierLoggedIn = true);
                break;
            case ADMIN:
                authenticateAndSetUser(username, password, adminList, ADMIN, () -> AdminLoggedIn = true);
                break;
            default:
                System.out.println("Invalid role specified.");
        }
    }

    private void authenticateAndSetUser(String username, String password, ArrayList<?> accountList, String role, Runnable setRoleLoggedIn) {
        for (Object account : accountList) {
            if (isValidUser(account, username, password)) {
                isUserLoggedIn = true;
                loggedName = username;
                this.role = role;
                loggedPassword = password;
                setRoleLoggedIn.run();
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    private boolean isValidUser(Object account, String username, String password) {
        if (account instanceof User) {
            User user = (User) account;
            return user.getUsername().equals(username) && user.getPassword().equals(password);
        } else if (account instanceof StoreOwner) {
            StoreOwner storeOwner = (StoreOwner) account;
            return storeOwner.getUsername().equals(username) && storeOwner.getPassword().equals(password);
        } else if (account instanceof MaterialSupplier) {
            MaterialSupplier materialSupplier = (MaterialSupplier) account;
            return materialSupplier.getUsername().equals(username) && materialSupplier.getPassword().equals(password);
        } else if (account instanceof Admin) {
            Admin admin = (Admin) account;
            return admin.getUsername().equals(username) && admin.getPassword().equals(password);
        }
        return false;
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
            System.out.println("Supplier: " + supplier.getUsername());
        }
        isUserListVisible = true;
    }

    public void addUser(String username, String password, String role) {
        SignUp(username, password, role);
        String message = "User added successfully.";
        addedSuccessfully = true;
        printMessage(message);
    }

    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        store_owners.removeIf(storeOwner -> storeOwner.getUsername().equals(username));
        material_suppliers.removeIf(supplier -> supplier.getUsername().equals(username));
        adminList.removeIf(adminUser -> adminUser.getUsername().equals(username));

        rewriteFile(USER_FILE, users);
        rewriteFile(STORE_OWNER_FILE, store_owners);
        rewriteFile(MATERIAL_SUPPLIER_FILE, material_suppliers);
        rewriteFile(ADMIN, adminList);

        System.out.println("User " + username + " deleted successfully!");
        String message = "User deleted successfully.";
        deletedSuccessfully = true;
        printMessage(message);
    }

    public void updateUser(String oldUsername, String newUsername, String newPassword) {
        for (User user : users) {
            if (user.getUsername().equals(oldUsername)) {
                user.setUsername(newUsername);
                user.setPassword(newPassword);
                rewriteFile(USER_FILE, users);
                System.out.println("User updated successfully!");
                String message = "User updated successfully.";
                updatedSuccessfully = true;
                printMessage(message);
                return;
            }
        }
        for (StoreOwner storeOwner : store_owners) {
            if (storeOwner.getUsername().equals(oldUsername)) {
                storeOwner.setUsername(newUsername);
                storeOwner.setPassword(newPassword);
                rewriteFile(STORE_OWNER, store_owners);
                System.out.println("Store Owner updated successfully!");
                String message = "User updated successfully.";
                updatedSuccessfully = true;
                printMessage(message);
                return;
            }
        }
        for (MaterialSupplier supplier : material_suppliers) {
            if (supplier.getUsername().equals(oldUsername)) {
                supplier.setUsername(newUsername);
                supplier.setPassword(newPassword);
                rewriteFile(MATERIAL_SUPPLIER_FILE, material_suppliers);
                System.out.println("Material Supplier updated successfully!");
                String message = "User updated successfully.";
                updatedSuccessfully = true;
                printMessage(message);
                return;
            }
        }
        for (Admin adminUser : adminList) {
            if (adminUser.getUsername().equals(oldUsername)) {
                adminUser.setUsername(newUsername);
                adminUser.setPassword(newPassword);
                rewriteFile(ADMIN_FILE, adminList);
                System.out.println("Admin updated successfully!");
                String message = "User updated successfully.";
                updatedSuccessfully = true;
                printMessage(message);
                return;
            }
        }

        System.out.println("User " + oldUsername + " not found.");
    }

    public void AdminDashboardOptiones(String option) {
        switch (option) {
            case "1":
                userManagementPageOpen = true;

                System.out.println("User Management Page is now open.");
                System.out.println("Options:");
                System.out.println("1. View All Users");
                System.out.println("2. Add User");
                System.out.println("3. Delete User");
                System.out.println("4. Update User");
                System.out.println("5. Back to Admin Dashboard");

                break;
            case "2":
                MonitorAndReport();
                break;
            case "3":
            	   contentManagementPageOpen = true;
            	   
            	   System.out.println("1. View Recipe");
                   System.out.println("2. Delete Recipe");
                   System.out.println("3. View feedback");
                   System.out.println("4. Respond feedback");
                   System.out.println("5. Delete feedback");
            	   break;
        }
    }

    public void AdminDashboardpage() {
        adminDashbordOpen = true;
        System.out.println("Admin Dashboard is now open.");
        System.out.println("Available Tasks:");
        System.out.println("1. Manage User Accounts");
        System.out.println("2. Monitor and Report");
        System.out.println("3. Content Management");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

   

    private void MonitorAndReport() {
        // TODO Auto-generated method stub

    }

    public void navigateTo(String page) {
        if (StoreOwnerLoggedIn || MaterialSupplierLoggedIn||AdminLoggedIn) {
            currentPage = page;
        } else {
            throw new AssertionError("User not logged in or invalid user role.");
        }
    }

    public void addProduct(String productName, String price, String expDate) {
        Product newProduct = new Product(productName, price, expDate);
        Products.add(newProduct);  // Add to the existing list
        rewriteFile("files/products.txt", Products);  // Write the entire list back to the file
    }

    public void editProduct(String productName, String price, String expDate) {
        String updatedline = productName + "," + price + "," + expDate;
        try {
            List<String> lines = Files.readAllLines(Paths.get("files/products.txt"));
            List<String> updatedLines = new ArrayList<>();
            for (String line : lines) {
                if (line.contains(productName)) {
                    updatedLines.add(updatedline); // Replace the line
                    updateMessage = true;
                } else {
                    updatedLines.add(line); // Keep the line unchanged
                }
            }
            Files.write(Paths.get("files/products.txt"), updatedLines);
            System.out.println("File has been updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isProductInList(String name) {
        for (Product product : Products) {
            if (product.getProductName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void loadProducts() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("files/products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String productname = parts[0];
                    String price = parts[1];
                    String exp = parts[2];
                    Product a = new Product(productname, price, exp);
                    Products.add(a);
                }
            }
        }
    }

    public void deleteProduct(String productName) {
        Products.removeIf(product -> product.getProductName().equals(productName));
        rewriteFile("files/products.txt", Products);  // Write the updated list back to the file
        deletedProductSuccessfully = true;
    }

    public void getSalesReport() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("files/purchasedProducts.txt"))) {
            String line;
            double TotalSales = 0;
            double Profit = 0;
            int quantity = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String purchasedName = parts[0];
                    String quan = parts[1];
                    String purchasedPrice = parts[2];
                    TotalSales += (Double.parseDouble(purchasedPrice) * Double.parseDouble(quan));
                    quantity += Double.parseDouble(quan);
                }
            }
            Profit = TotalSales - quantity * 50;
            System.out.println("The Total number of sales: " + quantity);
            System.out.println("The total sales is: " + TotalSales);
            System.out.println("The profit is: " + Profit);
            reportGenerated = true;
        }
    }

    public void getBestSellingProduct() throws NumberFormatException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("files/purchasedProducts.txt"))) {
            String line;
            int quantity = 0;
            String name = "";
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String productname = parts[0];
                    String quan = parts[1];
                    if (quantity < Integer.parseInt(quan)) {
                        quantity = Integer.parseInt(quan);
                        name = productname;
                    }
                }
            }
            System.out.println("The highest number of sales: " + quantity);
            System.out.println("The best selling product is: " + name);
        }
    }

    public void addDiscount(String discount) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("files/products.txt"))) {
            String line;
            double newPrice = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String productname = parts[0];
                    String price = parts[1];
                    String exp = parts[2];
                    if (Double.parseDouble(price) == Double.parseDouble(discount)) {
                        newPrice = Double.parseDouble(price) * 35 / 100;
                        deleteProduct(productname);
                        addProduct(productname, "" + newPrice, exp);
                        System.out.println("The discount at " + productname + ": Original price = " + price + ", Discounted price = " + newPrice);
                        discountMessagepos = true;
                    }
                }
            }
        }
    }

    public void sendMessageToUser(String username, String message) {
        String path = "files/messagesToSuppliers.txt";
        String content = username + ", " + message;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Message sent successfully.");
            messageSentToUser = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToSupplier(String supplierName, String message) {
        String path = "files/messagesToUsers.txt";
        String content = supplierName + ", " + message;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Message sent successfully.");
            messageSentToSupplier = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToOwner(String ownerName, String message) {
        String path = "files/messagesToOwner.txt";
        String content = ownerName + ", " + message;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Message sent successfully.");
            messageSentToSupplier = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAccountDetails() {
        System.out.println("Account name: " + this.loggedName);
        System.out.println("Account password: " + this.loggedPassword);
        System.out.println("Account role: " + this.role);
    }

    public void EditBusinessInformation(String op, String accName, String password) {
        if (op.equals("Edit Business Information")) {
            updateUser(loggedName, accName, password);
        }
    }

    public void listOrders() throws FileNotFoundException, IOException {
        loadOrders();  // Ensure the latest orders are loaded from the file
        System.out.println("Order List:");
        for (Order order : orders) {
            System.out.println(order.getOrderDetails());
        }
    }

    public void processOrder(String oNum, String op) throws IOException {
        for (Order order : orders) {
            if (order.orderNum.equals(oNum)) {
                if ("Process".equals(op)) {
                    order.setStatus("processed");
                } else {
                    throw new IllegalArgumentException("Invalid operation");
                }
                break;
            }
        }
        rewriteFile("files/orders.txt", orders);  // Update the orders in the file
    }

    public boolean isOrderStatusUpdated(String oNum, String expectedStatus) {
        for (Order order : orders) {
            if (order.orderNum.equals(oNum)) {
                return order.getStatus().equals(expectedStatus);
            }
        }
        return false;
    }

    private void loadOrders() throws FileNotFoundException, IOException {
        orders.clear();  // Clear existing orders before loading new ones
        try (BufferedReader br = new BufferedReader(new FileReader("files/orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String orderNum = parts[0];
                    String storeOwner = parts[1];
                    String receiver = parts[2];
                    String productName = parts[3];
                    String status = parts[4];
                    Order order = new Order(orderNum, storeOwner, receiver, productName, status);
                    orders.add(order);
                }
            }
        }
    }
    public void selectOrderByNumber(String orderNum) {
        for (Order order : orders) {
            if (order.orderNum.equals(orderNum)) {
                currentOrder = order;
                break;
            }
        }
        if (currentOrder == null) {
            throw new AssertionError("Order with number " + orderNum + " not found.");
        }
    }

    public String getCurrentOrderStatus() {
        if (currentOrder != null) {
            System.out.println("Current order status: " + currentOrder.getStatus());
            return currentOrder.getStatus();
        } else {
            return null;
        }
    }
    public void returnToManagementPage() {
        navigateTo("order management page");
    }

    public boolean isOnPage(String page) {
        return currentPage.equals(page);
    }

	public void selectReport(String profitReports) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		if (profitReports.equals("Profit Reports")) {
			 try (BufferedReader br = new BufferedReader(new FileReader("files/purchasedProducts.txt"))) {
		            String line;
		            double TotalSales = 0;
		            double Profit = 0;
		            int quantity = 0;
		            while ((line = br.readLine()) != null) {
		                String[] parts = line.split(",");
		                if (parts.length == 3) {
		                    String purchasedName = parts[0];
		                    String quan = parts[1];
		                    String purchasedPrice = parts[2];
		                    TotalSales += (Double.parseDouble(purchasedPrice) * Double.parseDouble(quan));
		                    quantity += Double.parseDouble(quan);
		                }
		            }
		            Profit = TotalSales - quantity * 50;
		            System.out.println("The profit is: " + Profit);
		            reportGenerated = true;
		        }
		reportShown=true;
		}
		if (profitReports.equals("Generate Financial Report")) {
			this.getSalesReport();
		}
		
		
		
	}
	public String getCurrentUsername() {
		return loggedName;
	}
}
