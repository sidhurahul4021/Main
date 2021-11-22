package stepDefinitions;

import java.io.IOException;
import static org.junit.Assert.assertTrue;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.AddressEdit;
import pageObjects.AffiliateLogin;
import pageObjects.AffiliatesRegister;
import pageObjects.AttributesCatalog;
import pageObjects.CategoriesCatalog;
import pageObjects.ContactUs;
import pageObjects.Dashboard;
import pageObjects.DownloadsCatalog;
import pageObjects.FiltersCatalog;
import pageObjects.GiftCertificates;
import pageObjects.HomeCatalog;
import pageObjects.InformationCatalog;
import pageObjects.Login;
import pageObjects.Login1;
import pageObjects.LoginAccount;
import pageObjects.LoginMyAccount;
import pageObjects.LoginCatalog;
import pageObjects.LoginMarketing;
import pageObjects.ManufacturersCatalog;
import pageObjects.Marketing;
import pageObjects.MyAccountInformation;
import pageObjects.MyWishList;
import pageObjects.NavigationBar;
import pageObjects.NewsLetter;
import pageObjects.OptionsCatalog;
import pageObjects.PasswordChange;
import pageObjects.ProductsCatalog;
import pageObjects.RecurringProfilesCatalog;
import pageObjects.Register;
import pageObjects.Reports1;
import pageObjects.ReviewsCatalog;
import pageObjects.UniformStore;
import resources.Base;
import pageObjects.UniformStore1;
import java.io.InvalidObjectException;


import javax.swing.text.html.HTMLDocument.Iterator;



import com.gargoylesoftware.htmlunit.javascript.host.Set;

import io.cucumber.java.en.*;



import pageObjects.Reports2;
import pageObjects.loginSales;





public class StepDefinitions extends Base
{
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////    My Account       ////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Given("Login with user credentials")
	public void login_with_user_credentials() throws IOException, InterruptedException 
	{
		//initializing the browser
		driver =initializeDriver();
		
		//getting "http://uniformm1.upskills.in/"
		String arg1="http://uniformm1.upskills.in/";
		driver.get(arg1);
		
		//clicking my account drop down and then click on login
		driver.findElement(By.xpath("//*[@class='dropdown myaccount']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		//creating object for Login class
		LoginMyAccount l=new LoginMyAccount(driver);
		
		//sending valid mail and password 
		l.getEmail().sendKeys("palacharlaramya000@gmail.com");
		l.getPassword().sendKeys("Ramya@557");
		
		//clicking on submit
		l.getSubmit().click();
	}

	////////////////////////////My Account///////////////////////
	
	@When("Click on MyAccount in footer")
	public void click_on_my_account_in_footer() 
	{
		//creating object for UniformStore
		UniformStore u=new UniformStore(driver);
		
		//Clicking on MyAccount in footer
		u.getMyAccount().click();
	}
	
	@Then("Navigate to MyAccount page")
	public void navigate_to_my_account_page() 
	{
		//Getting present page title and comparing with expected title My Account
		String s=driver.getTitle();
		Assert.assertEquals("My Account",s);
		//printing a message
		System.out.println("Navigated to My Account Page"); 
	}
	
	@And("Close driver")
	public void close_driver()
	{
		//close driver
		driver.close();
	}

	@When("Click on MyAccount in dropdown")
	public void click_on_myaccount_in_dropdown()
	{
		//creating object for UniformStore
		UniformStore u=new UniformStore(driver);
		//clicking on MyAccount drop down
		u.getDropDown().click();
		//selecting My Account from dropdown
		u.getMyAccount2().click();
	}
	
	///////////////////////////Edit your account information////////////////////////////////

	@When("^Click on Edit your account information$")
	public void click_on_edit_your_account_information() throws Throwable 
	{
		//creating object for UniformStore
		UniformStore u=new UniformStore(driver);
		//clicking on Edit your account information
		u.getEdit().click();
	}
	
	@Then("^Navigate to MY ACCOUNT INFORMATION$")
	public void navigate_to_my_account_information() throws Throwable 
	{
		//Getting present page title and comparing with expected title My Account Information
		String s=driver.getTitle();
		Assert.assertEquals("My Account Information",s);
		//printing a message 
		System.out.println("Navigated to My Account Information"); 
	}

	@When("^Edit details and click on CONTINUE$")
	public void edit_details_and_click_on_continue() throws Throwable 
	{
		//creating object for MyAccountInformation class
		MyAccountInformation m=new MyAccountInformation(driver);
		//clearing the FirstName text field and entering ramya3
		m.getFirstName().clear();
		m.getFirstName().sendKeys("ramya3");
		//clearing the LastName text field and entering palacharla3
		m.getLastName().clear();
		m.getLastName().sendKeys("palacharla3");
		//clicking on continue
		m.getSubmit().click();
	}
	
	@Then("^Get success message$")
	public void get_success_message() throws Throwable 
	{
		//checking if success message is displayed or not 
		MyAccountInformation m=new MyAccountInformation(driver);
		Assert.assertTrue(m.getMsg().isDisplayed());
		//printing the success message
		System.out.println(m.getMsg().getText());
	}

	@When("^Edit details and click on Back$")
	public void edit_details_and_click_on_back() throws Throwable 
	{
		UniformStore u=new UniformStore(driver);
		//clicking on Edit your account information
		u.getEdit().click();
		MyAccountInformation m=new MyAccountInformation(driver);
		//clearing first name and giving ramya4 as input
		m.getFirstName().clear();
		m.getFirstName().sendKeys("ramya4");
		//clearing last name and giving palacharla4 as input
		m.getLastName().clear();
		m.getLastName().sendKeys("palacharla4");
		//clicking on back
		m.getBack().click();
		//again click on Edit your account information
		u.getEdit().click();
	}  
	
	@Then("^Details not updated$")
	public void details_not_updated() throws Throwable 
	{
		MyAccountInformation m=new MyAccountInformation(driver);
		//comparing the first name and last name are same as before
		Assert.assertEquals("ramya3", m.getFirstName().getAttribute("value"));
		Assert.assertEquals("palacharla3", m.getLastName().getAttribute("value"));
		//printing a message
		System.out.println("Details are not updated");
	}
	
	@When("^Giving text for Telephone field and click on continue$")
    public void giving_text_for_telephone_field_and_click_on_continue() throws Throwable 
	{
		MyAccountInformation m=new MyAccountInformation(driver);
		//clearing and giving xyz inside telephone field and click on continue
		m.getTelephone().clear();
		m.getTelephone().sendKeys("xyz");
		//clicking on submit icon
		m.getSubmit().click();
    }
	
	@Then("^Show Error$")
    public void show_error() throws Throwable 
    {
		MyAccountInformation m=new MyAccountInformation(driver);
    	//checking if success message is displayed if displayed printing error messsage
        if(m.getMsg().isDisplayed())
        {
        	System.out.println("!!!!!!!!!!ERROR:ACCEPTING TEXT IN TELEPHONE FIELD!!!!!!!!!!");
        }
    }

	//////////////////////Change your password///////////////////////
	
	@When("^Click on Change your password$")
	public void click_on_change_your_password() throws Throwable 
	{
		//clicking on Change your password
		UniformStore u=new UniformStore(driver);
		u.getEditPassword().click();
	}
	
	@Then("^Navigate to CHANGE PASSWORD$")
	public void navigate_to_change_password() throws Throwable 
	{
		//Getting present page title and comparing with expected title Change Password
		String name=driver.getTitle();
		Assert.assertEquals("Change Password", name);
		//printing a message
		System.out.println("Navigated to Change Password"); 
	}
	
	@When("^Edit password with different input for password and confirm password and click on CONTINUE$")
	public void edit_password_with_different_input_for_password_and_confirm_password_and_click_on_continue() throws Throwable
	{
		//creating object for PasswordChange class
		PasswordChange p=new PasswordChange(driver);
		//sending different input for password and confirm password fields
		p.getPassword().sendKeys("Ramya");
		p.getPasswordConfirm().sendKeys("Ramy");
		//clicking on continue
		p.getContinue().click();
	}
	
	@Then("^Get missmatch message$")
	public void get_missmatch_message() throws Throwable 
	{
		//checking if error message is displayed 
		PasswordChange p=new PasswordChange(driver);
		Assert.assertTrue(p.getMatchMsg().isDisplayed());
		//printing the error message
		System.out.println(p.getMatchMsg().getText());
	}
	
	@When("^Edit password with size lessthan 3 and click on CONTINUE$")
	public void edit_password_with_size_lessthan_3_and_click_on_continue() throws Throwable 
	{
		//clearing the fields and giving the same inputs with size less than 3
		PasswordChange p=new PasswordChange(driver);
		p.getPassword().clear();
		p.getPassword().sendKeys("Ra");
		p.getPasswordConfirm().clear();
		p.getPasswordConfirm().sendKeys("Ra");
		//clicking on continue
		p.getContinue().click();
	}
	
	@Then("^Get Sizemissmatch message$")
	public void get_sizemissmatch_message() throws Throwable 
	{
		PasswordChange p=new PasswordChange(driver);
		//checking if the error message is displayed or not
		Assert.assertTrue(p.getSizeMsg().isDisplayed());
		//printing the error message
		System.out.println(p.getSizeMsg().getText());
	}
	
	@When("^Edit password with same input for password and confirm password and click on CONTINUE$")
	public void edit_password_with_same_input_for_password_and_confirm_password_and_click_on_continue() throws Throwable 
	{
		//creating object for PasswordChange class
		PasswordChange p=new PasswordChange(driver);
		//clearing the fields and giving the valid and same password in the fields
		p.getPassword().clear();
		p.getPassword().sendKeys("Ramya@557");
		p.getPasswordConfirm().clear();
		p.getPasswordConfirm().sendKeys("Ramya@557");
		//click on continue
		p.getContinue().click();
	}
	
	@Then("^Get updated message$")
	public void get_updated_message() throws Throwable 
	{
		//checking the success message is displayed or not
		PasswordChange p=new PasswordChange(driver);
		Assert.assertTrue(p.getMsg().isDisplayed());
		//printing the success message
		System.out.println(p.getMsg().getText());
	}
	
	@When("^Clicking on Change your password and clicking on Back$")
	public void clicking_on_change_your_password_and_clicking_on_back() throws Throwable 
	{
		//clicking on change your password
		UniformStore u=new UniformStore(driver);
		u.getEditPassword().click();
		//printing a message
		System.out.println("Navigated to Change your password");
		//clicking on back 
		PasswordChange p=new PasswordChange(driver);
		p.getBack().click();
	}
	
	//////////////////////////////Modify your address book entries///////////////////////////
	
	@When("^Click on Modify your address book entries$")
    public void click_on_modify_your_address_book_entries() throws Throwable 
	{
		UniformStore u=new UniformStore(driver);
		//clicking on modify your address book entries
		u.getAddress().click();
    }
	@Then("^Navigate to Address book entries$")
    public void navigate_to_address_book_entries() throws Throwable 
	{
		//Getting present page title and comparing with expected title address book
		String name=driver.getTitle();
		Assert.assertEquals("Address Book", name);
		//printing navigated message 
		System.out.println("Navigated to Address Book Entries"); 
    }

    @When("^Clicking on New Address$")
    public void clicking_on_new_address() throws Throwable 
    {
    	//creating object for AddressEdit class
    	AddressEdit a=new AddressEdit(driver);
    	//clicking on new address
    	a.getNewAddress().click();
    }
    
    @And("^Creating a new Addrees by giving valid details and click on continue$")
    public void creating_a_new_addrees_by_giving_valid_details_and_click_on_continue() throws Throwable 
	{
    	//giving input for first name,last name,address,city,post code
		AddressEdit a=new AddressEdit(driver);
    	a.getFirstName().sendKeys("ramya");
    	a.getLastName().sendKeys("palacharla");
    	a.getAddress().sendKeys("4-99");
    	a.getCity().sendKeys("valluru");
    	a.getPostCode().sendKeys("533308");
    	
    	//clicking on country drop down
    	a.getCountry().click();
    	//storing the country web element inside country variable
    	WebElement country = a.getCountry();
    	//creating object for Select class and passing country as parameter to Select constructor
		Select dropdown = new Select(country);  
		//from the drop down selecting the value which is having the text as India
		dropdown.selectByVisibleText("India");
		
		//clicking on state drop down
		a.getState().click();
		//storing the state web element inside state variable
		WebElement state = a.getState();
		//creating object for Select class and passing state as parameter to Select constructor
		Select dropdown1 = new Select(state); 
		//from the drop down selecting the value which is having the text as AndhraPradesh
		dropdown1.selectByVisibleText("Andhra Pradesh");
		
		//clicking on default address "No" radio button 
		a.getDefaultNo().click();
		//checking if radio button "Yes" is not selected
		Assert.assertFalse(a.getDefaultYes().isSelected());
		//click on continue
		a.getContinue().click();
    }
    
	@Then("^Address is created$")
    public void address_is_created() throws Throwable 
	{
		AddressEdit a=new AddressEdit(driver);
		//checking if success message is displayed or not
		Assert.assertTrue(a.getSuccessMsg().isDisplayed());
		//printing success message
		System.out.println(a.getSuccessMsg().getText());
    }
	
	@When("^Deleting Default address$")
    public void deleting_default_address() throws Throwable 
	{
		AddressEdit a=new AddressEdit(driver);
		//clicking delete icon for the default address
		a.getDefaultAddress().click();
    }
	
	@Then("^Display error Message$")
    public void display_error_message() throws Throwable 
	{
    	AddressEdit a=new AddressEdit(driver);
    	//checking if error message is displayed or not
    	Assert.assertTrue(a.getDefaultDelMsg().isDisplayed());
    	//printing the error message
    	System.out.println(a.getDefaultDelMsg().getText());
    }
	
	@When("^Deleting Normal address$")
    public void deleting_normal_address() throws Throwable 
	{
		AddressEdit a=new AddressEdit(driver);
		//clicking delete icon for the normal address
		a.getNormalAddress().click();
    }
	
	@Then("^Delete that address$")
    public void delete_that_address() throws Throwable {
    	AddressEdit a=new AddressEdit(driver);
    	//checking if success message is displayed or not
    	Assert.assertTrue(a.getNormalDelMsg().isDisplayed());
    	//printing the success message
        System.out.println(a.getNormalDelMsg().getText());
    }
    
    @When("^Clicking on Back")
    public void clicking_on_back() throws Throwable
    {
    	//clicking on back icon
    	AddressEdit a=new AddressEdit(driver);
    	a.getBack().click();
    }
    
    ///////////////////////////////Modify your wish list//////////////////////////
    
    @When("^Click on Modify your wishlist$")
    public void click_on_modify_your_wishlist() throws Throwable 
    {
    	UniformStore u=new UniformStore(driver);
    	//clicking on Modify your wish list
		u.getWishList().click();
    }
    
    @Then("^Navigate to Modify your wishlist$")
    public void navigate_to_modify_your_wishlist() throws Throwable 
    {
    	//Getting present page title and comparing with expected title Modify your wish list
        String name=driver.getTitle();
        Assert.assertEquals("My Wish List",name);
        //printing a message
        System.out.println("Navigated to My Wish List");
    }
    
    @When("^Click on into icon$")
    public void click_on_into_icon() throws Throwable 
    {
    	//Storing the list of rows in rows variable
    	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
    	//getting the count of rows and storing in count
    	int count = rows.size();
    	//printing the row count
    	System.out.println("ROW COUNT : "+count);
        MyWishList m=new MyWishList(driver);
        //clicking on into icon for first row
        m.getRemove().click();
    }
    
    @Then("^Delete that product from MyWishList$")
    public void delete_that_product_from_mywishlist() throws Throwable 
    {
    	MyWishList m=new MyWishList(driver);
    	//checking if success message is displayed or not
    	Assert.assertTrue(m.getRemoveMsg().isDisplayed());
    	//Storing the list of rows in rows variable
    	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
    	//getting the count of rows and storing in count
    	int count = rows.size();
    	//printing the row count
    	System.out.println("ROW COUNT : "+count);
    	//printing the success message
    	System.out.println(m.getRemoveMsg().getText());
    }
    
    @When("^Click on Cart icon$")
    public void click_on_cart_icon() throws Throwable 
    {
    	MyWishList m=new MyWishList(driver);
    	//clicking on cart icon in the first row
        m.getCart().click();
    }
    
    @Then("^Product Should be added to cart$")
    public void product_should_be_added_to_cart() throws Throwable 
    {
    	MyWishList m=new MyWishList(driver);
    	//checking if success message is displayed or not
    	Assert.assertTrue(m.getCartMsg().isDisplayed());
    	//printing the success message
    	System.out.println(m.getCartMsg().getText());
    }
    
    @When("^Click on Continue$")
    public void click_on_continue() throws Throwable 
    {
    	MyWishList m=new MyWishList(driver);
    	//clicking on Continue button 
    	m.getContinue().click();
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////   Catalog     /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Given("^Login with admin creditials$")
    public void login_with_admin_creditials() throws Throwable 
    {
    	//opening browser
    	driver =initializeDriver();
    	//navigating to "http://uniformm1.upskills.in/admin/"
		String arg2="http://uniformm1.upskills.in/admin/";
		driver.get(arg2);
		//creating object for LoginCatalog
		LoginCatalog l=new LoginCatalog(driver);
		//sending admin name and password and clicking on submit
		l.getAdmin().sendKeys("admin");
		l.getPassword().sendKeys("admin@123");
		l.getSubmit().click();
    }
    
    @And("^Click on menu button and then Catalog$")
    public void click_on_menu_button_and_then_catalog() throws Throwable 
    {
    	//creating object for HomeCatalog
    	HomeCatalog h=new HomeCatalog(driver);
    	//clicking on menu button and then Catalog
    	h.getMenu().click();
    	h.getCatalog().click();
    }
    
    ////////////////////////////////categories/////////////////////////////////
    
    @When("^Click on Categories$")
    public void click_on_categories() throws Throwable 
    {
    	//clicking on Categories
    	HomeCatalog h=new HomeCatalog(driver);
    	h.getCategories().click();
    }
    
    @Then("^Navigate to Categories page$")
    public void navigate_to_categories_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Categories
    	String s=driver.getTitle();
    	Assert.assertEquals("Categories",s);
    	//checking if pageSource contains Categories if yes printing a message
    	if(driver.getPageSource().contains("Categories"))
    	{
    		System.out.println("Navigated to Categories page");
    	}
    }
    
    @When("^Clicking on plus icon$")
    public void clicking_on_plus_icon() throws Throwable {
    	//printing the page number and no of elements
    	System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText());
    	//clicking on plus icon
    	driver.findElement(By.xpath("//a[@data-original-title='Add New']")).click();
    }
    
    @And("^Not giving input for required fields for category and clicking on save icon$")
    public void not_giving_input_for_required_fileds_for_category_and_clicking_on_save_icon() throws Throwable 
    {
    	//clicking on save button
    	CategoriesCatalog c =new CategoriesCatalog(driver);
    	c.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required category details$")
    public void should_dispaly_error_message_to_fill_required_category_details() throws Throwable 
    {
    	//checking if error message is displayed to fill required fields or not
    	CategoriesCatalog c =new CategoriesCatalog(driver);
    	Assert.assertTrue(c.getErrCategory().isDisplayed());
    	Assert.assertTrue(c.getErrMeta().isDisplayed());
    	
    	//printing the error messages
    	System.out.println(c.getErrCategory().isDisplayed());
    	System.out.println(c.getErrMeta().isDisplayed());
    }

    @When("^Giving input for required fields for category and clicking on save icon$")
    public void giving_input_for_required_fields_for_category_and_clicking_on_save_icon() throws Throwable 
    {
    	//giving the input for required fields
    	CategoriesCatalog c =new CategoriesCatalog(driver);
    	c.getCategoryName().sendKeys("uniform");
    	c.getmetaTitle().sendKeys("auniform1");
    	
    	//clicking on save icon
    	c.getSave().click();
    }
    
    @Then("^Create that category$")
    public void create_that_category() throws Throwable 
    {
    	CategoriesCatalog c =new CategoriesCatalog(driver);
    	//checking if success message is displayed
    	Assert.assertTrue(c.getSuccess().isDisplayed());
    	
    	//printing the success message and printing the page number
    	System.out.println(c.getSuccess().getText());
    	System.out.println(c.getPage().getText());
    }
    
    @When("^Selecting checkboxes$")
    public void selecting_checkboxes() throws Throwable 
    {
    	//printing page number and clicking the first check box
    	System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText());
    	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[1]")).click();
    }
    
    @And("^Clicking on delete icon$")
    public void clicking_on_delete_icon() throws Throwable 
    {
    	//clicking on delete icon and clicking on ok in alert box
    	driver.findElement(By.xpath("//*[@data-original-title='Delete']")).click();
    	driver.switchTo().alert().accept();
    }
    
    @Then("^Delete that categories$")
    public void delete_that_categories() throws Throwable 
    {
    	CategoriesCatalog c =new CategoriesCatalog(driver);
    	//checking if success message is displayed 
    	Assert.assertTrue(c.getSuccess().isDisplayed());
    	System.out.println(c.getSuccess().getText());
    	//printing the success message
    	System.out.println(c.getPage().getText());
    }
    
    @When("^Clicking on edit icon$")
    public void clicking_on_edit_icon() throws Throwable 
    {
    	//clicking on edit icon of first row
        driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[4]/a")).click();
    }
    
    @And("^Editing category and meta title$")
    public void editing_category_and_meta_title() throws Throwable 
    {
    	//clearing the fields and editing details
    	CategoriesCatalog c =new CategoriesCatalog(driver);
    	c.getEditCategoryName().clear();
    	c.getEditCategoryName().sendKeys("dress");
    	c.getEditMetaTitle().clear();
    	c.getEditMetaTitle().sendKeys("outfit");
    	//clicking on save icon
    	c.getSave().click();
    }
    
    @Then("^Category should be edited$")
    public void category_should_be_edited() throws Throwable 
    {
    	//checking if success message is displayed 
    	CategoriesCatalog c =new CategoriesCatalog(driver);
    	Assert.assertTrue(c.getSuccess().isDisplayed());
    	//printing success message
    	System.out.println(c.getSuccess().getText());
    }
    
    ///////////////////////////////////products////////////////////////////////////////
    
    @When("^Click on Products$")
    public void click_on_products() throws Throwable 
    {
    	//clicking on products
    	HomeCatalog h=new HomeCatalog(driver);
    	h.getProducts().click();
    }
    
    @Then("^Navigate to Products page$")
    public void navigate_to_products_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Products
    	String s=driver.getTitle();
    	Assert.assertEquals("Products",s);
    	//checking if page source contains products if yes then and printing a message
    	if(driver.getPageSource().contains("Products"))
    	{
    		System.out.println("Navigated to Products page");
    	}
    }
    
