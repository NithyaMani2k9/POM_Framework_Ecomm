package Maven_POM_Ecomm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseClass;
public class HomePageTest extends BaseClass{

	WebDriver driver;
	HomePage homeObj;
	@BeforeTest
	public void InitializeSession() throws IOException
	{
		InitializeDriver();
		driver = getDriver();
		driver.get(getURL());
		homeObj = new HomePage(driver);
	}
	
	@Test
	public void VerifyTitle()
	{
		Assert.assertEquals(homeObj.getTitle(), "My Store");
	}
	
	@Test
	public void VerifyingSignInClick()
	{
		homeObj.ClickSignIn();
	}
	
	@AfterTest
	public void EndSession() throws InterruptedException
	{ 
		if(driver != null)
		{
			System.out.println("In test class endsession");
			EndDriver();
		}
	}
	
}
