package utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import BaseClass.Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Gestures extends Base {

	public AndroidDriver driver;

	public Gestures(AndroidDriver driver) {
		this.driver = driver;
	}

	/**
	 * LongPress Event Takes WebElement as a parameter
	 * 
	 * @param ELEMENT
	 */
	public void longPress(WebElement ELEMENT) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ELEMENT).getId(), "duration", 1000));
	}

	/**
	 * view uiSelector class use google engine , has UiSelector to select till which
	 * element to be scrolled.
	 * 
	 * it does'nt scroll on the coordinates
	 * 
	 * @param elementLocatorText
	 */
	public void scrollUsingAndroidUiAutomator(String elementLocatorText) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementLocatorText + "\"));"));
	}

	/**
	 * Scroll Event Gestures Takes webElement text present on the UI to scroll into
	 * Scroll on the basis of Coordinates
	 */
	public void scrollUsingCoordinated(WebElement ele, String direction) {
		// Java
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", direction, "percent", 3.0));

	}

	/**
	 * Swipe Gesture using JavaScript
	 */
	public void swipeGesture(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
	}

	/**
	 * Drag and Drop using JavaScript
	 * 
	 * @param element
	 * @param X
	 * @param Y
	 */
	public void dragAndDropGesture(WebElement element, int X, int Y) {
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", X, "endY", Y));
	}
	
	
	
	
}
