package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Attribute extends BaseClassTest {
	
	@Test(priority = -2, enabled = true)
	public void createContact()  {
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.partialLinkText("Create Contact")).click();
		WebElement elementFirstName = driver.findElement(By.id("firstNameField"));
		elementFirstName.sendKeys("Abinaya");
		driver.findElement(By.id("lastNameField")).sendKeys("Shree");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Sudheera");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Shri");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("EIE");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Electronics and Instrumentation Engineering");
				
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("sudheera96@gmail.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select obj = new Select(state);
		obj.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Confidential");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("Page title is : " + driver.getTitle());
		// driver.close();

	}

	@Test(priority = 1, enabled = false)
	public void deleteLead() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("044 94578612");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		WebElement leadId = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String leadId1 = leadId.getText();
		System.out.println(leadId1);
		Thread.sleep(2000);
		leadId.click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(leadId1);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		if (driver.findElement(By.className("x-paging-info")).isDisplayed()) {
			System.out.println("No Records to Display");
		} else {
			System.out.println("Records to Display");
		}
		// driver.close();

	}

	@Test(priority = 4, enabled = true)
	public void duplicateLead() throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("rrr@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(), 'Find Leads')]")).click();
		Thread.sleep(1000);
		WebElement leadFirstName = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String capturedLeadName = leadFirstName.getText();
		System.out.println(capturedLeadName);
		leadFirstName.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if (driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("The title contains the word Duplicate Lead");
		} else {
			System.out.println("The title does not contain the word Duplicate Lead");
		}
		driver.findElement(By.name("submitButton")).click();
		String duplicatedLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(duplicatedLeadName);
		if (capturedLeadName.equals(duplicatedLeadName)) {
			System.out.println("Duplicated lead name is same as Captured name");
		} else {
			System.out.println("Duplicated lead name is not same as Captured name");
		}
		// driver.close();

	}

	@Test(priority = 2,enabled = true)
	public void editLead() throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Hari");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("11336")).click();
		Thread.sleep(2000);
		System.out.println("The page title is  " + driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf Training Centre");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])")).click();
		// driver.close();
	}

	@Test(priority = 3, enabled = true,invocationCount = 3,threadPoolSize = 2)
	public void createLead() {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Gayathri");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("SK");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("3/04/1999");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("22");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("babu@testleaf.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9457861236");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Arith");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("google.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Ashwin");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Alice");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("123,ECR road");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("TVK nagar");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")).sendKeys("Tennessee");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("640037");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("05");
		driver.findElement(By.name("submitButton")).click();

	}

}
