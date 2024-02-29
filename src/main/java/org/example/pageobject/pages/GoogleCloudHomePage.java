package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage extends BasePage {
    public String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//div[@class='ND91id LLv0lb' and @jsname='MVsrn']")
    private WebElement searchIcon;
    @FindBy(xpath = "//label[contains(@class, 'qdOxv-fmcmS-yrriRe') and contains(@class, 'VfPpkd-ksKsZd-mWPk3d') and contains(@class, 'qdOxv-fmcmS-yrriRe-OWXEXe-INsAgc')]//input[@id='i5']")
    private WebElement searshField;
    @FindBy(xpath = "//i[@role='button' and @data-icon-position='UbuQg']")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver webdriver) {
        super(webdriver);
    }

    public void open() {
        webDriver.get(GOOGLE_CLOUD_URL);
    }

    public void performSearch(String searchTerm) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement searchIconClickable = wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        WebElement searchIconVisible = wait.until(ExpectedConditions.visibilityOf(searchIcon));

        searchIconClickable.click(); // Click on the search icon
        searshField.sendKeys(searchTerm); // Enter the search term and submit
        searshField.submit();
    }

}