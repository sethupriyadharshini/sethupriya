import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TextArea {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        // by ID
        driver.findElement(By.id("name")).sendKeys("abcdef");
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        //by xpath
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abcedf@gmail.com");
        //by css selector-type 1
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abcdef");
        //by tagname
        List<WebElement> atag=driver.findElements(By.tagName("a"));
        for(WebElement a:atag)
        {
            System.out.println(a.getText());
        }
        //by css selector - type-2
        driver.findElement(By.cssSelector("textarea.form-control[id='address']")).sendKeys("123/3 b t nagar");
        //click button using name
        driver.findElement(By.name("submit")).click();
        //by linktext
        System.out.println(driver.findElement(By.linkText("Login")).isDisplayed());
        //by partial link text
        System.out.println(driver.findElement(By.partialLinkText("T")).isDisplayed());
        System.out.println(driver.findElement(By.partialLinkText("T")).getText());
        Thread.sleep(2000);
        //by class name
        driver.findElement(By.className("nav-link")).click();
        driver.quit();
    }
}
