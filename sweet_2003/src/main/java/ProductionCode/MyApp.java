package ProductionCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyApp {

	String filePath="files/users.txt";
	
	
    private ArrayList<User> users;
    private boolean loggedIn;
    private boolean successMessageDisplayed;
    private boolean errorMessageDisplayed;


	public boolean isSigndUp;


	public boolean accountCreated;

    public MyApp() {
        // Initialize the ArrayList and add users
        this.users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
    
    public void signUp(String username, String password) {
    	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            
                 writer.write(username+","+password);
                 writer.newLine();
             
             System.out.println("Credentials written to file successfully.");
         } catch (IOException e) {
             System.err.println("An error occurred while writing to the file: " + e.getMessage());
         }
     }

	public boolean searchName(String username, String password) {
		for (User user : users) {
		if (user.getName()==username) {
			this.isSigndUp=true;
		} else {
			this.isSigndUp=false;
		}
		}
		return this.isSigndUp;
	}
    }
    

