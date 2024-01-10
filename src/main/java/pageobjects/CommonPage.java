package pageobjects;

import org.openqa.selenium.By;

import util.MobileFunctionUtility;

public class CommonPage extends MobileFunctionUtility {
	
	/**
     * This class is having common page objects that are common for other 2 pages
     * and functions to interact with them.
     */
	
	private By alert_message = By.id("android:id/message");
	private By alert_title = By.xpath("//*[@resource-id=\"android:id/alertTitle\"]");
	private By alert_OK = By.id("android:id/button1");
	
	public By getAlert_OK() {
		return alert_OK;
	}
	public By getAlert_title() {
		return alert_title;
	}
	public By getAlert_message() {
		return alert_message;
	}
	
	public String getAlertMessageText() {
		return getText(getAlert_message());
	}
}
