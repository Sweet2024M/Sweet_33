package ProductionCode;

public class MyApp {

    private boolean loggedIn;
    private boolean successMessageDisplayed;
    private boolean errorMessageDisplayed;

    public MyApp() {
        this.loggedIn = false;
        this.successMessageDisplayed = false;
        this.errorMessageDisplayed = false;
    }

    public void login(String username, String password) {
        if ("mohammad".equals(username) && "123".equals(password)) {
            this.loggedIn = true;
            this.successMessageDisplayed = true;
            this.errorMessageDisplayed = false;
        } else {
            this.loggedIn = false;
            this.successMessageDisplayed = false;
            this.errorMessageDisplayed = true;
        }
    }

    public void logout() {
        this.loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessageDisplayed;
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessageDisplayed;
    }
}
