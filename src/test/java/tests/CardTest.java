package tests;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import pages.CardPage;
import pages.ThreeDSPage;

public class CardTest {
	public static WebDriver driver;
	public static CardPage cardPage;
	public static ThreeDSPage threeDSPage;
	public static Properties prop;

    @BeforeClass
    public void setUp() throws IOException {
        
    	prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\abadawy\\eclipse-workspace\\PayTabsAutomationTask\\src\\main\\java\\com\\tap\\config\\config.properties");
		prop.load(fis);
    	System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));

        cardPage = new CardPage(driver);
        threeDSPage = new ThreeDSPage(driver);
        
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
