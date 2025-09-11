package ApiDemos_AppTests;

import ApiDemos_App.PagesLocators;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollTest extends TestBase
{
    PagesLocators pageLocators;

    @Test
    public void Scroll_Test() throws MalformedURLException
    {
        Android_setUp();
        pageLocators = new PagesLocators(driver);

        pageLocators.clickViews();

        pageLocators.clickWebPage();
        System.out.println(pageLocators.getWebViewTxt());
        Assert.assertTrue(pageLocators.getWebViewTxt().contains("WebView"));

        driver.navigate().back();

        pageLocators.clickWebPage2();
        System.out.println(pageLocators.getWebView2Txt());
        Assert.assertTrue(pageLocators.getWebView2Txt().contains("WebView2"));

        driver.navigate().back();

        pageLocators.clickWebPage3();
        System.out.println(pageLocators.getWebView3Txt());
        Assert.assertTrue(pageLocators.getWebView3Txt().contains("WebView3"));

        driver.navigate().back();
        driver.navigate().back();

        tearDown();

    }
}
