package Cart;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBeans.CartPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepDefCart {

	private WebDriver driver;
	CartPageFactory objcpg;
	
	String address = "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe";
	File src1 = new File("C:\\Users\\Dell\\git\\repository\\McDelivery\\PageFactory.xlsx");
	int actual = 0;
	int add = 0;
	int sub = 0;
	
	@Given("^User has added an item to the cart with quantity of (\\d+) and is on cart page$")
	public void user_has_added_an_item_to_the_cart_with_quantity_of_and_is_on_cart_page(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		actual = arg1;
		
		System.setProperty("webdriver.chrome.driver", address);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.mcdelivery.co.in/home/beverages");
	    driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		
		XSSFSheet sheet4 = wb1.getSheetAt(4);
		
		String item = sheet4.getRow(1).getCell(0).getStringCellValue();
		
		String path = "//div[contains(text(),'" + item + "')]/../../following-sibling::app-price-section/div[1]/div[1]";
		if(driver.findElement(By.xpath("//div[contains(text(),'" + item + "')]")).isDisplayed()) {
			Thread.sleep(5000);
			driver.findElement(By.xpath(path+"/button[1]")).click();
		}
		
		while(arg1>1) {
			driver.findElement(By.xpath(path+"/div[1]/button[2]")).click();
			arg1--;
			Thread.sleep(5000);
		}
		
		objcpg = new CartPageFactory(driver);
		objcpg.setPfViewCart();
	}

	@When("^user clicks on plus button (\\d+) number of times$")
	public void user_clicks_on_plus_button_number_of_times(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		add = arg1;
		Thread.sleep(5000);
		while(arg1>0) {
			objcpg.setPfAddQuantity();
	    	arg1--;
	    	Thread.sleep(5000);
	    }
	}

	@Then("^the quantity of the particular item in the cart becomes q plus n$")
	public void the_quantity_of_the_particular_item_in_the_cart_becomes_q_plus_n() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//objcpg.setPfItemQuantity();
		Thread.sleep(5000);
	    //int result = Integer.parseInt(objcpg.getPfItemQuantity());
	    
	    Assert.assertEquals(Integer.parseInt(objcpg.getPfItemQuantity()), (actual+add));
//	    if(result == (actual + add)) {
//	    	System.out.println("ADDITION MATCHED");
//	    }
	    Thread.sleep(5000);
	    driver.close();
	}

	@When("^user clicks on minus button (\\d+) number of times$")
	public void user_clicks_on_minus_button_number_of_times(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		sub = arg1;
		Thread.sleep(5000);
		while(arg1>0) {
			objcpg.setPfRemoveQuantity();
	    	arg1--;
	    	Thread.sleep(5000);
	    }
	}

	@Then("^the quantity of the particular item in the cart becomes q minus n$")
	public void the_quantity_of_the_particular_item_in_the_cart_becomes_q_minus_n() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//objcpg.setPfItemQuantity();
		Thread.sleep(5000);
		//int result = Integer.parseInt(objcpg.getPfItemQuantity());
	    
		Assert.assertEquals(Integer.parseInt(objcpg.getPfItemQuantity()), (actual-sub));
		
//	    if(result == (actual - sub)) {
//	    	System.out.println("REMOVAL MATCHED");
//	    }
		Thread.sleep(5000);
	    driver.close();
	}
	
}
