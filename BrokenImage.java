package day13102022;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        List<WebElement> b_image = driver.findElements(By.xpath("//div/img"));
        for(WebElement w : b_image)
        {
        	if(w.getAttribute("naturalWidth").equals("0"))
            {
        		System.out.println("w get attribute: "+w.getAttribute("naturalWidth"));
                System.out.println("broken");
            }
            else
            {
            	System.out.println("w get attribute: "+w.getAttribute("naturalWidth"));
                System.out.println("not broken");
            }
        }
        
    }
}
