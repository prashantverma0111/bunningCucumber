package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class loginPage {
	
	WebDriver driver;	
	
	By txt_userProfile=By.xpath("//a[@id='icon-account'][@data-name='account'][@role='button']");
	By btn_singin=By.xpath("//button[@data-locator='Button_SignIn'][@tabindex='0']");
	By txt_username=By.xpath("//input[@name='username'][@id='okta-signin-username']");
	By txt_password=By.xpath("//input[@type='password'][@id='okta-signin-password']");
	By btn_login=By.xpath("//input[@value='Sign in'][@id='okta-signin-submit']");
	By btn_cartIcon=By.xpath("//*[@id='icon-cart'][@data-locator='icon-cart']");
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void gotoLoginPage() throws InterruptedException {
		System.out.println("Clicking on the user icon");
		driver.findElement(txt_userProfile).click();
		System.out.println("Click on sign in");
		Thread.sleep(1000);
		driver.findElement(btn_singin).click();
	}
	
	
	public void enterUserName(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void clickCartIcon() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(btn_cartIcon).click();
		Thread.sleep(5000);
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
