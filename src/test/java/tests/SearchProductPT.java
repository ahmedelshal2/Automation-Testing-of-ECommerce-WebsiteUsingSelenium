package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductPT extends TestBase2 
{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	@Test
	public void UserCanSearchForProducts()
	{
		searchObject=new SearchPage(getDriver());
		detailsObject=new ProductDetailsPage(getDriver());
		searchObject.ProductSearch(productName);
		searchObject.openProductDetailsPage();
		//Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);

	}


}
