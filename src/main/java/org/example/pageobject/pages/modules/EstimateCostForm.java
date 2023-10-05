package org.example.pageobject.pages.modules;

import lombok.Getter;
import org.example.pageobject.pages.CalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter

public class EstimateCostForm extends CalculatorPage {
    public EstimateCostForm(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateButton;

    @FindBy(css = "[ng-model='emailQuote.user.email']")
    private WebElement emailInputElement;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailButton;

    public void selectEmailEstimate() {
        if (emailEstimateButton != null) {
            emailEstimateButton.click();
        }
    }

    public void pasteEmail() {
        if (emailInputElement != null) {
            emailInputElement.clear();
            emailInputElement.sendKeys(Keys.CONTROL + "v");
        }
    }

    public void pressSendMail() {
        if (sendEmailButton != null) {
            sendEmailButton.click();
        }
    }
}