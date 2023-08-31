package utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import BaseClass.Base;
import io.appium.java_client.AppiumDriver;

public class utils extends Base{

	static public ExtentReports extent;

	/**
	 * Extent Report is used for reporting in the FrameWork CreateTest and flush
	 * report are attached in the Listeners ExtentSparkReporter is used to Configure
	 * to the Reporting ExtentReport is used to generate the report
	 * 
	 * @return
	 * @return
	 */
	public static ExtentReports getReporter() {
		String path = System.getProperty("user.dir") + "//reports//index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Appium Automation Result");
		reporter.config().setDocumentTitle("Report Test Result");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Ballu");

		return extent;
	}

	/**
	 * getting the ScreenShot on failure
	 * 
	 * @return
	 * @throws IOException
	 * 
	 */
	public static String getScreenShotPath(String testCaseName) throws IOException {

		File source = driver.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	/**
	 * This Code is used to read the JsonFile and Pass the Data(parameter) from Json
	 * file to Method used Dependency Commom-io to convert JsonFile -----> Json
	 * String jackson-databind to Map the Json String to the DataProvider in the
	 * Method json File which is readed is provided in the Utility
	 * 
	 * Pass the Json File path to the Below Method
	 * 
	 * @param jsonFilepath
	 * @return
	 * @throws IOException
	 */
	public static List<HashMap<String, String>> getJsonData(String jsonFilepath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(jsonFilepath), StandardCharsets.UTF_8);

		ObjectMapper map = new ObjectMapper();

		List<HashMap<String, String>> data = map.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}
}
