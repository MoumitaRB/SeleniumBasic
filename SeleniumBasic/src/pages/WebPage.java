package pages;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class WebPage {
	
	public WebDriver driver;
	
	//locators
	private String url= "https://the-internet.herokuapp.com/dynamic_controls";
	@FindBy(xpath="//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")
	private WebElement checkBox;
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	private WebElement removeBtn;
	@FindBy(xpath = "//p[@id='message']")
	private WebElement textMsg;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement addBtn;
	@FindBy(xpath="//button[contains(text(),'Enable')]")
	private WebElement enableBtn;
	
	
	public WebPage(WebDriver driver)
	{
		try {
			this.driver=driver;	
			PageFactory.initElements(this.driver, this);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}	
	
	//methods
	public void launchUrl() {
		driver.get(url);
	}
	
	public void clickOnCheckBox() {
		checkBox.click();
		removeBtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public boolean verifyingTextMsg() {
		boolean status = false;
		String msg = textMsg.getText();
		if(msg.equals("It's gone!")) {
			status = true;
		}
		 return status;		
	}
	
	public boolean isAddBtnDisplayed() {
		boolean status = false;
		boolean addBtnFlag =addBtn.isDisplayed();
		if(addBtnFlag==true) {
			status = true;
		}
		return status;
	}
	
	public boolean isCheckboxDisplayed() {		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		try {
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30L))
		       .pollingEvery(Duration.ofSeconds(5L))
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"));
		     }
		   });
		   return (foo != null);
		} catch(TimeoutException tex) {
			return false;
		}

	}
		
}
