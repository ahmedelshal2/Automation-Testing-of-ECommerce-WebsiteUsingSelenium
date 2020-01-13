package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	
	HomePage home;
	ContactUsPage contactpage;
	String fullNamee="AhmdlMorJshedy";
	String emaill="al4i4j4d55@gmail.com";
	String enquiryy="hello admin please help me";
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Contact US Test Case")
	@Link(name="JIRA Ticket", url = "https://google.com")

	public void UsercanuseContactUs()
	{
		home=new HomePage(driver);
		home.openContactUsPage();
		contactpage=new ContactUsPage(driver);
		contactpage.ContactUs(fullNamee, emaill, enquiryy);
		Assert.assertTrue(contactpage.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}

}
