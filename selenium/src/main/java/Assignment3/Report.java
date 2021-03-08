package Assignment3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public void runner() throws InterruptedException {

		report = new ExtentReports("C:\\Users\\shahi\\Desktop\\New folder (2)\\New folder.html", true);
		test = report.startTest("Extent Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahi\\Desktop\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(3000);

	}

	@Test
	public void test() {
		if (driver.getTitle().equals("Google")) {
			test.log(LogStatus.PASS, "open the given url");
		} else {
			test.log(LogStatus.FAIL, "fail");
		}

	}

	@AfterClass
	public void teardown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
