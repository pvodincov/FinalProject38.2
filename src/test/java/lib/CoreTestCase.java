package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lib.ui.PlatformSelector;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase {

    protected AppiumDriver<WebElement> driver;
    private static final String APPIUM_URL = "http://0.0.0.0:4723/wd/hub";

    @Before
    public void setUp() throws Exception {
        URL URL = new URL(APPIUM_URL);

        if (PlatformSelector.PLATFORM == "ios") {
            this.driver = new IOSDriver<WebElement>(URL, this.getIOSDesiredCapabilities());
        } else if (PlatformSelector.PLATFORM == "android") {
            this.driver = new AndroidDriver<WebElement>(URL, this.getAndroidDesiredCapabilities());
        } else {
            throw new Exception("Cannot run Appium session with the platform equals " + PlatformSelector.PLATFORM);
        }
    }

    /*@After
    public void tearDown() {
        this.driver.quit();
    }*/

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("avd","Pixel4_API29");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\tester\\IdeaProjects\\QAJA_MOBILE\\apps\\org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 12 Pro");
        capabilities.setCapability("platformVersion", "14.2");
        capabilities.setCapability("app", "/Users/vitalijkotov/SFMobile/apps/Wikipedia.app");
        return capabilities;
    }

}
