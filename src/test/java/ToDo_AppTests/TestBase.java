package ToDo_AppTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests
{
    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:deviceName", "R9DN100F1GJ");
        caps.setCapability("appium:automationName", "Uiautomator2");
        caps.setCapability("appium:app",
                System.getProperty("user.dir") + "/apps/ToDo_1.24.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
    }

    // in case running parallel devices with different UDID (Unique Device Ident) and ports
    public static void Android_setUpParalleldevices(
            String port, String deviceName, String platformVersion,
            String udid, String wdaLocalPort) throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "Uiautomator2");
        caps.setCapability("appium:app",
                System.getProperty("user.dir") + "/apps/ToDo_1.24.apk");
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:wdaLocalPort", wdaLocalPort);
        caps.setCapability("appium:udid", udid);

        driver = new AndroidDriver(new URL("http://localhost:" + port), caps);
    }

    public static void tearDown()
    {
        if(null != driver)
        {
            driver.quit();
        }
    }
}
