package ru.netology;

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

        driver = new AndroidDriver(Objects.requireNonNull(getUrl()), desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        WebElement el1 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el1.isDisplayed();
        el1.click();
        el1.sendKeys("123456");

        WebElement el2 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        el2.isDisplayed();
        el2.click();

        WebElement el3 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        el3.isDisplayed();
        el3.click();

        WebElement el4 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el4.isDisplayed();
        el4.clear();
        el4.click();

        WebElement el5 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        el5.isDisplayed();
        el5.click();

        WebElement el6 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        el6.isDisplayed();
        Assertions.assertEquals("123456", el6.getText());
    }


    @Test
    public void sampleTest2() {
        WebElement el7 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el7.isDisplayed();
        el7.click();
        el7.sendKeys("Hello");

        WebElement el8 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el8.isDisplayed();
        el8.click();

        WebElement el9 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ru.netology.testing.uiautomator:id/text\"]"));
        el9.isDisplayed();
        Assertions.assertEquals("Hello", el9.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
