package ProductionCode;

public class User {

	private String name;
	private String password ;
	private String userType;
	private int id;
	
	
	
	public User(int id,String name, String password,String userType) {
		this.name = name;
		this.password = password;
		this.userType=userType;
		this.id=id;
	}

	
	
	//getter & setter
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
	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	
	
}
