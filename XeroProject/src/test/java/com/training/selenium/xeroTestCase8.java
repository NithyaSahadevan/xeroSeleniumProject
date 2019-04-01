package com.training.selenium;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.LogStatus;

public class xeroTestCase8 extends xeroTestCases{

	public void TC08A_TrialVersion() throws InterruptedException, IOException
	{
		LaunchPage();

		loginLink();

		String[][] retData=readExcelData(dt_path,"TC08");	

		//Enter UserName
		WebElement userName=driver.findElement(By.id("email"));
		enterText(userName,retData[0][0],"Email");

		//Enter Password
		WebElement pw=driver.findElement(By.id("password"));
		enterText(pw,retData[0][1],"Password");

		WebElement loginButton=driver.findElement(By.id("submitButton"));
		clickObject(loginButton,"Login Button");

		Thread.sleep(4000);



		//Self Tab
		try {
			WebElement self=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button"));
			clickObject(self,"self dropdown");
			logger.log(LogStatus.PASS, "you are now in self dropdown page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception  self dropdown click failed");
		}

		Thread.sleep(2000);

		//Add an organization   
		try {
			WebElement addOrgn=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[3]/ol/li[5]/a"));
			clickObject(addOrgn,"Add organization");
			logger.log(LogStatus.PASS, "you are now in Add an organization  page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Add an organization click failed");
		}

		Thread.sleep(2000);
		
		//Enter organization Name
		try {
			WebElement OrgName=driver.findElement(By.id("text-1022-inputEl"));
			clickObject(OrgName,"Organization Name");
			enterText(OrgName,retData[1][0],"Organization Name");
			logger.log(LogStatus.PASS, "organization Name added");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception organization Name entry failed");
		}	


		//country where organization pay taxes
		try {
			WebElement country=driver.findElement(By.xpath("//*[@id=\"countryCmb-inputEl\"]"));
			enterText(country, retData[1][1], "Country");
			Thread.sleep(2000);
			country.sendKeys(Keys.ENTER);

			logger.log(LogStatus.PASS, "TaxPay Country");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception TaxPay Country entry failed");
		}
		Thread.sleep(2000);

		//Time Zone
		/*try {

			WebElement timeZone = driver.findElement(By.xpath("//*[@id='cmbTimeZone-inputEl']"));			
			enterText(timeZone, retData[1][2], "Time Zone");
			Thread.sleep(2000);
			timeZone.sendKeys(Keys.ENTER);
			logger.log(LogStatus.PASS,"Time Zone entry succeedeed");

		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Time Zone entry failed");
		}
		Thread.sleep(2000);*/

		//Area of business  
		
	//What does your Organization do?  
	try {
		WebElement orgnBusiness = driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));	
		clickObject(orgnBusiness,"occupation");
		Thread.sleep(2000);
		enterText(orgnBusiness,retData[1][3],"What does your Organization do?");
		Thread.sleep(2000);
		orgnBusiness.sendKeys(Keys.DOWN);
		orgnBusiness.sendKeys(Keys.DOWN);
		orgnBusiness.sendKeys(Keys.DOWN);
		orgnBusiness.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS,"Organization Business added");
	}
	catch (Exception e){
		logger.log(LogStatus.FAIL,"Exception Organization Business entry failed");
	}	

	//Click Start Trial 
	WebElement startTrial = driver.findElement(By.id("simplebutton-1035"));		
	clickObject(startTrial, "Start Trial");

	
		Thread.sleep(2000);
		endTest();
		Thread.sleep(2000);
		driver.close();
	}

}
