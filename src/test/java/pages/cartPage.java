package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class cartPage {
	
	WebDriver driver;	
	
	//Add more button
	By btn_AddProduct=By.xpath("//button[@data-locator='Btn_Increase_Quantity']");
	By btn_RemoveProduct=By.xpath("//button[@data-locator='Btn_Decrease_Quantity']");
	By txt_ItemCount=By.xpath("//*[@class='priceLineItem bold'][@data-locator='title_Total']");
	
	public cartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void addOneMoreProdcut() throws InterruptedException {
		System.out.println("Adding 1 more item to the cart");
		Thread.sleep(2000);
		driver.findElement(btn_AddProduct).click();
		Thread.sleep(2000);
		
	}//addOneMoreProduct
	
	
	
	public void removeOneProduct() throws InterruptedException {
		System.out.println("User removes an item from the cart");
		driver.findElement(btn_RemoveProduct).click();
		Thread.sleep(2000);
	}
	
	
	public void validateCartCount(Integer itemCount) {
		String totalItem=driver.findElement(txt_ItemCount).getText();
		String expectedCount="Total "+itemCount+" item(s)";
		if(totalItem.equalsIgnoreCase(expectedCount))
		        	System.out.println("Total Item count is correct --- "+expectedCount);
			      else
			    	  System.out.println("Total Item count is INCORRECT  --- "+expectedCount);
		
	}
	
	
	
	
	
	
	
	
	
		
	
	

}
