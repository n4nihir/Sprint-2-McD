package PlaystoreIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBeans.PlaystoreIconPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepDefPlaystoreIcon {

	private WebDriver driver;
	PlaystoreIconPageFactory objpipg;
	String address = "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe";
	List<String> browserTabs = new ArrayList<String>();
	
	@Given("^User has opened the website$")
	public void user_has_opened_the_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", address);
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    objpipg = new PlaystoreIconPageFactory(driver);
	    driver.get("https://www.mcdelivery.co.in/home/trending");
	    driver.manage().window().maximize();
	}

	@When("^User clicks on the play store icon$")
	public void user_clicks_on_the_play_store_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objpipg.setPfplayStoreIcon();
	}

	@Then("^Navigate to Playstore page in a new tab$")
	public void navigate_to_Playstore_page_in_a_new_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//get window handlers as list
		browserTabs = new ArrayList<String> (driver.getWindowHandles());
		Assert.assertEquals(2, browserTabs.size());
		
		driver.switchTo().window(browserTabs.get(1));
		
		Assert.assertTrue(driver.getCurrentUrl().startsWith("https://play.google.com/"));
	}

	@Then("^McDelivery app download page is displayed$")
	public void mcdelivery_app_download_page_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(objpipg.getPfAppDescription(), "McDelivery- McDonald’s India: Food Delivery App");
	    Assert.assertEquals(objpipg.getPfAppDeveloper(), "McDonald's India – West & South");
	    
	    for(String tab : browserTabs) {
	    	Thread.sleep(5000);
	    	driver.switchTo().window(tab);
	    	driver.close();
	    }
	    
	}


	
}
