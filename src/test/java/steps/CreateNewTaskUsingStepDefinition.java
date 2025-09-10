package steps;

import ToDo_App.CreateTaskPage;
import ToDo_App.TasksListPage;
import ToDo_AppTests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class CreateNewTaskUsingStepDefinition extends TestBase
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

    @Given("Enter TaskName")
    public void enterTaskName()
    {
        createTaskPage.enterTaskName("Task 1");
    }

    @Given("Enter TaskDesc")
    public void enterTaskDesc()
    {
        createTaskPage.enterTaskDesc("Desc 1");
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
