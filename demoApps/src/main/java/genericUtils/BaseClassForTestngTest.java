package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import genericUtils.FileUtility;

public class BaseClassForTestngTest {
	public WebDriver driver;
	FileUtility fUtil=new FileUtility();
	@BeforeSuite
	public void bs()
	{
		System.out.println("Database connectivity achieved");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("This is before test");
	}
	
	//@Parameters("browser")
	@BeforeClass
	public void bc() throws IOException
	{
		String browser = fUtil.fetchDataFromPropertyFile("Browser");
		String url = fUtil.fetchDataFromPropertyFile("url");
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("edge"))
			driver=new EdgeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}
	
	@BeforeMethod
	public void bm()
	{
		System.out.println("login user");
	}
	
	@AfterMethod
	public void am()
	{
		System.out.println("logout user");
	}
	
	@AfterClass
	public void ac()
	{
		driver.quit();
	}
	
	@AfterTest
	public void at()
	{
		System.out.println("This  after test");
	}
	
	@AfterSuite
	public void as()
	{
		System.out.println("close database connectivity");
	}

}
