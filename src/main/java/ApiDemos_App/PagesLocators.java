package ApiDemos_App;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PagesLocators extends PageBase
{
    public PagesLocators(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
    }

    @AndroidFindBy(accessibility = "Views")
    WebElement viewsBtn;

    @AndroidFindBy(accessibility = "App")
    WebElement appBtn;

    @AndroidFindBy(accessibility = "Activity")
    WebElement activityBtn;

    @AndroidFindBy(accessibility = "Custom Title")
    WebElement txtTitleBtn;

    @AndroidFindBy(uiAutomator =
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().description(\"WebView\"))")
    WebElement WebViewPageBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Views/WebView\"]")
    WebElement WebViewTxt;

    @AndroidFindBy(uiAutomator =
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().description(\"WebView2\"))")
    WebElement WebViewPage2Btn;

    @AndroidFindBy(className = "android.widget.TextView")
    WebElement WebView2Txt;

    @AndroidFindBy(uiAutomator =
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().description(\"WebView3\"))")
    WebElement WebViewPage3Btn;

    @AndroidFindBy(className = "android.widget.TextView")
    WebElement WebView3Txt;

    @AndroidFindBy(accessibility = "Drag and Drop")
    WebElement DragDropBtn;

    @AndroidFindBy(id = "drag_dot_1")
    public WebElement dragPosition;

    @AndroidFindBy(id = "drag_dot_2")
    public WebElement dropPosition;

    @AndroidFindBy(id = "drag_dot_hidden")
    public WebElement dropHiddenPosition;

    @AndroidFindBy(id = "drag_result_text")
    WebElement dragResult;

    @AndroidFindBy(id = "left_text_edit")
    WebElement leftField;

    @AndroidFindBy(id = "right_text_edit")
    WebElement rightField;

    @AndroidFindBy(id = "left_text_button")
    WebElement leftBtn;

    @AndroidFindBy(id = "right_text_button")
    WebElement rightBtn;

    @AndroidFindBy(id = "right_text")
    WebElement rightTxt;

    @AndroidFindBy(id = "left_text")
    WebElement leftTxt;

    @AndroidFindBy(uiAutomator =
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().description(\"Search View\"))")
    WebElement searchBtn;

    @AndroidFindBy(accessibility = "Action Bar")
    WebElement actionBar;

    @AndroidFindBy(accessibility = "Search")
    WebElement barSearchBtn;

    @AndroidFindBy(className = "android.widget.EditText")
    WebElement searchTxt;

    @AndroidFindBy(id = "txt_query")
    WebElement searchResult;

    @AndroidFindBy(id = "status_text")
    WebElement searchStatus;

    public String getSearchStatus()
    {
        return searchStatus.getText();
    }

    public String getSearchResult()
    {
        return searchResult.getText();
    }

    public void writeSearchTxt(String txt)
    {
        sendText(searchTxt, txt);
    }

    public void clickBarSearch()
    {
        click(barSearchBtn);
    }

    public void clickActionBar()
    {
        click(actionBar);
    }

    public void clickSearchBtn()
    {
        click(searchBtn);
    }

    public String getRightTxt()
    {
        return rightTxt.getText();
    }

    public String getLeftTxt()
    {
        return leftTxt.getText();
    }

    public void clickRightBtn()
    {
        click(rightBtn);
    }

    public void clickLeftBtn()
    {
        click(leftBtn);
    }

    public void clearRightField()
    {
        clear(rightField);
    }

    public void writeRightField(String txt)
    {
        sendText(rightField, txt);
    }

    public void clearLeftField()
    {
        clear(leftField);
    }

    public void writeLeftField(String txt)
    {
        sendText(leftField, txt);
    }

    public void clickCustomTitle()
    {
        click(txtTitleBtn);
    }

    public void clickActivity()
    {
        click(activityBtn);
    }

    public void clickApp()
    {
        click(appBtn);
    }

    public String getDragResult()
    {
        return dragResult.getText();
    }

    public void clickDragDrop()
    {
        click(DragDropBtn);
    }

    public void clickViews()
    {
        click(viewsBtn);
    }

    public void clickWebPage()
    {
        click(WebViewPageBtn);
    }

    public void clickWebPage2()
    {
        click(WebViewPage2Btn);
    }

    public void clickWebPage3()
    {
        click(WebViewPage3Btn);
    }

    public String getWebViewTxt()
    {
        return WebViewTxt.getText();
    }

    public String getWebView2Txt()
    {
        return WebView2Txt.getText();
    }

    public String getWebView3Txt()
    {
        return WebView3Txt.getText();
    }
}
