package org.example.pageobject.yopmail;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailGeneratorPage extends BasePage {
    @FindBy(id = "geny")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[@class='tooltip']/following-sibling::button")
    private WebElement checkEmailBtn;

    public EmailGeneratorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getEmailAddress() {
        waitForVisibility(emailAddress);
        return emailAddress.getText();
    }

    public EmailBoxPage clickCheckEmailBtn() {
        waitForVisibility(checkEmailBtn);
        checkEmailBtn.click();

        return new EmailBoxPage(webDriver);
    }
}
