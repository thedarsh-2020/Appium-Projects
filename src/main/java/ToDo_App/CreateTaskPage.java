package ToDo_App;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateTaskPage extends PageBase
{
    public CreateTaskPage(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "editTextTitre")
    WebElement taskNameTxt;

    @AndroidFindBy(id = "editTextNote")
    WebElement taskDescTxt;

    @AndroidFindBy(id = "action_save")
    WebElement saveBtn;

    @AndroidFindBy(id = "editTextTag")
    WebElement tagTxtBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Personnal\"]")
    WebElement personalTagCheckBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Shopping\"]")
    WebElement shoppingTagCheckBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"To read\"]")
    WebElement toReadTagCheckBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Work\"]")
    WebElement workTagCheckBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    WebElement okBtn;

    @AndroidFindBy(id = "editTextPriority")
    WebElement priorityBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"None\"]")
    WebElement nonePriRdoBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Low\"]")
    WebElement lowPriRdoBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Medium\"]")
    WebElement mediumPriRdoBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"High\"]")
    WebElement highPriRdoBtn;

    @AndroidFindBy(id = "buttonStartDate")
    WebElement startDateBtn;

    @AndroidFindBy(id = "buttonDeadline")
    WebElement endDateBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/date_picker_header_date\"]")
    WebElement dateHeader;

    @AndroidFindBy(accessibility = "Next month")
    WebElement nextMonthBtn;

    public void enterTaskName(String taskName)
    {
        clear(taskNameTxt);
        sendText(taskNameTxt, taskName);
    }

    public void enterTaskDesc(String descText)
    {
        clear(taskDescTxt);
        sendText(taskDescTxt, descText);
    }

    public void clickSaveBtn()
    {
        click(saveBtn);
    }

    public void clickTagBtn()
    {
        click(tagTxtBtn);
    }

    public void selectPersonalTag()
    {
        click(personalTagCheckBtn);
    }

    public void selectShoppingTag()
    {
        click(shoppingTagCheckBtn);
    }

    public void selectToReadTag()
    {
        click(toReadTagCheckBtn);
    }

    public void selectWorkTag()
    {
        click(workTagCheckBtn);
    }

    public void OkBtn()
    {
        click(okBtn);
    }

    public void clickPriorityBtn()
    {
        click(priorityBtn);
    }

    public void selectNonePriority()
    {
        click(nonePriRdoBtn);
    }

    public void selectLowPriority()
    {
        click(lowPriRdoBtn);
    }

    public void selectMediumPriority()
    {
        click(mediumPriRdoBtn);
    }

    public void selectHighPriority()
    {
        click(highPriRdoBtn);
    }

    public void clickStartDateBtn()
    {
        click(startDateBtn);
    }

    public void selectStartDate(String startMonth, String startDay)
    {
        while (!dateHeader.getText().contains(startMonth))
        {
            click(nextMonthBtn);

            WebElement selectedDay = driver.findElement(By.xpath(
                    "//android.view.View[@text = '" + startDay + "']"));
            click(selectedDay);
        }

        WebElement selectedDay = driver.findElement(By.xpath(
                "//android.view.View[@text = '" + startDay + "']"));
        click(selectedDay);
    }

    public void clickEndDateBtn()
    {
        click(endDateBtn);
    }

    public void selectEndDate(String endMonth, String endDay)
    {
        while (!dateHeader.getText().contains(endMonth))
        {
            click(nextMonthBtn);

            WebElement selectedDay = driver.findElement(By.xpath(
                    "//android.view.View[@text = '" + endDay + "']"));
            click(selectedDay);
        }

        WebElement selectedDay = driver.findElement(By.xpath(
                "//android.view.View[@text = '" + endDay + "']"));
        click(selectedDay);
    }
}
