package org.example;

import org.example.pageobject.pages.CalculatorPage;
import org.example.pageobject.pages.GoogleCloudHomePage;
import org.example.pageobject.pages.SearchResultsPage;
import org.example.pageobject.pages.modules.IFrame;
import org.example.pageobject.yopmail.EmailBoxPage;
import org.example.pageobject.yopmail.EmailGeneratorPage;
import org.example.pageobject.yopmail.YopmailMainPage;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleCloudCalculatorTest extends BaseTest {
    private final GoogleCloudHomePage homePage = new GoogleCloudHomePage(webDriver);
    private final SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
    private final YopmailMainPage yopmailMainPage = new YopmailMainPage(webDriver);
    private final EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage(webDriver);
    private final EmailBoxPage emailBoxPage = new EmailBoxPage(webDriver);
    private final CalculatorPage calculatorPage = new CalculatorPage(webDriver);
    private final IFrame iframe = new IFrame(webDriver);


    @BeforeMethod
    public void setUp() {
        setUpWebDriver();
    }

    @Test
    public void testGoogleCloudPricingCalculator() {

        homePage.open();
        homePage.performSearch("Google Cloud Platform Pricing Calculator");
        searchResultsPage.clickCalculatorLink();
        calculatorPage.fillOutCalculatorForm();


        String calculatorPageWindow = webDriver.getWindowHandle();
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/");

        yopmailMainPage.clickCreateRandomEmailElement();
        webDriver.navigate().to("https://yopmail.com/ru/email-generator");

        String generatedEmail = emailGeneratorPage.getEmailAddress();
        String yopMailWindow = webDriver.getWindowHandle();


        webDriver.switchTo().window(calculatorPageWindow);
        calculatorPage.switchToFrame1();
        calculatorPage.switchToFrame2();
        calculatorPage.getIframe().clickEmailEstimateBtn();
        calculatorPage.getEstimateCostForm().inputEmail(generatedEmail);
        calculatorPage.getEstimateCostForm().clickSendEmailBtn();

        webDriver.switchTo().window(yopMailWindow);



        emailGeneratorPage.clickCheckEmailBtn();
        String estimatedMonthlyCostFromEmail = emailBoxPage
                .delayedClickRefreshBtn(20)
                .switchToIfMailFrame()
                .getEstimatedMonthlyCost();

        String estimatedMonthlyCostFromCalculator = calculatorPage.getIframe().getEstimatedMonthlyCost();
        Assert.assertEquals(estimatedMonthlyCostFromEmail, estimatedMonthlyCostFromCalculator);
    }


    @AfterMethod
    public void closeDriver() {
        quit();
    }
}