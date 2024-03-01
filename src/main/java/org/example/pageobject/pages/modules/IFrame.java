package org.example.pageobject.pages.modules;

import lombok.Getter;
import org.example.pageobject.BasePage;
import org.example.pageobject.pages.CalculatorPage;
import org.example.waits.WebDriverWaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
    public class IFrame extends BasePage {

    private final WebDriverWaitUtils waitUtils;
    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.quantity')]")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.label')]")
    private WebElement purposeOfInstances;

    @FindBy(xpath = "//md-select[@name='series']")
    private WebElement instanceSeriesTypeDropDownMenu;

    @FindBy(xpath = "//div[@id='select_container_116']//md-option")
    private List<WebElement> instanceSeries;

    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[7]/div[1]")
    private WebElement MachineType;


    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkbox;

    @FindBy(xpath = "//md-select[@aria-label='GPU type']")
    private WebElement GpuType;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement GpuNumber;


    @FindBy(xpath = "//md-select[@placeholder=\"Local SSD\"]")
    private WebElement LocalSsd;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Datacenter location']")
    private WebElement DatacenterLocation;


    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']")
    private WebElement CommittedUsage;

    @FindBy(xpath = "//div[@id='mail']//h2[contains(text(), 'Estimated Monthly Cost')]")
    private WebElement getMonthlyEstimatedCost;


    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateBtn;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(), 'Add to Estimate')]")
    private WebElement addToEstimateBtn;

    public IFrame(WebDriver webDriver) {
        super(webDriver);
        this.waitUtils = new WebDriverWaitUtils(webDriver);
    }


    public void setNumberOfInstances(String numOfInstances) {
        waitUtils.waitForVisibility(numberOfInstancesInput).sendKeys(numOfInstances);
    }

    public void setPurposeOfInstances(String purposeOfInstances) {

        getPurposeOfInstances().sendKeys(purposeOfInstances);
    }

    public void selectSeries() {
        instanceSeriesTypeDropDownMenu.click();
        By seriesLocator = By.xpath("//md-option[@value='n1']");
        waitUtils.waitForClickability(webDriver, seriesLocator).click();
    }

    public void selectMachineType() {
        MachineType.click();
        By machineTypeLocator = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
        waitUtils.waitForClickability(webDriver, machineTypeLocator).click();
    }

    public void selectAddGpus() {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectGpuType() {
        GpuType.click();
        By typeOfGPULocator = By.xpath("//md-option/div[contains(text(), 'NVIDIA Tesla V100')]");
        waitUtils.waitForClickability(webDriver, typeOfGPULocator).click();
    }

    public void selectGpuNumber() {
        GpuNumber.click();
        By numberOfGPUsLocator = By.xpath("//md-option[contains(@ng-repeat,'.computeServer.gpuType')][@value='1']");
        waitUtils.waitForClickability(webDriver, numberOfGPUsLocator).click();
    }

    public void selectLocalSsd() {
        LocalSsd.click();
        By localSSD = By.xpath("//div[@class='md-text ng-binding' and contains(text(), '2x375 GB')]");
        waitUtils.waitForClickability(webDriver, localSSD).click();
    }

    public void selectDatacenterLocation() {
        DatacenterLocation.click();
        By datacenterLocator = By.xpath("//div[contains(@class,'md-clickable')]//div[contains(text(), 'Frankfurt')]");
        waitUtils.waitForClickability(webDriver, datacenterLocator).click();
    }

    public void selectCommittedUsage() {
        CommittedUsage.click();
        By committedUsageLocator = By.xpath("//div[contains(@class,'md-clickable')]//div[contains(text(), '1 Year')]");
        waitUtils.waitForClickability(webDriver, committedUsageLocator).click();
    }
    public void clickAddToEstimateBtn(){
        addToEstimateBtn.click();
    }
    public String getEstimatedMonthlyCost(){
        Pattern p = Pattern.compile("(\\d{1,3},)?\\d{3}\\.\\d{2}");
        Matcher m = p.matcher(getMonthlyEstimatedCost.getText());
        m.find();
        return m.group();
    }

    public EstimateCostForm clickEmailEstimateBtn(){
        waitUtils.waitForVisibility(emailEstimateBtn);
        emailEstimateBtn.click();

        return new EstimateCostForm(webDriver);
    }
    }

