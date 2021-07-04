package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class searchPage {
	
	WebDriver driver;	
	
	//page product heading
	By txt_heading=By.xpath("//*[@data-locator='search-product-tile-title-0']");
	//first product image
	By img_product=By.xpath("//*[@data-locator='search-product-tile-image-0']");
	
	By txt_heading2=By.xpath("//*[@data-locator='product-title'][@class='MuiTypography-root productItemName  MuiTypography-h1']");
	
	By btn_addToCart=By.xpath("//*[@tabindex='0'][@data-locator='atcButton'][span[text()='Add to Cart']]");
	
	By btn_review=By.xpath("//*[@class='MuiButton-label'][text()='Review & checkout']");
	
	By btn_cartIcon=By.xpath("//a[@id='icon-cart'][@data-locator='icon-cart']");
	
	By txt_totalPrice=By.xpath("//*[@data-locator='tile_TotalPrice']");
	
	By txt_headingOnCartPage=By.xpath("//*[@datalocator='ItemForClickCollect_Product_Name']");
		
	
	
	public searchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public String returnProductHeading() throws InterruptedException {
		Thread.sleep(5000);
		String productHeading=driver.findElement(txt_heading).getText();
		return productHeading;
		
	}
	
	
	
	public String gotoPDP() throws InterruptedException {
		driver.findElement(img_product).click();
		Thread.sleep(5000);
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,10);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.presenceOfElementLocated (txt_heading));
//		driver.getPageSource().contains(productHeading);
	      
	      String heading2=driver.findElement(txt_heading2).getText();
	   	return heading2;
		
	}
	
	
	public void addToCart() throws InterruptedException {
		System.out.println("User clicks on add to cart button");
		Thread.sleep(2000);
		driver.findElement(btn_addToCart).click();
		WebDriverWait w1 = new WebDriverWait(driver,10);
	      // presenceOfElementLocated condition
	      w1.until(ExpectedConditions.presenceOfElementLocated(btn_review));
	
	}
	
	
	public void clickCartIconValidateProduct() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Click on the cart");
		String headingBeforeClickingCart=driver.findElement(txt_heading2).getText();
		System.out.println("Product heading before clicking the cart "+headingBeforeClickingCart);
		driver.findElement(btn_cartIcon).click();
		Thread.sleep(2000);
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,3);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.presenceOfElementLocated (txt_totalPrice));
	      String totalPrice = driver.findElement(txt_totalPrice).getText();
			String headingAfterClickingCart=driver.findElement(txt_headingOnCartPage).getText();
			System.out.println("Total price is "+totalPrice);
			System.out.println("Product heading after clicking the cart "+headingAfterClickingCart);
			   if(headingBeforeClickingCart.equalsIgnoreCase(headingAfterClickingCart))
		        	System.out.println("The expected heading "+headingAfterClickingCart+" is same as actual heading --- "+headingBeforeClickingCart);
			      else
			    	  System.out.println("The expected heading "+headingAfterClickingCart+" doesn't match the actual heading --- "+headingBeforeClickingCart);
	}
	
		
	
	

}
