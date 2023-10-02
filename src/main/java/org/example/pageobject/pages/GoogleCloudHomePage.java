package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage extends BasePage {
    @FindBy(name = "q")
    private WebElement searchIcon;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver webdriver) {
        super(webdriver);
    }

    public void open() {
        webDriver.get("https://cloud.google.com/");
    }

    public void performSearch(String searchTerm) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement searchIconClickable = wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        WebElement searchIconVisible = wait.until(ExpectedConditions.visibilityOf(searchIcon));

        searchIconClickable.click(); // Click on the search icon
        searchIconVisible.sendKeys(searchTerm); // Enter the search term and submit
        searchIconVisible.submit();
    }

    // Add other methods specific to the home page if needed
}