package acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ProductionCode.MyApp;
import ProductionCode.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class login_logoutFeature {

    private MyApp app;

    public login_logoutFeature() {
        this.app = new MyApp();
    }

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        app.logout(); // Ensure user is logged out
        assertFalse(app.isLoggedIn());
    }

    @When("the user enters the username {string} and the password {string}")
    public void the_user_enters_the_username_and_the_password(String username, String password) {
    	//User u=new User(username,password);
        app.login(username,password);
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() {
        assertTrue(app.isLoggedIn());
    }

    @Then("a success message pops up")
    public void a_success_message_pops_up() {
        assertTrue(app.isSuccessMessageDisplayed());
    }

    @When("the user enters a wrong username and a wrong password")
    public void the_user_enters_wrong_username_and_password() {
        app.login("wrongUsername", "wrongPassword");
    }

    @Then("the user can't log in")
    public void the_user_cannot_log_in() {
        assertFalse(app.isLoggedIn());
    }

    @Then("an unsuccessful message pops up")
    public void an_unsuccessful_message_pops_up() {
        assertTrue(app.isErrorMessageDisplayed());
    }

    @Given("the user is already logged in")
    public void the_user_is_already_logged_in() {
        app.login("jawad", "123456");
        assertTrue(app.isLoggedIn());
    }

    @When("the user chooses the logout option")
    public void the_user_chooses_the_logout_option() {
        app.logout();
    }

    @Then("the user is logged out")
    public void the_user_is_logged_out() {
        assertFalse(app.isLoggedIn());
    }
}
