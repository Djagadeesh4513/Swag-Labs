package swagLabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_chooseAndCheckout {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String zoom = "document.body.style.zoom='0.65'";
		js.executeScript(zoom);
		
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("secret_sauce");
		
		WebElement Login = driver.findElement(By.xpath("//input[@type='submit']"));
		Login.click();
		
		Thread.sleep(2000);
		
		String Text = driver.findElement(By.xpath("//div[text()='Swag Labs' and @class = 'app_logo']")).getText();
		if (Text.equals("Swag Labs"))
		{
			System.out.println("User Logged in successfully");
		}
		
		List<WebElement> linktexts;
		linktexts= driver.findElements(By.xpath("//div[@class='inventory_item_img']//a"));
		
		for (int i=0;i<linktexts.size();i++)   
		{  
			try
			{
				linktexts.get(i).click();
			}
			catch(StaleElementReferenceException e)
			{
				linktexts= driver.findElements(By.xpath("//div[@class='inventory_item_img']//a"));
				linktexts.get(i).click();
			}
			Thread.sleep(1000);
			try
			{
				driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
			}
			catch(StaleElementReferenceException e)
			{
				driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
			}
			
			try
			{
				driver.findElement(By.xpath("//button[@name='back-to-products']")).click();
			}
			catch(StaleElementReferenceException e)
			{
				driver.findElement(By.xpath("//button[@name='back-to-products']")).click();
			}
			Thread.sleep(1000);
		}  
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		driver.findElement(By.xpath("//div[@class='checkout_info']//input[@id='first-name']")).sendKeys("PUSHPA");
		driver.findElement(By.xpath("//div[@class='checkout_info']//input[@id='last-name']")).sendKeys("THE BOSS");
		driver.findElement(By.xpath("//div[@class='checkout_info']//input[@id='postal-code']")).sendKeys("1990");
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		
		System.out.println("\nValidation Test Passed");
		
		driver.close();
	}
}
