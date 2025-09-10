package ToDo_App;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TasksListPage extends PageBase
{
    public TasksListPage(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "fab")
    WebElement addTaskBtn;

    public void clickAddTaskBtn()
    {
        click(addTaskBtn);
    }
}
