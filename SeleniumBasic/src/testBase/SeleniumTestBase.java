package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SeleniumTestBase {
	
public WebDriver driver;
	

@BeforeClass
public void setUp()  {
	System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win64\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}


@AfterClass
public void tearDown() {
	try
	{
		driver.close();
	}
	finally
	{
		driver.quit();
	}
}

}
