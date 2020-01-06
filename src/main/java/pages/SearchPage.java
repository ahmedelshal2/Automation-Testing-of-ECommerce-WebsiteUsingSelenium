package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="small-searchterms")
	WebElement SearchTextBox;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> ProductList;
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		setTextElementText(SearchTextBox, productName);
		clickButton(searchBtn);
	}
	
	public void openProductDetailsPage()
	{
		clickButton(productTitle);
	}
	public void productSearchUsingAutoSuggest(String searchTxt)
	{
		setTextElementText(SearchTextBox, searchTxt);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductList.get(0).click();
	}

}
