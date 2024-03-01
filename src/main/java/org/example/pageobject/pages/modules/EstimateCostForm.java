package org.example.pageobject.pages.modules;

import lombok.Getter;
import org.example.pageobject.BasePage;
import org.example.waits.WebDriverWaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter

public class EstimateCostForm extends BasePage {
    private final WebDriverWaitUtils waitUtils;
    public EstimateCostForm(WebDriver webDriver) {
        super(webDriver);
        this.waitUtils = new WebDriverWaitUtils(webDriver); // Initialize WebDriverWaitUtils
    }


    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailBtn;

    public void  inputEmail(String email){
        waitUtils.waitForVisibility(emailInput);
        emailInput.sendKeys(email);
    }

    public void clickSendEmailBtn(){
        sendEmailBtn.click();
    }
}