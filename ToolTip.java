import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //using text tool tip
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement tooltip = driver.findElement(By.cssSelector("input#age"));
        String tooltipname=tooltip.getAttribute("title");
        tooltip.sendKeys("23");
        System.out.println(tooltipname);

        //using button tool tip
        driver.get("https://demo.guru99.com/test/tooltip.html");
        WebElement div = driver.findElement(By.xpath("//a[@id='download_now']"));
        Actions action = new Actions(driver);
        action.moveToElement(div).perform();
        String tooltiptext = driver.findElement(By.xpath("//*[@class='box']/div/a")).getText();
        System.out.println(tooltiptext);
    }
}
