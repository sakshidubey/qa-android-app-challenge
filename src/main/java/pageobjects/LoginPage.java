package pageobjects;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import util.MobileFunctionUtility;

public class LoginPage extends MobileFunctionUtility {
	
	/**
     * This class is having login page objects and functions to interact with them.
     */
	
	private By textfield_username = MobileBy.AccessibilityId("username");
	private By textfield_password = MobileBy.AccessibilityId("password");
	private By btn_login = MobileBy.AccessibilityId("login");
	
	public By getTextfield_username() {
		return textfield_username;
	}
	public By getTextfield_password() {
		return textfield_password;
	}
	public By getBtn_login() {
		return btn_login;
	}
	
	public void loginToApplication(String username, String password) {
		sendKeys(getTextfield_username(), username);
		sendKeys(getTextfield_password(), password);
		click(getBtn_login());
	}
	
	
}
