package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	
	HomePage home;
	ContactUsPage contactpage;
	String fullNamee="Ahmed Morshedy";
	String emaill="ali455@gmail.com";
	String enquiryy="hello admin please help me";
	@Test
	public void UsercanuseContactUs()
	{
		home=new HomePage(driver);
		home.openContactUsPage();
		contactpage=new ContactUsPage(driver);
		contactpage.ContactUs(fullNamee, emaill, enquiryy);
		Assert.assertTrue(contactpage.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}

}
