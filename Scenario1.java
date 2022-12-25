import java.util.NoSuchElementException;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.get("https://www.amazon.com/");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("car accessories");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//String name= driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/div[2]/span/a/div/img")).getText();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/div[2]/span/a/div/img")).click();
		//driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/div[1]/h2/a/span")).click();

	    try
	    {
	    	WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
	    	addToCartButton.click();
	    } 
	    catch(NoSuchElementException e)
	    {
	        System.out.print("Item is out of stock!");
	    } 
		//driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
//		String actual= driver.findElement(By.xpath("//*[@id="sc-active-C616d6995-a7bb-4443-b380-6b8387ad3a37"]/div[4]/div/div[1]/a/img")).getText();
//		if(actual.equals(name)) {
//			System.out.println("Item added successfully");
//		}
		if(driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]")).getText().equals("1")) {
			System.out.println("Item added successfully");	
			
		}
		else {
			System.out.println("Item wasn't added to cart");
			
		}
		driver.quit();
		
		
	

	}

}
