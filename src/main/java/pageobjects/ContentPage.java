package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import util.MobileFunctionUtility;

public class ContentPage extends MobileFunctionUtility {
	
	/**
     * This class is having page objects for all pages except login and functions to interact with them.
     */
	
	private By element_NativeViewDemoPage = By.xpath("//android.widget.TextView[@text=\"Native View Demo\"]");
	private By element_listOfItemsInScrollView = By.xpath("//*[@content-desc=\"scrollView\"]/android.view.ViewGroup/android.view.ViewGroup");
	private By element_DragMe = MobileBy.AccessibilityId("dragMe");
	private By element_DragZone = MobileBy.AccessibilityId("dropzone");
	private By element_DragDropSucess = MobileBy.AccessibilityId("success");
	private By element_DoubleTapMe = MobileBy.AccessibilityId("doubleTapMe");
	private By element_Spinner = By.className("android.widget.Spinner");
	
	public By getElement_Spinner() {
		return element_Spinner;
	}

	public By getElement_DoubleTapMe() {
		return element_DoubleTapMe;
	}

	public By getElement_DragDropSucess() {
		return element_DragDropSucess;
	}

	public By getElement_DragMe() {
		return element_DragMe;
	}

	public By getElement_DragZone() {
		return element_DragZone;
	}

	public By getElement_listOfItemsInScrollView() {
		return element_listOfItemsInScrollView;
	}

	public By getElement_NativeViewDemoPage() {
		return element_NativeViewDemoPage;
	}

	public void performDragAndDrop() {
		dragAndDrop(getElement_DragMe(), getElement_DragZone());
	}
	
	public void performDoubleTap() {
		doubleTap(getElement_DoubleTapMe());
	}
	
	public void performScrolling(String elementName) {
		scrollToSpecificElement(getDynamicXPathLocatorWithText(elementName));
	}

}
