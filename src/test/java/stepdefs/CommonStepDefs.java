package stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.CommonPage;
import util.MobileFunctionUtility;

public class CommonStepDefs {
	
	/**
     * This step definition class contains definition steps that are common for all the screen of an APP
     */
	
	MobileFunctionUtility mobileFunctionUtility;
	CommonPage commonPage;

	public CommonStepDefs(MobileFunctionUtility mobileFunctionUtility, CommonPage commonPage) {
		this.mobileFunctionUtility = mobileFunctionUtility;
		this.commonPage = commonPage;
	}

	@Then("I click on {string} element")
	public void i_click_on_a_element(String name) {
		mobileFunctionUtility.clickOnAElementBasedOnName(name);
	}

	@Then("I verify the {string} page present")
	public void i_verify_the_page_present(String pageName) {
		assertTrue(pageName + " page is not present",
				mobileFunctionUtility.checkEleDisplayed(mobileFunctionUtility.getDynamicXPathLocatorWithText(pageName)));
	}
	
	@Then("I verify {string} alert title displayed")
	public void i_verify_alert_title_displayed(String name) {
		assertEquals("Expected alert title should be displayed", name, mobileFunctionUtility.getText(mobileFunctionUtility.getDynamicXPathLocatorWithText(name)));
	}
	
	@And("I verify {string} alert message displayed")
	public void i_verify_alert_message_displayed(String alertMessage) {
		assertTrue("Expected alert title should be displayed", mobileFunctionUtility.getText(commonPage.getAlert_message()).contains(alertMessage));
	}
	
	@And("I click on Alert OK button")
	public void i_click_on_alert_ok_button() {	
		mobileFunctionUtility.click(commonPage.getAlert_OK());
	}
	
	@And("I verify {string} element not displayed on the screen")
	public void i_verify_element_not_displayed_on_screen(String elementName) {
		assertTrue("Element should not be displayed", !mobileFunctionUtility.checkEleDisplayed(mobileFunctionUtility.getDynamicXPathLocatorWithText(elementName)));
	}
	
	@Then("I verify {string} element displayed on the screen")
	public void i_verify_element_displayed_on_screen(String elementName) {
		assertTrue("Element should be displayed", mobileFunctionUtility.checkEleDisplayed(mobileFunctionUtility.getDynamicXPathLocatorWithText(elementName)));
	}
	

}
