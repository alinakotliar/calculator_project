package org.example.factory;

import org.example.enumeration.SupportedBrowsers;
import org.example.properties.converters.SupportedBrowserConverter;
import org.example.properties.holder.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        String browserProperty = new PropertyHolder().readProperty("browser");
        SupportedBrowsers supportedBrowser = SupportedBrowserConverter.valueOfWebBrowser(browserProperty);
        return supportedBrowser.getWebDriver();
    }
}
