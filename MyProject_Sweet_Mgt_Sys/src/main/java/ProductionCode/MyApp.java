package ProductionCode;

public class MyApp {

	public boolean is_logged_in;
    User mainUser =new User("jawad", "123456");
    User admin=new User("Admin", "123456");
    
	public User getmainUser() {
		return mainUser;
	}
	public void setmainUser(User a1) {
		this.mainUser = a1;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	
    
    
	

}
