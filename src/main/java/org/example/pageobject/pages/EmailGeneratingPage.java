package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailGeneratingPage extends BasePage {
    private String firstTab;

    public EmailGeneratingPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"listeliens\"]/a[1]/div[1]/i")
    private WebElement randomEmailGeneratorLink;

    @FindBy(id = "cprnd")
    private WebElement copyToClipboardButton;

    public void navigateToMailDrop() {
        // Откройте новую вкладку
        ((JavascriptExecutor) webDriver).executeScript("window.open('', '_blank');");

        // Получите список открытых вкладок
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());

        // Переключитесь на новую (вторую) вкладку
        webDriver.switchTo().window(tabs.get(1));

        // Перейдите на https://yopmail.com/
        webDriver.get("https://maildrop.cc/");
    }

    public void generateRandomEmail() {
        WebElement viewMailBoxButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div/div[3]/form/button")));
        viewMailBoxButton.click();
    }

    public void copyEmailToClipboard() {
                // Найдите поле ввода email и выполните копирование
                WebElement inputElement = webDriver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[3]/form/div/input"));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inputElement));

        String text = inputElement.getAttribute("value");
                String modifiedText = text + "@maildrop.cc";

                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection strSel = new StringSelection(modifiedText);
                clipboard.setContents(strSel, null);

        // Вернитесь на первую вкладку
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());

        // Переключитесь на новую (вторую) вкладку
        webDriver.switchTo().window(tabs.get(0));
    }

    public void refreshMailbox(){
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        Duration timeout = Duration.ofSeconds(10);

        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        By refreshButtonLocator = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/span[1]");

        WebElement refreshButton = wait.until(ExpectedConditions.visibilityOfElementLocated(refreshButtonLocator));

        refreshButton.click();
    }
    public String extractAndCompareCosts() {
        // Получите текст письма
        WebElement emailContentElement = webDriver.findElement(By.xpath("//div[contains(@class, 'email-content')]"));
        String emailContent = emailContentElement.getText();

        // Создайте регулярное выражение для поиска сумм в формате "USD 587.02"
        Pattern pattern = Pattern.compile("USD ([0-9,]+\\.[0-9]{2})");
        Matcher matcher = pattern.matcher(emailContent);

        double maxCost = 0.00;

        // Найдите и сравните суммы
        while (matcher.find()) {
            String costStr = matcher.group(1);
            double cost = Double.parseDouble(costStr.replace(",", ""));
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        // Теперь у вас есть максимальная стоимость из текста письма.
        // Вы можете сравнить ее с каким-либо значением или сохранить ее для дальнейшего использования.
        String maxCostFormatted = String.format("USD %.2f", maxCost);

        // Верните наибольшую стоимость в формате "USD 587.02"
        return maxCostFormatted;
    }
}
