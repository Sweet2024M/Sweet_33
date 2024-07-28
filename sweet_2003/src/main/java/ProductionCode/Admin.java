package ProductionCode;

import java.util.ArrayList;

public class Admin {
 
	private ArrayList<User> users;
	private boolean logIn = false, logOut = true;
    private String name, password;
    
	public Admin() {
		super();
	}

	public void login(String username, String password) {   
        logIn = true;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public boolean isLoggedIn() {
		
		if(logIn && !logOut)return true;
		else return false;
		
	}
    
  public void addUser(int id,String name, String password, String userType) {
		User user = new User(id,name,password,userType);
		users.add(user);	
	}
  
  public void updateUser(int id,String name, String password, String userType) {
		for(User user: users) {
			if(user.getId()== id) {
				user.setPassword(password);
				user.setUserType(userType);
			}
		}
	}
  
  public void deleteUser(int id,String name, String password, String userType) {
	  for(User user: users) {
			if(user.getId()== id) {
				users.remove(id);
			}
		}	
	}
  
  public void selectService(String serviceName) {
	  if(serviceName == "add")
		  addUser(0,"name","password","user Type");
	  else if(serviceName == "update")
		  updateUser(0,"name","password","user Type");
	  else if(serviceName == "delete")
		  deleteUser(0,"name","password","user Type");
  }
  
	public boolean isUserExist(int id) {
		for(User user:users) {
			if(user.getId()==id)
				return true;
		}
		
		return false;
	}
    
	public boolean isUserDetails(int id,String name, String password,String userType) {
		
		for(User user:users) {
			if(user.getId()==id) {
				if(user.getName()==name && user.getPassword()==password && user.getUserType()==userType)
					return true;
			}
			
		}
		
		return false;
	}
  
}
