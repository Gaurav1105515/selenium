package Assignment2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class brokenLink {
	public static WebDriver driver;
	static String web = "https://www.zlti.com";
	static String page = "";
	static HttpURLConnection huc = null;
	static int respCode = 200;

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
		driver.get("https://www.zlti.com");
		Thread.sleep(1000);
		List<WebElement> Element = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = Element.iterator();
		Thread.sleep(1000);
		while (it.hasNext()) {

			page = it.next().getAttribute("href");

			System.out.println(page);

			if (page == null || page.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				Thread.sleep(1000);
				continue;

			}

			if (!page.startsWith(web)) {
				System.out.println("URL belongs to another domain, skipping it.");
				Thread.sleep(1000);
				continue;
			}
			try {
				huc = (HttpURLConnection) (new URL(page).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(page + " is a broken link");
					Thread.sleep(1000);
				} else {
					System.out.println(page + " is a valid link");
					Thread.sleep(1000);
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
				Thread.sleep(1000);

			}
		}
	}

	@AfterClass
	public static void quit() {
		driver.quit();

	}
}
