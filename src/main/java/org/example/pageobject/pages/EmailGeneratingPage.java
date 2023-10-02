package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class EmailGeneratingPage extends BasePage {
    private String firstTab;

    public EmailGeneratingPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"listeliens\"]/a[1]/div[1]/i")
    private WebElement randomEmailGeneratorLink;

    @FindBy(id = "cprnd")
    private WebElement copyToClipboardButton;

    public void navigateToMailDrop() {
        // Откройте новую вкладку
        ((JavascriptExecutor) webDriver).executeScript("window.open('', '_blank');");

        // Получите список открытых вкладок
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());

        // Переключитесь на новую (вторую) вкладку
        webDriver.switchTo().window(tabs.get(1));

        // Перейдите на https://yopmail.com/
        webDriver.get("https://maildrop.cc/");
    }

    public void generateRandomEmail() {
        WebElement viewMailBoxButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div/div[3]/form/button")));
        viewMailBoxButton.click();
    }

    public void copyEmailToClipboard() {
                // Найдите поле ввода email и выполните копирование
                WebElement inputElement = webDriver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[3]/form/div/input"));
                String text = inputElement.getAttribute("value");
                String modifiedText = text + "@maildrop.cc";

                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection strSel = new StringSelection(modifiedText);
                clipboard.setContents(strSel, null);

        // Вернитесь на первую вкладку
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());

        // Переключитесь на новую (вторую) вкладку
        webDriver.switchTo().window(tabs.get(0));
    }
}
