package org.example.pageobject.pages;

import lombok.Getter;
import org.example.pageobject.BasePage;
import org.example.pageobject.pages.modules.EstimateCostForm;
import org.example.pageobject.pages.modules.IFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
@Getter
public class CalculatorPage extends BasePage {
    @FindBy(xpath = "(//iframe)[1]")
    private WebElement iframe1;
    @FindBy(xpath = "//iframe[@id ='myFrame']")
    private WebElement iframe2;


    public CalculatorPage(WebDriver webDriver) {
        super(webDriver);
        switchToFrame1();
        switchToFrame2();
    }

    public void switchToFrame1() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToFrame2() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IFrame getIframe() {
        return new IFrame(webDriver);
    }
    public EstimateCostForm getEstimateCostForm() {
        return new EstimateCostForm(webDriver);
    }
    public void fillOutCalculatorForm(){
        IFrame iframe = getIframe();
        iframe.setNumberOfInstances("4");
        iframe.setPurposeOfInstances("leave blank");
        /*
        iframe.selectSeries();
        iframe.selectMachineType();
        iframe.selectAddGpus();
        iframe.selectGpuType();
        iframe.selectGpuNumber();
        iframe.selectLocalSsd();
        iframe.selectDatacenterLocation();
        iframe.selectCommittedUsage();

         */
        iframe.addToEstimate();
    }

public void emailEstimation(){
        getEstimateCostForm().selectEmailEstimate();
        getEstimateCostForm().pasteEmail();
        getEstimateCostForm().pressSendMail();
}

}