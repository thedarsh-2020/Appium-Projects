package ToDo_AppTests;

import ToDo_App.CreateTaskPage;
import ToDo_App.TasksListPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CreateFullTask extends TestBase
{
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    String taskName = "Full Task";
    String taskDesc = "This is a full Task";
    String startMonth = "Nov";
    String startDay = "20";
    String endMonth = "Jan";
    String endDay = "1";

    @Test
    public void add_Full_Task() throws MalformedURLException
    {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        // open create task page
        tasksListPage.clickAddTaskBtn();

        // fill tasks fields
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);

        // check Tag buttons
        createTaskPage.clickTagBtn();
        createTaskPage.selectPersonalTag();
        createTaskPage.selectShoppingTag();
        createTaskPage.selectToReadTag();
        createTaskPage.selectWorkTag();
        createTaskPage.OkBtn();

        // set start date
        createTaskPage.clickStartDateBtn();
        createTaskPage.selectStartDate(startMonth, startDay);
        createTaskPage.OkBtn();

        // set end date
        createTaskPage.clickEndDateBtn();
        createTaskPage.selectEndDate(endMonth, endDay);
        createTaskPage.OkBtn();

        // check priority
        createTaskPage.clickPriorityBtn();
        createTaskPage.selectHighPriority();
        createTaskPage.OkBtn();

        // save the task
        createTaskPage.clickSaveBtn();

        // close the app
        tearDown();
    }
}
