package Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchTab {
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
		String  urlNew=null;
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		for(String newTab:driver.getWindowHandles()) {
			
			driver.switchTo().window(newTab);
			urlNew = driver.getCurrentUrl();
			System.out.println(driver.getTitle());
			WebElement w1 = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]/a"));
			Thread.sleep(1000);
			w1.click();
			Thread.sleep(1000);
			Select name = new Select(driver.findElement(By.id("search_type")));
			name.selectByVisibleText("First Name");
			driver.findElement(By.id("search_patient")).click();
			Thread.sleep(3000);
		}
		
	}
	@AfterClass
	public static void quit() {
		driver.quit();
	}
}
