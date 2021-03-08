package Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatingGoogleAccount {
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
		driver.get("https://accounts.google.com/signup");
		Thread.sleep(1000);
		String a=driver.getCurrentUrl();
		System.out.println(a);
		//Checking First Name text field
				driver.findElement(By.id("firstName")).sendKeys("gaurav");

				//Checking First Name text field
				driver.findElement(By.id("lastName")).sendKeys("shahi");
				
				//Checking Username text field
				WebElement UN = driver.findElement(By.id("username"));
				UN.sendKeys("gaurav121");
				System.out.println("Username : "+UN.getAttribute("value"));
				Thread.sleep(1000);

				//Checking Password text field
				driver.findElement(By.name("Passwd")).sendKeys("gaurav1@");

				//Checking Confirm password text field
				driver.findElement(By.name("ConfirmPasswd")).sendKeys("gaurav1");
			
				//clicking on Next Button
				driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
				Thread.sleep(1000);
				String b=driver.getCurrentUrl();
				System.out.println(b);
				Assert.assertEquals(a, b);
		
	}
	@AfterClass
	public static void quit() {
		driver.quit();
}
}
