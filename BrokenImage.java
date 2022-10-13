import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoqa.com/broken");
        WebElement b_image = driver.findElement(By.xpath("//img[2]"));
        if(b_image.getAttribute("naturalWidth").equals("0"))
        {
            System.out.println("broken");
        }
        else
            System.out.println("not broken");
    }
}