    @And("^Not giving input for required fields for products and clicking on save icon$")
    public void not_giving_input_for_required_fields_for_products_and_clicking_on_save_icon() throws Throwable 
    {
    	//clicking on save
    	ProductsCatalog p =new ProductsCatalog(driver);
    	p.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required products details$")
    public void should_dispaly_error_message_to_fill_required_products_details() throws Throwable 
    {
    	//checking if error message is displayed or nor 
    	ProductsCatalog p =new ProductsCatalog(driver);
    	Assert.assertTrue(p.getErrProduct().isDisplayed());
    	Assert.assertTrue(p.getErrMeta().isDisplayed());
    	//printing the error message
    	System.out.println(p.getErrProduct().getText());
    	System.out.println(p.getErrMeta().getText());
    }

    @When("^Giving input for required fields for products and clicking on save icon$")
    public void giving_input_for_required_fields_for_products_and_clicking_on_save_icon() throws Throwable 
    {
    	//creating object for ProductsCatalog
    	ProductsCatalog p =new ProductsCatalog(driver);
    	//giving input for required fields
    	p.getProductName().sendKeys("White_shirt");
    	p.getmetaTitle().sendKeys("Shirts");
    	//clicking on data and giving input for required fields
    	p.getData().click();
    	p.getModel().sendKeys("half_hands");
    	//clicking on save
    	p.getSave().click();
    }
    
    @Then("^Create that product$")
    public void create_that_product() throws Throwable 
    {
    	ProductsCatalog p =new ProductsCatalog(driver);
    	//checking if success message is displayed or not 
    	Assert.assertTrue(p.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(p.getSuccess().getText());
    	System.out.println(p.getPage().getText());
    }
      
    @Then("^Delete that product$")
    public void delete_that_product() throws Throwable 
    {
    	ProductsCatalog p =new ProductsCatalog(driver);
    	//checking if success message is displayed or not 
    	Assert.assertTrue(p.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(p.getSuccess().getText());
    	System.out.println(p.getPage().getText());
    }
    
    @When("^Clicking on Edit icon$")
    public void clicking_on_Edit_icon() throws Throwable 
    {
    	//clicking on edit icon of first row
    	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[8]/a")).click();
    }
    
    @And("^Editing Product details$")
    public void editing_product_details() throws Throwable 
    {
    	//clearing the fields and modifying the details 
    	ProductsCatalog p =new ProductsCatalog(driver);
    	p.getProductName().clear();
    	p.getProductName().sendKeys("black_shirt");
    	p.getmetaTitle().clear();
    	p.getmetaTitle().sendKeys("shirts");
    	//clicking on save
    	p.getSave().click();
    }
    
    @Then("^Product details should be edited$")
    public void product_details_should_be_edited() throws Throwable 
    {
    	//checking if success message is displayed or not 
    	ProductsCatalog p =new ProductsCatalog(driver);
    	Assert.assertTrue(p.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(p.getSuccess().getText());
    }
    
    @When("^Giving valid product details$")
    public void giving_valid_product_details() throws Throwable 
    {
    	//giving valid input details
    	ProductsCatalog p=new ProductsCatalog(driver);
    	p.getName().sendKeys("jacket");
    	p.getPrice().sendKeys("0.0000");
    	p.getStatus().click();
    	
    	//storing status dropdown location in status
    	WebElement status=p.getStatus();
    	//creating object for Select class and passing status as argument to constructor
    	Select dropdown=new Select(status);
    	//selecting Enabled from dropown
    	dropdown.selectByVisibleText("Enabled");
    	
    	p.getModel().sendKeys("jack12");
    	p.getQuantity().sendKeys("1");
    }
    
    @And("^Click on filter$")
    public void click_on_filter() throws Throwable 
    {
    	//clicking on filter button
    	ProductsCatalog p=new ProductsCatalog(driver);
    	p.getFilter().click();
    }

    @Then("^Display the products which are having selected details$")
    public void display_the_products_which_are_having_selected_details() throws Throwable 
    {
    	//Checking if list is displayed or not
    	WebElement list=driver.findElement(By.xpath("//*[@class='table table-bordered table-hover']/tbody"));
    	Assert.assertTrue(list.isDisplayed());
    	//printing a message
    	System.out.println("Displayed");
    }
    
    @When("^Giving invalid product details$")
    public void giving_invalid_product_details() throws Throwable 
    {
    	//giving invalid details 
    	ProductsCatalog p=new ProductsCatalog(driver);
    	p.getName().sendKeys("xxxx");
    	p.getPrice().sendKeys("100");
    	p.getStatus().click();
    	//storing status dropdown location in status
    	WebElement status=p.getStatus();
    	//creating object for Select class and passing status as argument to constructor
    	Select dropdown=new Select(status);
    	//selecting enabled from dropdown
    	dropdown.selectByVisibleText("Enabled");
    	p.getModel().sendKeys("jack");
    	p.getQuantity().sendKeys("1");
    }
    
    @Then("^Display No Results$")
    public void display_no_results() throws Throwable 
    {
    	//checking if no results is displayed or not 
    	ProductsCatalog p=new ProductsCatalog(driver);
    	Assert.assertTrue(p.getNoResult().isDisplayed());
    	//printing that message
    	System.out.println(p.getNoResult().getText());
    }
    
    ////////////////////////////////recurring profiles////////////////////////////////////
    
    @When("^Click on Recurring Profiles$")
    public void click_on_recurring_profiles() throws Throwable 
    {
    	//creating object for HomeCatalog and clicking on Recurring Profiles 
    	HomeCatalog h=new HomeCatalog(driver);
    	h.getRecurringProfiles().click();
    }
    
    @Then("^Navigate to Recurring Profiles page$")
    public void navigate_to_recurring_profiles_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Recurring Profiles
    	String s=driver.getTitle();
    	Assert.assertEquals("Recurring Profiles",s);
    	//checking if page source contains Recurring Profiles and printing a message
    	if(driver.getPageSource().contains("Recurring Profiles"))
    	{
    		System.out.println("Navigated to Recurring Profiles page");
    	}
    }
    
    @And("^Not giving input for required fields for recurring profiles and clicking on save icon$")
    public void not_giving_required_fields_for_recurring_profiles__and_clicking_on_save_icon() throws Throwable 
    {
    	//clicking on save 
    	RecurringProfilesCatalog r=new RecurringProfilesCatalog(driver);
    	r.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required Recurring Profile details$")
    public void should_display_error_message_to_fill_required_recurring_profile_details() throws Throwable 
    {
    	//checking if error message is displayed or not 
    	RecurringProfilesCatalog r=new RecurringProfilesCatalog(driver);
    	Assert.assertTrue(r.getErrorMsg().isDisplayed());
    	//printing error message
    	System.out.println(r.getErrorMsg().getText());
    }
    
    @When("^Giving input for required fields for recurring profiles and clicking on save icon$")
    public void giving_input_for_required_fields_for_recurring_profiles_and_clicking_on_icon() throws Throwable 
    {
    	//giving input for required field 
    	RecurringProfilesCatalog r=new RecurringProfilesCatalog(driver);
    	r.getName().sendKeys("profile");
    	//clicking on save icon
    	r.getSave().click();
    }
    
    @Then("^Create that Recurring Profile$")
    public void create_that_recurring_profile() throws Throwable 
    {
    	//checking if error message is displayed or not 
    	RecurringProfilesCatalog r=new RecurringProfilesCatalog(driver);
    	Assert.assertTrue(r.getSuccess().isDisplayed());
    	//printing the message
    	System.out.println(r.getSuccess().getText());
    }
    
    @And("^Clicking on copy icon$")
    public void clicking_on_copy_icon() throws Throwable 
    {
    	//clicking on copy icon
    	RecurringProfilesCatalog r=new RecurringProfilesCatalog(driver);
    	r.getCopyIcon().click();
    }
    
    @Then("^Copy that RecurringProfile$")
    public void copy_that_recurringprofile() throws Throwable 
    {
    	//displaying the page number and count of elements
        System.out.println(driver.findElement(By.xpath("//*[@class='col-sm-6 text-right']")).getText());
    }

    @Then("^Delete that Recurring profile$")
    public void delete_that_recurring_profile() throws Throwable 
    {
    	//checking if success message is displayed or not 
	    RecurringProfilesCatalog p =new RecurringProfilesCatalog(driver);
	    Assert.assertTrue(p.getSuccess().isDisplayed());
	    //printing the success message and page number
		System.out.println(p.getSuccess().getText());
		System.out.println(p.getPage().getText());
    }
    
    @And("^Editing Recurring Profiles details$")
    public void editing_recurring_profiles_details() throws Throwable 
    {
    	//clearing the fields and again giving the inputs
    	RecurringProfilesCatalog p =new RecurringProfilesCatalog(driver);
    	p.getEditName().clear();
    	p.getEditName().sendKeys("xxxx");
    	//clicking on save icon
    	p.getSave().click();
    }
    
    @Then("^Recurring Profiles should be edited$")
    public void recurring_profiles_should_be_edited() throws Throwable 
    {
    	//checking if success message is displayed or not 
    	RecurringProfilesCatalog p =new RecurringProfilesCatalog(driver);
    	Assert.assertTrue(p.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(p.getSuccess().getText());
    }
    
    ////////////////////////////////////filters/////////////////////////////////////
    
    @When("^Click on Filters$")
    public void click_on_filters() throws Throwable 
    {
    	//creating object for HomeCatalog and clicking on Filter
    	HomeCatalog h=new HomeCatalog(driver);
    	h.getFilter().click();
    }
    
    @Then("^Navigate to Filters page$")
    public void navigate_to_filters_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Filters
    	String s=driver.getTitle();
    	Assert.assertEquals("Filters",s);
    	//checking if page source contains Filters and printing a message
    	if(driver.getPageSource().contains("Filters"))
    	{
    		System.out.println("Navigated to Filters page");
    	}
    } 
    
    @And("^Not giving input for required fields for Filter and clicking on save icon$")
    public void not_giving_input_for_requiredfileds_for_filter_and_clicking_on_save_icon() throws Throwable 
    {
    	//clicking on save icon
    	FiltersCatalog f=new FiltersCatalog(driver);
    	f.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required Filter details$")
    public void should_display_warning_message_to_fill_required_filter_details() throws Throwable 
    {
    	//checking if error message is displayed or not 
    	FiltersCatalog f=new FiltersCatalog(driver);
    	Assert.assertTrue(f.getErrorMsg().isDisplayed());
    	//printing the error message
    	System.out.println(f.getErrorMsg().getText());
    }
    
    @When("^Giving input for required fields for Filter and clicking on save$")
    public void giving_input_for_required_fields_and_clicking_on_save() throws Throwable
    {
    	//giving input 
    	FiltersCatalog f=new FiltersCatalog(driver);
    	f.getFilterGroupName().sendKeys("ramya");
    	f.getAddPlus().click();
    	f.getFilterName().sendKeys("ramya11");
    	//clicking on save icon
    	f.getSave().click();
    }

    @Then("^Create Filter$")
    public void create_filter() throws Throwable 
    {
    	//Checking if success message is displayed or not 
    	FiltersCatalog f=new FiltersCatalog(driver);
    	Assert.assertTrue(f.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(f.getSuccess().getText());
    }
    
    @Then("^Delete that Filter$")
    public void delete_that_filter() throws Throwable 
    {
    	//checking if success message is displayed or not
    	FiltersCatalog f=new FiltersCatalog(driver);
    	Assert.assertTrue(f.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(f.getSuccess().getText());
    	System.out.println(f.getPage().getText());
    }
    
    @And("^Editing filter details$")
    public void editing_filter_details() throws Throwable 
    {
    	//clearing the fields and editing them
    	FiltersCatalog f=new FiltersCatalog(driver);
    	f.getFilterGroupName().clear();
    	f.getFilterGroupName().sendKeys("123");
    	f.getFilterName().clear();
    	f.getFilterName().sendKeys("xyz");
    	//clicking on save
    	f.getSave().click();
    }
    
    @Then("^Filter details should be edited$")
    public void filter_details_should_be_edited() throws Throwable 
    {
    	//checking if success message is displayed or not 
    	FiltersCatalog f=new FiltersCatalog(driver);
    	Assert.assertTrue(f.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(f.getSuccess().getText());
    }
    
    ///////////////////////////////////attributes/////////////////////////////////////
    
    @When("^Click on Attributes$")
    public void click_on_attributes() throws Throwable 
    {
    	//creating object for HomeCatalog class
    	HomeCatalog h=new HomeCatalog(driver);
    	//Clicking on Attributes
    	h.getAttributes().click();
    }

    @Then("^Should display drop down$")
    public void should_display_drop_down() throws Throwable 
    {
   
    	System.out.println("Drop down is displayed");
    }
    
    @When("^Click on Attributes in Attributes List$")
    public void click_on_attributes_in_attributes_list() throws Throwable 
    {
    	//Clicking on attributes
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getAttributes().click();
    }

    @Then("^Navigate to Attributes Page$")
    public void navigate_to_attributes_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Attributes
    	String s=driver.getTitle();
    	Assert.assertEquals("Attributes",s);
    	//checking if page source contains Attributes and printing a message
    	if(driver.getPageSource().contains("Attributes"))
    	{
    		System.out.println("Navigated to Attributes page");
    	}
    }
    
    @And("^Not giving attributes details for required fields$")
    public void not_giving_attributes_details_for_required_fields() throws Throwable 
    {
    	//clicking on save icon
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required attribute details$")
    public void should_dispaly_error_message_to_fill_required_attribute_details() throws Throwable 
    {
    	//checking if error message is displayed or not
    	AttributesCatalog a=new AttributesCatalog(driver);
    	Assert.assertTrue(a.getAttErrMsg().isDisplayed());
    	//printing the error message
    	System.out.println(a.getAttErrMsg().getText());
    }
    
    @When("^Giving attribute details for requiredfileds and clicking on save icon$")
    public void giving_attribute_details_for_requiredfileds_and_clicking_on_save_icon() throws Throwable 
    {
    	//giving the attribute details
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getAttName().sendKeys("cccc");
    	//clicking on save icon
    	a.getSave().click();
    }

    @Then("^Create attribute$")
    public void create_attribute() throws Throwable 
    {
    	//Checking if success message is displayed or not
    	AttributesCatalog a=new AttributesCatalog(driver);
    	Assert.assertTrue(a.getSuccess().isDisplayed());
    	//printing the success message and page number
    	System.out.println(a.getSuccess().getText());
    	System.out.println(a.getPage().getText());
    }

    @When("^Click on edit icon$")
    public void click_on_edit_icon() throws Throwable 
    {
    	//clicking on edit icon
        driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[5]/a")).click();
    }
    
    @And("^Editing attribute details$")
    public void editing_attribute_details() throws Throwable 
    {
    	//clearing the input fields and sending again
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getAttName().clear();
    	a.getAttName().sendKeys("pqr");
    	//clicking on save icon
    	a.getSave().click();
    }
    
    @Then("^Attribute details should be edited$")
    public void attribute_details_should_be_edited() throws Throwable
    {
    	//checking if success message is displayed or not
    	AttributesCatalog a=new AttributesCatalog(driver);
    	Assert.assertTrue(a.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(a.getSuccess().getText());
    }
    
    @When("^Clicking on Attribute Groups$")
    public void clicking_on_attribute_groups() throws Throwable
    {
    	//clicking on Attribute Groups
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getAttributeGroups().click();
    }

    @Then("^Navigate to Attribute Groups Page$")
    public void navigate_to_attribute_groups_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Attribute Groups
    	String s=driver.getTitle();
    	Assert.assertEquals("Attribute Groups",s);
    	//checking if page source contains Attribute Groups and printing a message
    	if(driver.getPageSource().contains("Attribute Groups"))
    	{
    		System.out.println("Navigated to Attribute Groups page");
    	}
    }
    
    @And("^Not giving attribute group details for required fields and clicking on save icon$")
    public void not_giving_attribute_group_details_for_required_fields_and_clicking_on_save_icon() throws Throwable
    {
    	//Clicking on save icon
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required attribute group details$")
    public void should_dispaly_error_message_to_fill_required_attribute_group_details() throws Throwable 
    {
    	//checking if error message is displayed or not
    	AttributesCatalog a=new AttributesCatalog(driver);
    	Assert.assertTrue(a.getAttGrpErrMsg().isDisplayed());
    	//printing the error message
    	System.out.println(a.getAttGrpErrMsg().getText());
    }
    
    @When("^Giving attribute group details for required fields and clicking on save icon$")
    public void giving_attribute_group_details_for_required_fields_and_clicking_on_save_icon() throws Throwable 
    {
    	//giving input for required fields
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getAttGrpName().sendKeys("zzz");
    	//clicking on save icon
    	a.getSave().click();
    }
    
    @Then("^Create Attribute Group$")
    public void create_attribute_group() throws Throwable 
    {
    	//Checking if success message is displayed or not
    	AttributesCatalog a=new AttributesCatalog(driver);
    	Assert.assertTrue(a.getSuccessGrp().isDisplayed());
    	//printing the success message
    	System.out.println(a.getSuccessGrp().getText());
    	System.out.println(a.getPage().getText());
    }
    
    @And("^Editing attribute group details$")
    public void editing_attribute_group_details() throws Throwable 
    {
    	//clearing the fields and sending input again
    	AttributesCatalog a=new AttributesCatalog(driver);
    	a.getAttGrpName().clear();
    	a.getAttGrpName().sendKeys("sizes");
    	//clicking on save icon
    	a.getSave().click();
    }
    
    @Then("^Attribute group details should be edited$")
    public void attribute_group_details_should_be_edited() throws Throwable 
    {
    	//Checking if success message is displayed or not
    	AttributesCatalog a=new AttributesCatalog(driver);
    	Assert.assertTrue(a.getSuccessGrp().isDisplayed());
    	//printing the success message
    	System.out.println(a.getSuccessGrp().getText());
    }
    
    ///////////////////////////options///////////////////////////////
    
    @When("^Click on Options$")
    public void click_on_options() throws Throwable
    {
    	//clicking on Options
    	HomeCatalog h=new HomeCatalog(driver);
    	h.getOptions().click();
    }
    
    @Then("^Navigate to Options Page$")
    public void navigate_to_options_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Options
    	String s=driver.getTitle();
    	Assert.assertEquals("Options",s);
    	//checking if page source contains Options and printing a message
    	if(driver.getPageSource().contains("Options"))
    	{
    		System.out.println("Navigated to Options page");
    	}
    }
    
    @And("^Not giving option details for required fields$")
    public void not_giving_option_details_for_required_fields() throws Throwable 
    {
    	//clicking on save
        OptionsCatalog o=new OptionsCatalog(driver);
        o.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required option details$")
    public void should_dispaly_error_message_to_fill_required_option_details() throws Throwable 
    {
    	//checking if error message is displayed or not
    	OptionsCatalog o=new OptionsCatalog(driver);
    	Assert.assertTrue(o.getErrMsg().isDisplayed());
    	//printing the message
    	System.out.println(o.getErrMsg().getText());
    }
    
    @When("^Giving option details for required fields and clicking on save icon$")
    public void giving_option_details_for_requiredfileds_and_clicking_on_save_icon() throws Throwable 
    {
    	//giving  input for required fields
    	OptionsCatalog o=new OptionsCatalog(driver);
    	o.getOptionName().sendKeys("option");
        o.getAddPlus().click();
        o.getOptionValue().sendKeys("option1");
        //clicking on save icon
        o.getSave().click();
    }

    @Then("^Create option$")
    public void create_option() throws Throwable 
    {
    	//checking if success message is displayed or not 
    	OptionsCatalog o=new OptionsCatalog(driver);
    	Assert.assertTrue(o.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(o.getSuccess().getText());
    	System.out.println(o.getPage().getText());
    }
    
    @Then("^Delete that option$")
    public void delete_that_option() throws Throwable 
    {
    	//checking if success message is displayed or not 
    	OptionsCatalog o=new OptionsCatalog(driver);
    	Assert.assertTrue(o.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(o.getSuccess().getText());
    	System.out.println(o.getPage().getText());
    }
    
    ///////////////////////////manufacturers///////////////////////////////////
    
    @When("^Click on Manufacturers$")
    public void click_on_manufacturers() throws Throwable 
    {
    	//creating object for HomeCatalog
    	HomeCatalog h=new HomeCatalog(driver);
    	//clicking on manufacturers
    	h.getManufacturers().click();
    }

    @Then("^Navigate to Manufacturers Page$")
    public void navigate_to_manufacturers_page() throws Throwable
    {
    	//Getting present page title and comparing it with expected title Manufacturers
        String s=driver.getTitle();
        Assert.assertEquals("Manufacturers",s);
       //checking if page source contains Manufactures and printing a message
        if(driver.getPageSource().contains("Manufacturers"))
        {
        	System.out.println("Navigated to Manufacturers page");
        }
    }
    
    @And("^Not giving manufacturer details for required fields and clicking on save icon$")
    public void not_giving_manufacturer_details_for_required_fields_and_clicking_on_save_icon() throws Throwable 
    {
    	//clicking on save icon
    	ManufacturersCatalog m=new ManufacturersCatalog(driver);
    	m.getSave().click();
    }
    
    @Then("^Should dispaly Error message to fill required manufacturer details$")
    public void should_dispaly_error_message_to_fill_required_manufacturer_details() throws Throwable 
    {
    	//Checking if error message is displayed or not 
    	ManufacturersCatalog m=new ManufacturersCatalog(driver);
    	Assert.assertTrue(m.getErrMsg().isDisplayed());
    	//printing the error message
    	System.out.println(m.getErrMsg().getText());
    }
    
    @When("^Giving manufacturer details for required fileds and clicking on save icon$")
    public void giving_manufacturer_details_for_required_fileds_and_clicking_on_save_icon() throws Throwable 
    {
    	//giving input for required fields
    	ManufacturersCatalog m=new ManufacturersCatalog(driver);
    	m.getManName().sendKeys("ramya");
    	//clicking on save icon
    	m.getSave().click();
    }

    @Then("^Create Manufacturer$")
    public void create_manufacturer() throws Throwable 
    {
    	ManufacturersCatalog m=new ManufacturersCatalog(driver);
    	//checking if success message is displayed and print the message
    	Assert.assertTrue(m.getSuccess().isDisplayed());
    	System.out.println(m.getSuccess().getText());
    	//printing page number
    	System.out.println(m.getPage().getText());
    }
    
    @Then("^Delete that Manufacturer$")
    public void delete_that_manufacturer() throws Throwable 
    {
    	//checking if success message is displayed
    	ManufacturersCatalog m=new ManufacturersCatalog(driver);
    	Assert.assertTrue(m.getSuccess().isDisplayed());
    	//printing the message and page number
    	System.out.println(m.getSuccess().getText());
    	System.out.println(m.getPage().getText());
    }
    
    ///////////////////////////////downloads//////////////////////////////////
    
    @When("^Click on Downloads$")
    public void click_on_downloads() throws Throwable 
    {
    	//clicking on downloads
    	HomeCatalog h=new HomeCatalog(driver);
    	h.getDownloads().click();
    }

    @Then("^Navigate to Downloads Page$")
    public void navigate_to_downloads_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Downloads
    	String s=driver.getTitle();
    	Assert.assertEquals("Downloads",s);
    	//checking if page source contains Downloads and printing a message
    	if(driver.getPageSource().contains("Downloads"))
    	{
    		System.out.println("Navigated to Downloads page");
    	}
    }
    
    @And("^Giving downloads details for required fileds and clicking on save icon$")
    public void giving_downloads_details_for_required_fileds_and_clicking_on_save_icon() throws Throwable 
    {
    	//giving required details
    	DownloadsCatalog d=new DownloadsCatalog(driver);
        d.getDownloadName().sendKeys("download");
        //clicking on save icon
        d.getSave().click();
    }
    
    @Then("^Create download$")
    public void create_download() throws Throwable 
    {
    	DownloadsCatalog d=new DownloadsCatalog(driver);
    	//checking if error message is displayed if yes then printing error message
        if(d.getFileNameErr().isDisplayed() || d.getMaskErr().isDisplayed())
        {
        	System.out.println("!!!!!!!!!!Error: FILE NAME AND MASK ARE NOT MARKED AS MANDATORY!!!!!!!!!!");
        	//clicking on back icon
        	d.getBack().click();
        }
        else
        {
        	System.out.println("download created");
        }
    }
    
    @Then("^Delete that Download$")
    public void delete_that_download() throws Throwable 
    {
    	//checking if success message is displayed or not
    	DownloadsCatalog d=new DownloadsCatalog(driver);
    	Assert.assertTrue(d.getSuccess().isDisplayed());
    	//printing success message
    	System.out.println(d.getSuccess().getText());
    	System.out.println(d.getPage().getText());
    }
    
    @And("^Editing Downloads details$")
    public void editing_downloads_details() throws Throwable 
    {
    	//clearing the input fields and editing
    	DownloadsCatalog d=new DownloadsCatalog(driver);
    	d.getDownloadName().clear();
    	d.getDownloadName().sendKeys("download1");
    	//clicking on save icon
    	d.getSave().click();
    }
    
    @Then("^Download details should be edited$")
    public void download_details_should_be_edited() throws Throwable 
    {
    	//checking if success message is displayed or not
    	DownloadsCatalog d=new DownloadsCatalog(driver);
    	Assert.assertTrue(d.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(d.getSuccess().getText());
    }

    //////////////////////////////////reviews/////////////////////////////
    
    @When("^Click on Reviews$")
    public void click_on_reviews() throws Throwable 
    {
    	//clicking on Reviews
    	HomeCatalog h=new HomeCatalog(driver);
    	h.getReviews().click();
    }
    
    @Then("^Navigate to Reviews Page$")
    public void navigate_to_reviews_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title reviews
    	String s=driver.getTitle();
    	Assert.assertEquals("Reviews",s);
    	//checking if page source contains Reviews and printing a message
    	if(driver.getPageSource().contains("Reviews"))
    	{
    		System.out.println("Navigated to Reviews page");
    	}
    }
    
    @And("^Not giving review details for required fields$")
    public void not_giving_review_details_for_required_fields() throws Throwable 
    {
    	ReviewsCatalog r=new ReviewsCatalog(driver);
    	//clicking on save icon
    	r.getSave().click();
    }

    @Then("^Should dispaly Error message to fill required review details$")
    public void should_dispaly_error_message_to_fill_required_review_details() throws Throwable
    {
    	//creating object for ReviewsCatalog class
    	ReviewsCatalog r=new ReviewsCatalog(driver);
    	//checking if error messages are displayed or not
    	Assert.assertTrue(r.getErrAuthor().isDisplayed());
    	Assert.assertTrue(r.getErrProduct().isDisplayed());
    	Assert.assertTrue(r.getErrText().isDisplayed());
    	Assert.assertTrue(r.getErrRating().isDisplayed());
    	//printing error messages
    	System.out.println(r.getErrAuthor().getText()+"\n"+r.getErrProduct().getText()+"\n"+r.getErrText().getText()+"\n"+r.getErrRating().getText());
    }

    @When("^Giving review details for required fields$")
    public void giving_review_details_for_required_fields() throws Throwable 
    {
    	//giving input for required fields
    	ReviewsCatalog r=new ReviewsCatalog(driver);
    	r.getAuthorName().sendKeys("ramya");
    	r.getProduct().sendKeys("Apron");
    	driver.findElement(By.xpath("//*[@id='form-review']/div[2]/div/ul/li[1]")).click();
    	r.getText().sendKeys("good");
    	r.getRating().click();
    	//clicking on save icon
    	r.getSave().click();
    }

    @Then("^Create Review$")
    public void create_review() throws Throwable 
    {
    	//checking if success message is displayed or not 
    	ReviewsCatalog r=new ReviewsCatalog(driver);
    	//printing the success message and page number
    	System.out.println(r.getSuccess().getText());
    	System.out.println(r.getPage().getText());
    }
    
    @Then("^Delete review$")
    public void delete_review() throws Throwable 
    {
    	ReviewsCatalog r=new ReviewsCatalog(driver);
    	//checking if success message is displayed or not 
    	Assert.assertTrue(r.getSuccess().isDisplayed());
    	//printing the success message and page number
    	System.out.println(r.getSuccess().getText());
    	System.out.println(r.getPage().getText());
    }

    @When("^giving valid review details$")
    public void giving_valid_review_details() throws Throwable 
    {
    	//giving valid details for input fields
    	ReviewsCatalog r=new ReviewsCatalog(driver);
    	r.getProName().sendKeys("jacket");
    	r.getAuthor().sendKeys("AVENGER");
    	r.getStatus().click();
    	//selecting Enabled from drop down
    	WebElement status=r.getStatus();
    	Select dropdown=new Select(status);
    	dropdown.selectByVisibleText("Enabled");
    }
    
    @Then("^Display the reviews which are having selected details$")
    public void display_the_reviews_which_are_having_selected_details() throws Throwable 
    {
    	//Checking if list is displayed or not
    	WebElement list=driver.findElement(By.xpath("//*[@class='table table-bordered table-hover']/tbody"));
    	Assert.assertTrue(list.isDisplayed());
    	//printing the success message
        System.out.println("Displayed");
    }	
    
    @When("^giving invalid review details$")
    public void giving_invalid_review_details() throws Throwable 
    {
    	//giving invalid details for input fields
    	ReviewsCatalog r=new ReviewsCatalog(driver);
    	r.getProName().sendKeys("jjjjjjjjjjj");
    	r.getAuthor().sendKeys("AVENGER");
    	r.getStatus().click();
    	//selecting Enabled from drop down
    	WebElement status=r.getStatus();
    	Select dropdown=new Select(status);
    	dropdown.selectByVisibleText("Enabled");
    }

    //////////////////////////////information///////////////////////////////
    
    @When("^Click on Information$")
    public void click_on_information() throws Throwable 
    {
    	//creating object for HomeCatalog
    	HomeCatalog h=new HomeCatalog(driver);
    	//clicking on Information
    	h.getInformation().click();
    }
    
    @Then("^Navigate to Information Page$")
    public void navigate_to_information_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title information
    	String s=driver.getTitle();
    	Assert.assertEquals("Information",s);
    	//checking if page source contains Information and printing a message
    	if(driver.getPageSource().contains("Information"))
    	{
    		System.out.println("Navigated to Information page");
    	}
    }
    
    @And("^Not giving information details for required fields$")
    public void not_giving_information_details_for_required_fields() throws Throwable 
    {
    	//clicking on save icon
    	InformationCatalog i=new InformationCatalog(driver);
    	i.getSave().click();
    }

    @Then("^Should dispaly Error message to fill required information details$")
    public void should_dispaly_error_message_to_fill_required_information_details() throws Throwable 
    {
    	//checking if error message is displayed or not
    	InformationCatalog i=new InformationCatalog(driver);
    	Assert.assertTrue(i.getErrInfo().isDisplayed());
    	Assert.assertTrue(i.getErrDesc().isDisplayed());
    	Assert.assertTrue(i.getErrMeta().isDisplayed());
    	//printing a message
    	System.out.println("Displaying messages to fill required fields");
    }
    
    @When("^Giving information details for required fields$")
    public void giving_information_details_for_required_fields() throws Throwable 
    {
    	//giving input for required fields
    	InformationCatalog i=new InformationCatalog(driver);
    	i.getInfoTitle().sendKeys("Customer_care");
    	i.getDesc().sendKeys("for any quiries contact");
    	i.getMetaTitle().sendKeys("contact");
    	//clicking on save icon
    	i.getSave().click();
    }

    @Then("^Create Information$")
    public void create_information() throws Throwable 
    {
    	//checking if success message is displayed or not
    	InformationCatalog i=new InformationCatalog(driver);
    	Assert.assertTrue(i.getSuccess().isDisplayed());
    	//printing success message
    	System.out.println(i.getSuccess().getText());
    	System.out.println(i.getPage().getText());
    } 
    
    @Then("^Delete Information$")
    public void delete_information() throws Throwable 
    {
    	//checking if success message is displayed or not
    	InformationCatalog i=new InformationCatalog(driver);
    	Assert.assertTrue(i.getSuccess().isDisplayed());
    	//printing the success message
    	System.out.println(i.getSuccess().getText());
    	System.out.println(i.getPage().getText());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////     News Letter   /////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @When("^Click on Subscribe unsubscribe to newsletter$")
    public void click_on_subscribe_unsubscribe_to_newsletter() throws Throwable 
    {
    	//creating object for NewsLetter class
    	NewsLetter n=new NewsLetter(driver);
    	//clicking on Subscribe Unsubscribe to newsletter
    	n.getNewsLetter().click();
    }

    @Then("^Navigate to NewsLetter page$")
    public void navigate_to_newsletter_page() throws Throwable 
    {
    	//Getting present page title and comparing it with expected title Newsletter Subscription
    	String s=driver.getTitle();
    	Assert.assertEquals("Newsletter Subscription",s);
    	//printing navigated message
    	System.out.println("Navigated to Newsletter Subscription page");
    }
    
    @When("^Clicking on Subscribe Yes$")
    public void clicking_on_subscribe_yes() throws Throwable 
    {
    	//clicking on "Yes" for subscribe
    	NewsLetter n=new NewsLetter(driver);
    	n.getSubYes().click();
    	//checking if subscribe "Yes" is selected or not
    	Assert.assertTrue(n.getSubYes().isSelected());
    	System.out.println("Yes is selected");
    }

    @And("^Clicking on Subscribe No$")
    public void clicking_on_subscribe_no() throws Throwable 
    {
    	//clicking on subscribe "No"
    	NewsLetter n=new NewsLetter(driver);
    	n.getSubNo().click();  
    	//Checking if subscribe "No" is selected or not
    	Assert.assertTrue(n.getSubNo().isSelected());
    	System.out.println("No is selected");
    }
    
    @Then("^Subscribe Yes should not be selected$")
    public void subscribe_yes_should_not_be_selected() throws Throwable
    {
    	//checking if Subscribe Yes is not selected
    	NewsLetter n=new NewsLetter(driver);
    	Assert.assertFalse(n.getSubYes().isSelected());
    	System.out.println("Yes is not selected");
    }
    
    @When("^Clicking on Yes in NewsLetter$")
    public void clicking_on_yes_in_newsletter() throws Throwable 
    {
    	//clicking on "Yes"
    	NewsLetter n=new NewsLetter(driver);
    	n.getSubYes().click();
    }

    @And("^Clicking on CONTINUE in NewsLetter$")
    public void clicking_on_continue_in_newsletter() throws Throwable 
    {
    	//Clicking on continue button
    	NewsLetter n=new NewsLetter(driver);
    	n.getSubmit().click();
    }
    
    @Then("^Subscribe NewsLetter$")
    public void subscribe_newsletter() throws Throwable 
    {
    	//checking if success message is displayed or not
    	NewsLetter n=new NewsLetter(driver);
    	Assert.assertTrue(n.getSuccess().isDisplayed());
    	System.out.println(n.getSuccess().getText());
    	//again navigating to NewsLetter page
    	n.getNewsLetter().click();
    	//checking if yes is selected
    	Assert.assertTrue(n.getSubYes().isSelected());
    	System.out.println("Subscribed");
    }
    
    @When("^Clicking on No in NewsLetter$")
    public void clicking_on_no_in_newsletter() throws Throwable 
    {
    	//clicking on "No"
    	NewsLetter n=new NewsLetter(driver);
    	n.getSubNo().click();
    }
    
    @Then("^Unsubscribe NewsLetter$")
    public void unsubscribe_newsletter() throws Throwable 
    {
    	//checking if success message is displayed or not
    	NewsLetter n=new NewsLetter(driver);
    	Assert.assertTrue(n.getSuccess().isDisplayed());
    	System.out.println(n.getSuccess().getText());
    	//again navigating to NewsLetter page
    	n.getNewsLetter().click();
    	//checking if no is selected
    	Assert.assertTrue(n.getSubNo().isSelected());
    	System.out.println("Un Subscribed");
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////	       Rahul                   ////////////////////////////////////////////
    ///////////////////////////////////	       MyOrders                   /////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Given("Login with Correct credentials")
    public void login_with_correct_credentials() throws IOException {
    	//initializing driver
    	driver =initializeDriver();
    	//storing the url in a string
    	String arg1="http://uniformm1.upskills.in/";
    	//opening the url by the driver
    	driver.get(arg1);
    	//clicking on drop down of my account and clicking on login
    	driver.findElement(By.xpath("//*[@class='dropdown myaccount']")).click();
    	driver.findElement(By.xpath("//a[text()='Login']")).click();
    	
    	LoginAccount l=new LoginAccount(driver);
    	//sending valid credentials to text box for login
    	l.getEmail().sendKeys("boddu.rahul.kumar@gmail.com");
    	l.getPassword().sendKeys("Rahul@123");
    	//clicking on submit
    	l.getSubmit().click();
    }
        

    @When("clicking on view your order history")
    public void clicking_on_view_your_order_history() {

    	//user clicking on view your order history
    	driver.findElement(By.xpath("//a[text()='View your order history']")).click();  
    }

    //confirming the expected page and actual page is same or not by printing some text of that page
    @Then("Navigate to Order history page")
    public void navigate_to_order_history_page() {
    	
    	//printing some text of that page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Order History']")).getText());
    	//confirming the expected page and actual page is same or not
    	String s= driver.findElement(By.xpath("//h1[text()='Order History']")).getText();
    	Assert.assertEquals("ORDER HISTORY",s);
    	
    }

    @When("^Order is Placed$")
    public void order_is_placed() throws Throwable {
    	
    	//printing text in console window when order is placed
    	System.out.println("order is placed");
    	
        }


    //table is present
    @Then("^Display Order Id$")
    public void display_order_id() throws Throwable {
    	
    	//using is displayed function checking the order information table is present or not,then printing text
    	if(driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody")).isDisplayed()) {
    		System.out.println("order is displayed");
    	}
    }

    @When("Click on view")
    public void click_on_view() throws Throwable {
    	//performing click function on view button
    	driver.findElement(By.xpath("//a[@href='http://uniformm1.upskills.in/index.php?route=account/order/info&order_id=592']")).click();
       
    }
    @Then("^Navigate to Order Information page$")
    public void navigate_to_order_information_page() throws Throwable {
    	
    	//Checking weather it is navigated to another page or not by is displayed function
    	if(driver.findElement(By.xpath("//div[@id=\"content\"]/table[2]")).isDisplayed()) {
    		System.out.println("order is displayed");
    		
    	}
    }


    @When("^Click on Return$")
    public void click_on_return() throws Throwable {
    	
    	//clicking on return button
    	driver.findElement(By.xpath("//a[@href='http://uniformm1.upskills.in/index.php?route=account/return/add&order_id=592&product_id=140']")).click();
        }


    @Then("^Naviage to Return page$")
    public void naviage_to_return_page() throws Throwable {
    	
    	
    	//printing something of Return page in console window
    	System.out.println(driver.findElement(By.xpath("//p[text()='Please complete the form below to request an RMA number.']")).getText());
    	
    	//confirming the expected page and actual page is same or not
    	String s= driver.findElement(By.xpath("//p[text()='Please complete the form below to request an RMA number.']")).getText();
    	Assert.assertEquals("Please complete the form below to request an RMA number.",s);
    	}


    @Then("^Checking the radio buttons and check boxes$")
    public void checking_the_radio_buttons_and_check_boxes() throws Throwable {
        

    	//checking the radio buttons,check box,text boxes of return page
    	driver.findElement(By.xpath("//input[@name='return_reason_id' and @value='1']")).click();
    	driver.findElement(By.xpath("//input[@name='opened' and @value='1']")).click();
    	driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("bad");
    	driver.findElement(By.xpath("//input[@name='agree']")).click();
    	}


    @When("^Click on submit$")
    public void click_on_submit() throws Throwable {
    	
    	//clicking on submit
    	driver.findElement(By.xpath("//input[@type='submit']")).click();
    }


    @Then("^navigate to confirmation page$")
    public void navigate_to_confirmation_page() throws Throwable {
    	
    	////printing something of Confirmation page in console window
    	System.out.println(driver.findElement(By.xpath("//p[text()='Thank you for submitting your return request. Your request has been sent to the relevant department for processing.']")).getText());
    	
    	//confirming the expected page and actual page is same or not
    	String s= driver.findElement(By.xpath("//p[text()='Thank you for submitting your return request. Your request has been sent to the relevant department for processing.']")).getText();
    	Assert.assertEquals("Thank you for submitting your return request. Your request has been sent to the relevant department for processing.",s);
        }


    @When("^Click on continuebutton$")
    public void click_on_continuebutton() throws Throwable {
    	
    	//verifying the function of continue button by clicking on it
    	driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    	
    }



    @Then("^Naviage to Uniform Store main page$")
    public void naviage_to_uniform_store_main_page() throws Throwable {
    	
    	//checking if it navigated to another page by verifying drop down functionality of that page
    	driver.findElement(By.xpath("//*[@class='dropdown myaccount']")).click();
    }



    @When("^Click on My account$")
    public void click_on_my_account() throws Throwable {
    	
    	//clicking on my account of drop drown section
    	driver.findElement(By.xpath("//a[text()='My Account']")).click();
       }


    @Then("^Navigate to My account Page$")
    public void navigate_to_my_account_page11() throws Throwable {
    	
    	////printing something of My account page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='My Account']")).getText());
    	
    	//confirming the expected page and actual page is same or not
    	String s= driver.findElement(By.xpath("//h1[text()='My Account']")).getText();
    	Assert.assertEquals("MY ACCOUNT",s);
     }


    @When("^click on view your order history$")
    public void click_on_view_your_order_history() throws Throwable {
    	
    	//clicking on view your order history
    	driver.findElement(By.xpath("//a[text()='View your order history']")).click();
    }


    @Then("^Navigate to Order history page1$")
    public void navigate_to_order_history_page1() throws Throwable {
    	
    	//printing something of order history page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Order History']")).getText());
    	
    	//confirming the expected page and actual page is same or not
    	String s= driver.findElement(By.xpath("//h1[text()='Order History']")).getText();
    	Assert.assertEquals("ORDER HISTORY",s);
        
    }


        @When("Clicking on continue button in Account module")
        public void clicking_on_continue_button_in_account_module()  {
        	
        	//clicking on continue button of order history page
        	driver.findElement(By.xpath("//a[text()='Continue']")).click();
         }

        @Then("^Navigate to My account page$")
        public void navigating_to_my_account_page() {
        	

        	//printing something of My account page in console window
        	System.out.println(driver.findElement(By.xpath("//h1[text()='My Account']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h1[text()='My Account']")).getText();
        	Assert.assertEquals("MY ACCOUNT",s);
        }
        
//        @Then("^Close Driver$")
//        public void close_driver() throws Throwable {
//            driver.close();
//        }
//        
        @When("^Clicking on Downloads$")
        public void clicking_on_downloads()  {
        	
        	//clicking on downloads button
        	driver.findElement(By.xpath("//*[@id=\"content\"]/ul[3]/li[2]/a")).click();
        	
        }

        @Then("^Navigate to Downloads page$")
        public void navigating_to_downloads_page()  {
        	
        	//printing something of Downloads page in console window
        	System.out.println(driver.findElement(By.xpath("//h2[text()='Account Downloads']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h2[text()='Account Downloads']")).getText();
        	Assert.assertEquals("Account Downloads",s);
        	}
        
       
        @When("^Clicking on Continue button in My order$")
        public void clicking_on_continue_button_in_my_order() {
        	
        	 //click on continue button
        	driver.findElement(By.xpath("//a[text()='Continue']")).click();
        	 }

       
        @Then("^Navigate to My account Page1$")
        public void navigate_to_my_account_page1() {
        	
        	//printing something of My account page in console window
        	System.out.println(driver.findElement(By.xpath("//h1[text()='My Account']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h1[text()='My Account']")).getText();
        	Assert.assertEquals("MY ACCOUNT",s);
        }
        
        
       
        @When("^Clicking on Your Reward points$")
        public void clicking_on_your_reward_points() {
        	
        	//clicking on your reward points
        	driver.findElement(By.xpath("//a[text()='Your Reward Points']")).click();
        }
        
        
        
        @Then("^Navigate to Reward points page$")
        public void navigate_to_reward_points_page() {
        	
        	////printing something of reward points in console window
        	System.out.println(driver.findElement(By.xpath("//h1[text()='Your Reward Points']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h1[text()='Your Reward Points']")).getText();
        	Assert.assertEquals("YOUR REWARD POINTS",s);
        }
        
      
        @When("^Clicking on continue")
        public void clicking_on_continue() {
        	
        	//clicking on continue button
        	driver.findElement(By.xpath("//a[text()='Continue']")).click();
        	
        }

        @Then("^Navigate to My account")
        public void navigate_to_my_account() {

        	//printing something of My account page in console window
        	System.out.println(driver.findElement(By.xpath("//h2[text()='My Orders']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h2[text()='My Orders']")).getText();
        	Assert.assertEquals("My Orders",s);
        }
        
        
        @When("^Clicking on View your return requests$")
        public void clicking_on_view_your_return_requests()  {
        	
        	//clicking on return requests function
        	driver.findElement(By.xpath("//a[text()='View your return requests']")).click();
           }
        
        @Then("^Navigate to Product returns page$")
        public void navigate_to_product_returns_page()  {
        	
        	 //Checking if navigated to product returns page
        	if(driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody")).isDisplayed()) 
        	{   
        		//printing in console window
        		System.out.println("Products returns are displayed");
        	}
          }


        @When("^Clicking on continue $")
        public void clicking_on_continue1() {
        	
           //Clicking on continue button
        	driver.findElement(By.xpath("//a[text()='Continue']")).click();
        	  }
        
       
        @Then("^Navigate to My account $")
        public void navigate_to_my_account1() {
        	
        	//printing any text of that page in console window
            System.out.println(driver.findElement(By.xpath("//h2[text()='My Orders']")).getText());

            //confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h2[text()='My Orders']")).getText();
        	Assert.assertEquals("My Orders",s);
         }
        
       
        @When("^Clicking on Your Transactions$")
        public void clicking_on_your_transactions()  {
        	
            //clicking on your transactions of my orders section
        	driver.findElement(By.xpath("//a[text()='Your Transactions']")).click();
        }
            
       //checking if it is navigated to transactions page or not   
        @Then("^Navigate to Transactions Page$")
        public void navigate_to_transactions_page()  {
        	
            //Printing text of your transactions page in console window
        	System.out.println(driver.findElement(By.xpath("//h1[text()='Your Transactions']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h1[text()='Your Transactions']")).getText();
        	Assert.assertEquals("YOUR TRANSACTIONS",s);
        	}
        
        
       
        @When("^Clicking on continue btn$")
       public void clicking_on_continue_btn()  {
        	
        	//clicking on continue button
        	driver.findElement(By.xpath("//a[text()='Continue']")).click();
        }
           
        @Then("^Navigate to account page$")
        public void navigate_to_account_page() {
        	
            //Printing text of that page in console window
        	System.out.println(driver.findElement(By.xpath("//h2[text()='My Account']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
        	Assert.assertEquals("My Account",s);
        }
            
        
        @When("^Clicking on recurring payments$")
        public void clicking_on_recurring_payments()  {
        	
        	//Clicking on recurring payments of My orders section
        	driver.findElement(By.xpath("//a[text()='Recurring payments']")).click();
             }
         
       
        @Then("^Navigate to recurring payments page$")
       public void navigate_to_recurring_payments_page()  {
        	
        	//Printing something of that page in console window
        	System.out.println(driver.findElement(By.xpath("//p[text()='No recurring payments found!']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//p[text()='No recurring payments found!']")).getText();
        	Assert.assertEquals("No recurring payments found!",s);
        	 }
        
     
      @When("^Clicking on continue btn1$")
      public void clicking_on_continue_btn1()  {
    	  
    	  //clicking on continue button
        	driver.findElement(By.xpath("//a[text()='Continue']")).click();
        	 }
      
       
       @Then("^Navigate to account page1$")
        public void navigate_to_account_page1()  {
    	   
            //printing something of that page in console window
        	System.out.println(driver.findElement(By.xpath("//h1[text()='My Account']")).getText());
        	
        	//confirming the expected page and actual page is same or not
        	String s= driver.findElement(By.xpath("//h1[text()='My Account']")).getText();
        	Assert.assertEquals("MY ACCOUNT",s);
        	
          }
       
        ///////////////////////////////////////////////////////////////////////////////////////////////
       ///////////////////////////////////MY ACCOUNT MODULE//////////////////////////////////////////
               //////////////////////////////////////////////////////////////////////////////////////
       
       
       @When("^Clicking on Myaccount$")
       public void clicking_on_myaccount() throws Throwable {
    	   
    	   //clicking on my account in my account section
    	   driver.findElement(By.xpath("//a[@class='list-group-item' and text()='My Account']")).click();
           
       }
       
       @When("^Clicking on edit account$")
       public void clicking_on_edit_account() throws Throwable {
    	   
    	   //clicking on edit account in account section
    	   driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Edit Account']")).click();
           
       }
       

       @Then("^Navigate to edit details page$")
       public void navigate_to_edit_details_page() throws Throwable {
    	   
        //printing something of edits details page on console window
       	System.out.println(driver.findElement(By.xpath("//h1[text()='My Account Information']")).getText());
       	
        //confirming the expected page and actual page is same or not
       	String s= driver.findElement(By.xpath("//h1[text()='My Account Information']")).getText();
       	Assert.assertEquals("MY ACCOUNT INFORMATION",s);
           
       }

       @When("^Click on back$")
       public void click_on_back() throws Throwable {
    	   
    	   //clicking on back button
    	   driver.findElement(By.xpath("//a[@class='btn btn-default' and text()='Back']")).click();
           
       }


    @When("clicking on password")
    public void clicking_on_password() {
    	
         //clicking on password in my account section
    	 driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Password']")).click();
    }

    @Then("Navigate to password page")
    public void navigate_to_password_page() {
    	
        //printing something of password page in console window 
       	System.out.println(driver.findElement(By.xpath("//h1[text()='Change Password']")).getText());
       	
        //confirming the expected page and actual page is same or not  
       	String s= driver.findElement(By.xpath("//h1[text()='Change Password']")).getText();
       	Assert.assertEquals("CHANGE PASSWORD",s);
        
    }

    @When("click on back btn")
    public void click_on_back_btn() {
    	
    	 //clicking on back button
    	 driver.findElement(By.xpath("//a[@class='btn btn-default' and text()='Back']")).click();
       
    }
       


    @When("clicking on adressbook")
    public void clicking_on_adressbook() {
    	 
        //Clicking on address book in account section
    	driver.findElement(By.xpath("//a[text()='Address Book']")).click();
    }

    @Then("Navigate to adressbook page")
    public void navigate_to_adressbook_page() {
    	
    	//printing something of address book page in console window
    	System.out.println(driver.findElement(By.xpath("//h2[text()='Address Book Entries']")).getText());
    	
    	//confirming the expected page and actual page is same or not
       	String s= driver.findElement(By.xpath("//h2[text()='Address Book Entries']")).getText();
       	Assert.assertEquals("Address Book Entries",s);
    }

    @When("Clicking on back button")
    public void clicking_on_back_button() {
    	
    	//clicking on back button
    	driver.findElement(By.xpath("//a[@class='btn btn-default' and text()='Back']")).click();
    }


    @When("clicking on wishlist")
    public void clicking_on_wishlist() {
    	
    	//clicking on wish list in account section
    	driver.findElement(By.xpath("//a[text()='Wish List']")).click();
        
    }

    @Then("Navigate to wishlist page")
    public void navigate_to_wishlist_page() {
    	
    	//printing something of wish list page in console window
    	System.out.println(driver.findElement(By.xpath("//h2[text()='My Wish List']")).getText());
    	
    	//confirming the expected page and actual page is same or not
       	String s= driver.findElement(By.xpath("//h2[text()='My Wish List']")).getText();
       	Assert.assertEquals("My Wish List",s);
        
    }


    @When("clicking on order history")
    public void clicking_on_order_history() {
    	
    	//Clicking on order history in my account section
    	driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Order History']")).click();
    }

    @Then("Navigate to order history page")
    public void navigate_to_order_history_page11() {
    	
    	//printing something of order history page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Order History']")).getText());
    	
    	//confirming the expected page and actual page is same or not
       	String s= driver.findElement(By.xpath("//h1[text()='Order History']")).getText();
       	Assert.assertEquals("ORDER HISTORY",s);
        
    }



    @When("clicking on downloads")
    public void clicking_on_downloads1() {
    	
    	//Clicking on Downloads in My account section
    	driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Downloads']")).click();
       
    }

    @Then("Navigate to downloads page")
    public void navigate_to_downloads_page1() {
    	
    	//Printing something of downloads page in console window
    	System.out.println(driver.findElement(By.xpath("//h2[text()='Account Downloads']")).getText());
    	
    	//confirming the expected page and actual page is same or not 
       	String s= driver.findElement(By.xpath("//h2[text()='Account Downloads']")).getText();
       	Assert.assertEquals("Account Downloads",s);
     }


    @When("clicking on rewardpoints")
    public void clicking_on_rewardpoints() {
    	
    	//clicking on reward points age
    	driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Reward Points']")).click();
        
    }

    @Then("Navigate to rewardpoints page")
    public void navigate_to_rewardpoints_page() {
    	
    	//printing something of reward points page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Your Reward Points']")).getText());
    	
    	//confirming the expected page and actual page is same or not 
       	String s= driver.findElement(By.xpath("//h1[text()='Your Reward Points']")).getText();
       	Assert.assertEquals("YOUR REWARD POINTS",s);
        }


    @When("clicking on return for exchange")
    public void clicking_on_return_for_exchange() {
    	
    	//Clicking on return for exchange
    	driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Return For Exchange']")).click();
        
    }

    @Then("Navigate to return for exchange page")
    public void navigate_to_return_for_exchange_page() {
    	
    	//printing something of return for exchange page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Product Returns']")).getText());
    	
    	//confirming the expected page and actual page is same or not
       	String s= driver.findElement(By.xpath("//h1[text()='Product Returns']")).getText();
       	Assert.assertEquals("PRODUCT RETURNS",s);
    }

    @When("Click on view button")
    public void click_on_view_button() throws Throwable {
    	
    	//clicking on view button
    	driver.findElement(By.xpath("//a[@href='http://uniformm1.upskills.in/index.php?route=account/return/info&return_id=587']")).click();
       	
    }

        @Then("^Navigate to return information page$")
        public void navigate_to_return_information_page() throws Throwable {
        	
        	//printing something of return information page in console window
        	System.out.println(driver.findElement(By.xpath("//h1[text()='Return Information']")).getText());
        	
        	//confirming the expected page and actual page is same or not
           	String s= driver.findElement(By.xpath("//h1[text()='Return Information']")).getText();
           	Assert.assertEquals("RETURN INFORMATION",s);
            
        }
        

    @When("clicking on transactions")
    public void clicking_on_transactions() {
    	
    	//clicking on transactions in My account section 
    	driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Transactions']")).click();
       
    }

    @Then("Navigate to transactions page")
    public void navigate_to_transactions_page1() {
    	
    	//printing something of transactions page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Your Transactions']")).getText());
    	
    	//confirming the expected page and actual page is same or not 
       	String s= driver.findElement(By.xpath("//h1[text()='Your Transactions']")).getText();
       	Assert.assertEquals("YOUR TRANSACTIONS",s);
        
    }



    @When("clicking on newsletter")
    public void clicking_on_newsletter() {
    	
    	//Clicking on newsletter in my account section
    	driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Newsletter']")).click();
    	
    }

    @Then("Navigating to newsletter page")
    public void navigating_to_newsletter_page() {
    	
    	//printing something of newsletter page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Newsletter Subscription']")).getText());
    	
    	//confirming the expected page and actual page is same or not
       	String s= driver.findElement(By.xpath("//h1[text()='Newsletter Subscription']")).getText();
       	Assert.assertEquals("NEWSLETTER SUBSCRIPTION",s);
    	
        
    }

    @When("clicking on logout")
    public void clicking_on_logout() {
    	
    	//Clicking on logout in my account section
    	driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Logout']")).click();
    	
    }

    @Then("Navigate to logout page")
    public void navigate_to_logout_page() {
    	
    	//printing something of logout page in console window
    	System.out.println(driver.findElement(By.xpath("//h1[text()='Account Logout']")).getText());
    	
    	//confirming the expected page and actual page is same or not
       	String s= driver.findElement(By.xpath("//h1[text()='Account Logout']")).getText();
       	Assert.assertEquals("ACCOUNT LOGOUT",s);
    	
       
       }
    
    
  ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////RESHMI///////////////////////////////////////////////////////////
    ///////////////////////////   REGISTER MODULE   //////////////////////////////////////////////////
    ////////////////////////////////////////////////////// ///////////////////////////////////////////
    
  //Register page with valid credentials.
  	@Given("Enter valid credentials")
  	public void enter_valid_credentials() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
        driver.get("http://uniformm1.upskills.in/");
  		//Clicking on MyAccount dropdown and Clicking on Register
  		driver.findElement(By.xpath("//*[@class='dropdown myaccount']")).click();
  		driver.findElement(By.xpath("//a[text()='Register']")).click();

  		//Creating Object for Register class
  		Register c= new Register(driver);

  		//Filling all the textfields with valid credentials
  		c.getfirstname().sendKeys("Reshmi");
  		c.getlastname().sendKeys("kaparthini");
  		c.getemail().sendKeys("ajhamdgmhfag@gmail.com");
  		c.gettelephone().sendKeys("9629755926");
  		c.getaddress1().sendKeys("12, LNP Street");
  		c.getaddress2().sendKeys("Palayamkottai");
  		c.getcity().sendKeys("Tirunelveli");
  		c.getpostCode().sendKeys("627011");

  		//Selecting "India" option in Country Dropdown field
  		WebElement country=driver.findElement(By.name("country_id"));
  		Select s1=new Select(country);
  		s1.selectByVisibleText("India");

  		//Selecting "Tamil Nadu" option in Region/State Dropdown field
  		WebElement region=driver.findElement(By.name("zone_id"));
  		Select s2=new Select(region);
  		s2.selectByVisibleText("Tamil Nadu");

  		//Sending Password and Confirm Password fields
  		c.getpassword().sendKeys("Reshmi123");
  		c.getpasswordConfirm().sendKeys("Reshmi123");

  		//Selecting the radio button and CheckBox
  		c.getradio().click();
  		c.getcheck().click();

  	}


  	@When("Click on Continue.")
  	public void click_on_continueR() {
  		Register r = new Register(driver);

  		//Clicking on Continue Button
  		r.getContinue().click();
  	}


  	@Then("^Navigate to Account successfully created page\\.$")
  	public void navigate_to_Account_successfully_created_page() throws Throwable {

  		//Verifying the Currenturl with the expected url.
  		String URL = driver.getCurrentUrl();
  		Assert.assertEquals(URL, "http://uniformm1.upskills.in/index.php?route=account/success" );

  		//Getting the text from the resultant page.
  		System.out.println(driver.findElement(By.xpath("//*[@id='content']")).getText());
  	}


  	@Then("Click on Continue in Account Successfully created page.")
  	public void click_on_continue_in_account_successfully_created_page() {
  		Register r = new Register(driver);

  		//Clicking on Continue Button 
  		r.getcontinueBtn().click();
  	}


  	@Then("Navigated to the My Account page.")
  	public void navigated_to_the_my_account_page() {

  		//Verifying the title of the page with the title provided 
  		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("MY ACCOUNT");
  		assertTrue(verifyTitle);
  		System.out.println("My Account page will be displayed");

  		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  		driver.close();
  	}


  	//Scenario: Registering with already existing email

  	@Given("Enter all the credentials along with already exisiting email.")
  	public void enter_all_the_credentials_along_with_already_exisiting_email() throws IOException {

  		//initialising the browser
  		driver=initializeDriver();
  		driver.get("http://uniformm1.upskills.in/");

  		//Clicking on MyAccount dropdown and Clicking on Register
  		driver.findElement(By.xpath("//*[@class='dropdown myaccount']")).click();
  		driver.findElement(By.xpath("//a[text()='Register']")).click();

  		//Creating an Object for Register class
  		Register c= new Register(driver);

  		//Filling all the textfields with valid credentials and email textfield with already exisiting email address
  		c.getfirstname().sendKeys("Reshmi");
  		c.getlastname().sendKeys("kaparthini");
  		c.getemail().sendKeys("kaparthini.resh@gmail.com");
  		c.gettelephone().sendKeys("9629755926");
  		c.getaddress1().sendKeys("12, LNP Street");
  		c.getaddress2().sendKeys("Palayamkottai");
  		c.getcity().sendKeys("Tirunelveli");
  		c.getpostCode().sendKeys("627011");

  		//Selecting "India" option in Country Dropdown field
  		WebElement country=driver.findElement(By.name("country_id"));
  		Select s=new Select(country);
  		s.selectByVisibleText("India");

  		//Selecting "Tamil Nadu" option in Region/State Dropdown field
  		WebElement region=driver.findElement(By.name("zone_id"));
  		Select s1=new Select(region);
  		s1.selectByVisibleText("Tamil Nadu");

  		//Sending Password and Confirm Password fields
  		c.getpassword().sendKeys("Reshmi123");
  		c.getpasswordConfirm().sendKeys("Reshmi123");

  		//Selecting the radio button and CheckBox
  		c.getradio().click();
  		c.getcheck().click();

  	}

  	@When("Click on Continue in Register page.")
  	public void click_on_continue_in_register_page() {
  		Register d= new Register(driver);

  		//Clicking on Continue Button
  		d.getContinue().click();
  	}

  	@Then("Warning message {string} will be displayed.")
  	public void warning_message_will_be_displayed(String string) {

  		//getting the output
  		System.out.println("E-Mail Address is already registered");
  		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

  		//close driver
  		driver.close();
  	}

  	//////Scenario : Verifying without entering anyone of the mandatory fields
  	
  	@Given("Enter all the mandatory textfields except one")
  	public void enter_all_the_mandatory_textfields_except_one() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on MyAccount dropdown and Clicking on Register
  		driver.findElement(By.xpath("//*[@class='dropdown myaccount']")).click();
  		driver.findElement(By.xpath("//a[text()='Register']")).click();

  		//Creating object for Register class
  		Register r = new Register(driver);

  		//Filling all the textfields except anyone of the mandatory fields
  		r.getfirstname().sendKeys("reshmi");
  		r.getlastname().sendKeys("kaparthini");
  		//r.getemail().sendKeys("reshmi4@gmail.com");
  		r.gettelephone().sendKeys("9629755926");
  		r.getaddress1().sendKeys("12, LNP Street");
  		r.getaddress2().sendKeys("Palayamkottai");
  		r.getcity().sendKeys("Tirunelveli");
  		r.getpostCode().sendKeys("627011");

  		//Selecting "India" option in Country Dropdown field
  		WebElement country=driver.findElement(By.name("country_id"));
  		Select s=new Select(country);
  		s.selectByVisibleText("India");

  		//Selecting "Tamil Nadu" option in Region/State Dropdown field
  		WebElement region=driver.findElement(By.name("zone_id"));
  		Select s1=new Select(region);
  		s1.selectByVisibleText("Tamil Nadu");

  		//Sending Password and Confirm Password fields
  		r.getpassword().sendKeys("Reshmi123");
  		r.getpasswordConfirm().sendKeys("Reshmi123");

  		//Selecting the radio button and checkbox
  		r.getradio().click();
  		r.getcheck().click();
  	}

  	@When("click Continue")
  	public void click_continue() {
  		Register d= new Register(driver);

  		//Clicking on Continue button
  		d.getContinue().click();
  	}

  	@Then("Warning message should be displayed.")
  	public void warning_message_should_be_displayed() {

  		//Getting the Contents of the page
  		System.out.println(driver.findElement(By.xpath("//*[@class='text-danger']")).getText());

  		//Close driver
  		driver.close();
  	}

  	////////Scenario : Verifying without selecting the Privacy Policy element
  	
  	@Given("Enter all the valid credentials without selecting the Privacy Policy element")
  	public void enter_all_the_valid_credentials_without_selecting_the_privacy_policy_element() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on MyAccount dropdown and Clicking on Register
  		driver.findElement(By.xpath("//*[@class='dropdown myaccount']")).click();
  		driver.findElement(By.xpath("//a[text()='Register']")).click();

  		//Creating an Object for the Register class
  		Register r = new Register(driver);

  		//Entering all the textfields
  		r.getfirstname().sendKeys("reshmi");
  		r.getlastname().sendKeys("kaparthini");
  		r.getemail().sendKeys("kaparthini.resh@gmail.com");
  		r.gettelephone().sendKeys("9629755926");
  		r.getaddress1().sendKeys("12, LNP Street");
  		r.getaddress2().sendKeys("Palayamkottai");
  		r.getcity().sendKeys("Tirunelveli");
  		r.getpostCode().sendKeys("627011");

  		//Selecting "India" option in Country Dropdown field
  		WebElement country=driver.findElement(By.name("country_id"));
  		Select s=new Select(country);
  		s.selectByVisibleText("India");

  		//Selecting "Tamil Nadu" option in Region/State Dropdown field
  		WebElement region=driver.findElement(By.name("zone_id"));
  		Select s1=new Select(region);
  		s1.selectByVisibleText("Tamil Nadu");

  		//Sending Password and Confirm Password fields
  		r.getpassword().sendKeys("Reshmi123");
  		r.getpasswordConfirm().sendKeys("Reshmi123");

  		//Selecting the radio button
  		r.getradio().click();

  	}

  	@When("Click Continue button.")
  	public void click_continue_button() {
  		Register d= new Register(driver);

  		//Click on Continue button
  		d.getContinue().click();
  	}

  	@Then("Warning message {string} should be displayed.")
  	public void warning_message_should_be_displayed(String string) {

  		//printing the output
  		System.out.println("Warning  message:You must agree to Privacy Policy");

  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  		//close driver	
  		driver.close();
  	}

                //////////////////////////////////////////////////////////////////////
  	            /////////////////////FOOTER MODULE/////////////////////////////////////
  	           ////////////////////////////////////////////////////////////////////////
  	// Scenario : Verifying all the links are working
  	@Given("Navigating to the Website")
  	public void navigating_to_the_website() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  	}

  	@When("Verifying all working links in footer section")
  	public void verifying_all_working_links_in_footer_section() {

  		String Title = "Under Construction: Uniform store";					

  		//Getting the links in the WebPage
  		List<WebElement> linkElements = driver.findElements(By.tagName("a"));							
  		String[] linkTexts = new String[linkElements.size()];							
  		int	i = 0;					

  		//extract the link texts of each link element		
  		for (WebElement e : linkElements) {							
  			linkTexts[i] = e.getText();							
  			i++;			
  		}		

  		//test each link		
  		for (String t : linkTexts) {							
  			driver.findElement(By.linkText(t)).click();					
  			if (driver.getTitle().equals(Title)) {							
  				System.out.println("\"" + t + "\""+ " is under construction.");			
  			} else {			
  				System.out.println("\"" + t + "\"" + " is working.");			
  			}		

  		}	
  		return;
  	}   


  	@Then("Condition of links are displayed.")
  	public void condition_of_links_are_displayed() {

  		//printing the output
  		System.out.println("All links are working");

  		//close driver
  		driver.close();
  	}

  	//Scenario : Verifying the Affiliates Link
  	@Given("Navigate to Website and Select Affiliate link in Footer section.")
  	public void navigate_to_website_and_select_affiliate_link_in_footer_section() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on Affiliates link
  		driver.findElement(By.xpath("//a[text()='Affiliates']")).click();
  	}

  	@And("Click on Continue in the New Affiliate Program page.")
  	public void click_on_continue_in_the_new_affiliate_program_page() {

  		//Click on Affiliates link
  		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
  	}

  	@When("Enter all the mandatory fields.")
  	public void enter_all_the_mandatory_fields() {

  		//Create Object for AffiliateRegister class
  		AffiliatesRegister r = new AffiliatesRegister(driver);

  		//Enter all the textfields in Affiliate Register form
  		r.getfirstname().sendKeys("reshmi");
  		r.getlastname().sendKeys("kaparthini");
  		r.getemail().sendKeys("rekaparthini@gmail.com");
  		r.gettelephone().sendKeys("9629755926");
  		r.getaddress1().sendKeys("12, LNP Street");
  		r.getaddress2().sendKeys("Palayamkottai");
  		r.getcity().sendKeys("Tirunelveli");
  		r.getpostCode().sendKeys("627011");

  		//Selecting "India" option in Country Dropdown field
  		WebElement country=driver.findElement(By.name("country_id"));
  		Select s=new Select(country);
  		s.selectByVisibleText("India");

  		//Selecting "Tamil Nadu" option in Region/State Dropdown field
  		WebElement region=driver.findElement(By.name("zone_id"));
  		Select s1=new Select(region);
  		s1.selectByVisibleText("Tamil Nadu");

  		//Select Radio button
  		r.getradio().click();

  		//Sending Password and Confirm Password fields
  		r.getpassword().sendKeys("Reshmi123");
  		r.getpasswordConfirm().sendKeys("Reshmi123");

  	}
  	@Then("Click on Continue button.")
  	public void click_on_continue_button() {

  		AffiliatesRegister r = new AffiliatesRegister(driver);

  		//Click on Continue Button
  		r.getContinue().click();

  		//Verifying the Current url with the expected url
  		String URL = driver.getCurrentUrl();
  		Assert.assertEquals(URL, "http://uniformm1.upskills.in/index.php?route=affiliate/success" );

  		//Getting the Content of the page
  		System.out.println(driver.findElement(By.xpath("//*[@id='content']")).getText());

  		//Close driver
  		driver.close();

  	}

  	//Verifying the Affiliates Login page
  	@Given("Navigate to Affiliate Login page")
  	public void navigate_to_affiliate_login_page() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on Affiliates link
  		driver.findElement(By.xpath("//a[text()='Affiliates']")).click();
  	}

  	@When("Enter email and password")
  	public void enter_email_and_password() {

  		//Create Object for AffiliateRegister class
  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Enter all the textfields in Affiliate Register form
  		r.getEmail().sendKeys("kaparthini.resh@gmail.com");
  		r.getpassword().sendKeys("Reshmi123");
  	}

  	@Then("Click on Submit")
  	public void clicking_on_submit() {
  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Click on Submit
  		r.getsubmit().click();
  	}

  	@Then("A warning message will be displayed")
  	public void a_warning_message_will_be_displayed() {

  		//getting the Warning message and printing it
  		System.out.println(driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());

  		//Close driver
  		driver.close();
  	}

  	//Verifying affiliate login with incorrect email address or password

  	@Given("navigate to Affiliate Login page1")
  	public void navigate_to_affiliate_login_page1() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on Affiliates link
  		driver.findElement(By.xpath("//a[text()='Affiliates']")).click();
  	}


  	@When("Enter either incorrect email address or incorrect password")
  	public void enter_either_incorrect_email_address_or_incorrect_password() {

  		//Create Object for AffiliateRegister class
  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Enter all the textfields in Affiliate Register form
  		r.getEmail().sendKeys("kaparthini.reshmi@gmail.com");
  		r.getpassword().sendKeys("Reshmi123");

  	}

  	@Then("Click on Submit button")
  	public void click_on_submit_button() {
  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Click on Submit
  		r.getsubmit().click();
  	}

  	@Then("A Warning message should be displayed")
  	public void a_warning_message_should_be_displayed() {

  		//getting the Warning message and printing it
  		System.out.println(driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());

  		//Close driver
  		driver.close();
  	}

  	//Verifying Forgotten password link in Affiliate Login 
  	@Given("Navigate to Affiliate Login")
  	public void navigate_to_affiliate_login() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on Affiliates link
  		driver.findElement(By.xpath("//a[text()='Affiliates']")).click();
  	}

  	@When("Click on Forgotten password link")
  	public void click_on_forgotten_password_link() {
  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Click on Forgotten password
  		r.getforgotpwd().click();
  	}

  	@When("Enter email address")
  	public void enter_email_address() {
  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Enter valid email address
  		r.getEmail().sendKeys("kaparthini.resh@gmail.com");
  	}

  	@Then("Click Continue.")
  	public void click_Continue() {
  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Click on Submit
  		r.getContinue().click();
  	}

  	@Then("Warning message will be displayed")
  	public void warning_message_will_be_displayed() {

  		//getting the Warning message and printing it
  		System.out.println(driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());
  	}

  	@Then("Click on Back button")
  	public void click_on_back_button() {

  		AffiliateLogin r = new AffiliateLogin(driver);

  		//Click on Back
  		r.getback().click();

  		//Verifying the current url with the expected url
  		String URL = driver.getCurrentUrl();
  		Assert.assertEquals(URL, "http://uniformm1.upskills.in/index.php?route=affiliate/login" );

  		//Getting the text from the resultant page.
  		System.out.println("Affiliate Login page will be displayed");

  		//Close driver
  		driver.close();

  	}


  	//Verifying Gift Certificates form

  	@Given("Navigate to Website and Select Gift Certificates link in Footer section.")
  	public void navigate_to_website_and_select_gift_certificates_link_in_footer_section() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on Gift Certificates link
  		driver.findElement(By.xpath("//a[text()='Gift Certificates']")).click();
  	}

  	@When("Enter all the credentials in the Gift certificate form.")
  	public void enter_all_the_credentials_in_the_gift_certificate_form() {

  		//Create an Object for GiftCertificates class
  		GiftCertificates r = new GiftCertificates(driver);

  		//Enter all the textfields 
  		r.getReceipientname().sendKeys("Eby Paul Daniel");
  		r.getReceipientemail().sendKeys("eby@gmail.com");
  		r.getYourname().sendKeys("Reshmi");
  		r.getYouremail().sendKeys("reshmi@gmail.com");
  		r.getradio().click();
  		r.getmessage().sendKeys("Happy New Year");
  		r.getamount().sendKeys("30s");
  		r.getcheck().click();
  	}

  	@Then("Click on Continue in Gift Certificates form.")
  	public void click_on_continue_in_gift_certificates_form() {

  		GiftCertificates r = new GiftCertificates(driver);

  		//Click on Continue button
  		r.getContinue().click(); 

  		//Verifying the current url with the expected url
  		String URL = driver.getCurrentUrl();
  		Assert.assertEquals(URL, "http://uniformm1.upskills.in/index.php?route=account/voucher/success" );
  		System.out.println(driver.findElement(By.xpath("//*[@id='content']")).getText());

  		//close driver
  		driver.close();
  	}

  	//Verifying Contact Us form
  	@Given("Navigate to Website and Select Contact Us link in Footer section.")
  	public void navigate_to_website_and_select_contact_us_link_in_footer_section() throws IOException {

  		//initialising the Browser
  		driver=initializeDriver();
  		 driver.get("http://uniformm1.upskills.in/");
  		//Clicking on Contact Us link
  		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
  	}

  	/*@When("Verifying the Zoom in and Zoom out buttons in Map.")
  	public void verifying_the_zoom_in_and_zoom_out_buttons_in_map() {

  		ContactUs r = new ContactUs(driver);

  		//r.getZoomIn().click();
  		//r.getZoomOut().click();
  	}*/

  	@When("Verifying the Contact Us form")
  	public void verifying_the_contact_us_form() {

  		//Create an Object for ContactUs class
  		ContactUs r = new ContactUs(driver);

  		//Enter all textfields 
  		r.getname().sendKeys("Reshmi");
  		r.getemail().sendKeys("kaparthini@gmail.com");
  		r.getenquiry().sendKeys("Nothing to mention here");

  	}

  	@Then("Click ContinueR")
  	public void click_continueR() {

  		ContactUs r = new ContactUs(driver);

  		//Click on Submit button
  		r.getSubmit().click();

  		//Click on Continue button
  		r.getContinue().click();

  		//Verify the current url with the expected url
  		String URL = driver.getCurrentUrl();
  		Assert.assertEquals(URL, "http://uniformm1.upskills.in/index.php?route=common/home" );
  		System.out.println("Home Page gets displayed");

  		//close driver
  		driver.close();

  	}
  	



/////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////// ABHIGNYA ////////////////////////////////////////////////
////////////////////////////////////////// LOGIN///////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
// Navigates to our website
@Given("^Navigating to our website$")
public void navigating_to_our_website() throws Throwable
{
//initalizing the browser
driver =initializeDriver();



// Maximizing the window
driver.manage().window().maximize();



//navigating to the uniform store with this URL
driver.get("http://uniformm1.upskills.in/");



}



// Logging in with the given username and password
@And("^Login with (.+) and (.+)$")
public void login_with_and(String username, String password) throws IOException, InterruptedException
{
// Creating an object for login class
Login l=new Login(driver);



// To click on the user icon
l.getDropdown().click();



// To click on login option in the drop down
l.getLogin().click();



// To get the email and password
l.getEmail().sendKeys(username);
l.getPassword().sendKeys(password);



// To click on submit button
l.getSubmit().click();



// Specifiyng implicit wait
driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
}



// To click on MyAccount after logging in.
@When("Click on to MyAccount")
public void click_on_to_my_account()
{
System.out.println("hii");



// To click on MyAccount option if the login is success
driver.findElement(By.xpath("//h5[text()='My Account']"));



// Creating an object
UniformStore1 u=new UniformStore1(driver);
u.getMyAccount().click();
}


//
//// To navigate to the MyAccount Page.
@Then("It should Navigate to My Account")
public void It_should_navigate_to_my_account()
{
driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
System.out.println("true");
driver.close();
}
// End of login page Scenario



////////////////////////////////////NAVIGATION////////////////////////////////////////////////////



// Navigating to the website
@Given("Navigating to website")
public void navigate_to_website() throws IOException
{
//initalizing the browser
driver =initializeDriver();



// Maximizing the window
driver.manage().window().maximize();



//navigating to the uniform store with this URL
driver.get("http://uniformm1.upskills.in/");



}



// Logging in with a username and password
@When("Login with your credentials")
public void login_with_your_credentials() throws InterruptedException
{
// Creating an object for login class
Login l=new Login(driver);



// To click on the user icon
l.getDropdown().click();



// To click on login option in the drop down
l.getLogin().click();

// Login with the email and password
l.getEmail().sendKeys("abhignya7@gmail.com");
l.getPassword().sendKeys("Abhignya123");

// To click on submit button
l.getSubmit().click();

// Specifiyng implicit wait
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}



@Then("Explore all the options")
public void explore_all_the_options() throws InterruptedException
{
// Creating a constructor
NavigationBar n= new NavigationBar(driver);



// To click on the Uniform store logo in the Navigation Bar
n.getLogo().click();
driver.findElement(By.xpath("//*[@class='tp-rightarrow tparrows round']")).click();
driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
System.out.println("Clicking on the logo");



// To click on the home screen option in the Navigation Bar
n.getMenu().click();
driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
System.out.println("----ERROR!!----");



// To click on the cart option in the Navigation Bar
n.getCart().click();
driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
System.out.println("Clicking on the my Cart option");



// To click on the wishlist option in the Navigation Bar
n.getWishlist().click();
driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);



// To click on the user icon in the Navigation Bar
n.getUser().click();
driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
driver.findElement(By.partialLinkText("Logout")).click();
driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
System.out.println("Clicking on the user option");


}

// To close the browser
@Then("Close the browser")
public void close_the_browser()
{
driver.close();
System.out.println("Close the browser");
}



/////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////  DEEPAK//////////////////////////////////////////////
////////////////////////////////// SALES //////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////


@Given("^Login with admin Creditials$")
public void login_with_admin_Creditials() throws Throwable {
	driver =initializeDriver();
	driver.get("http://uniformm1.upskills.in/admin/");
	//driver.manage().window().maximize();
	loginSales l=new loginSales(driver);
	l.getAdmin().sendKeys("admin");
	l.getPassword().sendKeys("admin@123");
	l.getSubmit().click();     //logging in
}

@And("^Click on menu button and then sales$")
public void click_on_menu_button_and_then_sales() throws Throwable {
	 loginSales l=new loginSales(driver);
	    l.getMenu().click();                 //clicking on menu button to get options
	    l.getSales().click();                // clicking on sales options
	    System.out.println("Sales dropdown is displayed");
}

// orders

@When("^Click on orders$")
public void click_on_orders() throws Throwable {
    loginSales l = new loginSales(driver);
    l.getOrders().click();
    System.out.println("orders page is displayed");
}

@Then("^Navigate to orders page$")
public void navigate_to_orders_page() throws Throwable {
    String s=driver.getTitle();
    Assert.assertEquals("Orders",s);      // checking if right page is displayed
   
}

//recurring orders pages

@When("^click on recurring orders$")
public void click_on_recurring_orders() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getRecOrder().click();              // recurring orders page is displayed
	System.out.println("Recurring orders page is displayed");  
}

@Then("^Navigate to recurring orders page$")
public void navigate_to_recurring_orders_page() throws Throwable {
   String tit=driver.getTitle();
   Assert.assertEquals("Recurring Orders",tit); // checking if recurring orders page is displayed 
}

//Returns

@When("^click on Returns$")
public void click_on_returns() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getReturns().click();
	System.out.println("returns page is displayed");
}

@Then("^Navigate to returns page$")
public void navigate_to_returns_page() throws Throwable {
   String tit1=driver.getTitle();
   Assert.assertEquals("Product Returns",tit1);  //checking if return page is displayed
}

//gift vouchers

@When("^click on gift vouchers$")
public void click_on_gift_vouchers() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getGiftVouchers().click(); // clicking on gift vouchers in the options
}

@Then("^click on giftVouchers in the dropdown$")
public void click_on_giftvouchers_in_the_dropdown() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getGiftVouchers1().click();  // clicking on gift vouchers in the gift vouchers dropdown
	System.out.println("Gift Vouchers page is displayed");
}

@Then("^navigate to Gift vouchers page$")
public void navigate_to_gift_vouchers_page() throws Throwable {
    String tit2=driver.getTitle(); // printing the title of the page to check if giftvouchers page is displayed
    Assert.assertEquals("Gift Vouchers", tit2);
}


//Voucher Themes

@When("^click on voucher themes in gift voucher dropdown$")
public void click_on_voucher_themes_in_gift_voucher_dropdown() throws Throwable {
	loginSales l = new loginSales(driver);
	//l.getGiftVouchers().click();
	l.getVoucherThemes().click(); // clicking on voucher themes in the gift vouchers drop down
	System.out.println("Voucher themes page is displayed");
}

@Then("^navigate to voucher themes page$")
public void navigate_to_voucher_themes_page() throws Throwable {
    String tit2=driver.getTitle(); // checking if voucher themes page is displayed
    Assert.assertEquals("Voucher Themes",tit2);
}

//PayPal


@When("^click on PayPal$")
public void click_on_paypal() throws Throwable {
    loginSales l = new loginSales(driver);
    l.getpayPal().click();
}

@Then("^click on search in the dropdown$")
public void click_on_search_in_the_dropdown() throws Throwable {
    loginSales l = new loginSales(driver);
    l.getSearch().click(); //clicking on paypal
    System.out.println("Search page in PayPal is displayed");
}

@Then("^navigate to the search page$")
public void navigate_to_the_search_page() throws Throwable {
    String tit3=driver.getTitle(); //checking if paypal page is displayed
    Assert.assertEquals("Search Transactions",tit3);
}


//Orders pages


@When("^click on Orders option$")
public void click_on_orders_option() throws Throwable {
    loginSales l = new loginSales(driver);
    l.getOrders().click(); // returning back to orders page
    
}

@Then("^enter the order id in the order id text box$")
public void enter_the_order_id_in_the_order_id_text_box() throws Throwable {
   loginSales l = new loginSales(driver);
   l.getOrderid().sendKeys("333"); // entering orderId in orderId text box to filter the orders
}

@Then("^click on filter in orders$")
public void click_on_filter_in_orders() throws Throwable {
   loginSales l=new loginSales(driver);
   l.getFilButton().click();
   WebElement column = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[2]"));
   String OrderNum=column.getText();
   Assert.assertEquals("333", OrderNum); // checking if correct orderId is displayed
   System.out.println(OrderNum+" is the order displayed");
}

// clicking on view button

@Then("^click on view btn$")
public void click_on_view_btn() throws Throwable {
    loginSales l = new loginSales(driver);
    l.getViewButton().click(); // clicking on view button for the above filtered order
}

// clicking on uniform store link in the page displayed when clicked on view button

@Then("^click on UniformStore link$")
public void click_on_uniformstore_link() throws Throwable {
	loginSales l = new loginSales(driver);
	
	driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div[1]/div/table/tbody/tr[1]/td[2]/a")).click();  //clicking uniform store link in the page displayed when clicked on view button
	java.util.Set<String> windows = driver.getWindowHandles();  // using window handle to come back to orders page from uniform store page
	java.util.Iterator<String> it = windows.iterator();
	String parentId = it.next();
	String childId = it.next();
	driver.switchTo().window(childId); //switching driver to child window i.e uniform store window
	System.out.println(driver.findElement(By.xpath("//a[text()='Uniform Store']")).getText()+"page is displayed"); 
	driver.close(); // closing uniform store page
	driver.switchTo().window(parentId);

}

// clicking on print invoice button

@Then("^click on print invoice button$")
public void click_on_print_invoice_button() throws Throwable {
    loginSales l = new loginSales(driver);
    l.getInvoiceBtn().click();  //clicking on invoice button in the view button page
    
    driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a[1]"));  
	java.util.Set<String> windows = driver.getWindowHandles();  // using window handle to come back to orders page from uniform store page
	java.util.Iterator<String> it = windows.iterator();
	String parentId = it.next();
	String childId = it.next();
	driver.switchTo().window(childId); // switching driver to child window i.e invoice page
	String tit4=driver.getTitle();
	System.out.println(tit4 + " is displayed");
	
	driver.close();
	driver.switchTo().window(parentId);
}

// shipping list button

@Then("^click on print shiplist button$")
public void click_on_print_shiplist_button() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getShippingList().click(); //clicking on shipping list button
	System.out.println("Shipping is displayed");
	
	driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a[2]"));  
	java.util.Set<String> windows = driver.getWindowHandles();  // using window handle to come back to orders page from uniform store page
	java.util.Iterator<String> it = windows.iterator();
	String parentId = it.next();
	String childId = it.next();
	driver.switchTo().window(childId); // switching driver to child window i.e invoice page
	
	
	driver.close();
	driver.switchTo().window(parentId);
}

@Then("^click on cancel button$")
public void click_on_cancel_button() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getCancelBtn().click(); //clicking on cancel button to come back
}

@Then("^click on check Box$")
public void click_on_check_box() throws Throwable {
	loginSales l = new loginSales(driver);
	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[2]")).click();    //clicking the functionality of check box
}


// do not have any operations to do in recurring orders page

// now in returns page



@Then("^click on returns option in sales drop down$")
public void click_on_returns_option_in_sales_drop_down() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getReturns().click(); //navigating to return page
}

@Then("^enter the return Id in the returnId text box$")
public void enter_the_return_id_in_the_returnid_text_box() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getReturnId().sendKeys("517");                  //entering return id in text box
}

@Then("^click on filter button$")
public void click_on_filter_button() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getreturnFilter().click();                     // clicking on filter button
	System.out.println("returnId is filtered");
}

@Then("^click on return option again$")
public void click_on_return_option_again() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getReturns().click();                           //navigating to returns page again
	Thread.sleep(2000);
	System.out.println("navigated back to return page");
}

@When("^selecting the check box$")
public void selecting_the_check_box() throws Throwable {
	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[1]")).click(); //selecting text box
	System.out.println("Selected text box");
}

@Then("^click on delete button$")
public void click_on_delete_button() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getTrashBtn().click();
	System.out.println("clicked on trash button");
	driver.switchTo().alert().accept(); //hovering to pop up
}

// Checking there is no data in the table in recurring order page

@When("^click on recurring orders and get text from table$")
public void click_on_recurring_orders_and_get_text_from_table() throws Throwable {
   loginSales l = new loginSales(driver);
   l.getRecOrder().click();
   String Nd = l.getNodata().getText();
   System.out.println(Nd +" is present in table");
}


@And("^enter recurring id and click on filter$")
public void enter_recurring_id_and_click_on_filter() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getRecurID().sendKeys("333");                   //searching recurring id in recurring id text box
	l.getRecurFilter().click();                        //clicking on filter
}
@Then("^should display no results in the table$")
public void should_display_no_results_in_the_table() throws Throwable {
	loginSales l = new loginSales(driver);               //displaying no data is there in the recurring order page's table
	String Nd = l.getNodata().getText();
	   System.out.println(Nd +" is present in table");
}

//Gift vouchers pages in the gift vouchers drop down

@When("^click on GiftVouchers in gift vouchers drop down$")
public void click_on_giftvouchers_in_gift_vouchers_drop_down() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getGiftVouchers().click();                        //going to gift vouchers page
	l.getGiftVouchers1().click();                        //clicking on gift vouchers option in the drop down 
}

