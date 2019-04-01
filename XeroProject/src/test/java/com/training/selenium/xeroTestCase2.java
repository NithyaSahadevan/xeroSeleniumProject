package com.training.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class xeroTestCase2 extends xeroTestCases{

	public void freeTrial() throws InterruptedException
	{
		LaunchPage();
		try
		{
			WebElement freeTrial=driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObject(freeTrial,"FreeTrial Link");
			logger.log(LogStatus.PASS, "FreeTrial Page is displayed");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"FreeTrial Link click failed");
		}
	}

	//SignUp Page
	public void TC02A_XDCSignUp() throws InterruptedException, IOException 
	{
		freeTrial();

		String[][] retData=readExcelData(dt_path,"TC02A");
		try {
			WebElement firstName=driver.findElement(By.xpath("//input[@name='FirstName']"));
			enterText(firstName,retData[0][0],"FirstName");
			logger.log(LogStatus.PASS, "First name is displayed");

			WebElement lastName=driver.findElement(By.xpath("//input[@name='LastName']"));
			enterText(lastName,retData[0][1],"LastName");
			logger.log(LogStatus.PASS, "Last name is displayed");

			WebElement email=driver.findElement(By.xpath("//input[@name='EmailAddress']"));
			enterText(email,retData[0][2],"Email Address");
			logger.log(LogStatus.PASS, "Email is displayed");

			WebElement phone=driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
			enterText(phone,retData[0][3],"Phone Number");
			logger.log(LogStatus.PASS, "Phone Number is displayed");

			//Select country from DropDown
			Select city=new Select(driver.findElement(By.xpath("//select[@name='LocationCode']")));
			city.selectByValue(retData[0][4]);
			logger.log(LogStatus.PASS, "country is displayed");

			WebElement robot=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[3]"));
			selectCheckBox(robot,"Check if human");
			logger.log(LogStatus.PASS, "reCaptcha is checked");

			WebElement terms=driver.findElement(By.name("TermsAccepted"));
			selectCheckBox(terms,"Terms Accepted");
			logger.log(LogStatus.PASS, "Terms Accepted");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "failed");
		}
		endTest();
		Thread.sleep(2000);
		driver.close();
		
	}
	
	//Free trial entering invalid data
	public void TC02B() throws InterruptedException, IOException
	{
		freeTrial();
		
		String[][] retData=readExcelData(dt_path,"TC02B");
		
		Thread.sleep(2000);
		WebElement getStarted1=driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[9]/span"));
		clickObject(getStarted1,"Get Started Button");
		logger.log(LogStatus.PASS, "First name,Last name,Email address, Phone number can't be empty");
		
		WebElement email=driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		enterText(email,retData[0][0],"Email Address");
		logger.log(LogStatus.PASS, "Email is displayed");
		
		WebElement getStarted2=driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[9]/span"));
		clickObject(getStarted2,"Get Started Button");
		logger.log(LogStatus.PASS, "Email address is invalid");
		logger.log(LogStatus.PASS, "term and Policy checkbox should be highlight");
		
		endTest();
		Thread.sleep(2000);
		driver.close();
		
	}

	//Free trial terms and conditions
	public void TC02C() throws InterruptedException {
		
		freeTrial();
		String parent=driver.getWindowHandle();
		
		Thread.sleep(2000);
		
		WebElement terms=driver.findElement(By.linkText("terms of use"));
		clickObject(terms,"terms of use link");
		logger.log(LogStatus.PASS, "term and Policy page is displayed");
		
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		
		WebElement privacy=driver.findElement(By.linkText("privacy notice"));
		clickObject(privacy,"privacy notice");
		logger.log(LogStatus.PASS, "Privacy Policy page is displayed");
		
		String originalHandle = driver.getWindowHandle();

	    //Do something to open new tabs

	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }

	    driver.switchTo().window(originalHandle);
		
		endTest();
		Thread.sleep(2000);
		driver.close();
		
	}
	
	
	//Free trial see full trial offers
	public void TC02D() throws InterruptedException 
	{
		freeTrial();
		
		
		endTest();
		Thread.sleep(2000);
		driver.close();
	}
	
	//Free trial accountant or bookkeeper link
	public void TC02E() throws InterruptedException 
	{
		freeTrial();
		
		Thread.sleep(2000);
		WebElement acc=driver.findElement(By.partialLinkText("accountant or bookkeeper"));
		clickObject(acc,"accountant link");
		logger.log(LogStatus.PASS, "accountant or bookkeeper page is displayed");
		
		
		endTest();
		Thread.sleep(2000);
		driver.close();
	}
}
