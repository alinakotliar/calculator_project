package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }
    public void waitForVisibility(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForClickabilityOfElement(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(element)));
    }
}
