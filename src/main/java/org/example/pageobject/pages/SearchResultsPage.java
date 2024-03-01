package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.example.waits.WebDriverWaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    private final WebDriverWaitUtils waitUtils;
    public SearchResultsPage(WebDriver webdriver) {
        super(webdriver);
        this.waitUtils = new WebDriverWaitUtils(webDriver); // Initialize WebDriverWaitUtils
    }
    @FindBy(xpath = "(//div[@class='fjX8Pb']//a[contains(text(), 'Google Cloud Pricing Calculator')])[1]")
    private WebElement calculatorLink;


    public void clickCalculatorLink() {
        waitUtils.waitForVisibility(calculatorLink);
         calculatorLink.click();
    }


}

