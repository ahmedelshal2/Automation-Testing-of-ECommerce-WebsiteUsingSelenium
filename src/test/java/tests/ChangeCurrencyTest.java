package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;	
	@Test(priority=1)
	public void usercanChangeCurrency()
	{
		homeObject=new HomePage(driver);
		homeObject.changeCurrency();
		
	}
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject=new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("Mac");
			detailsObject=new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			Assert.assertTrue(detailsObject.productPricelbl.getText().contains("Ђ"));
			System.out.println(detailsObject.productPricelbl.getText());
		} catch (Exception e) {
			System.out.println("Error Occurred "+e.getMessage());
		}
		

		
	}

}
