package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDDTandPropertiesFile extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String firstnamee=LoadProperties.userData.getProperty("firstname");
	String lastnamee=LoadProperties.userData.getProperty("lastname");
	String emaill=LoadProperties.userData.getProperty("email");
	String passwordd=LoadProperties.userData.getProperty("password");




	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{

		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration(firstnamee,lastnamee,emaill,passwordd);
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
		loginObject.UserLogin(emaill, passwordd);

		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
