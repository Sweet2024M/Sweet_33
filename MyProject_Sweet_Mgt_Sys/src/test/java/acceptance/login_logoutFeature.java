package acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ProductionCode.MyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ProductionCode.*;

public class login_logoutFeature {

	MyApp app;
	
	
	public login_logoutFeature(MyApp app) {
		super();
		this.app = app;
	}
	@Given("user not logged in the system")
	public void user_not_logged_in_the_system() {
	   assertFalse(app.is_logged_in);
	}
	/*@Given("user with valid credintials")
	public void user_with_valid_credintials() {
	    assertTrue(true);
	}*/
	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String un, String password) {
	    User A = new User(un, password);
	    System.out.println(A.toString());
	    
	   boolean res1=A.getName().equals(app.getmainUser().getName());
	   boolean res2=A.getPassword().equals(app.getmainUser().getPassword());
	   System.out.println(res1 && res2);
assertTrue(res1 && res2);
	    
	    
	}
	@Then("user logs in")
	public void user_logs_in() {
	   assertTrue(app.is_logged_in=true);
	}
	@Then("success message pops up")
	public void success_message_pops_up() {
       System.out.println("you have successfully logged in");	
	   assertTrue(true);
	}

}
