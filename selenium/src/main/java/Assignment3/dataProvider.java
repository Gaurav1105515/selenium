package Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	public static WebDriver driver;
	@DataProvider(name = "gaurav")
  	public Object[][] dataprov(){
        	return new Object[][]{
        		{"facebook"},{"google"}
        	};
  	}
	

	@BeforeClass
	public static void Runner() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahi\\Desktop\\driver\\chromedriver.exe");
		Thread.sleep(1000);
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		driver.manage().window().maximize();
		Thread.sleep(1000);

}
	@Test(dataProvider ="gaurav")
	public  static void main(String abc)throws InterruptedException{
  	  
	      WebElement text = driver.findElement(By.name("q"));
  	  text.sendKeys(abc);
  	  Thread.sleep(8000);
  	 
		
	}
	@AfterClass
	public static void quit() {
		driver.quit();
}
}
