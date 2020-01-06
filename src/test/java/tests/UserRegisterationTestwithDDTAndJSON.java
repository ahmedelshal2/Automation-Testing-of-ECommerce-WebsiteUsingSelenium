package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestwithDDTAndJSON extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;


	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonReader=new JsonDataReader();
		jsonReader.JsonReader();
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration(jsonReader.firstname, jsonReader.lastname,jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(jsonReader.email, jsonReader.password);	
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}	
}
