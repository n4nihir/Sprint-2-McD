package PageBeans;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizationGrillPageFactory{

	WebDriver driver;
	
	//step 1 : identify elements
		@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
		WebElement pfAddToCart;
		
		@FindBy(xpath="//button[contains(text(),'View Cart')]")
		WebElement pfViewCart;
		
		@FindBy(xpath="//div[@class='cart-items']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]")
		WebElement pfCartItemDivHead;
		
		@FindBy(xpath="//div[@class='cart-items']/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]")
		WebElement pfCartItemDivCustomizations;

		@FindBy(xpath="//span[contains(text(),'Customize')]")
		WebElement pfCustomize;
		
	//step 2 -- generate getters

		public WebElement getPfCartItemDivHead() {
			return pfCartItemDivHead;
		}

		public WebElement getPfCartItemDivCustomizations() {
			return pfCartItemDivCustomizations;
		}
		
	//step-3 -- generate setters

		public void setPfAddToCart() {
			pfAddToCart.click();
		}

		public void setPfViewCart() {
			pfViewCart.click();
		}
		
		public void setPfCustomize() {
			pfCustomize.click();
		}
		
	//step-4 -- generate clears
		
		
	//initialization
		
		public CustomizationGrillPageFactory(WebDriver driver) throws InterruptedException, IOException{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
}
