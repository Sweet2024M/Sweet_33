package ProductionCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyApp {

	private String filePath="";
	public boolean isLoggedIn;
	public boolean isSigndUp;
	
	 public ArrayList<User> users;
	 public ArrayList<StoreOwner> store_owners;
	 public ArrayList<MaterialSupplier> material_suppliers;
	private boolean UserLoggedIn;
	private boolean StoreOwnerLoggedIn;
	private boolean MaterialSupplierLoggedIn;
	public boolean userDashOpen;
	
	 
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
	        try (BufferedReader br = new BufferedReader(new FileReader("files/material.txt"))) {
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
					isLoggedIn=a.getUsername().equals(username) && a.getPassword().equals(password)?true:false;
					UserLoggedIn=true;
					openUserDash();
					if(isLoggedIn) return ;
				}
				

				
			}
			  else if (role.equals("Store_owner")) {
				  for (StoreOwner a : store_owners) {
						isLoggedIn=a.getUsername().equals(username) && a.getPassword().equals(password)?true:false;
						StoreOwnerLoggedIn=true;
						if(isLoggedIn) return ;
					}
			}
			  else if (role.equals("Material_supplier")) {
				  for (MaterialSupplier a : material_suppliers) {
						isLoggedIn=a.getUsername().equals(username) && a.getPassword().equals(password)?true:false;
						MaterialSupplierLoggedIn=true;
						if(isLoggedIn) return ;
					}
			}
		 
	}



	public void openUserDash() {
		if (!UserLoggedIn) return; 
		userDashOpen=true;
		
		
		
		System.out.println("welcome user");
	}
	
	
	
	
	
	
	
	
	
	
	}


