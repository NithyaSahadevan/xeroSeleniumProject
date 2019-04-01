package com.training.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class xeroTestCase4 extends xeroTestCases{

	public void TC04_logout() throws InterruptedException, IOException {
		LaunchPage();
		loginLink();

		String[][] retData=readExcelData(dt_path,"TC01A");	

		credentials(retData[0][0],retData[0][1]);

		Thread.sleep(3000);

		//User Tab
		try {
			WebElement userTab=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/button/div/abbr"));
			clickObject(userTab,"User Tab");
			logger.log(LogStatus.PASS, "you are now in user dropdown page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception  user dropdown click failed");
		}


		Thread.sleep(3000);
		//Logout Link
		try {
			WebElement Logout=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/div/div[2]/div/ol/li[5]/a"));
			clickObject(Logout,"Logout Link");
			logger.log(LogStatus.PASS, "you are now in mainpage after logout");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception  Logout click failed");
		}

		endTest();
		Thread.sleep(2000);
		driver.close();
	}
}