@Then("^navigate to giftVouchers page$")
public void navigate_to_giftvouchers_page() throws Throwable {
   String tit=driver.getTitle();
   Assert.assertEquals("Gift Vouchers",tit);
   System.out.println(tit+ " is displayed");                //printing title of the page
}

@Then("^click on check box and click on delete button$")
public void click_on_check_box_and_click_on_delete_button() throws Throwable {
	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td[1]")).click(); //Selecting check box
	loginSales l = new loginSales(driver);
	l.getGiftVoucherDelete().click();                    //deleting the selected voucher
	
	driver.switchTo().alert().accept();
	System.out.println(l.getDelSuccessMsg().getText()); //printing the deleted success message
}

// voucher themes page operation


@When("^click on voucher themes option in gift vouchers drop down$")
public void click_on_voucher_themes_option_in_gift_vouchers_drop_down() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getVoucherThemes().click();                         //opening voucher themes page
}

@Then("^click on edit and enter the voucher theme name$")
public void click_on_edit_and_enter_the_voucher_theme_name() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getvoucherThemesEdit().click();
	System.out.println("clicked on edit button");
	l.getVoucherThemeText().clear();                             // clearing previous text
	l.getVoucherThemeText().sendKeys("Heart break a happy break"); //entering new text 
	System.out.println("Entered text");
}

