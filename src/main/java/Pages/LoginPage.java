package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import Base.BaseTest;

public class LoginPage extends BaseTest {
	 private Page page;

	    public LoginPage(Page page) {
	        this.page = page;
	    }
	
	
    private final String emailField = "Email Id or Username";
    private final String passwordField = "Password";
    private final String loginButton = "Log In";

    public void login(String username, String password) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(emailField)).fill(username);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(passwordField)).fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(loginButton)).click();
    }

    public void navigateToLoginPage() {
        page.navigate("https://awspf.com/signin");
    }

}