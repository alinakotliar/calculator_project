package org.example.pageobject.yopmail;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailPrivacyWindow extends BasePage {
    public YopmailPrivacyWindow(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "accept")
    private WebElement acceptCookiesBtm;
    @FindBy(id = "dismiss-button")
    private WebElement closeAdd;


    public YopmailMainPage clickAcceptCookies(){
        waitForVisibility(acceptCookiesBtm);
        acceptCookiesBtm.click();

        return new YopmailMainPage(webDriver);
    }
public void clickCloseAdd(){
        closeAdd.click();
}

}
