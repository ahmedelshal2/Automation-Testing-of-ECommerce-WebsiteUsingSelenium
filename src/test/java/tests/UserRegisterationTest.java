package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration("ali","ahmed","ahe2204@gmail.com","123456ahmed");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}
	
	@Test(dependsOnMethods= {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin("ahelshal2014@gmail.com", "123456ahmed");
		
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
