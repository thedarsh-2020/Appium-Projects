package runner;

import ToDo_AppTests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/CreateTask.feature"
,glue = {"steps"}
,plugin = {"pretty", "html:target/cucumber-html-report.html"})
public class CreateTaskRunner extends TestBase
{
}
