package org.example.pageobject.yopmail;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailMainPage extends BasePage {
    public YopmailMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@id='listeliens']/a[@href='email-generator']")
    private WebElement createRandomEmailElement;

    public YopmailMainPage clickCreateRandomEmailElement(){
        waitForVisibility(createRandomEmailElement);
        createRandomEmailElement.click();

        return new YopmailMainPage(webDriver);
    }
}
