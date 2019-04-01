package com.training.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class xeroTestCase3 extends xeroTestCases{

	public void TC03_TestTabs() throws InterruptedException, IOException
	{
		LaunchPage();
		loginLink();

		String[][] retData=readExcelData(dt_path,"TC01A");	

		credentials(retData[0][0],retData[0][1]);

		Thread.sleep(4000);
		//Dashboard Tab
		try {
			WebElement dashBoard=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[1]/a"));
			clickObject(dashBoard,"Dashboard tab");
			logger.log(LogStatus.PASS, "you are now in dashboard page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Dashboard tab click failed");
		}

		Thread.sleep(2000);
		driver.navigate().back();

		//Accounting Tab
		try {
			WebElement accounts=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[3]/button"));
			clickObject(accounts,"Accounting tab");
			logger.log(LogStatus.PASS, "you are now in Accounting dropdown page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Accounting tab click failed");
		}

		Thread.sleep(2000);

		//Report SubMenu
		try {
			WebElement reports=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[3]/div/div[2]/div/ol[1]/li[2]/a"));
			clickObject(reports,"Report submenu");
			logger.log(LogStatus.PASS, "you are now in Reporting page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Reporting submenu click failed");
		}

		Thread.sleep(2000);
		driver.navigate().back();


		//Contact Tab
		try {
			WebElement contacts=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[4]/button"));
			clickObject(contacts,"Contact Tab");
			logger.log(LogStatus.PASS, "you are now in contact dropdown page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception contact tab click failed");
		}


		Thread.sleep(2000);
		driver.navigate().back();
		//New(+) Tab
		try {
			WebElement newtab=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[1]/button/div/svg/path"));
			clickObject(newtab,"New Tab");
			logger.log(LogStatus.PASS, "you are now in new drop down page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception new tab click failed");
		}

		Thread.sleep(2000);
		driver.navigate().back();

		//Search Tab
		try {
			WebElement searchTab=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[2]/button/div"));
			clickObject(searchTab,"Search Tab");
			logger.log(LogStatus.PASS, "you are now in search drop down page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception search tab click failed");
		}

		Thread.sleep(2000);
		driver.navigate().back();

		//Notifications Tab
		try {
			WebElement notificationTab=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[3]/button/div/svg/path"));
			clickObject(notificationTab,"notification Tab");
			logger.log(LogStatus.PASS, "you are now in notification drop down page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception notification tab click failed");
		}

		Thread.sleep(2000);
		driver.navigate().back();

		//Help Tab
		try {
			WebElement helpTab=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[4]/button/div/svg/path"));
			clickObject(helpTab,"notification Tab");
			logger.log(LogStatus.PASS, "you are now in help drop down page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception help tab click failed");
		}
		endTest();
		Thread.sleep(2000);
		driver.close();
	}

}
