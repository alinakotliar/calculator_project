package org.example.pageobject.yopmail;

import org.example.pageobject.BasePage;
import org.example.pageobject.yopmail.iframes.IfMailFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class EmailBoxPage extends BasePage {
    public EmailBoxPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "refresh")
    private WebElement refreshBtn;

    @FindBy(id = "ifmail")
    private WebElement ifMailFrame;

    public IfMailFrame switchToIfMailFrame(){
        webDriver.switchTo().frame(ifMailFrame);
        return new IfMailFrame(webDriver);
    }

    public EmailBoxPage delayedClickRefreshBtn(long seconds){
        Actions actions = new Actions(webDriver);
        actions.pause(Duration.ofSeconds(seconds));
        refreshBtn.click();

        return this;
    }
}

