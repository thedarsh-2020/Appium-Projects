package ToDo_AppTests;

import ToDo_App.CreateTaskPage;
import ToDo_App.TasksListPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CreateTask extends TestBase
{
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Test
    public void test_add_task() throws MalformedURLException
    {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("Start PlayWrite Course");
        createTaskPage.enterTaskDesc("Starting PlayWrite course after finishing appium ASAP");
        driver.navigate().back();           // to hide the keyboard after finishing writing tasks
        createTaskPage.clickSaveBtn();
        tearDown();
    }
}
