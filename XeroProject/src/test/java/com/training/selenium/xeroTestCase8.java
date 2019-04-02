package com.training.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

		//My xero subtab
		WebElement myXero = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[4]/ol/li/a"));		 
		clickObject(myXero, "My Xero");
		Thread.sleep(5000);


		String winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		//Add an organization   
		try {
			WebElement addOrgn=driver.findElement(By.id("ext-gen1043"));
			addOrgn.getAttribute("href");
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

		//What does your Organization do?  
		try {
			WebElement orgnBusiness = driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));	
			clickObject(orgnBusiness,"occupation");
			Thread.sleep(2000);
			enterText(orgnBusiness,retData[1][3],"What does your Organization do?");
			Thread.sleep(2000);
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
		logger.log(LogStatus.PASS,"Start trial page");
		
		Thread.sleep(5000);
		
		endTest();
		Thread.sleep(2000);
		driver.quit();
			
	}

	public void TC08B_BuyNow() throws InterruptedException, IOException
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

		//My xero subtab
		WebElement myXero = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[4]/ol/li/a"));		 
		clickObject(myXero, "My Xero");
		Thread.sleep(5000);


		String winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		//Add an organization   
		try {
			WebElement addOrgn=driver.findElement(By.id("ext-gen1043"));
			addOrgn.getAttribute("href");
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
			enterText(OrgName,retData[2][0],"Organization Name");
			logger.log(LogStatus.PASS, "organization Name added");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception organization Name entry failed");
		}	


		//country where organization pay taxes
		try {
			WebElement country=driver.findElement(By.xpath("//*[@id=\"countryCmb-inputEl\"]"));
			enterText(country, retData[2][1], "Country");
			Thread.sleep(2000);
			country.sendKeys(Keys.ENTER);

			logger.log(LogStatus.PASS, "TaxPay Country");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception TaxPay Country entry failed");
		}
		Thread.sleep(2000);

		//What does your Organization do?  
		try {
			WebElement orgnBusiness = driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));	
			clickObject(orgnBusiness,"occupation");
			Thread.sleep(2000);
			enterText(orgnBusiness,retData[2][3],"What does your Organization do?");
			Thread.sleep(2000);
			orgnBusiness.sendKeys(Keys.DOWN);
			orgnBusiness.sendKeys(Keys.DOWN);
			orgnBusiness.sendKeys(Keys.ENTER);
			logger.log(LogStatus.PASS,"Organization Business added");
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL,"Exception Organization Business entry failed");
		}	

		//Click Buy Now
		WebElement buyNow = driver.findElement(By.xpath("//*[@id=\"simplebutton-1036\"]"));		
		clickObject(buyNow, "Buy Now");
		logger.log(LogStatus.PASS,"\"Purchase Plan\" Subscription and Billing page");

		Thread.sleep(3000);
		
		endTest();
		Thread.sleep(2000);
		driver.quit();
		
			
	}
	
	public void TC08C_starterPlan() throws InterruptedException, IOException
	{
		String[][] retData=readExcelData(dt_path,"TC08C");	
		//String url = retData[1][1];
		String userEmail = retData[1][2];
		String pwd = retData[1][3];
		String org = retData[1][4];
		String countryName = retData[1][5];
		String time = retData[1][6];
		String occ = retData[1][7];
		String streetName = retData[1][8];
		String cityName = retData[1][9];
		String stateName = retData[1][10];
		String zip = retData[1][11];
		String cardNumber = retData[1][12];
		String expiryDate = retData[1][13];
		String cvcCode = retData[1][14];
		String cardName = retData[1][15];
		
		LaunchPage();

		loginLink();
		//Enter User name
		WebElement userName = driver.findElement(By.xpath("//*[@id='email']"));							
		enterText(userName, userEmail, "UserName");

		//Enter Password
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));						
		enterText(password, pwd, "Password");
		
		//Click Login
		WebElement login = driver.findElement(By.xpath("//*[@id='submitButton']"));							
		clickObject(login, "Login");
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		//Click Xero Menu 
		WebElement xeroMenu = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button"));		
		clickObject(xeroMenu, "Xero Menu");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//Click my Xero 
		WebElement myXero = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[4]/ol/li/a"));		
		clickObject(myXero, "My Xero");
		Thread.sleep(4000);
		
		String winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		
		//Click add organization 
		WebElement addOrg = driver.findElement(By.id("ext-gen1043"));		
		clickObject(addOrg, "Add Organization");
		Thread.sleep(4000);
		
		
		//Enter organization name
		WebElement orgName = driver.findElement(By.id("text-1022-inputEl"));			
		enterText(orgName, org, "Organization Name");
		
		//select country
		WebElement country = driver.findElement(By.xpath("//*[@id=\"countryCmb-inputEl\"]"));			
		enterText(country, countryName, "Country");
		Thread.sleep(2000);
		country.sendKeys(Keys.ENTER);
		
		//select time zone
		WebElement timeZone = driver.findElement(By.xpath("//*[@id='cmbTimeZone-inputEl']"));			
		enterText(timeZone, time, "Time Zone");
		Thread.sleep(2000);
		timeZone.sendKeys(Keys.ENTER);
		
		//Enter organization occupation
		WebElement occupation = driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));	
		enterText(occupation, occ, "What does your Organization do?");
		occupation.sendKeys(Keys.DOWN);
		occupation.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		occupation.sendKeys(Keys.ENTER);
		
		//Click Buy Now 
		WebElement buyNow = driver.findElement(By.xpath("//*[@id=\"simplebutton-1036\"]"));		
		clickObject(buyNow, "Buy Now");
		Thread.sleep(3000);
		
		//Click Starter plan 
		WebElement starterPlan = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div/div/div/section[1]/div[1]/label/div"));		
		clickObject(starterPlan, "Starter Plan");
		
		
		//Click continue billing 
		WebElement continueBilling = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[5]/div/button/span"));		
		clickObject(continueBilling, "Continue to billing details");
		
		//Enter street
		WebElement street = driver.findElement(By.xpath("//*[@id=\"contactAddress\"]"));						
		enterText(street, streetName, "Street Address");
		
		//Enter city
		WebElement city = driver.findElement(By.xpath("//*[@id=\"contactCity\"]"));						
		enterText(city, cityName, "City");
		
		//selecting desired state option from the list
		
		WebElement selectMenu = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[3]/div/div/div/form/div[5]/div[4]/div/button"));
		selectMenu.click();
		Thread.sleep(2000);
		driver.findElement(By.id(stateName)).click();
		
		//Enter zip code
		WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"contactPostalCode\"]"));						
		enterText(zipCode, zip, "Zip Code");

		//Click continue review and pay 
		WebElement continuePay = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[3]/div/div/div/div/button"));		
		clickObject(continuePay, "Continue to review and pay");
		Thread.sleep(3000);
		
		//Enter credit card number
		driver.switchTo().frame("__privateStripeFrame7");
		String cardPath = "/html/body/div/form/span[2]/span/input";
		WebElement creditCardNumber = driver.findElement(By.xpath(cardPath));
		enterText(creditCardNumber, cardNumber, "Credit Card Number");							
		driver.switchTo().defaultContent();
		
		//Enter credit card expiry date
		driver.switchTo().frame("__privateStripeFrame8");
		System.out.println("Switched to frame");
		String expiryPath = "/html/body/div/form/span[2]/span/input";
		WebElement creditCardExpiry = driver.findElement(By.xpath(expiryPath));						
		enterText(creditCardExpiry,expiryDate, "Credit Card Expiry Date");
		driver.switchTo().defaultContent();
		
		//Enter credit card cvc security code
		driver.switchTo().frame("__privateStripeFrame9");
		String cvcPath = "/html/body/div/form/span[2]/span/input";
		WebElement cvc = driver.findElement(By.xpath(cvcPath));							
		enterText(cvc, cvcCode, "CVC Security Code");
		driver.switchTo().defaultContent();
		
		//Enter name on credit card 
		WebElement nameOnCard = driver.findElement(By.xpath("//*[@id=\"stripe-cardholder-name\"]"));						
		enterText(nameOnCard, cardName, "Name on Card");
		
		//Click Authorize Payment 
		WebElement authorizePay = driver.findElement(By.xpath("//*[@id=\"continueButton\"]"));		
		clickObject(authorizePay, "Authorize Payment");
		
		Thread.sleep(5000);
		
		endTest();
		Thread.sleep(2000);
		driver.quit();
	}

	public void TC08F_QuickBooks() throws InterruptedException, IOException
	{
		String[][] retData=readExcelData(dt_path,"TC08C");	
		//String url = retData[1][1];
		String userEmail = retData[1][2];
		String pwd = retData[1][3];
		String org = retData[1][4];
		String countryName = retData[1][5];
		String time = retData[1][6];
		String occ = retData[1][7];
		String streetName = retData[1][8];
		String cityName = retData[1][9];
		String stateName = retData[1][10];
		String zip = retData[1][11];
		String cardNumber = retData[1][12];
		String expiryDate = retData[1][13];
		String cvcCode = retData[1][14];
		String cardName = retData[1][15];
		
		LaunchPage();

		loginLink();
		//Enter User name
		WebElement userName = driver.findElement(By.xpath("//*[@id='email']"));							
		enterText(userName, userEmail, "UserName");

		//Enter Password
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));						
		enterText(password, pwd, "Password");
		
		//Click Login
		WebElement login = driver.findElement(By.xpath("//*[@id='submitButton']"));							
		clickObject(login, "Login");
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		//Click Xero Menu 
		WebElement xeroMenu = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button"));		
		clickObject(xeroMenu, "Xero Menu");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//Click my Xero 
		WebElement myXero = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[4]/ol/li/a"));		
		clickObject(myXero, "My Xero");
		Thread.sleep(4000);
		
		String winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		
		//Click add organization 
		WebElement addOrg = driver.findElement(By.id("ext-gen1043"));		
		clickObject(addOrg, "Add Organization");
		Thread.sleep(4000);
		
		
		//Enter organization name
		WebElement orgName = driver.findElement(By.id("text-1022-inputEl"));			
		enterText(orgName, org, "Organization Name");
		
		//select country
		WebElement country = driver.findElement(By.xpath("//*[@id=\"countryCmb-inputEl\"]"));			
		enterText(country, countryName, "Country");
		Thread.sleep(2000);
		country.sendKeys(Keys.ENTER);
		
		//select time zone
		WebElement timeZone = driver.findElement(By.xpath("//*[@id='cmbTimeZone-inputEl']"));			
		enterText(timeZone, time, "Time Zone");
		Thread.sleep(2000);
		timeZone.sendKeys(Keys.ENTER);
		
		//Enter organization occupation
		WebElement occupation = driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));	
		enterText(occupation, occ, "What does your Organization do?");
		occupation.sendKeys(Keys.DOWN);
		occupation.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		occupation.sendKeys(Keys.ENTER);
		
		//Click on QuickBooks conversion link 
		WebElement conversionLink = driver.findElement(By.xpath("//*[@id=\"conversionLink\"]"));		
		clickObject(conversionLink, "move from QuickBooks for free");
				
		//Click convert check box 
		WebElement convertCheckBox = driver.findElement(By.xpath("//*[@id=\"conversionCheckbox-inputEl\"]"));		
		clickObject(convertCheckBox, "Want to convert your Data?");
		
		//Click Buy Now 
		WebElement buyNow = driver.findElement(By.xpath("//*[@id=\"simplebutton-1036\"]"));		
		clickObject(buyNow, "Buy Now");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Quick books file conversion Page openened");
		
		Thread.sleep(5000);
		
		endTest();
		Thread.sleep(2000);
		driver.quit();
	}
}
