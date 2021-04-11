package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage22 {

	public WebDriver driver;

	By username = By.id("custom-signin-username");
	By password = By.id("custom-signin-password");
	By submit = By.xpath("//BUTTON[@_ngcontent-fyb-c24=''][text()='Sign In']/self::BUTTON");
	By failedUser= By.xpath("//P[text()='Unable to sign in']");


	public LoginPage22(WebDriver driver) {

	this.driver=driver;
	PageFactory.initElements(driver, this);

	}

	public WebElement getUsername22() {

		return driver.findElement(username);
	}
	public WebElement getPassword22() {

		return driver.findElement(password);
	}
	public WebElement getSubmit22() {

		return driver.findElement(submit);
	}
	public WebElement failedUse22() {

		return driver.findElement(failedUser);
	}
	
}
