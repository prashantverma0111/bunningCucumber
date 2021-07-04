package StepDefinition;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.cartPage;
import pages.landingPage;
import pages.loginPage;
import pages.searchPage;

public class BunningSearchSteps_POM_v1 {

	RemoteWebDriver driver=null;
	loginPage login;
	landingPage landingP;
	searchPage searchP;
	cartPage cartP;
//	in user
	@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("Openning up the browser");
		String projectPath=System.getProperty("user.dir");
		System.out.println("ProjectPath is "+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
// in user
	@And("user is on the Bunning landing page")
	public void user_is_on_the_bunning_landing_page() throws InterruptedException {
		landingP=new landingPage(driver);
		landingP.gotoLandingPage("https://www.bunnings.com.au/");;
		}
//	in use
	@And("user searches {string} and adds to cart")
	public void user_searches_and_adds_to_cart(String searchItem) throws InterruptedException {
		landingP=new landingPage(driver);
		landingP.searchProduct(searchItem);
		user_click_on_the_product_and_add_it_to_cart_on_product_page();
   
	}
	
	

	
// in use
	@And("user click on the product and add it to cart on product page")
	public void user_click_on_the_product_and_add_it_to_cart_on_product_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Clicking on the product");
		searchP=new searchPage(driver);
		String beforeProductHeading=searchP.returnProductHeading();
		System.out.println("product heading1 before clicking on product is "+beforeProductHeading);
		String afterProductHeading=searchP.gotoPDP();
		
		//////Clicking the product image
		System.out.println("product heading2 after clicking on product is "+afterProductHeading);
	    if(beforeProductHeading.equalsIgnoreCase(afterProductHeading))
        	System.out.println("The expected heading is same as actual heading --- "+afterProductHeading);
	    else
	    	System.out.println("The expected heading doesn't match the actual heading --- "+afterProductHeading);
	      searchP.addToCart();
		 
		
	}

	@And("user click on the cart icon")
	public void user_click_on_the_cart() throws InterruptedException {
	login=new loginPage(driver);
    login.clickCartIcon();
		
		
	}

	
		

//	in use
	@Then("cart count is updated to {int}")
	public void cart_count_is_updated_to(Integer iCount)
	{
	cartP=new cartPage(driver);
	cartP.validateCartCount(iCount);		
		
	}
	
	
	// in use
	@And("user exits")
	public void user_exits() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
	
	
	
	//in use
	@Given("^user has logged in with(.*) and (.*)$")
	public void user_has_logged_in_with	(String username,String password) throws InterruptedException {
		browser_is_open();
		user_is_on_the_bunning_landing_page();
		System.out.println("Enter login credentials");
		login=new loginPage(driver);
	    login.gotoLoginPage();
	    System.out.println("Enter login credentials");
	    login.enterUserName(username);
	    login.enterPassword(password);
	    login.clickLogin();
		login.validateLogin();
				
		
		
		
		
		
	    // Write code here that turns the phrase above into concrete actions
	    
	}


//in use
	@Then("cart is updated and has total {int} item")
	public void cart_is_updated(Integer iCount) throws InterruptedException {
		searchP=new searchPage(driver);
		searchP.clickCartIconValidateProduct();
		   cart_count_is_updated_to(iCount);

	    
	}
// in use
	@Then("user adds an item")
	public void user_adds_an_item() throws InterruptedException {
		cartP=new cartPage(driver);
		cartP.addOneMoreProdcut();
//		user_add_more_items_in_the_cart();
	    // Write code here that turns the phrase above into concrete actions
	    
	}
// in use
	@Then("user remove an item")
	public void user_remove_an_item() throws InterruptedException {
		cartP=new cartPage(driver);
		cartP.removeOneProduct();
			//		user_remove_an_item_from_cart();
		
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	//in use
	@Then("the cart is empty")
	public void the_cart_is_empty() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-locator='Button_Remove'][@name='confirm delete button']")).click();
		WebDriverWait w = new WebDriverWait(driver,10);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//h1[@data-locator='ErrorMessage_EmptyCart']")));
		String emptyMessage=driver.findElement(By.xpath("//h1[@data-locator='ErrorMessage_EmptyCart']")).getText();
		if(emptyMessage.equalsIgnoreCase("Your cart is empty!"))
		{
			System.out.println("Cart is emptied successfuly");
		}
		else
		{
			System.out.println("Cart is not empty");
		}
		
	}
	
	
	
	
// in use
	@Then("user logs out")
	public void user_logs_out() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.findElement(By.xpath("//a[@id='icon-account'][@data-name='account'][@role='button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-locator='my_account_toolbar_sign_out_link']")));
		driver.findElement(By.xpath("//a[@data-locator='my_account_toolbar_sign_out_link']")).click();
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
