package PageBeans;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLocationPageFactory {

WebDriver driver;
	
	//step 1 : identify elements
	
	@FindBy(xpath="//app-header/div[1]/div[1]/div[1]/div[1]/div[3]/app-nudge[1]/div[1]/div[3]/button[2]")
	WebElement pfselect;
	
	@FindBy(xpath="//input[@id='menu-search']")
	WebElement pflocationsearch;
	
	@FindBy(xpath="//app-set-location/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]")
	WebElement pfselectedlocation;
	
	@FindBy(xpath="//button[contains(text(),'Change')]")
	WebElement pfChange;
	
	@FindBy(xpath="//button[contains(text(),'Done')]")
	WebElement pfdone;
	
	@FindBy(xpath="//h1[contains(text(),'Nearby Landmark')]/following-sibling::div")
	WebElement pfLandmark;
	
	@FindBy(xpath="//button[1]")
	WebElement pfcontinue;
	
	@FindBy(xpath="//app-header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]")
	WebElement pfnavbar;
	
	//step 2 : Setters
	public void setPfNavbar() {
		pfnavbar.click();
	}
	
	public void setPfChange() {
		pfChange.click();
	}
	
	public void setPflocationsearch(String location) {
		pflocationsearch.sendKeys(location);
	}
	
	public void setPfselectedlocation() {
		pfselectedlocation.click();
	}

	public void setPfdone() {
		pfdone.click();
	}
	
	public void setPfcontinue() {
		pfcontinue.click();
	}
	
	
	//getters
	public String getPflocation() {
		return pfnavbar.getText();
	}
	
	public String getLandmark() {
		return pfLandmark.getText();
	}
	
	
	//initialization
	public UserLocationPageFactory(WebDriver driver) throws IOException{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
