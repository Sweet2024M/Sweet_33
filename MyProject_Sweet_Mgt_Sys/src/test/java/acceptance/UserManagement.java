package acceptance;

import static org.junit.Assert.assertTrue;

import ProductionCode.MyApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagement {

    MyApp app;

    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
        app = new MyApp();
        app.login("admin", "adminpassword", "Admin");
        assertTrue(app.AdminLoggedIn);
    }

    @Given("I am on the admin dashboard")
    public void i_am_on_the_admin_dashboard() {
        app = new MyApp();

        app.openAdminDashboard();
        assertTrue(app.adminDashbordOpen);
    }

    @Given("I select {string} from the dashboard options")
    public void i_select_from_the_dashboard_options(String option) {
        app = new MyApp();

         app.AdminDashboardOptiones("1");
    }

    @Given("I am on the user management page")
    public void i_am_on_the_user_management_page() {
        app = new MyApp();
        app.AdminDashboardOptiones("1");
       assertTrue(app.userManagementPageOpen);
    }

    @When("I view the list of users")
    public void i_view_the_list_of_users() {
        app = new MyApp();
        app.viewAllUsers();
        
    }

    @When("I choose to add a new user")
    public void i_choose_to_add_a_new_user() {
        app = new MyApp();

       // app.addUser();
    }

//    @When("I enter the username {string}, password {string}, and role {string}")
//    public void i_enter_the_username_password_and_role(String username, String password, String role) {
//        // app.setUsername(username);
//        // app.setPassword(password);
//        // app.setRole(role);
//    }
//
//    @When("I submit the new user details")
//    public void i_submit_the_new_user_details() {
//        // app.submitUserDetails();
//    }
//
//    @When("I choose to delete the user with username {string}")
//    public void i_choose_to_delete_the_user_with_username(String username) {
//        // app.selectUser(username);
//        // app.deleteUser();
//    }
//
//    @When("I choose to update the user with username {string}")
//    public void i_choose_to_update_the_user_with_username(String username) {
//        // app.selectUser(username);
//        // app.updateUser();
//    }
//
//    @When("I enter the new password {string} and role {string}")
//    public void i_enter_the_new_password_and_role(String password, String role) {
//        // app.setPassword(password);
//        // app.setRole(role);
//    }
//
//    @When("I submit the updated user details")
//    public void i_submit_the_updated_user_details() {
//        // app.submitUpdatedUserDetails();
//    }
//
    @Then("I should see all users in the list")
    public void i_should_see_all_users_in_the_list() {
         assertTrue(app.isUserListVisible);
    }

    @Then("I should see a success message {string}")
    public void i_should_see_a_success_message(String message) {
        // assertTrue(app.getSuccessMessage().equals(message));
    }
}
