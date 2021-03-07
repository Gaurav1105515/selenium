package Assignment2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollWebPage {
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
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // scroll to the bottom of the page
		Thread.sleep(4000);
	}

	@AfterClass
	public static void quit() {
		driver.quit();

	}
}
