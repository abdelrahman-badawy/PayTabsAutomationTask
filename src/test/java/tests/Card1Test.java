package tests;

import org.testng.annotations.Test;

public class Card1Test extends CardTest {
	
	@Test
    public void testCardOne() throws InterruptedException {
        cardPage.selectCurrencyBHD();
        cardPage.selectAuthenticatedToken();
        


        cardPage.enterCardDetails(prop.getProperty("CardNumber1"), prop.getProperty("date1"), prop.getProperty("cvv1"));
        cardPage.clickGenerateTokenButton();
        threeDSPage.switchTo3dsFrame();
        threeDSPage.clickSubmitButton();
        threeDSPage.getResponseData();
        cardPage.clickResponseButton();
        String responseData = cardPage.getResponseBody();
        System.out.println("Response Data for Card 1: ");
        System.out.println(responseData);
        
        
    }

}
