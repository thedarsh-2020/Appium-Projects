package ApiDemos_AppTests;

import ApiDemos_App.PagesLocators;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SendTxtWithAssertion extends TestBase
{
    PagesLocators pageLocators;

    String rightTxt     = "Hello from Right";
    String leftTxt      = "Hello from Left";

    @Test
    public void Send_Txt_Assertion() throws MalformedURLException
    {
        Android_setUp();
        pageLocators = new PagesLocators(driver);

        pageLocators.clickApp();
        pageLocators.clickActivity();
        pageLocators.clickCustomTitle();

        pageLocators.clearRightField();
        pageLocators.writeRightField(rightTxt);
        pageLocators.clickRightBtn();

        pageLocators.clearLeftField();
        pageLocators.writeLeftField(leftTxt);
        pageLocators.clickLeftBtn();

        Assert.assertEquals(pageLocators.getRightTxt(), rightTxt);
        Assert.assertEquals(pageLocators.getLeftTxt(), leftTxt);

        tearDown();
    }
}
