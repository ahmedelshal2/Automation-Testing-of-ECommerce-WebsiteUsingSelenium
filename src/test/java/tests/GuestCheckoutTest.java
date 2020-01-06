package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCheckoutTest extends TestBase {
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutpage;
	OrderDetailsPage orderObject;
	String firstNName="ahmed";
	String LastNName="elshal";
	String emaill="emre2@gmail.com";
	String productName="Apple MacBook Pro 13-inch";
	String country="Egypt";
	String City="fowa";
	String address="desouk";
	String zipCode="46233";
	String PhoneNumber="123666654";

	
	@Test(priority=1)
	public void UserCanSearchWithAutoSuggest()
	{
		try {
			searchObject=new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("Mac");
			
			detailsObject=new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			detailsObject.AddToCart();
			Thread.sleep(2000);
			driver.navigate().to("https://demo.nopcommerce.com"+"/cart");

		} catch (Exception e) {
			System.out.println("Error Occurred "+e.getMessage());
		}	
	}
	@Test(priority=2)

	public void addQunatity() throws InterruptedException
	{
		cartPage=new ShoppingCartPage(driver);
		cartPage.openCheckoutPage();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/onepagecheckout");
	}
	@Test(priority=3)
	public void UserCanCheckoutProduct() throws InterruptedException
	{
		checkoutpage=new CheckoutPage(driver);
		checkoutpage.GesutChekout(firstNName, LastNName, emaill, country, City, address, zipCode, PhoneNumber);
		Thread.sleep(2000);
		checkoutpage.clickOnButtonContinueCheckout();
		Thread.sleep(3000);
		
		checkoutpage.confirmCheckout();
		Thread.sleep(2000);
		checkoutpage.vieworderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject=new OrderDetailsPage(driver);
		orderObject.DownloadPdfInvoice();
		orderObject.printOrderDetails();
		
	}
	
	//print invoice as PDF or Print Page
	

	/*@Test(priority=5)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
		System.out.println(driver.getCurrentUrl());
	}*/




}
