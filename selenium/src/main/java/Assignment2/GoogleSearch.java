package Assignment2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearch {
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
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Infosys");
		Thread.sleep(3000);
		List<WebElement> webElement = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		for (int i = 0; i < webElement.size(); i++) {
			String value = webElement.get(i).getText();
			if (value.contains("Infosys")) {
				Thread.sleep(1000);
				webElement.get(i).click();
				Thread.sleep(2000);
				break;

			}
		}
	}

	@AfterClass
	public static void quit() {
		driver.quit();
	}
}
