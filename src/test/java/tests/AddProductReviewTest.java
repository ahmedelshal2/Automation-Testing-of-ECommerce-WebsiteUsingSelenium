package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase {
	
	/*1-user registration
	 * 2-search for product
	 * 3-add review 
	 * 4-logout
	 */
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;
	String fname="ahskmed";
	String lname="elsshal";
	String email="ahe4lshla24422@gmail.com";
	String pass="123445678";
			
	//1-User Registration
	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{

		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration(fname,lname,email,pass);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));

	}
	//2-search for product
	@Test(priority=2)
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


	//3-add review
	@Test(priority=3)
	public void RegisteredUserCanaddReview()
	{
		detailsObject=new ProductDetailsPage(driver);
		detailsObject.openAddReviewPage();
		reviewObject=new ProductReviewPage(driver);
		reviewObject.addProductReview("the t-shirt", "it is very bad");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added"));
		
		
	}


	//4-user can logout
	@Test(priority=4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}

}
