package stepsWithTable;

import ToDo_App.CreateTaskPage;
import ToDo_App.TasksListPage;
import ToDo_AppTests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class CreateNewTaskUsingStepDefinitionUsingTable extends TestBase
{
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Given("Click Add New Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @Given("Enter {string} and {string}")
    public void enterAnd(String taskName, String descName)
    {
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(descName);
        driver.navigate().back();           // to hide the keyboard after finishing writing tasks
    }

    @When("Click Save")
    public void clickSave()
    {
        createTaskPage.clickSaveBtn();
    }

    @Then("Task added Successfully")
    public void taskAddedSuccessfully()
    {
        tearDown();
    }
}
