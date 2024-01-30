package testCases;
import pages.WebPage;
import testBase.SeleniumTestBase;
import java.time.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebPageTestCases extends SeleniumTestBase{

	public WebPage wp;
	
	@Test
	public void verifyingTextMsgAfterClickingOnRemoveBtnTest() {
		wp = new WebPage(driver);
		wp.launchUrl();
		wp.clickOnCheckBox();
		boolean status=wp.verifyingTextMsg();
		if(status == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyingAddBtnIsDispalyedTest() {
		wp = new WebPage(driver);
		wp.launchUrl();
		wp.clickOnCheckBox();
		boolean status =wp.isAddBtnDisplayed();
		if(status == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyingCheckBoxIsNotDisplayedAfterClickingOnRemoveBtnTest() throws InterruptedException{
		wp = new WebPage(driver);
		wp.launchUrl();
		wp.clickOnCheckBox();
		Thread.sleep(5000);
		boolean status = wp.isCheckboxDisplayed();
		if(status == true) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}
	
	
	
	
	
}
