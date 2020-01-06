package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class E2ETests extends TestBase {
	SearchPage searchObject;
	UserRegisterationPage registerObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutpage;
	OrderDetailsPage orderObject;
	String firstNName="ahmed";
	String LastNName="elshal";
	String emaill="ems458ref2@gmail.com";
	String country="Egypt";
	String City="fowa";
	String address="desouk";
	String zipCode="46233";
	String PhoneNumber="123666654";
	HomePage homeObject;
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page()  {
		
		homeObject=new HomePage(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce"));
		
	    
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String productName) throws InterruptedException {
		
		searchObject=new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("Mac");
		
		detailsObject=new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		detailsObject.AddToCart();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		
	   
	}

	@When("^choose to buy Two items$")
	public void choose_to_buy_Two_items() throws InterruptedException {
		cartPage=new ShoppingCartPage(driver);
		cartPage.openCheckoutPage();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/onepagecheckout");
	}

	@When("^move to checkout cart and enter personal details on checkout page and place the order$")
	public void move_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException  {
		checkoutpage=new CheckoutPage(driver);
		checkoutpage.GesutChekout(firstNName, LastNName, emaill, country, City, address, zipCode, PhoneNumber);
		Thread.sleep(2000);
		checkoutpage.clickOnButtonContinueCheckout();
		Thread.sleep(3000);
		
		checkoutpage.confirmCheckout();
		Thread.sleep(2000);
		checkoutpage.vieworderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		
		
	    
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		orderObject=new OrderDetailsPage(driver);
		orderObject.DownloadPdfInvoice();
		orderObject.printOrderDetails();
	}


}
