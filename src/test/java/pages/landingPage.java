package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class landingPage {
	
	WebDriver driver;	
	
	//search text box
	By txt_search=By.name("q");
		
	
	
	public landingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void gotoLandingPage(String url) throws InterruptedException {
		System.out.println("Navigating to "+url);
		driver.navigate().to(url);
		Thread.sleep(2000);
	}
	
	public void searchProduct(String searchItem) throws InterruptedException {
		System.out.println("user enters the search item");
		Thread.sleep(2000);
		driver.findElement(txt_search).sendKeys(searchItem);
		System.out.println("user hit enter");
		Thread.sleep(2000);
		driver.findElement(txt_search).sendKeys(Keys.ENTER);
		
	}
	
	
		
	
	public void validateLogin() {
		boolean Error = driver.getPageSource().contains("Your email address or password is incorrect");
	    if (Error == true)
	    {
	     System.out.print("Login unsuccessful");
	    }
	    else
	    {
	     System.out.print("Login successful");
	    }
	}

}
