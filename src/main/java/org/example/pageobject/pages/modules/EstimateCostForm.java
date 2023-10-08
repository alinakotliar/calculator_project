package org.example.pageobject.pages.modules;

import lombok.Getter;
import org.example.pageobject.BasePage;
import org.example.pageobject.pages.CalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter

public class EstimateCostForm extends BasePage {
    public EstimateCostForm(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailBtn;

    public void  inputEmail(String email){
        waitForVisibility(emailInput);
        emailInput.sendKeys(email);
    }

    public void clickSendEmailBtn(){
        sendEmailBtn.click();
    }
}