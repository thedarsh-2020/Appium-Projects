package runner;

import ToDo_AppTests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/CreateTaskUsingTable.feature"
        ,glue = {"stepsWithTable"}
        ,plugin = {"pretty", "html:target/cucumber-html-report.html"})
public class CreateTaskRunnerUsingTable extends TestBase
{
}
