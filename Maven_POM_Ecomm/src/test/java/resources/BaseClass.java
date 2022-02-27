package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//Driver session starts here
public class BaseClass 
{

	private String[] browserDrivers = {"chromedriver.exe","frirefoxdriver.exe"};
	private WebDriver driver;
	protected String url;
	private Properties prop;

	public void InitializeDriver() throws IOException
	{
		
		String filename = "data.properties";
		String resFilePath = System.getProperty("user.dir") + "//src//test//java//resources//";
		String dataFilePath = resFilePath + filename;
		FileInputStream fis = new FileInputStream(dataFilePath);
		prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if(driver == null)
		{
			switch(browser)
			{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", resFilePath+browserDrivers[0]);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", resFilePath+browserDrivers[0]);
				driver = new FirefoxDriver();
				break;
			}
		}
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
 
	public String getURL()
	{
		url = prop.getProperty("url");
		return url;
	}
	
	public void EndDriver() throws InterruptedException
	{
		if(driver != null)
		{
			System.out.println("In base class endsession before close()");
			driver.close();
			System.out.println("In base class endsession after close()");
			driver.quit();
		}
	}
}
