package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fnTxt;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lnTxt;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityText;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressTxt;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxt;
	
	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	@FindBy(id="shippingoption_1")
	WebElement shippingMethodRdo;
	
	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;
	
	@FindBy(id="paymentmethod_0")
	WebElement checkOrderRd;
	
	@FindBy(css="input.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;
	
	@FindBy(xpath="//*[@id=\"checkout-payment-info-load\"]/div/div/div/table/tbody/tr/td/p[3]")
	public WebElement checkoutMessage;
	
	@FindBy(css="input.button-1.payment-info-next-step-button")
	WebElement nextstepBtn;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement productnameLbl;
	
	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmOrderbtn;
	
	@FindBy(css="div.title")
	public WebElement asserttile;
	
	@FindBy(linkText="Click here for order details.")
	WebElement detailsOrder;
	
	@FindBy(css="input.button-1.order-completed-continue-button")
	WebElement lastButoonContinue;
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement guestcheckout;
	
	@FindBy(css="div.topic-block-title")
	public WebElement assertBacktoHome;
	
	public void RegisteredUserCheckoutProduct(String Country, String city, String Address,String ZipCode,String phoneNumber)
	{
		select=new Select(countryList);
		select.selectByVisibleText(Country);
		setTextElementText(cityText, city);
		setTextElementText(addressTxt, Address);
		setTextElementText(zipCodeTxt, ZipCode);
		setTextElementText(phoneTxt, phoneNumber);
	}
	public void clickguestCheckout()
	{
		clickButton(guestcheckout);
	}
	public void GesutChekout(String firstName,String LastName,String email,String Country, String city, String Address,String ZipCode,String phoneNumber)
	{
		setTextElementText(fnTxt, firstName);
		setTextElementText(lnTxt, LastName);
		setTextElementText(emailTxt, email);
		select=new Select(countryList);
		select.selectByVisibleText(Country);
		setTextElementText(cityText, city);
		setTextElementText(addressTxt, Address);
		setTextElementText(zipCodeTxt, ZipCode);
		setTextElementText(phoneTxt, phoneNumber);
	}
	
	public void clickOnButtonContinueCheckout() throws InterruptedException
	{
		clickButton(continueBtn);
		Thread.sleep(1000);
		clickButton(shippingMethodRdo);
		Thread.sleep(1000);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(checkOrderRd);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(nextstepBtn);
		
	}
	public void confirmCheckout() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(confirmOrderbtn);
		
	}
	public void vieworderDetails()
	{
		clickButton(detailsOrder);
	}
	public void backtoHome() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(lastButoonContinue);
	}

}
