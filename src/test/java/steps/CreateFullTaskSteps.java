package steps;

import ToDo_App.CreateTaskPage;
import ToDo_App.TasksListPage;
import ToDo_AppTests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class CreateFullTaskSteps extends TestBase
{
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Given("Environment SetUp")
    public void environmentSetUp() throws MalformedURLException
    {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
    }

    @Given("Open new task")
    public void openNewTask()
    {
        tasksListPage.clickAddTaskBtn();
    }

    @Given("Enter Task Details {string} and {string}")
    public void enterTaskDetailsAnd(String taskName, String taskDesc)
    {
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
    }

    @Given("Select Task Tags")
    public void selectTaskTags()
    {
        createTaskPage.clickTagBtn();
        createTaskPage.selectPersonalTag();
        createTaskPage.selectShoppingTag();
        createTaskPage.selectToReadTag();
        createTaskPage.selectWorkTag();
        createTaskPage.OkBtn();
    }

    @Given("Enter Start Date {string} and {string}")
    public void enterStartDateAnd(String startMonth, String startDay)
    {
        createTaskPage.clickStartDateBtn();
        createTaskPage.selectStartDate(startMonth, startDay);
        createTaskPage.OkBtn();
    }

    @Given("Enter End Date {string} and {string}")
    public void enterEndDateAnd(String endMonth, String endDay)
    {
        createTaskPage.clickEndDateBtn();
        createTaskPage.selectEndDate(endMonth, endDay);
        createTaskPage.OkBtn();
    }

    @Given("Select Task Priority")
    public void selectTaskPriority()
    {
        createTaskPage.clickPriorityBtn();
        createTaskPage.selectHighPriority();
        createTaskPage.OkBtn();
    }

    @When("Save Task")
    public void saveTask()
    {
        createTaskPage.clickSaveBtn();
    }

    @Then("Task added Successfully")
    public void taskAddedSuccessfully()
    {
        tearDown();
    }
}
