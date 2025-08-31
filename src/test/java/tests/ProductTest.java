package tests;




import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import base.DriverSetup;
import pages.ProductPage;



public class ProductTest extends DriverSetup{
	ExtentReports extent;
    ExtentTest test;
    
    @BeforeTest
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }
	
	@DataProvider(name="itemToSearch")
	public Object[][] searchItem() {
		return new Object[][] {{" "},{"Mobile phone"}};
	}
	
	@DataProvider(name="filters")
	public Object[][] filterElement(){
		return new Object[][] {{"Realme",10000,20000,"6"}};
	}
	
	@DataProvider(name="sortingCondition")
	public Object[][] applySorting(){
		return new Object[][] {{"High to low"},{"Low to high"},{"popularity"}};
	}
	
	@Test(priority=2 , dataProvider = "itemToSearch")
    public void searchElectronicItem(String item) {
		test = extent.createTest("Automate test: Attempt search without keywords OR Search for an electronic item");
        ProductPage productPage = new ProductPage(driver);
        productPage.searchProduct(item);
       
    }

    @Test(priority=4, dataProvider="filters")
    public void applyFilters(String brand, int minPrice, int maxPrice, String RAM) throws InterruptedException {
    	test = extent.createTest("Apply filters: RAM size, brand, and price range");
        ProductPage productPage = new ProductPage(driver);
        productPage.applyBrandFilter(brand);
        Thread.sleep(3000);
        productPage.applyPriceFilter(minPrice, maxPrice);
        Thread.sleep(3000);
        productPage.applyRamFilter(RAM);
        
    }

    @Test(priority=3, dataProvider="sortingCondition")
    public void sortResults(String condition)  {
    	test = extent.createTest("Automate sorting: Results by popularity or price");
        ProductPage productPage = new ProductPage(driver);
        productPage.sortBy(condition);
    }

   
    @Test(priority=5)
    public void selectProduct() {
    	test = extent.createTest("Automate test: View product details and check specifications");
    	ProductPage productPage = new ProductPage(driver);
    	productPage.selectAnyProduct();
    	
    }
    
    @AfterTest
    public void tearDownReport() {
        extent.flush();
    }

}
