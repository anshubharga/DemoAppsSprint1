package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(id="password")
	private WebElement pwdTextField;
	
	@FindBy(tagName="button")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Registered successfully']")
	private WebElement registeredSuccesfulMsg;
	
	@FindBy(xpath="//div[text()='Signin successful']")
	private WebElement loginSuccesfulMsg;
	
	@FindBy(xpath="//div[text()='Registered successfully']")
	private WebElement registeredSuccMsg;
	
	@FindBy(xpath="//div[text()='Signin successful']")
	private WebElement signinSuccMsg;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPwdTextField() {
		return pwdTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	public WebElement getRegisteredSuccesfulMsg() {
		return registeredSuccesfulMsg;
	}

	public WebElement getLoginSuccesfulMsg() {
		return loginSuccesfulMsg;
	}
	
	

	public WebElement getRegisteredSuccMsg() {
		return registeredSuccMsg;
	}

	public WebElement getSigninSuccMsg() {
		return signinSuccMsg;
	}

	public void loginUser(String email,String pwd) throws InterruptedException
	{
		emailTextField.sendKeys(email);
		pwdTextField.sendKeys(pwd);
		loginButton.click();
		Thread.sleep(2000);
	}
	
	public boolean verifyRegisterSuccesfulMsg()
	{
		return registeredSuccMsg.isDisplayed();
	}
	
	public boolean verifySigninSuccesfulMsg()
	{
		return signinSuccMsg.isDisplayed();
	}
}
