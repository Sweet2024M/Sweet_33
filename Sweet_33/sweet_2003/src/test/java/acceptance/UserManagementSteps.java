package acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ProductionCode.Admin;
import ProductionCode.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class UserManagementSteps {

    private Admin admin;
    private User user;


   
    @Given("I am logged in as an Admin")
    public void i_am_logged_in_as_an_admin() {
        admin.isLoggedIn(); 
    }

    
    @When("I select to add a user")
    public void i_select_to_add_a_user() {
       admin.selectService("add");
    }
    
    @When("I fill in the new user details")
    public void i_fill_in_the_new_user_details() {
    	admin.addUser(0,"username","password","user type");
    }

    
    @Then("the new user should be created")
    public void the_new_user_should_be_created() {
        assertTrue(admin.isUserExist(0)); 
    }

    @Given("a user exists")
    public void a_user_exists() {
    	assertTrue(admin.isUserExist(0)); 
    }

    @When("I select a user to update")
    public void i_select_a_user_to_update() {
    	admin.selectService("update");
    }

    @Then("the user details should be updated")
    public void the_user_details_should_be_updated() {
        assertTrue(admin.isUserDetails(0,"name","passwrod","user type")); 
    }
    
  

    @When("I select a user to delete")
    public void i_select_a_user_to_delete() {
    	admin.selectService("delete");
    }
    
    @Then("the user should be removed from the system")
    public void the_user_should_be_removed_from_the_system() {
        assertFalse(admin.isUserExist(user.getId())); 
    }


}

