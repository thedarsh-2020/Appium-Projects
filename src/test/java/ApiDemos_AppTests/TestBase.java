package ApiDemos_AppTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase
{
    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:deviceName", "R9DN100F1GJ");
        caps.setCapability("appium:automationName", "Uiautomator2");
        caps.setCapability("appium:appPackage", "io.appium.android.apis");
        caps.setCapability("appium:appActivity", "ApiDemos");

        // In case apk not installed in the device for 1st time
        //caps.setCapability("appium:app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
                System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
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
