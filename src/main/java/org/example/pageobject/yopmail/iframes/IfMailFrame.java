package org.example.pageobject.yopmail.iframes;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IfMailFrame extends BasePage {
    public IfMailFrame(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost')]")
    private WebElement estimatedMonthlyCost;

    public String getEstimatedMonthlyCost(){
        waitForVisibility(estimatedMonthlyCost);
        return estimatedMonthlyCost.getText().replaceAll("\\D{2,}", "").strip();
    }
}
