package utility;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import BaseClass.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class desriedCapabilties extends Base {
	
	public static void confriguration() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
		caps.setCapability(MobileCapabilityType.UDID, "RZ8M22QQM5M");
//	    caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");		
//		caps.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
		
		caps.setCapability("app", "D:\\Appium-WorkSpace\\Appium\\src\\test\\java\\utility\\ApiDemos-debug.apk");
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//		caps.setCapability("chromedriverExecutable","D:\\Appium-WorkSpace\\Appium\\src\\test\\java\\utility\\chromedriver.exe");
		
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S10");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Ballu");

		URL url = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(url, caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
