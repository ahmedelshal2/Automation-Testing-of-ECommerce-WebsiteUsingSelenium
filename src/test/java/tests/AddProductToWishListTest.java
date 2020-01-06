package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
	
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishListObject;
	
	@Test (priority=1)
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject=new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("Mac");
			detailsObject=new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			
		} catch (Exception e) {
			System.out.println("Error Occurred "+e.getMessage());
		}
	}
	@Test(priority=2)
	public void UserCanAddProductToWishlist()
	{
		detailsObject=new ProductDetailsPage(driver);
		detailsObject.AddProductToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com/"+"/wishlist");
		wishListObject=new WishListPage(driver);
		Assert.assertTrue(wishListObject.WishListHeader.isDisplayed());
		Assert.assertTrue(wishListObject.productCell.getText().contains(productName));
	}
	@Test(priority=3)
	public void UserCanRemoveProductFromCart()
	{
		wishListObject=new WishListPage(driver);
		wishListObject.removeProductFromWhishlist();
		Assert.assertTrue(wishListObject.EmptyCartLbl.getText().contains("empty"));
		
	}

}
