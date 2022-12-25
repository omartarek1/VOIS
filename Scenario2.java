import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {
  public static void main(String[] args) throws InterruptedException {
    // Set the path to the chromedriver executable
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

    // Create a new instance of the ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Set the browser window size to 1024x768
    driver.manage().window().setSize(new Dimension(1024, 768));

    // Navigate to the Amazon homepage
    driver.get("https://www.amazon.com/");

    // Click on the today's deals link
    WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-xshop")));
	WebElement ele= driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", ele);

//    // Select "Headphones" and "Grocery" from the left side filters
//	wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-xshop")));
//	Thread.sleep(7000);
//    WebElement headphonesFilter = driver.findElement(By.xpath("//*[@id='leftNavContainer']/ul[1]/div/li[2]/span/span/div/label/input"));
//    headphonesFilter.click();
//    WebElement groceryFilter = driver.findElement(By.xpath("//*[@id='leftNavContainer']/ul[2]/div/li[3]/span/span/div/label/input"));
//    groceryFilter.click();
//
//    // Select "10% off or more" from the discount filter
//    WebElement discountFilter = driver.findElement(By.xpath("//*[@id='leftNavContainer']/ul[8]/div/li[2]/span/span/div/label/input"));
//    discountFilter.click();
//
//    // Go to the fourth page of the search results
//    WebElement fourthPageLink = driver.findElement(By.xpath("//*[@id='pagn']/span[7]/a"));
//    fourthPageLink.click();
	
	driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[19]/label/input")).click();
	driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[21]/label/input")).click();
	driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[6]/ul/li[2]/div/a/span")).click();
	Thread.sleep(7000); 
	driver.findElement(By.xpath("//li[@class='a-last']")).click();
	Thread.sleep(7000);
	driver.findElement(By.xpath("//li[@class='a-last']")).click();
	Thread.sleep(7000);
	driver.findElement(By.xpath("//li[@class='a-last']")).click();

    // Select any item on the fourth page of the search results
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a/div/div/img")));
	WebElement item = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a/div/div/img"));
    item.click();

    // Add the item to the cart
    WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
    addToCartButton.click();

    // Close the browser
    driver.quit();
  }
}
