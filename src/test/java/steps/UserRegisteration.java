package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	
	@Given("^the user in home page$")
	public void the_user_in_home_page() 
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
	   
	}

	@When("^I click on register link$")
	public void i_click_on_register_link()  
	{
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*@When("^I entered the user data$")
	public void i_entered_the_user_data()  
	{
	    registerObject=new UserRegisterationPage(driver);
	    registerObject.userRegistration("ahmeeed", "ssddss", "lo55do5@gmail.com", "12389ss4");
	}*/
	
	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password)  
	{
		registerObject=new UserRegisterationPage(driver);
	    registerObject.userRegistration(firstname, lastname, email, password);
	}

	@Then("^The registeration page displayed successfully$")
	public void the_registeration_page_displayed_successfully()  
	{
	    registerObject.userLogout();
	}

}
