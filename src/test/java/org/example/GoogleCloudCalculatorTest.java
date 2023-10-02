package org.example;


import org.example.pageobject.BasePage;
import org.example.pageobject.pages.CalculatorPage;
import org.example.pageobject.pages.EmailGeneratingPage;
import org.example.pageobject.pages.GoogleCloudHomePage;
import org.example.pageobject.pages.SearchResultsPage;
import org.example.pageobject.pages.modules.EstimateCostForm;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleCloudCalculatorTest extends BaseTest{

    @BeforeMethod
    public void setUp() {
        setUpWebDriver();
    }

    @Test
    public void testGoogleCloudPricingCalculator() {
        GoogleCloudHomePage homePage = new GoogleCloudHomePage(webDriver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
        CalculatorPage calculatorPage = new CalculatorPage(webDriver);
        EmailGeneratingPage emailPage = new EmailGeneratingPage(webDriver);
        EstimateCostForm estimateForm = new EstimateCostForm(webDriver);

        // Step 1: Open the Google Cloud home page
        homePage.open();
        // Step 2: Search for the calculator
        homePage.performSearch("Google Cloud Platform Pricing Calculator");

        // Step 3: Click on the calculator link in the search results
        searchResultsPage.clickCalculatorLink();

        // Step 4: Click "COMPUTE ENGINE" calculatorPage.clickComputeEngine();
      calculatorPage.fillOutCalculatorForm();


        emailPage.navigateToMailDrop();
        emailPage.generateRandomEmail();
        emailPage.copyEmailToClipboard();

        estimateForm.selectEmailEstimate();
        estimateForm.pasteEmail();
        estimateForm.pressSendMail();

    }
/*
    @AfterMethod
    public void closeDriver() {
        quit();

    }
    */
}
