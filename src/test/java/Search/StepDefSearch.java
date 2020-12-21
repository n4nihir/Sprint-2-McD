package Search;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBeans.SearchPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class StepDefSearch {

	private WebDriver driver;
	SearchPageFactory obj;
	String address = "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	@Given("^User has opened the website$")
	public void user_has_opened_the_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", address);
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    obj = new SearchPageFactory(driver);
	    driver.get("https://www.mcdelivery.co.in/home/trending");
	    driver.manage().window().maximize();
	}
	
	@When("^User clicks on the search box$")
	public void user_clicks_on_the_search_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		obj.setPflocation();
	}


	@When("^Enters the name of the item$")
	public void enters_the_name_of_the_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		File src1 = new File("C:\\Users\\Dell\\git\\repository\\McDelivery\\PageFactory.xlsx");
		FileInputStream fis = new FileInputStream(src1);	
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb1.getSheetAt(1);
		String item = sheet1.getRow(1).getCell(0).getStringCellValue();
		//String item = "burger";
		obj.setPfitemSearch(item);
	}
	
	@Then("^Drop down list appears$")
	public void drop_down_list_appears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	    
	    List<String> searchlist = obj.getPfsearchlist();
	    Assert.assertNotNull(searchlist);
	}
	
	@Then("^List of the relevant items appears$")
	public void list_of_the_relevant_items_appears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		File src1 = new File("C:\\Users\\Dell\\git\\repository\\McDelivery\\PageFactory.xlsx");
		FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb1.getSheetAt(1);
		String item = sheet1.getRow(1).getCell(0).getStringCellValue();
		
	    List<String> searchlist = obj.getPfsearchlist();
	    
	    for(int i=0; i<searchlist.size(); i++) {
	    	Assert.assertTrue(searchlist.get(i).contains(item));
	    }
	    
	    driver.close();
	    
	}
	
}
