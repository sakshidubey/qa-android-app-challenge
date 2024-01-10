package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
public class Driver {
	
	/**
     * This class is having functions to initialize and get driver object
     */
	public static AppiumDriver<MobileElement> driver;
	public static DesiredCapabilities capability;
	
	public static void initializeDriver() throws MalformedURLException {
		 
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		String appName = System.getProperty("appname");
		String appPath = "";
		
		/**
	     * This condition is used to set app name inside appPath variable at runtime
	     * if not it will pass the default one which appiumChallenge
	     */
		if(!(appName == null || appName.equals(""))) {
			appPath = System.getProperty("user.dir") + "/apps/"+appName+".apk";		
		} else {
			appPath = System.getProperty("user.dir") + "/apps/appiumChallenge.apk";
		}
		
		capability = new DesiredCapabilities();
	    capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		capability.setCapability(MobileCapabilityType.APP,appPath);
		driver= new AndroidDriver<MobileElement>(url,capability);
		Driver.setAppiumDriver(driver);
	}
	
	public static AppiumDriver<MobileElement> getAppiumDriver() {
		return driver;
	}
	
	public static void setAppiumDriver(AppiumDriver<MobileElement> appiumDriver) {
		driver = appiumDriver;
	}
	
}