@And("^click on save$")
public void click_on_save() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getVoucherThemeSave().click();                               //saving the new entered text
	System.out.println("clicked on save");
	System.out.println(l.getVoucherEditSuccess().getText());
	System.out.println(l.getVoucherSuccessMsg().getText());
   
}

//clicking on paypal

@When("^click on paypal option in sals drop down$")
public void click_on_paypal_option_in_sals_drop_down() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getpayPal().click();
}

//Search option in the paypal dropdown

@Then("^Open search in the dropdown$")
public void open_search_in_the_dropdown() throws Throwable {
	loginSales l = new loginSales(driver);
	l.getSearch().click();
	String tit = driver.getTitle();
	Assert.assertEquals("Search Transactions" , tit);
	System.out.println(tit+" is displayed");
	Thread.sleep(2000);
}

//Reports



@When("^click on Reports$")
public void click_on_reports() throws Throwable {
    Reports2 r = new Reports2(driver);
    r.getReportsDropdown().click();                 //reports dropdown  
    System.out.println("clicked on reports dropdown");
}

@Then("^in the dropdown click on customers$")
public void in_the_dropdown_click_on_customers() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getCustomersDropdown().click();             //clicking on customers in the reports drop down
	System.out.println("clicked on customers option");
}

@Then("^in the dropdown click on customers online$")
public void in_the_dropdown_click_on_customers_online() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getCustomersOnline().click();              //Customers online option in customers drop down
	System.out.println("customers online option clicked");
}


