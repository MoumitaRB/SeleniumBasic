package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebPage {
	
	public WebDriver driver;
	//locators
	private String url= "https://admin-demo.nopcommerce.com/login";
	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailTextBox;
	@FindBy(id="Password")
	private WebElement pwdTextBox;
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	private WebElement loginBtn;
	@FindBy(xpath="//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]")
	private WebElement errMsg;
	
	
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
	
	
	public void setEmail(String emailId) {
		emailTextBox.clear();
		emailTextBox.sendKeys(emailId);
	}
    
	public void setPassword(String pwd) {
		pwdTextBox.clear();
		pwdTextBox.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	
	public boolean verifyingDashboardTitle() {
		boolean status = false;
		String title = driver.getTitle();
		if(title.equals("Dashboard / nopCommerce administration")){
			status = true;
		} 
		return status;
	}
	
	public boolean verifyingErrorMsg() {
		boolean status = false;
		String errorMsg = errMsg.getText();
		if(errorMsg.contains("Login was unsuccessful")) {
			status = true;
		}
		return status;
	}

}
