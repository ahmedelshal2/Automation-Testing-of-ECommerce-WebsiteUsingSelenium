package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class RegisteredUserCheckoutProduct extends TestBase {
	/*1-User register
	 * 2-search auto suggest
	 * 3-add to cart
	 * 4-navigate to shopping cart url
	 * click on radio btn then click button check out
	 * 5-navigate to checkout
	 * 6-logout
	 * 
	 * 
	 */
	HomePage homeObject;
	UserRegisterationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutpage;
	OrderDetailsPage orderObject;
	String firstNName="ahmed";
	String LastNName="elshal";
	String emaill="aw545edf@gmail.com";
	String Passwordd="123456";
	String productName="Apple MacBook Pro 13-inch";
	String country="Egypt";
	String City="fowa";
	String address="desouk";
	String zipCode="46233";
	String PhoneNumber="123666654";

	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{

		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration(firstNName,LastNName,emaill,Passwordd);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));

	}
	@Test(priority=2)
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
	@Test(priority=3)

	public void addQunatity() throws InterruptedException
	{
		cartPage=new ShoppingCartPage(driver);
		cartPage.openCheckoutPage();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/onepagecheckout");
	}
	@Test(priority=4)
	public void UserCanCheckoutProduct() throws InterruptedException
	{
		checkoutpage=new CheckoutPage(driver);
		checkoutpage.RegisteredUserCheckoutProduct(country, City, address, zipCode, PhoneNumber);
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
	

	@Test(priority=5)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
		System.out.println(driver.getCurrentUrl());
	}




}
