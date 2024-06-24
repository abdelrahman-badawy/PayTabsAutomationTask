package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;


public class CardPage {
    private WebDriver driver;
    private Actions builder;

    private By currencyDropdown = By.id("currency"); 
    private By currencyBHD = By.xpath("//option[@value='BHD']");
    private By scopeDropdown = By.id("scope"); 
    private By authenticatedToken = By.xpath("//option[@value='AuthenticatedToken']");
    private By cardInfo = By.id("card_input_mini");
    private By cardInput = By.id("card_input");
    private By cardNumberField = By.id("card_input"); 
    private By expiryDateField = By.id("date_input"); 
    private By cvvField = By.id("cvv_input"); 
    private By generateTokenButton = By.xpath("//*[@class='button token_button']"); // Change ID accordingly
    private By responseButton = By.id("Response ✅");
    private By responseBody = By.className("language-json");

    public CardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCurrencyBHD() {
        driver.findElement(currencyDropdown).click();
        driver.findElement(currencyBHD).click();
    }

    public void selectAuthenticatedToken() {
        driver.findElement(scopeDropdown).click();
        driver.findElement(authenticatedToken).click();
    }

    public void enterCardDetails(String cardNumber, String expiryDate, String cvv) throws InterruptedException {
    	Thread.sleep(5000);
    	driver.switchTo().frame(0);
    	builder = new Actions(driver);
    	builder.moveToElement(driver.findElement(cardInfo)).clickAndHold().perform();
    	builder.moveToElement(driver.findElement(cardInput)).release().perform();
    	driver.findElement(cardNumberField).clear();
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(expiryDateField).clear();
        driver.findElement(expiryDateField).sendKeys(expiryDate);
        driver.findElement(cvvField).clear();
        driver.findElement(cvvField).sendKeys(cvv);
        driver.switchTo().defaultContent();
    }
    
    

    public void clickGenerateTokenButton() {
        driver.findElement(generateTokenButton).click();
    }
    
    public void clickResponseButton() {
        driver.findElement(responseButton).click();
    }
    
    public String getResponseBody() {
        return driver.findElement(responseBody).getText();
    }
}
