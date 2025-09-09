package swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_logOut {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String zoom = "document.body.style.zoom='0.75'";
		js.executeScript(zoom);
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("standard_user");
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		WebElement Login = driver.findElement(By.xpath("//input[@type='submit']"));
		Login.click();
		
		Thread.sleep(2000);
		
		String Text = driver.findElement(By.xpath("//div[text()='Swag Labs' and @class = 'app_logo']")).getText();
		if (Text.equals("Swag Labs"))
		{
			System.out.println("User Logged in successfully");
		}
		
		driver.findElement(By.xpath("//div/button[@type= 'button' and @id = 'react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		
		WebElement sidebar_button =  driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(sidebar_button);
		act.click(sidebar_button);
		act.build().perform();
		
		
		String Text2 = driver.findElement(By.xpath("//div[@class='login_logo' and text()='Swag Labs']")).getText();
		if (Text2.equals("Swag Labs"))
		{
			System.out.println("User Logged out successfully");
		}
		Thread.sleep(2000);
		
		System.out.println("\nVALIDATION TEST PASSED");
		
		driver.close();
	}
}
