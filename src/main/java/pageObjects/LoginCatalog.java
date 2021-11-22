package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginCatalog 
{
	public WebDriver driver;
	By admin=By.id("input-username");
	By password=By.id("input-password");
	By submit=By.xpath("//*[@type='submit']");
	
	//defining the constructor
	public LoginCatalog(WebDriver driver) 
	{
		//assigning driver to driver variable in this class
		this.driver=driver;
	}
	
	public WebElement getAdmin()
	{
		return driver.findElement(admin);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
}
