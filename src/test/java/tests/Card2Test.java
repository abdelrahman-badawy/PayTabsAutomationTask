package tests;

import org.testng.annotations.Test;

public class Card2Test extends CardTest {
	
	@Test
    public void testCardTwo() throws InterruptedException {
        cardPage.selectCurrencyBHD();
        cardPage.selectAuthenticatedToken();
        cardPage.enterCardDetails(prop.getProperty("CardNumber2"), prop.getProperty("date2"), prop.getProperty("cvv2"));
        cardPage.clickGenerateTokenButton();
        threeDSPage.switchTo3dsFrame();
        threeDSPage.clickSubmitButton();
        threeDSPage.getResponseData();
        cardPage.clickResponseButton();
        String responseData = cardPage.getResponseBody();
        System.out.println("Response Data for Card 2: ");
        System.out.println(responseData);
    }

}
