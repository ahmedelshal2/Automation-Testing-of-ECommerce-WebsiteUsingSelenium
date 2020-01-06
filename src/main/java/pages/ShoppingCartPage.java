package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="removefromcart")
	WebElement removeCheck;
	
	@FindBy(name="updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css="input.qty-input")
	public WebElement quantityTxt;
	
	@FindBy(css="td.subtotal")
	public WebElement totalLbl;
	@FindBy(css="div.no-data")
	public WebElement removeSuccessfullyLbl;
	
	@FindBy(id="checkout")
	WebElement CheckoutBtn;
	
	@FindBy(id="termsofservice")
	WebElement agreeCheckbox;
	
	public void RemoveProductFromCart()
	{
		clickButton(removeCheck);
		clickButton(updateCartBtn);
	}
	public void UpdateProductQuantityInCart(String quantity)
	{
		//clear quantity textbox
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	public void openCheckoutPage()
	{
		clickButton(agreeCheckbox);
		clickButton(CheckoutBtn);
	}

}
