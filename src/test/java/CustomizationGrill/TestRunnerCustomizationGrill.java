package CustomizationGrill;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/CustomizationGrill",
        glue = {"CustomizationGrill"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)

public class TestRunnerCustomizationGrill {

	private TestNGCucumberRunner tcr;

    @BeforeClass(alwaysRun=true)
    public void beforeClass() throws Exception{
        tcr = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups="cucumber", description="Runs CucumberFeature", dataProvider="features")
    public void feature(CucumberFeatureWrapper cucumberFeature){
        tcr.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features(){
        return tcr.provideFeatures();
    }

    @AfterClass (alwaysRun=true)
    public void afterClass(){
        tcr.finish();
    }

	
}
