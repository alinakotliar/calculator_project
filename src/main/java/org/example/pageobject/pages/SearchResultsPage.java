package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver webdriver) {
        super(webdriver);
    }
    @FindBy(xpath = "(//div[@class='fjX8Pb']//a[contains(text(), 'Google Cloud Pricing Calculator')])[1]")
    private WebElement calculatorLink;


    public void clickCalculatorLink() {
        waitForVisibility(calculatorLink);
         calculatorLink.click();
    }


}

