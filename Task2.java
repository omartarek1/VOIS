import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {
  public static void main(String[] args) throws InterruptedException {
    // Set the path to the chromedriver executable
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

    // Create a new instance of the ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Set the browser window size to 1024x768
    driver.manage().window().setSize(new Dimension(1024, 768));

    // Navigate to the KSRTC website
    driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");

    // Select "CHIKKAMAGALURU" as the source and "BENGALURU" as the destination
    //Thread.sleep(7000);
    WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"routeSlider\"]/div/div[2]/div/div/ul/li[1]/a")));
	//driver.findElement(By.xpath("//*[@id=\\\"routeSlider\\\"]/div/div[2]/div/div/ul/li[1]/a")).click();
	driver.findElement(By.cssSelector("div[onclick='populateSearch('1467469338690', 'Chikkamagaluru', '1467467616730', 'Bengaluru');']")).click();


	

	//	WebElement source = driver.findElement(By.xpath("//*[@id='fromPlaceName']"));
//	source.sendKeys("CHIKKAMAGALURU");
//	WebElement destination = driver.findElement(By.xpath("//*[@id='toPlaceName']"));
//	destination.sendKeys("BENGALURU");
//    // Select the arrival date only
    WebElement datePicker = driver.findElement(By.id("txtJourneyDate"));
    datePicker.click();
    WebElement currentMonth = driver.findElement(By.className("ui-datepicker-month"));
    while (!currentMonth.getText().equals("December")) { 
      WebElement nextMonthButton = driver.findElement(By.className("ui-datepicker-next"));
      nextMonthButton.click();
      currentMonth = driver.findElement(By.className("ui-datepicker-month"));
    }
    WebElement desiredDate = driver.findElement(By.xpath("//a[contains(text(), '25')]")); 
    desiredDate.click();

    // Click "Search for bus"
    WebElement searchButton = driver.findElement(By.id("searchBtn"));
    searchButton.click();

    // Select a seat
    WebElement selectSeat = driver.findElement(By.id("SrvcSelectBtnForward1"));
    selectSeat.click();
    
    WebElement seat = driver.findElement(By.className("selectedSeatClassS"));
    seat.click();
    WebElement customerDetails = driver.findElement(By.id("Forwardprofile-tab"));
    customerDetails.click();
    
    //Passenger Details
    driver.findElement(By.id("passengerNameForward0")).sendKeys("Omar Tarek");
    driver.findElement(By.id("mobileNo")).sendKeys("6789125987");
    driver.findElement(By.id("mobileNo")).sendKeys("omartarek1997@live.co.uk");
    WebElement gender = driver.findElement(By.id("genderCodeIdForward0"));
    Select select = new Select(gender);
    select.selectByValue("MALE");
    driver.findElement(By.id("passengerAgeForward0")).sendKeys("25");
    
    WebElement concession = driver.findElement(By.id("concessionIdsForward0"));
    Select selectConcession = new Select(concession);
    selectConcession.selectByValue("GENERAL PUBLIC");
    
    WebElement country = driver.findElement(By.id("nationalityForward0"));
    Select selectCountry = new Select(country);
    selectCountry.selectByValue("Egypt");
    
    driver.findElement(By.id("passportNoForward0")).sendKeys("00000000");
    driver.findElement(By.id("foreignerAddressForward0")).sendKeys("xxxxxxxxxx");
    
    WebElement dateField = driver.findElement(By.id("dobForward0"));
    dateField.sendKeys("1997-05-04");

    
    WebElement makePayment = driver.findElement(By.id("PgBtn"));
    makePayment.click();
    driver.quit(); 
}
}