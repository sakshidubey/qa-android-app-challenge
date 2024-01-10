package stepdefs;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.ContentPage;
import pageobjects.LoginPage;
import util.MobileFunctionUtility;
import util.ReadPropertiesFile;

public class LoginStepDefs {
	
	/**
     * This step definition class contains definition for login steps
     */
	MobileFunctionUtility mobileFunctionUtility;
	LoginPage loginPage;
	ContentPage contentPage;
	
	 public LoginStepDefs (MobileFunctionUtility mobileFunctionUtility, LoginPage loginPage, ContentPage contentPage) { 
		 this.mobileFunctionUtility = mobileFunctionUtility;
		 this.loginPage = loginPage;
		 this.contentPage = contentPage;
	 }
	
	@Given("I launch the app successfully")
	public void i_launch_the_app_successfully() {
		assertNotNull("App is not launched successfully", Driver.getAppiumDriver());
	}
	
	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
		mobileFunctionUtility.click(loginPage.getBtn_login());
	}

	@When("I enter {string} and {string} on login page")
	public void i_enter_admin_and_admin_on_login_page(String username, String password) {
		loginPage.loginToApplication(username, password);
	}
	
	@When("I enter correct user credentials on login page")
	public void i_enter_correct_user_credentials_on_login_page() throws IOException {
		loginPage.loginToApplication(ReadPropertiesFile.getUsername(), ReadPropertiesFile.getPassword());
	}
	
}
