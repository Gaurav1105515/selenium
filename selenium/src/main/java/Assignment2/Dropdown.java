package Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dropdown {
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
	public static void dropdown() throws InterruptedException {
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		Select language=new Select(driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button/span")));
		language.selectByValue("Bootstrap");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Thread.sleep(2000);

	}

	@AfterClass
	public static void quit() {
		driver.quit();
	}
}
