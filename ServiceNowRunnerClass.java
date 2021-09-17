package runner;

import io.cucumber.testng.CucumberOptions;
import serviceNow.ServiceNowBaseClass;


@CucumberOptions(features="src/test/java/serviceNowFeature",
				glue="serviceNow", monochrome=true, publish=true,
				dryRun=false, tags="@functionality")
				

public class ServiceNowRunnerClass extends ServiceNowBaseClass{

}