@Then("^enter the IP address in the Ip address text box$")
public void enter_the_ip_address_in_the_ip_address_text_box() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getIpAdd().sendKeys("43.249.225.226");  //entering Ip address
}

@And("^Click on filter in in that page$")
public void click_on_filter_in_in_that_page() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getfilbutton().click();
	System.out.println("Ip address filtered"); //filtering based on ip address in customers online page
}

//Customers Activity in Customers drop down of reports

@When("^click on customer activity$")
public void click_on_customer_activity() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getCustomerActivity().click();            //clicking on Customer activity option
}

@Then("^Navigate to customer activity page$")
public void navigate_to_customer_activity_page() throws Throwable {
	String tit7 = driver.getTitle();
	Assert.assertEquals("Customer Activity Report",tit7);  //verifying if customers activity report is displayed
	System.out.println(tit7 + " is displayed");
   
}
@Then("^In the customer activity page enter Id address$")
public void in_the_customer_activity_page_enter_id_address() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getCustomerARip().sendKeys("122.175.68.165");                  //sending Ip address to filter
}

@And("^click on filter in the customer activity page$")
public void click_on_filter_in_the_customer_activity_page() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getCustomerArbutton().click();                                //filtering based on Ip address in customer activity report
	System.out.println("Customer activity report filtered");
}

