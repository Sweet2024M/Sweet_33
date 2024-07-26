package ProductionCode;

public class Admin {
	
	private String name;
	private String pass;
	
	public Admin(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}


	////////////////////////getter & setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	

	

}
