package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{


	prop = new Properties();
	String filePath = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
	FileInputStream fis = new FileInputStream(filePath);

	prop.load(fis);
	String browserName = prop.getProperty("browser");
	String headlessMode = prop.getProperty("head");
	// String browserName = System.getProperty("browser");
	System.out.println(browserName);

	if (browserName.contains("chrome")) {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		if (headlessMode.contains("headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} else {
			driver = new ChromeDriver();
		} // execute in chrome driver

	} else if (browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		// firefox code
	} else if (browserName.equals("IE")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		// IE code
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;

}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
