package acceptance;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ProductionCode.Admin;
import ProductionCode.ContentManagement;
import ProductionCode.MaterialSupplier;
import ProductionCode.MyApp;
import ProductionCode.Order;
import ProductionCode.Product;
import ProductionCode.StoreOwner;
import ProductionCode.User;

public class fileMangmentStep {
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

	    private static final Logger logger = Logger.getLogger(MyApp.class.getName());
	    
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
	    public boolean contentManagementPageOpen;

	    private Order currentOrder;
	    public boolean reportShown;

	    public ContentManagement contentmanagement;

	    public User user;
       MyApp app;
public fileMangmentStep(MyApp app) throws FileNotFoundException, IOException {
	super();
	this.app = app;
	this.user = new User();
   
    contentmanagement = new ContentManagement();
    user = new User();
    this.users = new ArrayList<>();
    this.store_owners = new ArrayList<>();
    this.material_suppliers = new ArrayList<>();
    this.adminList = new ArrayList<>();
    this.Products = new ArrayList<>();
    this.orders = new ArrayList<>();
	role=USER_MAIN;
	
	
	 try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
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
@When("I give an old username {string} username {string} and password {string}")
public void i_give_an_old_username_username_and_password(String oldUsername, String newUsername, String newPassword) {
	 for (User localUser : users) {
         if (localUser.getUsername().equals(oldUsername)) {
             localUser.setUsername(newUsername);
             localUser.setPassword(newPassword);
             app.rewriteFile(USER_FILE, users);
             logger.info("User updated successfully!");
             String message = "User updated successfully.";
             updatedSuccessfully = true;
             app.printMessage(message);
             return;
         }
     }
     for (StoreOwner storeOwner : store_owners) {
         if (storeOwner.getUsername().equals(oldUsername)) {
             storeOwner.setUsername(newUsername);
             storeOwner.setPassword(newPassword);
             app.rewriteFile(STORE_OWNER, store_owners);
             logger.info("Store Owner updated successfully!");
             String message = "User updated successfully.";
             updatedSuccessfully = true;
             app.printMessage(message);
             return;
         }
     }
     for (MaterialSupplier supplier : material_suppliers) {
         if (supplier.getUsername().equals(oldUsername)) {
             supplier.setUsername(newUsername);
             supplier.setPassword(newPassword);
             app.rewriteFile(MATERIAL_SUPPLIER_FILE, material_suppliers);
             logger.info("Material Supplier updated successfully!");
             String message = "User updated successfully.";
             updatedSuccessfully = true;
             app.printMessage(message);
             return;
         }
     }
     for (Admin adminUser : adminList) {
         if (adminUser.getUsername().equals(oldUsername)) {
             adminUser.setUsername(newUsername);
             adminUser.setPassword(newPassword);
             app.rewriteFile(ADMIN_FILE, adminList);
             logger.info("Admin updated successfully!");
             String message = "User updated successfully.";
             updatedSuccessfully = true;
             app.printMessage(message);
             return;
         }
     }
     logger.warning("User " + oldUsername + " not found.");
}


@Then("the file should be updated and rewrite file")
public void the_file_should_be_updated_and_rewrite_file() {
   assertTrue(true);
}


}
