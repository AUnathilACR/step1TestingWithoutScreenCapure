package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	public WebDriver driver;

	By username = By.id("custom-signin-username");
	By password = By.id("custom-signin-password");
	By submit = By.xpath("//button[contains(text(),'Sign In')]");
	By failedUser= By.xpath("//P[text()='Unable to sign in']");


	public LoginPage2(WebDriver driver) {

	this.driver=driver;
	PageFactory.initElements(driver, this);

	}

	public WebElement getUsername() {

		return driver.findElement(username);
	}
	public WebElement getPassword() {

		return driver.findElement(password);
	}
	public WebElement getSubmit() {

		return driver.findElement(submit);
	}
	public WebElement failedUse() {

		return driver.findElement(failedUser);
	}
	
}
