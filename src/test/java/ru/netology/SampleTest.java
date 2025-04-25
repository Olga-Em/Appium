package ru.netology;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.Objects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

    private AndroidDriver driver;
    MobileObjects mobileObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:app", "A:\\Learn\\QA\\Mobile\\Auto\\2.2_UI_Automator\\app\\build\\intermediates\\apk\\debug\\app-debug.apk");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);

        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void sampleTest() {
        var textToSet = "123456";

        mobileObjects.input.isDisplayed();
        mobileObjects.input.click();
        mobileObjects.input.sendKeys(textToSet);

        mobileObjects.btnChange.isDisplayed();
        mobileObjects.btnChange.click();

        mobileObjects.txtChange.isDisplayed();
        mobileObjects.txtChange.click();

        mobileObjects.input.isDisplayed();
        mobileObjects.input.clear();
        mobileObjects.input.click();

        mobileObjects.btnChange.isDisplayed();
        mobileObjects.btnChange.click();

        mobileObjects.txtChange.isDisplayed();

        Assertions.assertEquals(textToSet, mobileObjects.txtChange.getText());
    }


    @Test
    public void sampleTest2() {
        var textToSet = "Hello";

        mobileObjects.input.isDisplayed();
        mobileObjects.input.click();
        mobileObjects.input.sendKeys(textToSet);

        mobileObjects.btnActivity.isDisplayed();
        mobileObjects.btnActivity.click();

        mobileObjects.txtActivity.isDisplayed();

        Assertions.assertEquals(textToSet, mobileObjects.txtActivity.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
