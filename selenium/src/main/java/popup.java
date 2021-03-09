import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class popup {
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
	public static void main() throws InterruptedException {
		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		Thread.sleep(2000);
		Set<String>set1=driver.getWindowHandles();						

		Iterator<String>iterator1=set1.iterator();
		Thread.sleep(2000);

		String parent=iterator1.next();											
		String child=iterator1.next();											

		driver.switchTo().window(child);	
		Thread.sleep(2000);

		System.out.println("Child Window : "+driver.getTitle());
		driver.close();														

		driver.switchTo().window(parent);								
		System.out.println("Parent Window : "+driver.getTitle());
		Thread.sleep(3000);
		
	}
	@AfterClass
	public static void quit() {
		driver.quit();
	}
}
