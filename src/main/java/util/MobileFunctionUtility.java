package util;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class MobileFunctionUtility {
	
	/**
     * This class is having all the generic and reusable functions to interact with a Mobile APP.
     */
	
	private static final Logger log = Logger.getLogger(MobileFunctionUtility.class);	
	MobileElement element;
	AppiumDriver<MobileElement> driver;
	protected TouchAction<?> ta;
	
	public MobileFunctionUtility() {
		driver = Driver.getAppiumDriver();
	}
	
	/**
     * This function is used to get list of elements.
     * @by: Locator of an element
     * @return: List of Mobile elements
     */
	public List<MobileElement> getListofElements(By by) {
		return driver.findElements(by);
	}
	
	/**
     * This function is used to get a element.
     * @by: Locator of an element
     * @return: Mobile element
     */
	public MobileElement getElement(By by) {
		return driver.findElement(by);
	}
	
	/**
     * This function is used to click on a element.
     * @by: Locator of an element
     */
	public void click(By by) {
		element = driver.findElement(by);
		explicitlyWait(by).click();
		
	}
	
	/**
     * This function is used to enter value in a textfield.
     * @by: Locator of an element
     * @value: Value to be entered
     */
	public void sendKeys(By by,String value) {
		explicitlyWait(by).sendKeys(value);
	}
	
	/**
     * This function is used to check element is displayed or not.
     * @by: Locator of an element
     * @return: Boolean value
     */
	public boolean checkEleDisplayed(By by) {
		boolean result = false;
		try {
			result = explicitlyWait(by).isDisplayed();
		} catch(Exception e) {
			log.error(e.toString());
		}
		return result; 
	}
	
	/**
     * This function is used to check element is exist or not.
     * @by: Locator of an element
     * @return: Boolean value
     */
	public boolean checkIfExists(By by) {	
		return driver.findElements(by).size()>0;
	}
		
	/**
     * This function is used to wait for an element to be visible.
     * @by: Locator of an element
     * @return: an element
     */
	public MobileElement explicitlyWait(By by) {
		WebDriverWait wait=new WebDriverWait(driver,5);
		return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	/**
     * This function is used to get text of an element.
     * @by: Locator of an element
     * @return: String
     */
	public String getText(By by) {
		return explicitlyWait(by).getText();
	}
	
	/**
     * This function is used to scroll on a screen till specific element.
     * @by: Locator of an element
     */
	public void scrollToSpecificElement(By by)
	{

		while(Driver.getAppiumDriver().findElements(by).size()==0)
		{
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			int center = (int) (dimensions.width*0.5);
			ta=new TouchAction<>(driver);
			ta.press(PointOption.point(center,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
			moveTo(PointOption.point(center,scrollEnd)).release().perform();
		}
	}
	
	/**
     * This function is used to long press on a element.
     * @by: Locator of an element
     */
	public void longPressElement(By by) {
		ta=new TouchAction<>(driver);
		ta.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(explicitlyWait(by)))
				.withDuration(Duration.ofMillis(200)))
				.release()
				.perform();
	}
	
	
	/**
     * This function is used to drag a element and drop at specific element.
     * @by: Locator of source element(drag)
     * @by: Locator of target element(drop)
     */
	public void dragAndDrop(By by_source, By by_target) {
		ta=new TouchAction<>(driver);
		ta.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(explicitlyWait(by_source))))
				.moveTo(ElementOption.element(explicitlyWait(by_target)))
				.release()
				.perform();
	}
	
	/**
     * This function is used to single tap on a element.
     * @by: Locator of an element
     */
	public void tap(By by) {
		ta=new TouchAction<>(driver);
		ta.tap(TapOptions.tapOptions()
			.withElement(ElementOption.element(explicitlyWait(by))))
			.perform();
	}
	
	/**
     * This function is used to double tap on a element.
     * @by: Locator of an element
     */
	public void doubleTap(By by) {
		ta=new TouchAction<>(driver);
		ta.tap(ElementOption.element(explicitlyWait(by)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2)))
				.tap(ElementOption.element(explicitlyWait(by)))
				.perform();
	}
	
	/**
     * This function is used to click on a Element based on the display text.
     * @name: Element name
     */
	public void clickOnAElementBasedOnName(String name) {		
		click(getDynamicXPathLocatorWithText(name));
			
	}
	
	/**
     * This function is used to validate an element on Page based on display text.
     * @pageName: Name of the element
     * @return: boolean
     */
	public boolean validatePageElementBasedOnName(String pageName) {
		String xpath = "//*[@text=\""+pageName+"\"]";
		return checkIfExists(By.xpath(xpath));
	}
	
	/**
     * This function is used to create dynamic xpath based on text.
     * @name: text value
     * @return: xpath locator based on text
     */
	public By getDynamicXPathLocatorWithText(String name) {
		String xpath = "//*[@text=\""+name+"\"]";
		return By.xpath(xpath);
	}
	
	/**
     * This function is used to create dynamic xpath based on contains text.
     * @name: text value
     * @return: xpath locator based on contains text
     */
	public By getDynamicXPathLocatorWithContainsText(String name) {
		String xpath = "//*[contains(@text, '"+name+"']";
		return By.xpath(xpath);
	}

}
