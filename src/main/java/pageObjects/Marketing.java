package pageObjects;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	public class Marketing {
	public WebDriver driver;
	By Marketing=By.xpath("//ul[@class='collapse in']/li[1]");
	By AddButton=By.xpath("//i[@class=\"fa fa-plus\"]");
	By Campaign=By.xpath("//input[@id=\"input-name\"]");
	By Tracking=By.xpath("//input[@id=\"input-code\"]");
	By Save=By.xpath("//button[@form=\"form-marketing\"]");
	By Affiliates=By.xpath("//*[@id=\'menu\']//li[7]//ul//li[2]//a");
	By Affiliatedname=By.xpath("//input[@id='input-name']");
	By Email=By.xpath("//input[@id=\'input-email\']");
	By Filter=By.xpath("//button[@id=\'button-filter\']");
	By Affiliateoption=By.xpath("//*[@id=\"menu\"]/li[7]/ul/li[2]/a");
	By Checkbox=By.xpath("//*[@id='menu']/li[7]/ul/li[2]/a");
	By Deletebutton=By.xpath("//button[@data-original-title='Delete']");
	By Couponsoption=By.xpath("//*[@id='menu']/li[7]/ul/li[3]/a");
	By Addsymbol=By.xpath("//a[@data-original-title=\"Add New\"]");
	By Couponsname=By.xpath("//input[@id=\"input-name\"]");
	By Code=By.xpath("//input[@id=\"input-code\"]");
	By Saveoption=By.xpath("//button[@data-original-title=\"Save\"]");
	By Back=By.xpath("//a[@class=\"btn btn-default\"]");
	By checkboxoption=By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[1]");
	By DeleteButtonoption=By.xpath("//button[@data-original-title=\"Delete\"]");
	By Mailoption=By.xpath("//ul[@class=\"collapse in\"]/li[4]");
	By Fromoption=By.xpath("//select[@id=\"input-store\"]");
	By Subject=By.xpath("//input[@id=\"input-subject\"]");
	By Mailsymbol=By.xpath("//button[@id=\"button-send\"]");
	By Home=By.xpath("//*[@id=\"content\"]/div[1]/div/ul/li[1]/a");

	public Marketing(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	}
	public WebElement getMarketing()
	{
	//Click on Marketing
	return driver.findElement(Marketing);
	}
	public WebElement getAddButton()
	{
	//Click on Add Button
	return driver.findElement(AddButton);

	}
	public WebElement getCampaign()
	{
	//Click on Campaign
	//Enter the Text in the Campaign Text Box
	return driver.findElement(Campaign);
	}
	public WebElement getTracking()
	{
	//Enter the Tracking Code
	return driver.findElement(Tracking);
	}
	public WebElement getSave()
	{
	return driver.findElement(Save);
	}
	public WebElement getAffiliates()
	{
	//Click on Affiliates
	return driver.findElement(Affiliates);
	}
	public WebElement getAffiliatedname()
	{
	//Click on Affiliated name
	return driver.findElement(Affiliatedname);
	}
	public WebElement getEmail()
	{
	//Click on Email option
	return driver.findElement(Email);
	}
	public WebElement getFilter()
	{
	//Click on Filter
	return driver.findElement(Filter);
	}
	public WebElement getAffiliateoption()
	{
	return driver.findElement(Affiliateoption);

	}
	public WebElement getCheckbox()
	{
	//Click on Check box
	return driver.findElement(Checkbox);

	}
	public WebElement getDeletebutton()
	{
	//Click on Delete Button
	return driver.findElement(Deletebutton);
	}
	public WebElement getCouponsoption()
	{
	//Click on Coupon Option
	return driver.findElement(Couponsoption);

	}
	public WebElement getAddsymbol()
	{
	//Click on Addsymbol
	return driver.findElement(Addsymbol);

	}
	public WebElement getCouponsname()
	{
	//Click on Couponsname
	return driver.findElement(Couponsname);
	}
	public WebElement getCode()
	{
	//Click on Getcode
	return driver.findElement(Code);
	}
	public WebElement getSaveoption()
	{
	// click on Save option
	return driver.findElement(Saveoption);
	}
	public WebElement getBack()
	{
	//Click on Get Back symbol
	return driver.findElement(Back);
	}
	public WebElement getcheckboxoption()
	{
	//Click on Checkbox option
	return driver.findElement(checkboxoption);
	}
	public WebElement getDeleteButtonoption()
	{
	return driver.findElement(DeleteButtonoption);
	}
	public WebElement getMailoption()
	{
	return driver.findElement(Mailoption);
	}
	public WebElement getFromoption()
	{
	return driver.findElement(Fromoption);
	}
	public WebElement getSubject()
	{
	return driver.findElement(Subject);
	}
	public WebElement getMailsymbol()
	{
	return driver.findElement(Mailsymbol);



	}
	public WebElement getHome()
	{
	return driver.findElement(Home);



	}

}
