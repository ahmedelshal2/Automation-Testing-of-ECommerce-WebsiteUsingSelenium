package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="td.product")
	public WebElement productCell;
	
	//@FindBy(css="div.page-title") or 
	//@FindBy(tagName="h1")
	
	@FindBy(css="h1")
	public WebElement WishListHeader;
	
	@FindBy(name="updatecart")
	private WebElement updateWishlistBtn;
	
	@FindBy(name="removefromcart")
	private WebElement removeformCartCheck;
	
	@FindBy(css="div.no-data")
	public WebElement EmptyCartLbl;
	
	public void removeProductFromWhishlist()
	{
		clickButton(removeformCartCheck);;
		clickButton(updateWishlistBtn);

	}
	

}
