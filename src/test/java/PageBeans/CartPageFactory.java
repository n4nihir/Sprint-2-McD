package PageBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageFactory {

	WebDriver driver;
	
	File src = new File("C:\\Users\\Dell\\git\\repository\\McDelivery\\PageFactory.xlsx");
	FileInputStream fis = new FileInputStream(src);
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet cartSheet = wb.getSheetAt(4);
	
	
	//identify elements
	
	@FindBy(xpath="//button[contains(text(),'View Cart')]")
	WebElement pfViewCart;
	
	@FindBy(xpath="//button[contains(text(),'+')]")
	WebElement pfAddQuantity;
	
	@FindBy(xpath="//button[contains(text(),'-')]")
	WebElement pfRemoveQuantity;
	
	@FindBy(xpath="//div[@class='cart-stepper d-flex']/input[1]")
	WebElement pfItemQuantity;
	



	public void setPfViewCart() {
		pfViewCart.click();
	}



	public void setPfAddQuantity() {
		pfAddQuantity.click();
	}



	public void setPfRemoveQuantity() {
		pfRemoveQuantity.click();
	}
	
	public void setPfItemQuantity() {
		pfItemQuantity.click();
	}



	public String getPfItemQuantity() {
		return pfItemQuantity.getAttribute("value");
	}



	//initialization
	public CartPageFactory(WebDriver driver) throws IOException{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
