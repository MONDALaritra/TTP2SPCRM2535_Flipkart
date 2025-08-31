package base;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	protected static WebDriver driver;

    @BeforeSuite
    @Parameters("browser")
    public void setUp(String browser) throws FileNotFoundException, IOException {
    	if(browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    	}else if(browser.equalsIgnoreCase("edge")) {
    		WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
    	}
        driver.manage().window().maximize();
        ConfigLoader config = new ConfigLoader();
        String url = config.getProperty("baseUrl");
        driver.get(url);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
