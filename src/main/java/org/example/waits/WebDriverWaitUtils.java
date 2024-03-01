package org.example.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
    public class WebDriverWaitUtils {
        private final WebDriver webDriver;
        private final WebDriverWait webDriverWait;

        public WebDriverWaitUtils(WebDriver webDriver) {
            this.webDriver = webDriver;
            this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        }

        public WebElement waitForVisibility(WebElement element) {
            return webDriverWait.until(ExpectedConditions.visibilityOf(element));
        }

        public WebElement waitForClickability(WebElement element) {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        }
        public WebElement waitForClickability(WebDriver driver, By locator) {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        }
    }
