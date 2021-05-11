

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners extends BasicTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		System.setProperty("org.uncommoms.reportng.escape-output", "false");
		
		try {
			BasicTest.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add a link to open in a new tab
		//"<a targert=\"blank\" href=\""+error+"\">Screenshot link</a>"
//		Reporter.log(error);
//		Reporter.log("<br>");
		//add a image to open in a new tab
		Reporter.log("<a target=\"blank\" href="+ BasicTest.fileName +"><img src="+BasicTest.fileName+" height=200 width=200></a>");

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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
