package testClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.SplashPage1;
import resources.base;

//Adding logs 
//Generating html reports
//Screenshots on failure
//JEnkins integration
public class ValidateFields extends base {
	public WebDriver driver;

	// public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest

	public void initializeValidateFieldes() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test

	public void ValidateField() throws IOException {

		// one is inheritance
		// creating object to that class and invoke methods of it
		SplashPage1 sp = new SplashPage1(driver);
		Assert.assertEquals(sp.getHeader().getText(), "ACR 2022 rANNUAL MEETING");

		// compare the text from the browser with actual text.- Error..
		Assert.assertTrue(sp.getNavigation().isDisplayed());
		// log.info("Navigation Bar is displayed");
		System.out.println("Test completed");
		// Assert.assertFalse(false);
		;

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
