package appiumTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.Base;
import io.appium.java_client.AppiumBy;
import utility.desriedCapabilties;
import utility.utils;
import utility.Gestures;

public class appiumBasic extends Base {

	/**
	 * Basic of appium
	 * 
	 * @throws MalformedURLException
	 * @throws Exception
	 */
	@Test
	public void runBrowser() throws MalformedURLException, Exception {
		desriedCapabilties.confriguration();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='6. Advanced preferences']")).click();
	}

	/**
	 * Long Press Gesture
	 * 
	 * @throws Exception
	 */

	@Test
	public void longPress(String name) throws Exception {

		desriedCapabilties.confriguration();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		Gestures touch = new Gestures(driver);
		touch.longPress(peopleNames);
	}

	/**
	 * Scrolling using the Uiscroable and scrolling through the coordinates
	 * 
	 * @throws Exception
	 */
	@Test
	public void ScrollPage() throws Exception {
		desriedCapabilties.confriguration();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		WebElement webView = driver.findElement(AppiumBy.accessibilityId("WebView"));
		Gestures touch = new Gestures(driver);
		// touch.scrollUsingAndroidUiAutomator("WebView");
		touch.scrollUsingCoordinated(webView, "down");
	}

	/**
	 * @throws Exception
	 * 
	 * 
	 */
	@Test
	public void SwipePage() throws Exception {
		desriedCapabilties.confriguration();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("//(android.widget.ImageView)[1]"));
		System.out.println(firstImage.getAttribute("focusable"));

		Gestures touch = new Gestures(driver);
		touch.swipeGesture(firstImage, "left");

	}

	/**
	 * Drag And Drop Using the Gestures JavaScript
	 * 
	 * @throws Exception
	 */
	@Test
	public void DragAndDrop() throws Exception {
		desriedCapabilties.confriguration();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement Source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Source));
		Gestures touch = new Gestures(driver);
		touch.dragAndDropGesture(Source, 660, 580);
	}

	@DataProvider
	public Object[] getJson() throws IOException {

		List<HashMap<String, String>> data = utils
				.getJsonData("D:\\Appium-WorkSpace\\Appium\\src\\test\\java\\utility\\JsonParameter.json");

		return new Object[] { data.get(0) };
	}
}
