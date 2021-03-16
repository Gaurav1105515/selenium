package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features="C:\\Users\\shahi\\git\\selenium\\RestAssured\\Feature\\Assignment8.feature",

plugin= {"pretty","testng:target/Reports/report.html"})
@RunWith(Cucumber.class)


public class runner8 {

}
