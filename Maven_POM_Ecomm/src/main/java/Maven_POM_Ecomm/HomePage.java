package Maven_POM_Ecomm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	private By contactUs = By.linkText("Contact us");
	private By signIn = By.linkText("Sign in");
	
	HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	//To click ContactUs link
	public void ClickContactUs()
	{
		driver.findElement(contactUs).click();
		
	}
	
	//To click SignIn link
	public void ClickSignIn()
	{
		driver.findElement(signIn).click();
	}
}

