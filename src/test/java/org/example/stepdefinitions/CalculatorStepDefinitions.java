package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.CalculatorPage;
import org.example.pageobject.pages.GoogleCloudHomePage;
import org.example.pageobject.pages.SearchResultsPage;
import org.example.pageobject.yopmail.EmailBoxPage;
import org.example.pageobject.yopmail.EmailGeneratorPage;
import org.example.pageobject.yopmail.YopmailMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import static org.example.stepdefinitions.BaseSteps.webDriver;

public class CalculatorStepDefinitions {

    private final GoogleCloudHomePage homePage;
    private final SearchResultsPage searchResultsPage;
    private final CalculatorPage calculatorPage;
    private final YopmailMainPage yopmailMainPage;
    private final EmailGeneratorPage emailGeneratorPage;
    private final EmailBoxPage emailBoxPage;
    private String generatedEmail;
    private String calculatorPageWindow;
    private String yopMailWindow;
    public CalculatorStepDefinitions() {
        homePage = new GoogleCloudHomePage(webDriver);
        searchResultsPage = new SearchResultsPage(webDriver);
        calculatorPage = new CalculatorPage(webDriver);
        yopmailMainPage = new YopmailMainPage(webDriver);
        emailGeneratorPage = new EmailGeneratorPage(webDriver);
        emailBoxPage = new EmailBoxPage(webDriver);
    }
    @Given("I am on {string}")
    public void openWebPage(String url) {
        homePage.open();
    }

    @When("I search for {string}")
    public void searchFor(String searchTerm) {
        homePage.performSearch(searchTerm);
    }

    @And("I select {string} from the search results")
    public void selectSearchResult(String searchResult) {
        searchResultsPage.clickCalculatorLink();
    }

    @And("I fill out the form with specific data")
    public void fillOutForm() {
        calculatorPage.fillOutCalculatorForm();
        calculatorPageWindow = webDriver.getWindowHandle();

    }

    @And("I generate a random email")
    public void generateCopyEnterRandomEmail() {
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/");
        yopmailMainPage.clickCreateRandomEmailElement();
        webDriver.navigate().to("https://yopmail.com/ru/email-generator");
        generatedEmail = emailGeneratorPage.getEmailAddress();
        yopMailWindow = webDriver.getWindowHandle();
        webDriver.switchTo().window(calculatorPageWindow);

    }

    @Then("I send email with estimate cost")
    public void sendEmailAndWait() {
        calculatorPage.switchToFrame1();
        calculatorPage.switchToFrame2();
        calculatorPage.getIframe().clickEmailEstimateBtn();
        calculatorPage.getEstimateCostForm().inputEmail(generatedEmail);
        calculatorPage.getEstimateCostForm().clickSendEmailBtn();
        webDriver.switchTo().window(yopMailWindow);
        emailGeneratorPage.clickCheckEmailBtn();
        emailBoxPage.delayedClickRefreshBtn(20);
    }

    @And("I verify that the emailed 'Total Estimated Monthly Cost' matches the result in the calculator")
    public void verifyEmailMatchesCalculator() {
        String estimatedMonthlyCostFromEmail = emailBoxPage.switchToIfMailFrame().getEstimatedMonthlyCost();
        String estimatedMonthlyCostFromCalculator = calculatorPage.getIframe().getEstimatedMonthlyCost();
        Assert.assertEquals(estimatedMonthlyCostFromEmail, estimatedMonthlyCostFromCalculator);
    }

    @After
    public void closeDriver() {
        webDriver.quit();
    }

}
