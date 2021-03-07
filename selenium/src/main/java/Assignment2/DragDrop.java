package Assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragDrop {
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
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		WebElement From = driver.findElement(By.id("draggable"));  
		WebElement To = driver.findElement(By.id("droppable")); 
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).perform();
		Thread.sleep(2000);
		
		
	}
	@AfterClass
	public static void quit() {
		driver.quit();
	}
}
