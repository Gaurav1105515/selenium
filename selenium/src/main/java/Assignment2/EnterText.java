package Assignment2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnterText {
	public static WebDriver driver;

	@BeforeClass
	public static void Runner() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahi\\Desktop\\driver\\chromedriver.exe");
		Thread.sleep(1000);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		Thread.sleep(1000);
}
	@Test
	public static void test() throws InterruptedException {
		driver.get("https://www.facebook.com");
		// Initialize JS object
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		// Enter username
		JS.executeScript("document.getElementById('email').value='gaurav'");
		Thread.sleep(1000);
		// Enter password
		JS.executeScript("document.getElementById('pass').value='gaurav1@'");
		Thread.sleep(1000);
	}
	@AfterClass
	public static void quit() {
		driver.quit();
}
}
