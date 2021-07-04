//package StepDefinition;
//
//import java.awt.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.cucumber.java.en.*;
//
//public class BunningSearchSteps {
//
//	RemoteWebDriver driver=null;
//	@SuppressWarnings("deprecation")
//	@Given("browser is open")
//	public void browser_is_open() {
//
//		System.out.println("Openning up the browser");
//		String projectPath=System.getProperty("user.dir");
//		System.out.println("ProjectPath is "+projectPath);
//		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//
//	}
//
//	@And("user is on the Bunning landing page")
//	public void user_is_on_the_bunning_landing_page() throws InterruptedException {
//		System.out.println("User navigates to Bunnings website");
//		driver.navigate().to("https://www.bunnings.com.au/");
//		Thread.sleep(2000);
//	}
//
//	@When("user searches a product")
//	public void user_searches_a_product() throws InterruptedException {
//		// Write code here that turns the phrase above into concrete actions
//		System.out.println("user enters the search item");
//		Thread.sleep(2000);
//		driver.findElement(By.name("q")).sendKeys("drill");
//		System.out.println("user hit enter");
//		Thread.sleep(2000);
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//
//	}
//
//
//	@Then("user is navigated to search results")
//	public void user_is_navigated_to_search_results() throws InterruptedException {
//		System.out.println("User reaches the product search page");
//		Thread.sleep(5000);
//		driver.getPageSource().contains("\'drill\' in ");
//		 
//
//	}
//
//	@And("user click on the product and add it to cart on product page")
//	public void user_click_on_the_product_and_add_it_to_cart_on_product_page() throws InterruptedException {
//		// Write code here that turns the phrase above into concrete actions
//		System.out.println("Clicking on the product");
//		Thread.sleep(5000);
//		String productHeading=driver.findElement(By.xpath("//*[@data-locator='search-product-tile-title-0']")).getText();
//		//////Clincking the product image
//		driver.findElement(By.xpath("//*[@data-locator='search-product-tile-image-0']")).click();
//		Thread.sleep(5000);
//		@SuppressWarnings("deprecation")
//		WebDriverWait w = new WebDriverWait(driver,10);
//	      // presenceOfElementLocated condition
//	      w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@data-locator='search-product-tile-title-0']")));
////		driver.getPageSource().contains(productHeading);
//	      System.out.println("product heading1 is "+productHeading);
//	      String heading2=driver.findElement(By.xpath("//*[@data-locator='product-title'][@class='MuiTypography-root productItemName  MuiTypography-h1']")).getText();
//	      System.out.println("product heading2 is "+heading2);
//	      if(productHeading.equalsIgnoreCase(heading2))
//        	System.out.println("The expected heading is same as actual heading --- "+heading2);
//	      else
//	    	  System.out.println("The expected heading doesn't match the actual heading --- "+heading2);
//	      
//			      
//		System.out.println("User clicks on add to cart button");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@tabindex='0'][@data-locator='atcButton'][span[text()='Add to Cart']]")).click();
//		WebDriverWait w1 = new WebDriverWait(driver,10);
//	      // presenceOfElementLocated condition
//	      w1.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@class='MuiButton-label'][text()='Review & checkout']")));
//
//	}
//
//	@Then("product is added to the cart \"\"Total {int} item\"\"")
//	public void product_is_added_to_the_cart(Integer int1) throws InterruptedException {
//		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(2000);
//		System.out.println("Click on the cart");
//		driver.findElement(By.xpath("//a[@id='icon-cart'][@data-locator='icon-cart']")).click();
//		Thread.sleep(2000);
//		driver.getPageSource().contains("Total "+int1+ "item");
//		driver.getPageSource().contains("Order summary");
//		Thread.sleep(2000);
//				
//
//	}
//
//	
//	@When("user add more items in the cart")
//	public void user_add_more_items_in_the_cart() throws InterruptedException {
//		System.out.println("Adding 1 more item to the cart");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@data-locator='Btn_Increase_Quantity']")).click();
//		Thread.sleep(2000);
//		
//	}
//	
//	
//	@And("user remove an item from cart")
//	public void user_remove_an_item_from_cart() throws InterruptedException {
//		System.out.println("User removes an item from the cart");
//		driver.findElement(By.xpath("//button[@data-locator='Btn_Decrease_Quantity']")).click();
//		Thread.sleep(2000);
//		
//	}
//	
//
//	
//	@Then("cart count is updated to {int}")
//	public void cart_count_is_updated_to(Integer iCount)
//	{
//		driver.getPageSource().contains("Total "+iCount+ "item");
//	}
//	
//	
//	
//	@And("user exits")
//	public void user_exits()
//	{
//		driver.quit();
//		driver.close();
//	}
//	
//	
//	
//	
//	
//	
//	
//	@Given("user has logged in")
//	public void user_has_logged_in() throws InterruptedException {
//		browser_is_open();
//		user_is_on_the_bunning_landing_page();
//		System.out.println("Clicking on the user icon");
//		driver.findElement(By.xpath("//a[@id='icon-account'][@data-name='account'][@role='button']")).click();
//		System.out.println("Click on sign in");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[@data-locator='Button_SignIn'][@tabindex='0']")).click();
//		Thread.sleep(1000);
//		System.out.println("Enter login credentials");
//		driver.findElement(By.xpath("//input[@name='username'][@id='okta-signin-username']")).sendKeys("bunnings0111@gmail.com");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@type='password'][@id='okta-signin-password']")).sendKeys("@!Bunnings23");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@type='password'][@id='okta-signin-password']")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		System.out.println("validating login");
//		// explicit wait - to wait for the compose button to be click-able
////		@SuppressWarnings("deprecation")
////		WebDriverWait wait = new WebDriverWait(driver,30);
////		driver.findElement(By.xpath("//a[@id='icon-account'][@data-name='account'][@role='button']")).click();
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-locator='my_account_toolbar_sign_out_link']")));
//		
//		boolean Error = driver.getPageSource().contains("Your email address or password is incorrect");
//	    if (Error == true)
//	    {
//	     System.out.print("Login unsuccessful");
//	    }
//	    else
//	    {
//	     System.out.print("Login successful");
//	    }
//		
//		
//		
//		
//		
//		
//	    // Write code here that turns the phrase above into concrete actions
//	    
//	}
//
//	@And("user searches {string} and adds to cart")
//	public void user_searches_and_adds_to_cart(String searchItem) throws InterruptedException {
//		System.out.println("user enters the search item");
//		Thread.sleep(2000);
//		driver.findElement(By.name("q")).sendKeys(searchItem);
//		System.out.println("user hit enter");
//		Thread.sleep(2000);
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		user_click_on_the_product_and_add_it_to_cart_on_product_page();
//		
//	    // Write code here that turns the phrase above into concrete actions
//	    
//	}
//
//	@Then("cart is updated and has total {int} item")
//	public void cart_is_updated(Integer iCount) throws InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Click on the cart");
//		String heading3=driver.findElement(By.xpath("//*[@data-locator='product-title'][@class='MuiTypography-root productItemName  MuiTypography-h1']")).getText();
//		System.out.println("heading3 before clicking the cart "+heading3);
//		driver.findElement(By.xpath("//a[@id='icon-cart'][@data-locator='icon-cart']")).click();
//		Thread.sleep(2000);
//		@SuppressWarnings("deprecation")
//		WebDriverWait w = new WebDriverWait(driver,3);
//	      // presenceOfElementLocated condition
//	      w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@data-locator='tile_TotalPrice']")));
//		String totalPrice = driver.findElement(By.xpath("//*[@data-locator='tile_TotalPrice']")).getText();
//		String heading4=driver.findElement(By.xpath("//*[@datalocator='ItemForClickCollect_Product_Name']")).getText();
//		System.out.println("Total price is "+totalPrice);
//		System.out.println("heading4 after clicking the cart "+heading4);
//		   if(heading3.equalsIgnoreCase(heading4))
//	        	System.out.println("The expected heading is same as actual heading --- "+heading4);
//		      else
//		    	  System.out.println("The expected heading doesn't match the actual heading --- "+heading4);
//		
//
//	    
//	}
//
//	@Then("user adds an item")
//	public void user_adds_an_item() throws InterruptedException {
//		user_add_more_items_in_the_cart();
//	    // Write code here that turns the phrase above into concrete actions
//	    
//	}
//
//	@Then("user remove an item")
//	public void user_remove_an_item() throws InterruptedException {
//		user_remove_an_item_from_cart();
//	    // Write code here that turns the phrase above into concrete actions
//	    
//	}
//
//	@Then("user logs out")
//	public void user_logs_out() {
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		driver.findElement(By.xpath("//a[@id='icon-account'][@data-name='account'][@role='button']")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-locator='my_account_toolbar_sign_out_link']")));
//		driver.findElement(By.xpath("//a[@data-locator='my_account_toolbar_sign_out_link']")).click();
//	    // Write code here that turns the phrase above into concrete actions
//	    
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
