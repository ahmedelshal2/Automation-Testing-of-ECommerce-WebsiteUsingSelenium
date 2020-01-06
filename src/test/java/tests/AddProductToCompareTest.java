package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";

	//1-Search for product Number 1
	//2-Search for product Number 2
	//3-Add to compare
	//4-clear list

	ProductDetailsPage detailObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;

	@Test(priority=1)
	public void UserCanCompareProducts() throws InterruptedException
	{
		searchObject=new SearchPage(driver);
		detailObject=new ProductDetailsPage(driver);
		compareObject=new ComparePage(driver);

		searchObject.productSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(detailObject.productNamebreadCrumb.getText().contains(firstProductName));
		detailObject.AddProductToCompare();

		searchObject.productSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailObject.productNamebreadCrumb.getText().contains(secondProductName));
		detailObject.AddProductToCompare();
		Thread.sleep(2000);

		driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");

		Assert.assertTrue(compareObject.FFirstProduct.getText().equals(firstProductName));
		Assert.assertTrue(compareObject.SSecondProduct.getText().equals(secondProductName));
		compareObject.compareProducts();
	}

	@Test(priority=2)
	public void UserCanClearCompareList()
	{
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLBL.getText().contains("You have no items to compare."));

	}

}
