package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase
{
	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="gender-male")
	WebElement genderMale;

	@FindBy(id="FirstName")
	WebElement firstName;

	@FindBy(id="LastName")
	WebElement lastName ;

	@FindBy(id="Email")
	WebElement email ;

	@FindBy(id="Password")
	WebElement password ;

	@FindBy(id="ConfirmPassword")
	WebElement confirmPassword ;
	

	@FindBy(id="register-button")
	WebElement registerButton ;
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText="Log out")
 public	WebElement logoutLink;
	@FindBy(linkText="My account")
	WebElement myAccountLink;
	

	public void userRegistration(String fName,String lName,String emailBox, String pass)
	{
		clickButton(genderMale);
		setTextElementText(firstName, fName);
		setTextElementText(lastName, lName);
		setTextElementText(email, emailBox);
		setTextElementText(password, pass);
		setTextElementText(confirmPassword, pass);
		clickButton(registerButton);
	}
	public void userLogout()
	{
		clickButton(logoutLink);
	}
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}

}
