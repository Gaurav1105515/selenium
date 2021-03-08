package Assignment4;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

public class screenshot {
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
	public static void test() throws InterruptedException, IOException {
		driver.get("https://api.jquery.com/dblclick/");
		Thread.sleep(1000);
		try {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		
		File screen = new File("C:\\Users\\shahi\\Desktop\\New folder.jpg");
		Files.copy(scrFile, screen);
		}catch (IOException e) {
			System.out.println("Message : "+e.getMessage());
		}
		Thread.sleep(1000);
		
	}

	@AfterClass
	public static void quit() {
		driver.quit();
	}
}
