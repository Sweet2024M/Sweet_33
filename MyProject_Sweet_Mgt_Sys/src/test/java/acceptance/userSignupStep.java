package acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ProductionCode.MyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userSignupStep {
	
	MyApp app;
	
	
	
	public userSignupStep(MyApp app) {
		super();
		this.app = app;
	}
	@Given("the user is not in the system")
	public void the_user_is_not_in_the_system() {
	   assertFalse(app.isSigndUp);
	}
	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String un, String password) {
	    app.signUp(un, password);
	}
	@Then("account created successfully")
	public void account_created_successfully() {
	    assertTrue(app.accountCreated);
	}
	@Then("success message pops up")
	public void success_message_pops_up() {
        assertTrue(app.isSuccessMessageDisplayed());
}
	
	
	@When("user enters username {string} already exists in the system")
	public void user_enters_username_already_exists_in_the_system(String un) {
	  app.checkUserExists(un);
      assertTrue(app.userExists);
	}
	@Then("account not created")
	public void account_not_created() {
	    assertFalse(app.accountCreated);	}
	@Then("error message pops up")
	public void error_message_pops_up() {
	    assertTrue(app.isErrorMessageDisplayed());
	}
	
	
}