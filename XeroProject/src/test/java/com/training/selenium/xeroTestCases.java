package com.training.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class xeroTestCases extends ReusableMethods{

	static String dt_path="C:\\Users\\sysadmin\\Desktop\\SeleniumTraining\\ExamSelenium\\ActualData.xls";


	public static void LaunchPage() throws InterruptedException
	{
		startTest();
		InitializeDriver();

		Launch("https://www.xero.com/us/", "Login");

	}
	public static void loginLink() throws InterruptedException
	{
		//Login to the user page
		WebElement loginPage=driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a"));
		clickObject(loginPage,"Login Page Link");
	}
	public static void credentials(String uName,String Pwd) throws InterruptedException, IOException
	{
		//Enter UserName
		WebElement userName=driver.findElement(By.id("email"));
		enterText(userName,uName,"Email");

		//Enter Password
		WebElement pw=driver.findElement(By.id("password"));
		enterText(pw,Pwd,"Password");

		//Click login button
		LoginModule lm=new LoginModule();
		lm.login(uName, Pwd);
	}


	//Navigate to Login Page with valid username and password
	public void TC01A() throws InterruptedException, IOException
	{
		LaunchPage();

		loginLink();

		String[][] retData=readExcelData(dt_path,"TC01A");	

		credentials(retData[0][0],retData[0][1]);

		Thread.sleep(2000);

		endTest();
		Thread.sleep(2000);
		driver.close();
	}

	//Try to login with invalid Password
	public void TC01B() throws InterruptedException, IOException {

		LaunchPage();

		loginLink();

		String[][] retData=readExcelData(dt_path,"TC01B");	

		credentials(retData[0][0],retData[0][1]);

		Thread.sleep(2000);
		
		endTest();
		Thread.sleep(2000);
		driver.close();
	}

	//Try to login with invalid username
	public void TC01C() throws IOException, InterruptedException
	{
		LaunchPage();

		loginLink();

		String[][] retData=readExcelData(dt_path,"TC01C");	

		credentials(retData[0][0],retData[0][1]);

		Thread.sleep(2000);

		endTest();
		Thread.sleep(2000);
		driver.close();
	}

	//Forgot Password
	public void TC01D() throws InterruptedException
	{
		LaunchPage();

		loginLink();

		//Click Forgot Password Link
		try {
			WebElement forgotPwd=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a[1]"));
			clickObject(forgotPwd,"Forgot Password link");
			logger.log(LogStatus.PASS,"forgot password page is displayed");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception forgot password click failed");
		}

		//Enter the email to send the new password
		try {

			WebElement ForgotPwEmail=driver.findElement(By.id("UserName1"));
			enterText(ForgotPwEmail,"nith123@abc.com","Forgot Password Email");
			System.out.println("Forgot Password page is Displayed");
			logger.log(LogStatus.PASS,"Forgot Password page is Displayed");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Send Link button click failed");
			endTest();

		}

		//Click the send link button  ""
		try {

			WebElement sendLink=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div[1]/a"));
			clickObject(sendLink,"SendLink Button");
			System.out.println("A link to reset your password has been sent to: page is Displayed");
			logger.log(LogStatus.PASS,"A link to reset your password has been sent to: page is Displayed");

		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Send Link button click failed");			
			Thread.sleep(2000);
		}


		endTest();
		Thread.sleep(2000);
		driver.close();
	}
}
