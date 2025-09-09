package swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_loginIn_E2E {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String zoom = "document.body.style.zoom='0.75'";
		js.executeScript(zoom);
		Thread.sleep(1000);
		
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("standard_user");
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("secret_sauce");
		Thread.sleep(1000);
		
		WebElement Login = driver.findElement(By.xpath("//input[@type='submit']"));
		Login.click();
		
		Thread.sleep(1000);
		
		String Text = driver.findElement(By.xpath("//div[text()='Swag Labs' and @class = 'app_logo']")).getText();
		if (Text.equals("Swag Labs"))
		{
			System.out.println("User Logged in successfully");
		}
		Thread.sleep(3000);
		
		WebElement s = driver.findElement(By.className("product_sort_container"));
		Select dropdown = new Select(s); 
		dropdown.selectByValue("lohi");
		Thread.sleep(1000);
		
		//Search for an product with some keyword
		driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::a/div[contains(text(),'Jacket')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='checkout_info']//input[@id='first-name']")).sendKeys("PUSHPA");
		driver.findElement(By.xpath("//div[@class='checkout_info']//input[@id='last-name']")).sendKeys("THE BOSS");
		driver.findElement(By.xpath("//div[@class='checkout_info']//input[@id='postal-code']")).sendKeys("1990");
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		Thread.sleep(1000);
		
		System.out.println("\n-------VALIDATION TEST PASSED-------");
		
		driver.close();
	}
}
