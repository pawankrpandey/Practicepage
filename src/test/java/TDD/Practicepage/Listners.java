package TDD.Practicepage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.ExtentReport;

public class Listners extends Base implements ITestListener {

	ExtentTest test;
	ExtentReports extent= ExtentReport.getReportObject();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		 test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		extenttest.get().log(Status.PASS, "TestPass");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	
		extenttest.get().fail(result.getThrowable());
		
        WebDriver driver=null;
		
		String testMethodName=result.getMethod().getMethodName();
		try 
		{
			
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch(Exception e)
		{
			
		}
		try 
		{
			extenttest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
