package org.example;


import org.example.pageobject.BasePage;
import org.example.pageobject.pages.CalculatorPage;
import org.example.pageobject.pages.EmailGeneratingPage;
import org.example.pageobject.pages.GoogleCloudHomePage;
import org.example.pageobject.pages.SearchResultsPage;
import org.example.pageobject.pages.modules.EstimateCostForm;
import org.example.pageobject.pages.modules.IFrame;
import org.example.pageobject.yopmail.EmailBoxPage;
import org.example.pageobject.yopmail.EmailGeneratorPage;
import org.example.pageobject.yopmail.YopmailMainPage;
import org.example.pageobject.yopmail.YopmailPrivacyWindow;
import org.example.util.WindowSwitchUtils;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleCloudCalculatorTest extends BaseTest{
    private final GoogleCloudHomePage homePage = new GoogleCloudHomePage(webDriver);
    private final SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
    private final YopmailPrivacyWindow yopmailPrivacyWindow = new YopmailPrivacyWindow(webDriver);
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

        // Шаг 11: Откройте новую вкладку и перейдите на https://yopmail.com/ или аналогичный сервис временных почтовых адресов
        String calculatorPageWindow = webDriver.getWindowHandle();
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/");

        yopmailMainPage.clickCreateRandomEmailElement();
        webDriver.navigate().to("https://yopmail.com/ru/email-generator");
// Шаг 12: Сгенерируйте случайный email
        String generatedEmail = emailGeneratorPage.getEmailAddress();

// Шаг 13: Вернитесь на страницу калькулятора и введите сгенерированный email в поле для email
        webDriver.switchTo().window(calculatorPageWindow);
        calculatorPage.getEstimateCostForm().inputEmail(generatedEmail);
        calculatorPage.getEstimateCostForm().clickSendEmailBtn();


// Шаг 14: Перейдите во вкладку с почтой
        webDriver.switchTo().window(calculatorPageWindow);
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/");

// Шаг 15: Дождитесь письма с оценкой стоимости и проверьте, что 'Total Estimated Monthly Cost' в письме совпадает с результатом в калькуляторе
        String estimatedMonthlyCostFromEmail = emailBoxPage
                .delayedClickRefreshBtn(10)
                .switchToIfMailFrame()
                .getEstimatedMonthlyCost();

        String estimatedMonthlyCostFromCalculator = calculatorPage.getIframe().getEstimatedMonthlyCost();
        Assert.assertEquals(estimatedMonthlyCostFromEmail, estimatedMonthlyCostFromCalculator);
    }


    }
/*
    @AfterMethod
    public void closeDriver() {
        quit();
*/

