package com.training.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class LoginModule extends ReusableMethods{
		static String s1,s2;
		
		//String dt_path="C:\\Users\\sysadmin\\Desktop\\SeleniumTraining\\ExamSelenium\\ActualData.xls";	
		String dt_path="testData\\ActualData.xls";	
		private void setLogin() throws IOException
		{
			String[][] retData=readExcelData(dt_path,"Sheet1");
			s1=retData[0][0];
			s2=retData[0][1];
		}
		public void login(String userName,String Password) throws InterruptedException, IOException
		{
			setLogin();
			WebElement loginButton=driver.findElement(By.id("submitButton"));
			clickObject(loginButton,"Login Button");
			if((userName.equals(s1))&&(Password.equals(s2)))
			{
				System.out.println("Successfuly logged in to HomePage");
				logger.log(LogStatus.PASS, "Successfuly logged in to HomePage");
			}
			else
			{
				System.out.println("Your Email or Password is incorrect");
				logger.log(LogStatus.FAIL, "Your Email or Password is incorrect");
			}
		}
}
