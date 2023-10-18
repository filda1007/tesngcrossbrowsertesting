package crosss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	
	
	private WebDriver driver;
	  private String URL = "https://www.facebook.com";
	  
	  @Parameters("browser")
	  @BeforeTest
	  public void beforeTest(String browser) {
	    if (browser.equalsIgnoreCase("firefox")) {
	      System.out.println(" Executing on Firefox");
	      System.setProperty("webdriver.firefox.driver","C:\\Users\\user\\Desktop\\Automation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
	      driver = new FirefoxDriver();
	      driver.get(URL);
	      driver.manage().window().maximize();
	    }else if (browser.equalsIgnoreCase("chrome")) {
	      System.out.println(" Executing on CHROME");
	      System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get(URL);
	      driver.manage().window().maximize();
	      
	    }else if(browser.equalsIgnoreCase("edge")) {
	      System.out.println(" Executing on EDGE");
	      System.setProperty("webdriver.edge.driver","C:\\Users\\user\\Desktop\\Automation\\edgedriver_win64\\msedgedriver.exe");
	      driver = new EdgeDriver();
	      driver.get(URL);
	      driver.manage().window().maximize();
	    }
	    else {
	      throw new IllegalArgumentException("The Browser Type is Undefined");
	    }
	    
	    
	  }
	  @Test
	  public void f() 
	  {
	    WebElement number = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	    number.sendKeys("1234567890");
	    
	    WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
	    password.sendKeys("1234");
	    
	    WebElement submit = driver.findElement(By.name("login"));
	    submit.click();  
	    
	  }
	  @AfterTest
	  public void afterTest() {
		  
	  }
}
