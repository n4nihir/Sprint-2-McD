package UserLocation;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBeans.UserLocationPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepDefUserLocation {

	private WebDriver driver;
	UserLocationPageFactory objulpg;
	String address = "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe";
	File src1 = new File("C:\\Users\\Dell\\git\\repository\\McDelivery\\PageFactory.xlsx");
	String location;
	String landmark;
	
	@Given("^User has opened the website$")
	public void user_has_opened_the_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", address);
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://www.mcdelivery.co.in");
	    driver.manage().window().maximize();
	}

	@When("^user searches for the location$")
	public void user_searches_for_the_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		
		XSSFSheet sheet4 = wb1.getSheetAt(0);
		
		location = sheet4.getRow(1).getCell(0).getStringCellValue();
		
		
		objulpg = new UserLocationPageFactory(driver);
	    objulpg.setPfNavbar();
		String option = driver.findElement(By.xpath("//app-nudge//button[1]")).getText();
		if(option.equals("Later")) {
			driver.findElement(By.xpath("//button[contains(text(), 'Select Now')]")).click();
		}
		if(option.equals("Change")){
			driver.findElement(By.xpath("//button[contains(text(), 'Change')]")).click();
		}
	    Thread.sleep(10000);
	    objulpg.setPflocationsearch(location);
	    Thread.sleep(5000);
	    objulpg.setPfselectedlocation();
	    Thread.sleep(5000);
	    
	}

	@When("^clicks done button$")
	public void clicks_done_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		objulpg.setPfdone();
		Thread.sleep(5000);
		
	    while(true) {
	    	String str = driver.findElement(By.xpath("//button[1]")).getText();
	    	if(str.equals("Continue")) {
		    	break;
		    }
		    objulpg.setPflocationsearch(location);
		    Thread.sleep(5000);
		    objulpg.setPfselectedlocation();
		    Thread.sleep(5000);
		    objulpg.setPfdone();
		    Thread.sleep(5000);
		    
	    }
	    landmark = objulpg.getLandmark();
	    Thread.sleep(5000);
	    objulpg.setPfcontinue();
	    Thread.sleep(5000);
	}

	@Then("^Selected location is displayed on the webpage$")
	public void selected_location_is_displayed_on_the_webpage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(objulpg.getPflocation(), landmark);
	    Thread.sleep(5000);
	    driver.close();
	}
	
	
}
