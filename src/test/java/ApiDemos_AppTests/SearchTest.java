package ApiDemos_AppTests;

import ApiDemos_App.PagesLocators;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SearchTest extends TestBase
{
    PagesLocators pageLocators;

    String textToSearch = "Appium Framework";

    @Test
    public void searchAssert() throws MalformedURLException
    {
        Android_setUp();

        pageLocators = new PagesLocators(driver);

        pageLocators.clickViews();

        pageLocators.clickSearchBtn();
        pageLocators.clickActionBar();
        pageLocators.clickBarSearch();
        pageLocators.writeSearchTxt(textToSearch);

        // casting to Android driver which can press enter
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        System.out.println(pageLocators.getSearchResult());

        driver.navigate().back();
        driver.navigate().back();
        androidDriver.hideKeyboard();

        System.out.println(pageLocators.getSearchStatus());
        Assert.assertTrue(pageLocators.getSearchStatus().contains(textToSearch + " : submitted"));

        tearDown();
    }
}
