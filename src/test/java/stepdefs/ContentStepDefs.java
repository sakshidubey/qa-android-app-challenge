package stepdefs;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.CommonPage;
import pageobjects.ContentPage;
import pageobjects.LoginPage;
import util.MobileFunctionUtility;

public class ContentStepDefs {
	
	/**
     * This step definition class contains definition for other steps that belongs to different screen
     */
	
	MobileFunctionUtility mobileFunctionUtility;
	ContentPage contentPage;
	LoginPage loginPage;
	CommonPage commonPage;

	public ContentStepDefs(MobileFunctionUtility mobileFunctionUtility, ContentPage contentPage, LoginPage loginPage,
			CommonPage commonPage) {
		this.mobileFunctionUtility = mobileFunctionUtility;
		this.contentPage = contentPage;
		this.loginPage = loginPage;
		this.commonPage = commonPage;
	}

	@Then("It has {int} list of elements")
	public void validate_number_of_elements_present_on_page(int expectedList) {
		int actualList = mobileFunctionUtility.getListofElements(contentPage.getElement_listOfItemsInScrollView())
				.size();
		assertEquals("Expected list of items not present", expectedList, actualList);
	}

	@Then("I long press on {string} element")
	public void i_long_press_on_a_element(String name) {
		mobileFunctionUtility.longPressElement(mobileFunctionUtility.getDynamicXPathLocatorWithText(name));
	}

	@And("I perform drag and drop operation")
	public void i_perform_drag_and_drop() {
		contentPage.performDragAndDrop();
	}

	@And("I perform double tap operation")
	public void i_perform_double_tap() {
		contentPage.performDoubleTap();
	}

	@And("I perform scrolling operation for {string} element")
	public void i_perform_scrolling(String elementName) {
		contentPage.performScrolling(elementName);
	}

	@And("I click on spinner")
	public void i_click_on_spinner() {
		mobileFunctionUtility.click(contentPage.getElement_Spinner());
	}

	@And("I select {string} value in wheel picker")
	public void i_select_in_wheel_picker(String colourName) {
		mobileFunctionUtility.click(mobileFunctionUtility.getDynamicXPathLocatorWithText(colourName));
	}
	
	@Then("I verify {string} message appeared")
	public void i_verify_message_appeared_on_screen(String message) {
		assertEquals("Expected alert title not displayed", message,
				mobileFunctionUtility.getText(contentPage.getElement_DragDropSucess()));
	}

}
