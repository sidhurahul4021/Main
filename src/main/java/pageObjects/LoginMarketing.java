package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginMarketing {
public WebDriver driver;
By admin=By.id("input-username");
By password=By.id("input-password");
By submit=By.xpath("//*[@type='submit']");
By menu = By.id("button-menu");
By Marketing=By.xpath("//span[text()='Marketing']");
By subMarketing=By.xpath("//ul[@class='collapse in']/li[1]");//a[text()='Marketing']
By Affiliates=By.xpath("//ul[@class='collapse in']/li[2]");
By Coupons=By.xpath("//ul[@class='collapse in']/li[3]");
By Mail=By.xpath("//ul[@class=\"collapse in\"]/li[4]");
By Campaignname=By.id("input-name");
By Filter=By.id("button-filter");

public LoginMarketing(WebDriver driver) {
// TODO Auto-generated constructor stub
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
public WebElement getMenu()
{
return driver.findElement(menu);



}
public WebElement getMarketing()
{
return driver.findElement(Marketing);

}
public WebElement getsubMarketing()
{
return driver.findElement(subMarketing);

}
public WebElement getAffiliates()
{
return driver.findElement(Affiliates);
}
public WebElement getCoupons()
{
return driver.findElement(Coupons);
}
public WebElement getMail()
{
return driver.findElement(Mail);
}
public WebElement getCampaignname()
{
return driver.findElement(Campaignname);
}
public WebElement getFilter()
{
return driver.findElement(Filter);
}
}
