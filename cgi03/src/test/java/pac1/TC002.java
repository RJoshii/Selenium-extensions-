package pac1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002
{
	public static void main(String[] args) {
        // Setup WebDriver and launch the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/?zx=1756096105173&no_sw_cr=1");
        System.out.println("title is:"+driver.getTitle());
		driver.navigate().to("https://www.yahoo.com");
		System.out.println("title is:"+driver.getTitle());
		driver.navigate().back();
		System.out.println("After back title is:"+driver.getTitle());
		driver.navigate().forward();
		System.out.println("After forward title is:"+driver.getTitle());
	    //driver.get("https://www.yahoo.com");
		//System.out.println("title is:"+driver.getTitle());
		//System.out.println("url is:"+driver.getCurrentUrl());
		//System.out.println("page source is:"+driver.getPageSource());
		
 
	}

}
