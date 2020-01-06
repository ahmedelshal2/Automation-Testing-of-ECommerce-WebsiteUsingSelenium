package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="Change password")
	WebElement changePasswordLink;
	@FindBy (id="OldPassword")
	WebElement oldPasswordTxt;
	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	@FindBy(css="input.button-1.change-password-button")
	WebElement changePasswordBtn;
	@FindBy(css="div.result")
	public WebElement resultLbl;



	public void openChangePasswordPage()
	{
		clickButton(changePasswordLink);
	}
	public void ChangePassword(String oldPassword,String newPassword)
	{
		setTextElementText(oldPasswordTxt, oldPassword);
		setTextElementText(newPasswordTxt, newPassword);
		setTextElementText(confirmPasswordTxt, newPassword);
		clickButton(changePasswordBtn);
	}

}
