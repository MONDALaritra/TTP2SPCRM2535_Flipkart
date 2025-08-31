package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[2]/div[2]/div/div/div/div/a")
	WebElement loginBtn;
	
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")
	public
    WebElement phoneNumberInput;

  
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")
	public
    WebElement requestOTPBtn;

    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/span[3]/span")
    WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterPhoneNumber(String phone) throws InterruptedException {
    	driver.navigate().refresh();
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
        Thread.sleep(2000);
    }

    
    public void loginUiVerification() {
    	loginBtn.click();
    	Assert.assertTrue(phoneNumberInput.isDisplayed());
    	Assert.assertTrue(requestOTPBtn.isDisplayed());
    }

    public void clickLogin() {
    	requestOTPBtn.click();
    }

    public boolean isLoginErrorDisplayed() {
        try {
            return loginErrorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
