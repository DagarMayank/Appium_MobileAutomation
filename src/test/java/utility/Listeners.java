package utility;

import java.io.IOException;

import utility.utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.Base;
import io.appium.java_client.android.AndroidDriver;

public class Listeners extends Base implements ITestListener {

	public AndroidDriver UIdriver = Base.driver;
	public ExtentTest testCase = Base.test;
	public ExtentReports extent = utils.getReporter();

	@Override
	public void onTestStart(ITestResult result) {
		testCase = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testCase.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testCase.fail(result.getThrowable());
		testCase.log(Status.FAIL, "Test Failed");

//		try {
//			UIdriver = (AndroidDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
//					.get(result.getInstance());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			testCase.addScreenCaptureFromPath(utils.getScreenShotPath(result.getMethod().getMethodName()),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
