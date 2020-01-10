package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTestPT extends TestBase2 {
	
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	
	@Test (priority=1)
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject=new SearchPage(getDriver());
			searchObject.productSearchUsingAutoSuggest("Mac");
			detailsObject=new ProductDetailsPage(getDriver());
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			
		} catch (Exception e) {
			System.out.println("Error Occurred "+e.getMessage());
		}
	}
	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject=new ProductDetailsPage(getDriver());
		detailsObject.AddToCart();
		Thread.sleep(2000);
		getDriver().navigate().to("https://demo.nopcommerce.com/"+"/cart");
			
	}
	@Test(priority=3)
	
	public void addQunatity()
	{
		cartPage=new ShoppingCartPage(getDriver());
		cartPage.UpdateProductQuantityInCart("4");
		Assert.assertTrue(cartPage.totalLbl.getText().contains("7,200.00"));
		System.out.println(cartPage.totalLbl.getText());
	}
	
	@Test(priority=4)
	public void UserCanRemoveProductFromCart()
	{
		cartPage=new ShoppingCartPage(getDriver());
		cartPage.RemoveProductFromCart();
		Assert.assertTrue(cartPage.removeSuccessfullyLbl.getText().contains("Your Shopping Cart is empty"));
	}
}
