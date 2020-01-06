package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationwithDTTAndDataProvider extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="testData")
	public static Object [][] userData()
	{
		return new Object[][] {
			{"Moataz","Nabil","testtest2@gmail.com","12345678"},
			{"Ahmed","Ali","testtest3@gmail.com","123457678"}
		};
	}
	
	
	@Test(priority=1,alwaysRun=true,dataProvider="testData")
	public void UserCanRegisterSuccessfully(String fname,String lname,String email,String password)
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));	
		registerObject.userLogout();
	}
}
