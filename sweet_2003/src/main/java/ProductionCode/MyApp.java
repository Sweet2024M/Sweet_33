package ProductionCode;

import java.util.ArrayList;

public class MyApp extends Login{
	
	
	public MyApp() {
		super();
		Login.login_page=true;// why it make error when i use an inheritance relation like directly write the name of the variable login_page
		
	}

	public void submitLogin() {
		if(loggedIn) {
			 switch(type_user) {
	         case "Admin":
	        	 admin_dashboard();
	             break;
	         case "Beneficiary User":
	        	 user_dashboard();
	             break;
	         case "Raw Material Supplier":
	        	 supplier_dashboard();
	             break;
	         case "Store Owner":
	        	 owner_dashboard();
	             break;
	         //default:
	     }
		}
			
		}

	private void owner_dashboard() {
		isDashboardVisible();
		// TODO Auto-generated method stub
		
	}

	private void supplier_dashboard() {
		isDashboardVisible();

		// TODO Auto-generated method stub
		
	}

	private void user_dashboard() {
		// TODO Auto-generated method stub
		isDashboardVisible();

	}

	private void admin_dashboard() {
		// TODO Auto-generated method stub
		isDashboardVisible();

	}

	public boolean isDashboardVisible() {
		return true;
	}
	
	


}
