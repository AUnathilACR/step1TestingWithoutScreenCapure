package testClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage2;
import pageObjects.SplashPage1;
import resources.base;

public class CICIPagesInvalidUser extends base{
	public WebDriver driver;
	@Test(priority = 4)
	public void initializeInValidUser() throws IOException {
		driver = initializeDriver();
		//log.info("Driver is initialized");
		
	}
	@Test(priority = 5, dataProvider = "getData")
	public void InValidUser(String UserName, String Password, String text) throws IOException, InterruptedException {

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
		
		//System.out.println(lp.failedUse().getText());

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][3];

		data[0][0] = "auwrgnaswgwgthil@acr.org";
		data[0][1] = "Gifrggtofgod@123";
		data[0][2] = "Invalid user1";
		
		/*
		 * data[1][0] = "sfgvfsgs@acr.org"; data[1][1] = "sfgsfggsg@123"; data[1][2] =
		 * "Invalid user2";
		 */
		return data;
	}

	@Test(priority = 6)
	public void tearDownInValidUser() {

		driver.close();
	}
}
