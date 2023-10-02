package org.example.pageobject.pages.modules;

import lombok.Getter;
import org.example.pageobject.pages.CalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
    public class IFrame extends CalculatorPage {


    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.quantity')]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.label')]")
    private WebElement purposeOfInstances;
    @FindBy(name = "series")
    private WebElement selectWithSeries;

    @FindBy(xpath = "//md-option[@ng-value='n1']")
    private WebElement optionWithSeries;

    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[7]/div[1]")
    private WebElement MachineType;

    @FindBy(css = "md-option[value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement standard8;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkbox;

    @FindBy(xpath = "//md-select[@aria-label='GPU type']")
    private WebElement GpuType;

    @FindBy(xpath = "//div[text()='NVIDIA Tesla V100']")
    private WebElement TeslaV100;

    @FindBy(id = "select_507")
    private WebElement GpuNumber;

    @FindBy(css = "md-option[ng-value='item.value'][value='1']")
    private WebElement OneGpu;

    @FindBy(xpath = "//label[.='Local SSD']/parent::md-input-container")
    private WebElement LocalSsd;

    @FindBy(css = "md-option[ng-value='item.value'][value='3']")
    private WebElement standard;

    @FindBy(xpath = "label[text()='Datacenter location']")
    private WebElement DatacenterLocation;

    @FindBy(xpath = "//div[contains(text(), 'Frankfurt (europe-west3)')]")
    private WebElement frankfurt;

    @FindBy(xpath = "//md-input-container//label[.='Committed usage']")
    private WebElement CommittedUsage;

    @FindBy(xpath = "//div[.='1 Year']")
    private WebElement year;

    @FindBy(xpath = "//button[contains(@class, 'md-raised') and contains(@class, 'md-primary') and contains(@class, 'cpc-button')]")
    private WebElement button;

    public IFrame(WebDriver webDriver) {
        super(webDriver);
    }

    public void setNumberOfInstances(String numberOfInstances) {
        getNumberOfInstances().sendKeys(numberOfInstances);
    }

    public void setPurposeOfInstances(String purposeOfInstances) {
        getPurposeOfInstances().sendKeys(purposeOfInstances);
    }

    public void selectSeries() {
        selectWithSeries.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(optionWithSeries).click().build().perform();
    }

    public void selectMachineType() {
        MachineType.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(standard8).click().build().perform();
    }

    public void selectAddGpus() {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectGpuType() {
        GpuType.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(TeslaV100).click().build().perform();
    }

    public void selectGpuNumber() {
        GpuNumber.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(OneGpu).click().build().perform();
    }

    public void selectLocalSsd() {
        LocalSsd.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(standard).click().build().perform();
    }

    public void selectDatacenterLocation() {
        DatacenterLocation.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(frankfurt).click().build().perform();
    }

    public void selectCommittedUsage() {
        CommittedUsage.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(year).click().build().perform();
    }

    public void addToEstimate() {
        button.click();
    }

    }

