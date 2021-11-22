package pageObjects;

	

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Reports1 {

By reportsDropdown = By.xpath("//span[text()='Reports']");
By Sales=By.xpath("//a[text()='Sales']");
By Ordersoption=By.xpath("//*[@id=\"reports\"]/ul/li[1]/ul/li[1]/a");
By Taxoption=By.xpath("//*[@id=\"reports\"]/ul/li[1]/ul/li[2]/a");
By Shipping=By.xpath("//*[@id=\"reports\"]/ul/li[1]/ul/li[3]/a");
By Returnsoption=By.xpath("//*[@id=\"reports\"]/ul/li[1]/ul/li[4]/a");
By Couponsoption=By.xpath("//*[@id=\"reports\"]/ul/li[1]/ul/li[5]/a");
By Productsoption=By.xpath("//*[@id='reports']/ul/li[2]/a");
By Viewedoption=By.xpath("//a[text()='Viewed']");


public WebDriver driver;
public Reports1(WebDriver driver) {
// TODO Auto-generated constructor stub
this.driver=driver;
}
//Click on Reports
public WebElement getreportsdown()
{
return driver.findElement(reportsDropdown);
}
//Click on the Sales in the Report Dropdown
public WebElement getSales()
{
return driver.findElement(Sales);
}
//Click on Orders in Sales Option
public WebElement getOrdersoption()
{
return driver.findElement(Ordersoption);
}
//Click on Tax option in Sales Dropdown
public WebElement getTaxoption()
{
return driver.findElement(Taxoption);



}
//Click on Shipping Option in the Sales
public WebElement getShipping()
{
return driver.findElement(Shipping);
}
//Return Option
public WebElement getReturnsoption()
{
return driver.findElement(Returnsoption);
}
//Coupons
public WebElement getCouponsoption(){



return driver.findElement(Couponsoption);
}
//Click on Product Dropdown
public WebElement getProductsoption()
{
return driver.findElement(Productsoption);
}
//Click on Viewed Option
public WebElement getViewedoption()
{
return driver.findElement(Viewedoption);
}

}
