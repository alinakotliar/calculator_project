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
import java.util.List;

@Getter
    public class IFrame extends CalculatorPage {


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

    @FindBy(xpath = "//md-select[@placeholder=\"Local SSD\"]")
    private WebElement LocalSsd;

    @FindBy(css = "md-option[ng-value='item.value'][value='2']")
    private WebElement standard;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Datacenter location']")
    private WebElement DatacenterLocation;

    @FindBy(xpath = "//div[contains(text(), 'Frankfurt (europe-west3)')]")
    private WebElement frankfurt;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']")
    private WebElement CommittedUsage;

    @FindBy(xpath = "//div[.='1 Year']")
    private WebElement year;

    @FindBy(xpath = "//button[contains(@class, 'md-raised') and contains(@class, 'md-primary') and contains(@class, 'cpc-button')]")
    private WebElement addToEstimatebutton;

    public IFrame(WebDriver webDriver) {
        super(webDriver);
    }

    public void setNumberOfInstances(String numOfInstances) {
        webDriverWait.until(ExpectedConditions.visibilityOf(numberOfInstancesInput));
        numberOfInstancesInput.sendKeys(numOfInstances);
    }

    public void setPurposeOfInstances(String purposeOfInstances) {

        getPurposeOfInstances().sendKeys(purposeOfInstances);
    }

    public void selectSeries() {
        instanceSeriesTypeDropDownMenu.click();
        String seriesLocator = "//md-option[@id='select_option_220']";
        waitForClickabilityOfElement(webDriver, seriesLocator).click();
    }

    public void selectMachineType() {
        MachineType.click();
        String machineTypeLocator = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']";
        waitForClickabilityOfElement(webDriver, machineTypeLocator).click();
    }

    public void selectAddGpus() {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectGpuType() {
        GpuType.click();
        String typeOfGPULocator = "//md-option/div[contains(text(), 'NVIDIA Tesla V100')]";
        waitForClickabilityOfElement(webDriver, typeOfGPULocator).click();
    }

    public void selectGpuNumber() {
        GpuNumber.click();
        String numberOfGPUsLocator = "//md-option[contains(@ng-repeat,'.computeServer.gpuType')][@value='1']";
        waitForClickabilityOfElement(webDriver, numberOfGPUsLocator).click();
    }

    public void selectLocalSsd() {
        LocalSsd.click();
        String LocalSSD = "//div[@class='md-text ng-binding' and contains(text(), '2x375 GB')]";
        waitForClickabilityOfElement(webDriver, LocalSSD).click();
    }

    public void selectDatacenterLocation() {
        DatacenterLocation.click();
        String datacenterLocator = "//div[contains(@class,'md-clickable')]//div[contains(text(), 'Frankfurt')]";
        waitForClickabilityOfElement(webDriver, datacenterLocator).click();
    }

    public void selectCommittedUsage() {
        CommittedUsage.click();
        String committedUsageLocator = "//div[contains(@class,'md-clickable')]//div[contains(text(), '1 Year')]";
        waitForClickabilityOfElement(webDriver, committedUsageLocator).click();
    }

    public void addToEstimate() {
        addToEstimatebutton.click();
    }

    public String extractCostFromElement(WebElement element) {
        return element.getText().trim(); // Получаем текст элемента и убираем лишние пробелы
    }
    public String getEstimatedCost() {
        WebElement costElement = webDriver.findElement(By.xpath("//*[@id=\"resultBlock\"]/md-card/md-toolbar/div"));
        return extractCostFromElement(costElement);
    }

    }

