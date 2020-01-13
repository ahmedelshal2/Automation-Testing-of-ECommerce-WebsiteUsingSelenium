package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	String fname="ahfmed";
	String lname="elsshal";
	String email="ro5e776ro1119@gmail.com";
	String pass="1234dd567";
			

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


	//3-email to friend
	@Test(priority=3)
	public void RegisteredUserCanSendProductToEmail()
	{
		detailsObject=new ProductDetailsPage(driver);
		detailsObject.openSendEmail();
		emailObject=new EmailPage(driver);
		emailObject.SendEmailToFriend("roby71203@test.com", "i have product very good");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent"));
	}


	//4-user can logout
	@Test(priority=4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}



}
