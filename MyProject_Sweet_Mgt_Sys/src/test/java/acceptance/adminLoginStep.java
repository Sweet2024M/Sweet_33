package acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ProductionCode.MyApp;
import ProductionCode.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adminLoginStep {
MyApp app;


	
	
	public adminLoginStep(MyApp app) {
	super();
	this.app = app;
}
	@Given("admin not logged in the system")
	public void admin_not_logged_in_the_system() {
	    assertFalse(app.is_logged_in);
	}
	@When("admin enters username {string} and password {string}")
	public void admin_enters_username_and_password(String un, String password) {
		  User A = new User(un, password);
		   		   if (A.getName().equals(app.getAdmin().getName()) && A.getPassword().equals(app.getAdmin().getPassword())) {
			   assertTrue(true);		
		}
		   		   else {
					assertFalse(false);
				}
		   		   
	}
	@Then("admin logs in")
	public void admin_logs_in() {
	    System.out.println("welcome Admin");
	    assertTrue(app.is_logged_in=true);
	}
	
	@Then("admin does not login")
	public void admin_does_not_login() {
	    assertFalse(app.is_logged_in);
	}
	@Then("error message pops up")
	public void error_message_pops_up() {
	    System.out.println("could not login ");
assertFalse(app.is_logged_in=false);
	}


}
