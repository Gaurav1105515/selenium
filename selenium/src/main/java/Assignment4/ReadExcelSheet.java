package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadExcelSheet {
	public static WebDriver driver;
	static XSSFWorkbook mybook;
	static FileInputStream excelapp;
	static FileOutputStream excelout;
	static XSSFSheet cred;
	@BeforeClass
	public static void Runner() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahi\\Desktop\\driver\\chromedriver.exe");
		Thread.sleep(1000);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		Thread.sleep(1000);
		String excelpath="C:\\Users\\shahi\\Desktop\\abc.xlsx";
		//for reading in excel
		excelapp=new FileInputStream(excelpath);
		//for opening workbook
		mybook=new XSSFWorkbook(excelapp);
		cred=mybook.getSheetAt(0);
		//for writing in excel
		excelout=new FileOutputStream(excelpath);
}
	@Test
	public static void test() throws InterruptedException {
		//no. of rows in excel
		int noofrows=cred.getLastRowNum()-cred.getFirstRowNum();
		System.out.println("no.of.rows:"+noofrows);
		//iterate each row in excel
		for(int i=1;i<noofrows;i++);
		//open the login page
		driver.get("https://www.facebook.com");
		
		Thread.sleep(1000);
		//username
		String username=cred.getRow(1).getCell(0).getStringCellValue();
		//password
		String password=cred.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		if(!(driver.getCurrentUrl().equals("https://www.facebook.com/login")));
		System.out.println("success");
		
		
		
	}
	@AfterClass
	public static void quit() {
		driver.quit();
}
}