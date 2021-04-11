package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SplashPage11 {

	public WebDriver driver;

	By signin = By.id("cice-splash-signin-submit");
	By header = By.xpath("//h1[contains(text(),'ACR 2022 ANNUAL MEETING')]");
	By electionDisplayed = By.xpath("//h4[contains(text(),'Election')]");

	public SplashPage11(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	public WebElement getLogin11() {

		return driver.findElement(signin);
	}

	public WebElement getHeader11() {

		return driver.findElement(header);
	}

	public WebElement getNavigation11() {

		return driver.findElement(electionDisplayed);
	}
}
