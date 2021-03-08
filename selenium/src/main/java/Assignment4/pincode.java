package Assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class pincode {
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
		driver.get("http://chennaiiq.com/chennai/pincode-by-name.php");
		WebElement Pincode = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
		List<WebElement> row =Pincode.findElements(By.tagName("tr"));
		for(int i=3;i<row.size();i++)
		{
			List<WebElement> col =row.get(i).findElements(By.tagName("td"));
			Thread.sleep(1000);
			String firstPin = col.get(2).getText();
			Thread.sleep(1000);
			
			for(int j=i;j<row.size();j++)
			{
				List<WebElement> newcolumn =row.get(j).findElements(By.tagName("td"));
				String secondPin = newcolumn.get(2).getText();
				Thread.sleep(1000);
				Assert.assertFalse(firstPin==secondPin);
				Thread.sleep(1000);
			}
			
	
		}
	}
	@AfterClass
	public static void quit() {
		driver.quit();
}
}
