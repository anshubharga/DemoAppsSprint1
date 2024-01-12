package webElement.textboox;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.FileUtility;
import pom.LoginPage;
import pom.RegisterPage;

public class ToRegisterAndLoginUsingTestngTest extends BaseClassForTestngTest{
	@Test(priority = 1)
	public void toRegisterUser() throws IOException
	{		
		String name = fUtil.fetchStringDataFromExcelSheet("RegisterationData", 1, 0);
		String email = fUtil.fetchStringDataFromExcelSheet("RegisterationData", 1, 1);
		String pwd = fUtil.fetchStringDataFromExcelSheet("RegisterationData", 1, 2);
		
		RegisterPage register=new RegisterPage(driver);
		LoginPage login=new LoginPage(driver);
		
		
		register.registerUser(name, email, pwd);
		Assert.assertTrue(login.verifyRegisterSuccesfulMsg());
		System.out.println("Pass: User has Registered");
	}
	
	@Test(priority = 2)
	public void toLoginUser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String email = fUtil.fetchStringDataFromExcelSheet("RegisterationData", 1, 1);
		String pwd = fUtil.fetchStringDataFromExcelSheet("RegisterationData", 1, 2);
		
		LoginPage login=new LoginPage(driver);
		
		login.loginUser(email, pwd);
		
		Assert.assertTrue(login.verifySigninSuccesfulMsg());
		System.out.println("Pass: User has Logged in");
	}

}
