package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String firstName="ahmtmed";
	String lastName="mmorsshedy";
	String email="pop44si12@gmail.com";
	String oldPassword="1234567";
	String newPassword="123456789";


	@Test(priority=1)
	public void UserCanRegisterSuccessfully()
	{

		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration(firstName,lastName,email,oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));

	}
	@Test(priority=2)
	public void RegisteredUserCanChangePassword()
	{
		myAccountObject=new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
	}
	@Test(priority=3)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	@Test(priority=4)
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}


}
