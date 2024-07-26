package acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ProductionCode.MyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAuthenticationSteps {
    private MyApp app;

    public UserAuthenticationSteps() {
        this.app = new MyApp();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        assertTrue(app.login_page);
    }

    @When("I select {string} as the user type")
    public void i_select_role_as_the_user_type(String role) {
    	app.userType(role);

    }

    @When("I enter {string} and {string}")
    public void i_enter_username_and_password(String username, String password) {
        app.user_login(username, password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        app.submitLogin(); 

    }

    @Then("I should see the {string} dashboard")
    public void i_should_see_the_dashboard(String role) {
app.submitLogin();
    }

    @Then("I should see an error message indicating invalid credentials")
    public void i_should_see_an_error_message_indicating_invalid_credentials() {
        assertTrue(app.isErrorMessageDisplayed());

    }

    @Given("I am logged in as {string}")
    public void i_am_logged_in_as(String role) {
        // Code to log in as a specific role
        System.out.println("Logged in as " + role);
        // Assume login credentials are based on role
        switch(role) {
            case "Admin":
                //app.admin_login("Hamode", "123");
                break;
            case "Beneficiary User":
               // app.user_login("jawad", "123");
                break;
            case "Raw Material Supplier":
              //  app.supplier_login("khaled", "123");
                break;
            case "Store Owner":
             //   app.owner_login("ahmad", "123");
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
        assertTrue(app.isLoggedIn());
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        app.logout();
    }
    
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        assertTrue(app.login_page);
        assertFalse(app.isLoggedIn()); 
    }
}
