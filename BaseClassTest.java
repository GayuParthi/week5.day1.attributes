package week5.day1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClassTest {
  public ChromeDriver driver;
  @BeforeMethod
  public void beforeMethod() {
  	WebDriverManager.chromedriver().setup();
  	driver = new ChromeDriver();
  	driver.get("http://leaftaps.com/opentaps/control/main");
  	driver.manage().window().maximize();
  	WebElement elementUsername = driver.findElement(By.id("username"));
  	elementUsername.sendKeys("DemoCSR");
  	WebElement elementPassword = driver.findElement(By.id("password"));
  	elementPassword.sendKeys("crmsfa");
  	driver.findElement(By.className("decorativeSubmit")).click();
  	driver.findElement(By.className("crmsfa")).click();	
  }


  @AfterMethod
  public void afterMethod() {
  	 driver.close();
  }
  


}
