package testClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage2;
import pageObjects.SplashPage1;
import resources.base;

public class CICEPagesValidUser extends base {
	public WebDriver driver;

	//public static Logger log = LogManager.getLogger(base.class.getName());

	@Test(priority = 1)
	public void initializeValidUser() throws IOException {
		driver = initializeDriver();
		//log.info("Driver is initialized");
		
	}

	@Test(priority = 2, dataProvider = "getData")
	public void ValidUser(String UserName, String Password, String text) throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		// driver.manage().window().fullscreen(); the page will be in full screen
		//log.info("Navigated to HomePage");
		
		driver.manage().window().maximize();
		SplashPage1 sp = new SplashPage1(driver);
		
		
		//log.info("Succesfully Validated The Title In Splash Page");
		// Assert.assertFalse(false);
		sp.getLogin().click();
		
		LoginPage2 lp = new LoginPage2(driver);
		lp.getUsername().sendKeys(UserName);
		//lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		//log.info(text);

		lp.getSubmit().click();
		WebDriverWait wait=new WebDriverWait(driver, 20);	
		WebElement revirewConfirm =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cice-checkin-review-confirm-submit")));
		Thread.sleep(4000);
		revirewConfirm.click();
		Thread.sleep(4000);
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][3];
		// row1
		data[0][0] = "user_1_regular_attendee";
		data[0][1] = "Giftofgod@123";
		data[0][2] = "valid user";

		/*
		 * // row2
		 * 
		 * data[1][0] = "auwrgnaswgwgthil@acr.org"; data[1][1] = "Gifrggtofgod@123";
		 * data[1][2] = "Invalid user";
		 */
		return data;
	}

	@Test(priority = 3)
	public void tearDownValidUser() {

		driver.close();
	}
}
