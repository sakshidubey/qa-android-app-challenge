package stepdefs;

import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import util.ReadPropertiesFile;

public class Hooks {
	
	@Before
	public void initializeDriver(Scenario scenario) throws Exception {
		Driver.initializeDriver();
		ReadPropertiesFile.loadData();
	}

	@AfterStep
	public void captureScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "");
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		Driver.getAppiumDriver().quit();
	}

}
