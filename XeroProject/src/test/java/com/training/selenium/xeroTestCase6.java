package com.training.selenium;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;

public class xeroTestCase6 extends xeroTestCases{

	//WebDriverWait wait = new WebDriverWait(driver, 40);
	public void TC06_UploadImage() throws InterruptedException, IOException
	{
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

		Thread.sleep(2000);

		//Profile SubTab 
		try {
			WebElement profile=driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/div/div[2]/div/ol/li[1]/a"));
			clickObject(profile,"profile subtab");
			logger.log(LogStatus.PASS, "you are now in user profile page");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception  user profile click failed");
		}

		Thread.sleep(4000);

		//Upload Image button click  
		try {
			WebElement uploadImage=driver.findElement(By.xpath("//*[@id=\"uploadavatarfield-1036\"]"));
			clickObject(uploadImage,"uploadImage Button");
			logger.log(LogStatus.PASS, "you are now in uploadImage dialogbox");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception  uploadImage button click failed");
		}

		
		Thread.sleep(2000);
		//Switch to photo frame
		//WebElement photoframe=driver.findElement(By.id("post_office_modal_frame"));
		//driver.switchTo().frame(photoframe);
		//System.out.println("photoframe");

		Thread.sleep(5000);
		
		//Browse button click 
		 
		try {					
			driver.findElement(By.xpath("//*[@id=\"filefield-1202-button-fileInputEl\"]")).sendKeys("D:\\SeleniumTraining\\football.jpg");		
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception  browse button click failed");
		}

		//Runtime.getRuntime().exec("C:\\Users\\sysadmin\\Desktop\\SeleniumTraining\\ExamSelenium\\fileupload.exe");	
		endTest();
		Thread.sleep(2000);
		driver.close();
	}

}
