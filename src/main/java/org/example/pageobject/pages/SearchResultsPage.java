package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void clickCalculatorLink() {
        WebElement calculatorLink = webDriver.findElement(By.partialLinkText("Google Cloud Pricing Calculator"));
        calculatorLink.click();
    }


}

