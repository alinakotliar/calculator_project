package org.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

    public class WindowSwitchUtils {

        public static String getNewWindowHandleAndSwitch(WebDriver driver) {
            driver.switchTo().newWindow(WindowType.TAB);
            return driver.getWindowHandle();
        }


    }
