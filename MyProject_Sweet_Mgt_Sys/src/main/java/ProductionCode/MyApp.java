package ProductionCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyApp {

	private String filePath="";
	public boolean isUserLoggedIn;
	public boolean isSigndUp;
	
	 public ArrayList<User> users;
	 public ArrayList<Admin> admin;
	 public ArrayList<StoreOwner> store_owners;
	 public ArrayList<MaterialSupplier> material_suppliers;
	 private boolean UserLoggedIn;
	 private boolean StoreOwnerLoggedIn;
	 private boolean MaterialSupplierLoggedIn;
	 public boolean AdminLoggedIn;
	 public boolean userDashOpen;
	 //admin
	 public boolean  adminDashbordOpen ;
	 public boolean  userManagementPageOpen ;
	 public boolean  isUserListVisible ;



	
	 
	public MyApp() {
		super();
		
		
		  this.users = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader("files/users.txt"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Assuming each line in the file is in the format: name,age
	                String[] parts = line.split(",");
	                if (parts.length == 2) {
	                    String name = parts[0];
	                    String password = parts[1];
	                    User user = new User(name, password);
	                    this.users.add(user);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
	        
	        this.store_owners = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader("files/store_owners.txt"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Assuming each line in the file is in the format: name,age
	                String[] parts = line.split(",");
	                if (parts.length == 2) {
	                    String name = parts[0];
	                    String password = parts[1];
	                    StoreOwner user = new StoreOwner(name, password);
	                    this.store_owners.add(user);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	  
	        
	        
	        this.material_suppliers = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader("files/material_suppliers.txt"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Assuming each line in the file is in the format: name,age
	                String[] parts = line.split(",");
	                if (parts.length == 2) {
	                    String name = parts[0];
	                    String password = parts[1];
	                    MaterialSupplier user = new MaterialSupplier(name, password);
	                    this.material_suppliers.add(user);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
	        this.admin = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader("files/store_owners.txt"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Assuming each line in the file is in the format: name,age
	                String[] parts = line.split(",");
	                if (parts.length == 2) {
	                    String name = parts[0];
	                    String password = parts[1];
	                    Admin user = new Admin(name, password);
	                    this.admin.add(user);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();}
	        
	       	        
	    }
		
	

	public void SignUp(String username, String password, String role) {
	  if (role.equals("user")) {
		filePath="files/users.txt";
	}
	  else if (role.equals("Store_owner")) {
		  filePath="files/store_owners.txt";
	}
	  else if (role.equals("Material_supplier")) {
		  filePath="files/material_suppliers.txt";
	}
	  else if (role.equals("Admin")) {
		  filePath="files/admin.txt";
	}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
           
			  writer.write(username+","+password);
              writer.newLine();
              isSigndUp=true;
            
            System.out.println("User details written to file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: "+filePath + e.getMessage());
        }
    }

	public void login(String username, String password,String role) {
		 if (role.equals("user")) {
				for (User a : users) {
					isUserLoggedIn=a.getUsername().equals(username) && a.getPassword().equals(password)?true:false;
					UserLoggedIn=true;
					openUserDash();
					if(isUserLoggedIn) return ;
				}
				

				
			}
			  else if (role.equals("Store_owner")) {
				  for (StoreOwner a : store_owners) {
						isUserLoggedIn=a.getUsername().equals(username) && a.getPassword().equals(password)?true:false;
						StoreOwnerLoggedIn=true;
						if(isUserLoggedIn) return ;
					}
			}
			  else if (role.equals("Material_supplier")) {
				  for (MaterialSupplier a : material_suppliers) {
						isUserLoggedIn=a.getUsername().equals(username) && a.getPassword().equals(password)?true:false;
						MaterialSupplierLoggedIn=true;
						if(isUserLoggedIn) return ;
					}
			}
			  else if (role.equals("Admin")) {
				  for (Admin a : admin) {
						isUserLoggedIn=a.getUsername().equals(username) && a.getPassword().equals(password)?true:false;
						AdminLoggedIn=true;
						if(isUserLoggedIn) return ;
					}
			}
		 
	}



	public void openUserDash() {
		if (!UserLoggedIn) return; 
		userDashOpen=true;
		
		
		
		System.out.println("welcome user");
	}



	public void manageAccoutn() {
		// TODO Auto-generated method stub

		
		
	}
	
	
	 public void openAdminDashboard() {
	    adminDashbordOpen = true;
	    System.out.println("Admin Dashboard is now open.");
	    System.out.println("Available Tasks:");
	    System.out.println("1. Manage User Accounts");
	    System.out.println("2. Monitor and Report");
	    System.out.println("3. Content Management");
	}
	
	
//	 public void openUserManagementPage() {
//		    if (!adminDashbordOpen) {
//		        System.out.println("Admin dashboard is not open. Please log in as an admin.");
//		        return;
//		    }
//
//		    System.out.println("User Management Page is now open.");
//		    System.out.println("Options:");
//		    System.out.println("1. View All Users");
//		    System.out.println("2. Add User");
//		    System.out.println("3. Delete User");
//		    System.out.println("4. Update User");
//		    System.out.println("5. Back to Admin Dashboard");
//		    
//		    userManagementPageOpen=true;
//
//		    Scanner scanner = new Scanner(System.in);
//		    int choice = scanner.nextInt();
//
//		    switch (choice) {
//		        case 1:
//		            viewAllUsers();
//		            break;
//		        case 2:
//		            addUser();
//		            break;
//		        case 3:
//		            deleteUser();
//		            break;
//		        case 4:
//		            updateUser();
//		            break;
//		        case 5:
//		            openAdminDashboard();  // Go back to admin dashboard
//		            break;
//		        default:
//		            System.out.println("Invalid choice. Please select a valid option.");
//		            openUserManagementPage();  // Recursively call the function again to display the menu
//		    }
//		}

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
		    isUserListVisible=true;
		}

		public void addUser(String username ,String password , String role) {
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Enter username:");
		   // String username = scanner.nextLine();
		    System.out.println("Enter password:");
		   // String password = scanner.nextLine();
		    System.out.println("Enter role (user, Store_owner, Material_supplier):");
		  //  String role = scanner.nextLine();
		    
		    SignUp(username, password, role);
		    System.out.println(role + " added successfully!");
		}

		public void deleteUser() {
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Enter the username of the account to delete:");
		    String username = scanner.nextLine();

		    users.removeIf(user -> user.getUsername().equals(username));
		    store_owners.removeIf(storeOwner -> storeOwner.getUsername().equals(username));
		    material_suppliers.removeIf(supplier -> supplier.getUsername().equals(username));

		    System.out.println("User " + username + " deleted successfully!");
		}

		public void updateUser() {
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Enter the username of the account to update:");
		    String username = scanner.nextLine();

		    for (User user : users) {
		        if (user.getUsername().equals(username)) {
		            System.out.println("Enter new username:");
		            user.setUsername(scanner.nextLine());
		            System.out.println("Enter new password:");
		            user.setPassword(scanner.nextLine());
		            System.out.println("User updated successfully!");
		            return;
		        }
		    }
		    System.out.println("User " + username + " not found.");
		}

		
	
	public void AdminDashboardOptiones(String optione) {
		if(optione.equals("1"))
			userManagmenetpage();
		else if(optione.equals("2"))
			MonitorAndReport();
		else if(optione.equals("3"))
		    ContentManagement();


			
		
	}
	public void userManagmenetpage() {
		  System.out.println("User Management Page is now open.");
		    System.out.println("Options:");
		    System.out.println("1. View All Users");
		    System.out.println("2. Add User");
		    System.out.println("3. Delete User");
		    System.out.println("4. Update User");
		    System.out.println("5. Back to Admin Dashboard");
		    
		    userManagementPageOpen=true;
			
		
	}
	
	public void MonitorAndReport() {}
	public void ContentManagement() {}

	
	
	}