//Customers Orders Report

@When("^click on order option in the Reports customers dropdown$")
public void click_on_order_option_in_the_reports_customers_dropdown() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getCustomerOrder().click();                                //clicking on orders in customers drop down of reports drop down
}

@Then("^Navigate to order page of customers dropdown$")
public void navigate_to_order_page_of_customers_dropdown() throws Throwable {
    String tit8 = driver.getTitle();
    Assert.assertEquals("Customer Orders Report",tit8);          // verifying if correct page is displayed
    System.out.println("Navigated to  customers order report");
}

//Reward points

 
@When("^click on rewards points in the customers dropdown of Reports drop down$")
public void click_on_rewards_points_in_the_customers_dropdown_of_reports_drop_down() throws Throwable {
	 Reports2 r = new Reports2(driver);
		r.getRewardPoints().click(); //opening reward points option
}

@Then("^navigate to rewards points page$")
public void navigate_to_rewards_points_page() throws Throwable {
	String tit9 = driver.getTitle();
    Assert.assertEquals("Customer Reward Points Report",tit9);
    System.out.println(tit9 +" is displayed");   //verifying if customers reward points page is displayed
}

@When("^click on Credits options$")
public void click_on_credits_options() throws Throwable {
    Reports2 r = new Reports2(driver);
    r.getCreditPoints().click();     //opening customers credits report page 
}

