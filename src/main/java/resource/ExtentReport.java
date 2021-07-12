package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\pawan\\index.html";
		
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("TDD Automation Practice");
		report.config().setDocumentTitle("Test Result");
		
		 extent=new ExtentReports();
		 extent.attachReporter(report);
		 extent.setSystemInfo("Tester", "pawan");
		
		 return extent;
		
	}
	
}
