package CustomizationGrill;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBeans.CustomizationGrillPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepDefCustomizationGrill {

	private WebDriver driver;
	CustomizationGrillPageFactory objcgpg;
	String address = "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe";
	File src1 = new File("C:\\Users\\Dell\\git\\repository\\McDelivery\\PageFactory.xlsx");
	
	@Given("^User is on items page and adds a customizable item$")
	public void user_is_on_items_page_and_adds_a_customizable_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", address);
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://www.mcdelivery.co.in/home/trending");
	    driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		
		XSSFSheet sheet3 = wb1.getSheetAt(3);
		
		
		String item = sheet3.getRow(1).getCell(0).getStringCellValue();
		if(driver.findElement(By.xpath("//div[contains(text(),'" + item + "')]")).isDisplayed()) {
			String path = "//div[contains(text(),'" + item + "')]/../../following-sibling::app-price-section/div[1]/div[1]/button[1]";
			driver.findElement(By.xpath(path)).click();
		}
	    
	}

	@When("^user chooses available customizations$")
	public void user_chooses_available_customizations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet sheet3 = wb1.getSheetAt(3);
		
		String cust1 = sheet3.getRow(1).getCell(1).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust1 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust1 + "')]/following-sibling::div/p[2]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust2 = sheet3.getRow(1).getCell(2).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust2 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust2 + "')]/following-sibling::div/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust3 = sheet3.getRow(1).getCell(3).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust3 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust3 + "')]/following-sibling::div/p[2]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust4 = sheet3.getRow(1).getCell(4).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust4 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust4 + "')]/following-sibling::div/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust5 = sheet3.getRow(1).getCell(5).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust5 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust5 + "')]/following-sibling::div/label/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust6 = sheet3.getRow(1).getCell(6).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust6 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust6 + "')]/following-sibling::div/label/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust7 = sheet3.getRow(1).getCell(7).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust7 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust7 + "')]/following-sibling::div/label/p[1]";
			driver.findElement(By.xpath(path)).click();
		}

		objcgpg = new CustomizationGrillPageFactory(driver);
	}

	@When("^clicks the Add to Cart button$")
	public void clicks_the_Add_to_Cart_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objcgpg.setPfAddToCart();
	}

	@Then("^item is added to cart with the customizations$")
	public void item_is_added_to_cart_with_the_customizations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    objcgpg.setPfViewCart();
	    FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet sheet3 = wb1.getSheetAt(3);
//		if(objcgpg.getPfCartItemDivHead().getText().equals(sheet3.getRow(1).getCell(0).getStringCellValue())) {
//			System.out.println("ITEM MATCHED");
//		}
		
		Assert.assertEquals(objcgpg.getPfCartItemDivHead().getText(), sheet3.getRow(1).getCell(0).getStringCellValue());
		
		String cust_string = objcgpg.getPfCartItemDivCustomizations().getText();
		for(int i=1; i<=7; i++) {
			int state = 0;
			if(cust_string.contains(sheet3.getRow(1).getCell(i).getStringCellValue())) {
				state = 1;
				Thread.sleep(5000);
			}
			Assert.assertEquals(1, state);
		}
		driver.close();
	}
	
	

	@Given("^User is on carts page and has added a customizable item with the customizations$")
	public void user_is_on_carts_page_and_has_added_a_customizable_item_with_the_customizations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", address);
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://www.mcdelivery.co.in/home/trending");
	    driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		
		XSSFSheet sheet3 = wb1.getSheetAt(3);
		
		
		String item = sheet3.getRow(1).getCell(0).getStringCellValue();
		if(driver.findElement(By.xpath("//div[contains(text(),'" + item + "')]")).isDisplayed()) {
			String path = "//div[contains(text(),'" + item + "')]/../../following-sibling::app-price-section/div[1]/div[1]/button[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust1 = sheet3.getRow(1).getCell(1).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust1 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust1 + "')]/following-sibling::div/p[2]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust2 = sheet3.getRow(1).getCell(2).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust2 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust2 + "')]/following-sibling::div/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust3 = sheet3.getRow(1).getCell(3).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust3 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust3 + "')]/following-sibling::div/p[2]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust4 = sheet3.getRow(1).getCell(4).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust4 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust4 + "')]/following-sibling::div/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust5 = sheet3.getRow(1).getCell(5).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust5 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust5 + "')]/following-sibling::div/label/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust6 = sheet3.getRow(1).getCell(6).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust6 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust6 + "')]/following-sibling::div/label/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		
		String cust7 = sheet3.getRow(1).getCell(7).getStringCellValue();
		if(driver.findElement(By.xpath("//p[contains(text(),'" + cust7 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + cust7 + "')]/following-sibling::div/label/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
		objcgpg = new CustomizationGrillPageFactory(driver);
		objcgpg.setPfAddToCart();
		objcgpg.setPfViewCart();
		
	}

	@When("^user clicks on Customize button and removes some customizations$")
	public void user_clicks_on_Customize_button_and_removes_some_customizations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    objcgpg.setPfCustomize();
	    
	    Thread.sleep(5000);
	    
	    FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		
		XSSFSheet sheet3 = wb1.getSheetAt(3);
		
	    String remove_cust1 = sheet3.getRow(2).getCell(1).getStringCellValue();
	    if(driver.findElement(By.xpath("//p[contains(text(),'" + remove_cust1 + "')]")).isDisplayed()) {
			String path = "//p[contains(text(),'" + remove_cust1 + "')]/following-sibling::div/p[2]";
			driver.findElement(By.xpath(path)).click();
		}
	    String remove_cust2 = sheet3.getRow(2).getCell(2).getStringCellValue();
	    if(driver.findElement(By.xpath("//h4[contains(text(),'" + remove_cust2 + "')]")).isDisplayed()) {
			String path = "//h4[contains(text(),'" + 
	    remove_cust2 + "')]/following-sibling::div/p[1]";
			driver.findElement(By.xpath(path)).click();
		}
	    Thread.sleep(5000);
	}

	@When("^clicks Add to Cart$")
	public void clicks_Add_to_Cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //driver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[3]/button[2]")).click();
		objcgpg.setPfAddToCart();
	}

	@Then("^item is added to cart with the valid customizations$")
	public void item_is_added_to_cart_with_the_valid_customizations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    FileInputStream fis = new FileInputStream(src1);
		@SuppressWarnings("resource")
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet sheet3 = wb1.getSheetAt(3);
//		if(objcgpg.getPfCartItemDivHead().getText().equals(sheet3.getRow(1).getCell(0).getStringCellValue())) {
//			System.out.println("ITEM MATCHED");
//		}
		Assert.assertEquals(objcgpg.getPfCartItemDivHead().getText(), sheet3.getRow(1).getCell(0).getStringCellValue());

		Thread.sleep(5000);
		
		String cust_string = objcgpg.getPfCartItemDivCustomizations().getText();
		for(int i=1; i<=2; i++) {
			int state = 0;
			if(!cust_string.contains(sheet3.getRow(2).getCell(i).getStringCellValue())) {
				state = 1;
				Thread.sleep(5000);
			}
			Assert.assertEquals(1, state);
		}
		driver.close();
	}

	
}
