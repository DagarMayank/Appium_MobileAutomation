package appiumTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utility.Gestures;
import utility.desriedCapabilties;
import utility.utils;

public class appiumMisclleanious extends Base{
	
		/**
		 * Device Rotaion  in the landScape
		 * @throws Exception
		 */
		@Test
		public void deviceRotation() throws Exception {
			desriedCapabilties.confriguration();
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			Thread.sleep(3000);
			DeviceRotation landScape = new DeviceRotation(0, 0, 90);
			driver.rotate(landScape);
			
			Thread.sleep(5000);
		}
		/**
		 * Copy Pasting the Clipboard text 
		 * 
		 * Working with Andoid Key used for naivagation in app
		 * @throws Exception 
		 */
		@Test
		public void clipBoardText() throws Exception {
			desriedCapabilties.confriguration();
			
			driver.setClipboardText("Hello World");  //use to copy the Text in the Clipboard
			driver.getClipboardText();    // Use to send the Copied Text in the form of SendKeys
			
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			driver.pressKey(new KeyEvent(AndroidKey.CALENDAR));
		}
		/**
		 * @throws Exception 
		 * 
		 */
		
		@SuppressWarnings("deprecation")
		@Test
		public void appPackageAndActivity() throws Exception {
			desriedCapabilties.confriguration();
			/**
			 * CMD command to get the App Package and App Activity
			 * 
			 *  adb shell dumpsys window | find "mCurrentFocus"
			 */
			Activity ac = new Activity("io.appium.android.apis", "io.appium.android.apis.ApiDemos");
			driver.startActivity(ac);
			Thread.sleep(4000);
		}
		
		@Test
		public void browserRun() throws Exception {
			desriedCapabilties.confriguration();
			driver.get("https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md");
		}
		
		
		@Test
		public void readJson() {
			
		}
		
		@DataProvider
		public Object[] getJson() throws IOException {
			
			List<HashMap<String,String>> data =  utils.getJsonData("D:\\Appium-WorkSpace\\Appium\\src\\test\\java\\utility\\JsonParameter.json");
			
			return new Object[] {  data.get(0) };
		}
}
