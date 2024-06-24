package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ThreeDSPage {
    private WebDriver driver;
   

    
    private By submitButton = By.cssSelector("td:nth-child(1) > input");
    

    public ThreeDSPage(WebDriver driver) {
        this.driver = driver;
        
    }

    public void switchTo3dsFrame() throws InterruptedException {
    	Thread.sleep(15000);
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
    }

    public void clickSubmitButton() {
    	driver.findElement(submitButton).click();
    }
    
    

    public void getResponseData() throws InterruptedException {
        
    	Thread.sleep(5000);
        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
    }
}
