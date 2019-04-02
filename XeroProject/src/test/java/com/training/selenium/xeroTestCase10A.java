package com.training.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class xeroTestCase10A extends xeroTestCases{

	public void TC10A() throws InterruptedException, IOException
	{
		LaunchPage();
		loginLink();

		String[][] retData=readExcelData(dt_path,"TC01A");	

		credentials(retData[0][0],retData[0][1]);

		Thread.sleep(4000);
		
		//Business drop down
		WebElement business = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[2]/button"));				
		clickObject(business, "Business");
		
		//click purchases
		WebElement purchases = driver.findElement(By.linkText("Purchase orders"));	
		clickObject(purchases, "Purchases");
		
		Thread.sleep(3000);
		endTest();
		Thread.sleep(2000);
		driver.close();
	}

}