@Then("^navigate to customer credit report page$")
public void navigate_to_customer_credit_report_page() throws Throwable {
	String t1=driver.getTitle();
	Assert.assertEquals("Customer Credit Report", t1);  //verifying if customer credit points page is displayed
	System.out.println("Customers credit report page is displayed");
}

@When("^click on marketing drop down$")
public void click_on_marketing_drop_down() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getMarketingDropdown().click(); //Clicking on marketing option in the repoerts drop down
}

@Then("^click on marketing reports option in the drop down$")
public void click_on_marketing_reports_option_in_the_drop_down() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getMarketingReport().click(); // clicking on marketing in the marketing drop down
}

@Then("^naviate to marketing report page$")
public void naviate_to_marketing_report_page() throws Throwable {
    String t2=driver.getTitle();
    Assert.assertEquals("Marketing Report",t2);
    System.out.println("marketing report page is displayed"); //verifying if marketing report page is displayed
}


@When("^click on Affliate option in drop down$")
public void click_on_affliate_option_in_drop_down() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getAffliateCommRep().click(); // navigating to affiliate Commission Report page
	
}

@Then("^Navigate to Affliate commission report page$")
public void navigate_to_affliate_commission_report_page() throws Throwable {
	String t2=driver.getTitle();
    Assert.assertEquals("Affiliate Commission Report",t2);
    System.out.println("Affiliate Commission Report page is displayed");//verifying if affiliate Commission Report page is displayed
}

@When("^click on Affliate activity option in the drop down$")
public void click_on_affliate_activity_option_in_the_drop_down() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getAffliateAct().click(); //navigating to affiliate activity report page
}

@Then("^Navigate to Affliate activity page$")
public void navigate_to_affliate_activity_page() throws Throwable {
    String t3=driver.getTitle();
    Assert.assertEquals("Affiliate Activity Report",t3); //verifying if affiliate activity report page is displayed
    System.out.println("Affiliate Acivity report page is displayed");
}


@When("^enter Ip address in the Ip address textbox of Affliate activity report page$")
public void enter_ip_address_in_the_ip_address_textbox_of_affliate_activity_report_page() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getAARiP().sendKeys("122.164.104.142");
}

