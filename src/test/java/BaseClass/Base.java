package BaseClass;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;
import java.io.File;
import java.net.MalformedURLException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static ExtentTest test;

	@BeforeTest
	public static void startServer() throws MalformedURLException {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1").usingPort(4723).usingAnyFreePort()
				.withAppiumJS(
						new File("C:\\Users\\Mayank\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withArgument(BASEPATH, "/wd/hub").withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "debug");

		service = AppiumDriverLocalService.buildService(builder);
		// service.start();

//	    AppiumDriverLocalService	server = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Mayank\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).build();
//server.start();
	}

	@AfterTest
	public static void tearDown() {
		driver.quit();
		service.stop();
	}
}
