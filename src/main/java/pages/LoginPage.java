package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="input.email")
	WebElement email ;

	@FindBy(css="input.password")
	WebElement password ;
	
	@FindBy(css="input.button-1.login-button")
	WebElement loginBtn;
	public void UserLogin(String emailBox,String pass)
	{
		setTextElementText(email, emailBox);
		setTextElementText(password, pass);
		clickButton(loginBtn);
	}

}
