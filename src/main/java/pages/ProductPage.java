package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	WebDriver driver;
	 public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	  }


    @FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input")
    WebElement searchBox;

    @FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/button")
    WebElement searchButton;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/div[2]/div[1]/div[1]/input")
    WebElement filterBrandBox;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/div[2]/div[1]/div[2]/div/label/div[1]")
    WebElement brandCheckBox;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[7]/div[2]/div/div")
    List<WebElement> ramOptions;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select")
    WebElement minPriceDropdown;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select")
    WebElement maxPriceDropdown;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div/div/div[2]/div[2]")
    WebElement popularityTab;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div/div/div[2]/div[3]")
    WebElement lowToHighTab;
    
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div/div/div[2]/div[4]")
    WebElement highToLowTab;

    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a")
    WebElement productLink;
    
   @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[7]/div[1]/div")
   WebElement RamSection;

   
    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void applyRamFilter(String ram) {
        
    	Actions act = new Actions(driver);
    	act.scrollToElement(RamSection).perform();
    	for(WebElement r : ramOptions) {
    		String RAM = r.getAttribute("title");
    		if(RAM.contains(ram)) {
    			r.click();
    			break;
    		}
    	}
    }

    public void applyBrandFilter(String brand) {
        
    	filterBrandBox.sendKeys(brand);
    	if(brandCheckBox.isDisplayed()) {
    		brandCheckBox.click();
    	}
    	
    }

    public void applyPriceFilter(int min, int max) throws InterruptedException {
     
        // logic to filter price range
    	if(min>=max) {
			return;
		}
    	Select select1 = new Select(minPriceDropdown);
    	Select select2 = new Select(maxPriceDropdown);
    	
    	if(min<10000) {
    		select1.selectByIndex(0);
    	}else if(min>=10000 && min<15000) {
    		select1.selectByIndex(1);
    	}else if(min>=15000 && min<20000) {
    		select1.selectByIndex(2);
    	}else if(min>=20000 && min<30000) {
    		select1.selectByIndex(3);
    	}else {
    		select1.selectByIndex(4);
    	}
    	
    	Thread.sleep(2000);
    	
    	if(max>=10000 && max<15000) {
    		select2.selectByContainsVisibleText("10000");
    	}else if(max>=15000 && max<20000) {
    		select2.selectByContainsVisibleText("15000");
    	}else if(max>=20000 && max<30000) {
    		select2.selectByContainsVisibleText("20000");
    	}else if(max==30000) {
    		select2.selectByContainsVisibleText("30000");
    	}else {
    		select2.selectByContainsVisibleText("30000+");
    	}
    }

    public void sortBy(String criteria) {
        
    	String crit = criteria.toLowerCase();
    	if(crit.equals("popularity")) {
    		popularityTab.click();
    	}else if(crit.equals("low to high")) {
    		lowToHighTab.click();
    	}else if(crit.equals("high to low")) {
    		highToLowTab.click();
    	}else {
    		return;
    	}
    }
    
    public void selectAnyProduct() {
    	String link = productLink.getAttribute("href");
    	driver.navigate().to(link);
    }
    
    

    
}
