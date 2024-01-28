package testCases;
import pages.WebPage;
import testBase.SeleniumTestBase;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebPageTestCases extends SeleniumTestBase{

	public WebPage wp;
	
	@Test
	public void loginTest_With_Valid_Email_And_Valid_Pwd() {
		wp = new WebPage(driver);
		wp.launchUrl();
		wp.setEmail("admin@yourstore.com");
		wp.setPassword("admin");
		wp.clickOnLoginBtn();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean status = wp.verifyingDashboardTitle();
		if(status == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}		
	}
	
	@Test
	 public void loginTest_With_Valid_Email_And_Invalid_Pwd() {
		wp = new WebPage(driver);
		wp.launchUrl();
		wp.setEmail("admin@yourstore.com");
		wp.setPassword("admin123");
		wp.clickOnLoginBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean status = wp.verifyingErrorMsg();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(status == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}		
	}
}