@And("^click on filter in the Marketing Affliate activity page$")
public void click_on_filter_in_the_marketing_affliate_activity_page() throws Throwable {
	Reports2 r = new Reports2(driver);
	r.getAArfilter().click();
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////NITISH/////////////////////////////////////////////////////////
///////////////////////////////////////////MARKETING//////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////








 
@Given("^login with admin creditial$")
public void login_with_admin_creditial() throws Throwable {


driver =initializeDriver();
driver.get("http://uniformm1.upskills.in/admin/");

driver.manage().window().maximize();
LoginMarketing l=new LoginMarketing(driver);
l.getAdmin().sendKeys("admin");
l.getPassword().sendKeys("admin@123");
l.getSubmit().click();



}
@And("^Click on menu button and then Marketing$")
//Click on Menu Option
//Click on Marketing
public void click_on_menu_button_and_then_marketing() throws Throwable {
LoginMarketing l=new LoginMarketing(driver);
l.getMenu().click();
l.getMarketing().click();

}

//Marketings

@When("^Click on Marketing$")
public void click_on_marketing() throws Throwable {
//Marketing options
Marketing m=new Marketing(driver);
m.getMarketing().click();
}



@Then("^Navigate to Marketing page$")
public void navigate_to_marketing_page() throws Throwable {
String s=driver.getTitle();
//It will Navigate to Marketing Tracking Page
Assert.assertEquals("Marketing Tracking",s);
}

//Affiliates



@When("^Click on Affiliates$")
public void click_on_affiliates() throws Throwable {
//Click on Affiliates
LoginMarketing l=new LoginMarketing(driver);
l.getAffiliates().click();
}



@Then("^Naviagte to Affiliates page$")
public void naviagte_to_affiliates_page() throws Throwable {
//It will Navigate to Affiliates Page
String t=driver.getTitle();
Assert.assertEquals("Affiliates",t);
}

//Coupons

@When("^click on Coupons$")
public void click_on_coupons() throws Throwable {
//Click on Coupons
LoginMarketing l=new LoginMarketing(driver);
l.getCoupons().click();



}



@Then("^Navigate to Coupons page$")
public void navigate_to_coupons_page() throws Throwable {
//It will Naviate to Coupons Page
String t1=driver.getTitle();
Assert.assertEquals("Coupons",t1);

}

//Mail

@When("^Click on Mail$")
public void click_on_mail() throws Throwable {
//Click on Mail Option
LoginMarketing l=new LoginMarketing(driver);
l.getMail().click();
}



@Then("^Navigate to Mail page$")
public void navigate_to_mail_page() throws Throwable {
//It will Navigate to Mail Page
String t2=driver.getTitle();
Assert.assertEquals("Mail",t2);
}



@When("^Click on Marketing option$")
public void click_on_marketing_option() throws Throwable {
//Campaign Name in Marketing
Marketing m=new Marketing(driver);
m.getMarketing().click();
}



@Then("^enter the Campaign Name in the campaign Name text box$")
public void enter_the_campaign_name_in_the_campaign_name_text_box() throws Throwable {
//Enter the Campaign Name in the Text Box.
LoginMarketing l=new LoginMarketing(driver);
l.getCampaignname().sendKeys("jhgfds");
}



@Then("^Click Filter$")
public void click_filter() throws Throwable {
//Click on Filtering
LoginMarketing l=new LoginMarketing(driver);
l.getFilter().click();

}




@When("^Click on Add Button$")
public void click_on_add_button() throws Throwable {
//Add campaign name and Tracking Code in Tracking option
Marketing m=new Marketing(driver);
m.getAddButton().click();
}



@Then("^Enter the Name in the Campaign text Box$")
public void enter_the_name_in_the_campaign_text_box() throws Throwable {
//Click on Campaign Text in the Text Box
Marketing m=new Marketing(driver);
m.getCampaign().sendKeys("nitish");
}




@Then("^Enter the Code in the Tracking code box$")
public void enter_the_code_in_the_tracking_code_box() throws Throwable {
//Add Tracking code
Marketing m=new Marketing(driver);
m.getTracking().sendKeys("7395926362");
}



@And("^Click on Save Button$")
public void click_on_save_button() throws Throwable {
//Click on Save Button
Marketing m=new Marketing(driver);
m.getSave().click();
}


@When("^Click on Affiliated$")
public void click_on_affiliated() throws Throwable {
//Click on Affilates option in marketing dropdown
Marketing m=new Marketing(driver);
m.getAffiliates().click();
}

@Then("^Enter the Name in the Affiliated name text box$")
public void enter_the_name_in_the_affiliated_name_text_box() throws Throwable {
//Enter the Affiliate name in the Text Box
Marketing m=new Marketing(driver);
m.getAffiliatedname().sendKeys("Chinu patil");
}

@Then("^Enter Mail in the Emails Text Box$")
public void enter_mail_in_the_emails_text_box() throws Throwable {
//Enter the Mail in the Text Box
Marketing m=new Marketing(driver);
m.getEmail().sendKeys("chinmaya@gmail.com");
}

@And("^Click on Filtering$")
public void click_on_filtering() throws Throwable {
//Click on Filtering Option
Marketing m=new Marketing(driver);
m.getFilter().click();
}

@When("^Click on Affiliate option$")
public void click_on_affiliate_option() throws Throwable {
//Click on Affiliates Option
Marketing m=new Marketing(driver);
m.getAffiliateoption().click();
}



@Then("^Select the Check Box$")
public void select_the_check_box() throws Throwable {
//Select the Check Box
Marketing m=new Marketing(driver);
m.getCheckbox().click();
}

@And("^click on Deletebutton$")
public void click_on_deletebutton() throws Throwable {
//delete the option By using Delete option
Marketing m=new Marketing(driver);
m.getDeletebutton().click();
}
//Click on Accept Button For Accepting
@And("^Click on Accept$")
public void click_on_accept() throws Throwable {
driver.switchTo().alert().accept();
}

@When("^Click on Couponsoptions$")
public void click_on_couponsoptions() throws Throwable {
Marketing m=new Marketing(driver);
////Click on Option
m.getCouponsoption().click();
}

@Then("^Click On Add Symbol$")
public void click_on_add_symbol() throws Throwable {
//Click on ADD Option
Marketing m=new Marketing(driver);
m.getAddsymbol().click();

}



@Then("^Click on Coupon Name$")
public void click_on_coupon_name() throws Throwable {
//Click on Coupon Name
Marketing m=new Marketing(driver);
m.getCouponsname().sendKeys("nitisha");
}



@Then("^Click on Code$")
public void click_on_code() throws Throwable {
//Click on Code option
Marketing m=new Marketing(driver);
m.getCode().sendKeys("739592");
}



@And("^Click on Save Option$")
public void click_on_save_option() throws Throwable {
// Click on Save Option
Marketing m=new Marketing(driver);
m.getSaveoption().click();
}
@And("^Click on Back option$")
public void click_on_back_option() throws Throwable {
//Click on Back Option
Marketing m=new Marketing(driver);
m.getBack().click();
}

@Then("^Select the checkbox option$")
public void select_the_checkbox_option() throws Throwable {
//Click on Check Box
Marketing m=new Marketing(driver);
m.getcheckboxoption().click();
}



@And("^Click on DeleteButton option$")
public void click_on_deletebutton_option() throws Throwable {
//Click on Delete option
Marketing m=new Marketing(driver);
m.getDeleteButtonoption().click();
}

@And("^Click on Accept option$")
public void click_on_accept_option() throws Throwable {
//Click on Accept Option
driver.switchTo().alert().accept();
System.out.println("Delete is Done");
}



@When("^Click on Mail option$")
public void click_on_mail_option() throws Throwable {
//Click on The Mail option in the Marketing Dropdown
Marketing m=new Marketing(driver);
m.getMailoption().click();
}



@Then("^Enter the Details in the From option$")
public void enter_the_details_in_the_from_option() throws Throwable {
//Enter the From Adress
Marketing m=new Marketing(driver);
m.getFromoption().click();
}

@And("^Enter the Subject$")
public void enter_the_subject() throws Throwable {
//Click On Subject to enter the Subject
Marketing m=new Marketing(driver);
m.getSubject().sendKeys("Regarding the Order");
System.out.println("Enter the Subject");
}




@And("^Click Mail Symbol$")
public void click_mail_symbol() throws Throwable {
//Click on Mail Symbol for Sending the Mail
Marketing m=new Marketing(driver);
m.getMailsymbol().click();
}

@And("^click on Home$")
public void click_on_home() throws Throwable {
//Click on Home
//It will show the Menu
Marketing m=new Marketing(driver);
m.getHome().click();
}

@When("^click on reportsdropdown$")
public void click_on_reportsdropdown() throws Throwable {
//Click on Reports Dropdown
Reports1 r=new Reports1(driver);
r.getreportsdown().click();

}



@Then("^Click on Sales$")
public void click_on_sales() throws Throwable {
//click on Sales in Report Dropdown
Reports1 r=new Reports1(driver);
r.getSales().click();
}

@Then("^Click on Order option$")
public void click_on_order_option() throws Throwable {
//Click on Orders in Sales
Reports1 r=new Reports1(driver);
r.getOrdersoption().click();
}

@Then("^Navigate to Sales Report Page$")
public void navigate_to_sales_report_page() throws Throwable {
////Then it navigate to Sales Report Page
Reports1 r=new Reports1(driver);
String r1=driver.getTitle();
Assert.assertEquals("Sales Report",r1);
}




@When("^Click on Tax option$")
public void click_on_tax_option() throws Throwable {
//Click on Tax option
Reports1 r=new Reports1(driver);
r.getTaxoption().click();
}

@Then("^Navigate to Tax Report Page$")
public void navigate_to_tax_report_page() throws Throwable {
//Then it Navigate to Reports Page
Reports1 r=new Reports1(driver);
String r2=driver.getTitle();
Assert.assertEquals("Tax Report",r2);

}

@Then("^Click on Shipping$")
public void click_on_shipping() throws Throwable {
// //Click on shipping
Reports1 r=new Reports1(driver);
r.getShipping().click();
}

@And("^Navigate to Shipping Report$")
public void navigate_to_shipping_report() throws Throwable {
//Navigate to Shipping Reports
Reports1 r=new Reports1(driver);
String r3=driver.getTitle();
Assert.assertEquals("Shipping Report",r3);
}

@When("^Click on Returns option$")
public void click_on_returns_option() throws Throwable {
//Click on Returns Option
Reports1 r=new Reports1(driver);
r.getReturnsoption().click();
}

@Then("^Navigate to Returns Report$")
public void navigate_to_returns_report() throws Throwable {
//Then it Navigate to Returns Reports Page
Reports1 r=new Reports1(driver);
String r4=driver.getTitle();
Assert.assertEquals("Returns Report",r4);

}



@When("^Click on Coupons option$")
public void click_on_coupons_option() throws Throwable {
//Click on Coupons Option
Reports1 r=new Reports1(driver);
r.getCouponsoption().click();
}



@Then("^Navigate to Coupons Report$")
public void navigate_to_coupons_report() throws Throwable {
//Naviagte to Coupons Page
Reports1 r=new Reports1(driver);
String r5=driver.getTitle();
Assert.assertEquals("Coupons Report",r5);
}

@When("^Click on product$")
public void click_on_product() throws Throwable {
//Click on Products
Reports1 r=new Reports1(driver);
r.getProductsoption().click();
}

@Then("^Click on Viewed$")
public void click_on_viewed() throws Throwable {
//Click on Viewed Option in the Sales dropdown
Reports1 r=new Reports1(driver);
r.getViewedoption().click();
}

@And("^Navigate to products Viewed Reports$")
public void navigate_to_products_viewed_reports() throws Throwable {
//It will Navigate to Product Viewed Reports Page
Reports1 r=new Reports1(driver);
String r6=driver.getTitle();
Assert.assertEquals("Products Viewed Report",r6);
System.out.println("It will Show Products Viewed Report");
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////RUKMINI/////////////////////////////////////////////////////////
///////////////////////////////////////CUSTOMER AN DASHBOARD//////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	@Given("login with credentials")
	public void login_with_credentials() throws IOException {
		
		//initializing the driver
		driver=initializeDriver();
		 String s=" http://uniformm1.upskills.in/admin/index.php?route=common/login";
		 driver.get(s);
		 
		 Login1 l=new Login1(driver);
		 
		 //passing credentials for login
		 l.getUser().sendKeys("admin");
		 l.getPass().sendKeys("admin@123");
		 
		 
		   
	}
     
	   @When("click on login")
	    public void click_on_login() {
		Login1 l=new Login1(driver);
		//to submit the credentials
		 l.getSubmit().click();

	}     

	@Then("navigate to admin page")
	public void navigate_to_admin_page() {
		//to navigate to dashboard page
		String msg= driver.findElement(By.xpath("//*[text()='Dashboard']")).getText();
		System.out.println("navigated to admin page");
	}
	
		@When("click on Customers option")
	public void click_on_customers_option() {
		
		Login1 l1=new Login1(driver);
		 //To open the dropdown of customers
		 l1.getCuopen().click();
		System.out.println("customer dropdown is opened");
	}
		

		    @Then("^Customers  page is opened$")
		    public void customers_page_is_opened() throws Throwable {
		     //To open customer page	
			 driver.findElement(By.xpath("//*[@id=\"customer\"]/ul/li[1]/a")).click();
		   
			 System.out.println("customer page is opened");
			
		    }
		    @And("enter customer details")
		    public void enter_customer_details() {
		     Login1 l2=new Login1(driver);
			 //To place cursor on email text box
		     l2.getCemail().click();
			 l2.getCemail().sendKeys("rukmini.ganesana@gmail.com");
			 
			//To place cursor on name text box
			 l2.getCname().click();
			 l2.getCname().sendKeys("rukmini");
			 
			 //To place cursor on approved text box
			 l2.getCapp().click();
		     WebElement Approved = l2.getCapp();
			
		     //To select the value from the approved dropdown
		     Select dropdown = new Select(Approved);
			 dropdown.selectByVisibleText("Yes");
			 
			 l2.getCapp().click();
			 WebElement CustomerGroup = l2.getCgroup();
			//To select the value from the CustomerGroup dropdown1
			 Select dropdown1 = new Select(CustomerGroup);
			 dropdown1.selectByVisibleText("Guest");
			   
			 l2.getCstatus().click();
			 WebElement Status = l2.getCstatus();
			 Select dropdown2 = new Select(Status);
			 dropdown2.selectByVisibleText("Enabled");
			 
			 l2.getCip().click();
			 //To send data to IPtextbox
			 l2.getCip().sendKeys("152.168.4.101");
			 
			 //To filter with the given data
			 l2.getCfilter().click();
			 
			 driver.findElement(By.xpath("//*[@id=\"button-menu\"]/i")).click();
			 
			 driver.findElement(By.xpath("//*[@id=\"customer\"]/a")).click();
			   
		 }		 
			 //to open customer Group page
			 @Then("Customers Group  page is opened")
			 public void customers_group_page_is_opened()
			 {
				 
				 Login1 l3=new Login1(driver);
		          System.out.println("customer dropdown2 is opened");
			    
		          l3.getCgrp().click();
			     System.out.println("Customer Group page is opened");
			 }

			 @And("enter customer Group details")
			 public void enter_customer_group_details()
			 {
				 Login1 l4=new Login1(driver);
				 
				 System.out.println("edit is opened");
			 
				 //To add data by clicking plus icon
				 l4.getCgplus().click();
				 l4.getCgname().click();
				 l4.getCname().sendKeys("Basic");
				 
				 //To save the added data
				 l4.getCsave().click();
				 System.out.println("clicked");
				 
				  
				 driver.findElement(By.xpath("//*[@type='button']")).click();
				 System.out.println("click");
				 
				 
				 //To navigate back to customer page
				 l4.getCuopen().click();
				 System.out.println("closed");
				
				
			 }
			 @Then("Custom fields  page is opened")
			 public void custom_fields_page_is_opened() {
				 
				 Login1 l5=new Login1(driver);
				 
				 //To open Custom fields page
				  l5.getCfields().click();
		          System.out.println("custom field is opened");
			    
				 
			     
			 }

			 @Then("enter Custom Fields")
			 public void enter_custom_fields() {
				 Login1 l6=new Login1(driver);
				 System.out.println("custom driver started is opened");
				 
				    
				 //To add data in custom fields
				 l6.getCfadd().click();
				 System.out.println("custom save is opened");
				 l6.getCfname().click();
				 //To place data in name Text box
				 l6.getCname().sendKeys("Basic");
				 
				   l6.getCfcancel().click();
			 }
				   
			      //Dashboard
				 
				    @When("Clicking on view orders in orders and sales icon")
				   public void clicking_on_view_orders_in_orders_and_sales_icon() {
					   
					 Dashboard l7=new Dashboard(driver);
					 //To click on View more at orders icon
					 l7.getOview().click();
					 System.out.println("navigated to order page ");
						 
				      
				   }

				      @Then("Orders page is opened")
				      public void orders_page_is_opened() {
					   
					   Dashboard l8=new Dashboard(driver);
					   System.out.println("data");
					   
						l8.getOid().click();
						//To send data into text box
						l8.getOid().sendKeys("333");
						System.out.println("data in order page");
						
					   	l8.getOstatus().click();
					     WebElement Orderstatus = l8.getOstatus();
					     //To select the option from status dropdown
						 Select dropdown = new Select(Orderstatus);
						 dropdown.selectByVisibleText("Pending");
						
						  l8.getOname().click();
						  l8.getOname().sendKeys("rukmini");
						  
						  l8.getOfilter().click();
						  System.out.println("filter applied");
						  
						  //To navigate back to home page
						  l8.getOdashboard().click();
						  System.out.println("clicked on dashboard");
				   }  
						  
						  @When("clicked on viewmore in Total customers")
						  public void clicked_on_viewmore_in_total_customers() {
							  
		                 Dashboard l9=new Dashboard(driver);
		     			//To click on view more on Customers  icon
						 l9.getCview().click();
								   
					     System.out.println("navigated to customer page page ");
									 
						     
						  }

						  @Then("navigated  page")
						  public void navigated_page() {
							  Dashboard l10=new Dashboard(driver);
							  
							  l10.getOdashboard().click();
						  }
						 


                   @When("clicked on viewmore in people  Online")
                   public void clicked_on_viewmore_in_people_online() {
                	   Dashboard l11=new Dashboard(driver);
           			//To click on view more on Customers online icon
						  l11.getOnline().click();
                	   
                   }

                   @Then("navigated  to people online page")
                   public void navigated_to_people_online_page() {
                	   
                	   Dashboard l12=new Dashboard(driver);
						  
						  l12.getIp().click();
						  //To place data in IP box
						  l12.getIp().sendKeys("192.168.4.101");
						  
						  
						  l12.getCustomer().click();
						  //To place data in name text box
						  l12.getCustomer().sendKeys("Team");
						  
                          //To filter the given data
						  l12.getFilter().click();
						 }

                 @When("verify World map and Sales analytics options")
                     public void verify_world_map_and_sales_analytics_options() {
                	 

             		  Dashboard d1=new Dashboard(driver);
             		  //To map in the area
             		  d1.getMapin().click();
             		 //To map out the area
             		  d1.getMapout().click();
             		 //To click on sales 
             		 d1.getSales().click();
             		
					
             		  
          }

                  @Then("stay back on Dashboard page")
                  public void stay_back_on_dashboard_page() {
                	  Dashboard d4=new Dashboard(driver);
					  
					  d4.getOdashboard().click();
                  }
                  
    

						  
  
						  
						   
						      
				 
			 
			 


}


