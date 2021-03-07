package Assignment2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SizeOfBrowser {
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
	public static void setsize() throws InterruptedException {
		driver.get("https://www.google.com");
		 // fetching the current window size with getSize()
	      System.out.println(driver.manage().window().getSize());
	      //Create object of Dimensions class
	      Dimension dm = new Dimension(600,630);
	      //Setting the current window to that dimension
	      driver.manage().window().setSize(dm);
	      Thread.sleep(2000);
	}
	@AfterClass
	public static void quit() {
		driver.quit();
	}
}
