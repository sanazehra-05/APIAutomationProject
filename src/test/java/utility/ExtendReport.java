package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String reportName;
	
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		reportName = "Test-Report" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);
		sparkReporter.config().setDocumentTitle("API Automation Project");
		sparkReporter.config().setReportName("User Api Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("application", "user api");
		extent.setSystemInfo("user name", "admin");
		extent.setSystemInfo("OS", "windows 11");
	}


	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); 
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "test get sucess");
	}
	
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName()); 
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "test get fail");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	  }
	
	public void onFinish(ITestContext context) {
		extent.flush();
	  }

}
