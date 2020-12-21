package PageBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {

WebDriver driver;
	
	//step 1 : identify elements
	@FindBy(xpath="//input[@id='menu-search']")
	@CacheLookup
	WebElement pfsearch;
	
	@FindBy(xpath="//input[@id='menu-search']")
	@CacheLookup
	WebElement pfsearchtype;
	
	@FindAll({
		@FindBy(xpath="//div[@class='item-title']")
	})
	List<WebElement> pfsearchList;
	
	
	//WebElement pfLocation;

	//step 2 : Setters
	
	public void setPflocation() { // item = "burger"
		pfsearch.click();
	}
	
	public void setPfitemSearch(String item) { // item = "burger"
		pfsearch.sendKeys(item);
	}
	
	//getters
	public List<String> getPfsearchlist() {
		List<String> search_list = new ArrayList<String>();
		
		for(int i =0;i<pfsearchList.size();i++) {
			 String elementText = pfsearchList.get(i).getText(); 
			 search_list.add(elementText);
		}
		return search_list;
		
	}
	
	//initialization
	public SearchPageFactory(WebDriver driver) throws IOException{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
