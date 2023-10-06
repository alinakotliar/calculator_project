package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.example.waits.ExplicitWait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailGeneratingPage extends BasePage {
    public EmailGeneratingPage(WebDriver webDriver) {
        super(webDriver);
    }
    private static final String URL = "https://yopmail.com/ru/email-generator";

    @FindBy(id = "refresh")
    private WebElement refreshBtn;

    @FindBy(id = "ifmail")
    private WebElement ifMailFrame;
    @FindBy(id = "geny")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[@class='tooltip']/following-sibling::button")
    private WebElement checkEmailBtn;

    public EmailGeneratingPage switchToIfMailFrame(){
        webDriver.switchTo().frame(ifMailFrame);
        return new EmailGeneratingPage(webDriver);
    }

    public EmailGeneratingPage delayedClickRefreshBtn(long seconds){
        Actions actions = new Actions(webDriver);
        actions.pause(Duration.ofSeconds(seconds));
        refreshBtn.click();

        return this;
    }
    public String getEmailAddress() {
        waitForVisibility(emailAddress);
        return emailAddress.getText();
    }

    public EmailGeneratingPage clickCheckEmailBtn() {
        waitForVisibility(checkEmailBtn);
        checkEmailBtn.click();

        return new EmailGeneratingPage(webDriver);
    }

}
