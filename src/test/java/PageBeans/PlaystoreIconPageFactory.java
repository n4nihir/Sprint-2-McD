package PageBeans;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaystoreIconPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//app-header/div[1]/div[1]/div[1]/div[2]/div[1]/img[2]")
	@CacheLookup
	WebElement pfplayStoreIcon;
	
	@FindBy(xpath="//h1[@itemprop='name']/span[1]")
	@CacheLookup
	WebElement pfAppDescription;
	
	@FindBy(xpath="//h1[@itemprop='name']/../following-sibling::div/div[1]/div[1]/span[1]/a[1]")
	@CacheLookup
	WebElement pfAppDeveloper;
	
	//step 2 : Setters
	public void setPfplayStoreIcon() {
		pfplayStoreIcon.click();
	}
	
	//Getters
	public String getPfAppDescription() {
		return pfAppDescription.getText();
	}
	
	public String getPfAppDeveloper() {
		return pfAppDeveloper.getText();
	}
	
	
	
	//initialization
	public PlaystoreIconPageFactory(WebDriver driver) throws IOException{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
