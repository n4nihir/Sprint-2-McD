package Cart;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Cart",
        glue = {"Cart"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)

public class TestRunnerCart {

	 private TestNGCucumberRunner tcr;
	 private String featureName;

	    @BeforeClass(alwaysRun = true)
	    public void beforeClass() throws Exception {
	        tcr = new TestNGCucumberRunner(this.getClass());
	    }

	    @BeforeMethod
	    public void beforeMethod(Object[] params) {
	        CucumberFeatureWrapper cucumberFeature = (CucumberFeatureWrapper) params[0];
	        featureName = cucumberFeature.getCucumberFeature().getGherkinFeature().getName();
	    }

	    @Test(groups = "cucumber", description = "Runs CucumberFeature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        tcr.runCucumber(cucumberFeature.getCucumberFeature());
	    }

	    public String getTestName() {
	        return featureName;
	    }

	    @DataProvider
	    public Object[][] features() {
	        return tcr.provideFeatures();
	    }

	    @AfterClass(alwaysRun = true)
	    public void afterClass() {
	        tcr.finish();
	    }
	
	
}
