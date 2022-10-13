import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement slider = driver.findElement(By.xpath("//span[@tabindex='0']"));
        Actions act = new Actions(driver);
        act.dragAndDropBy(slider,90,0).perform();
    }
}
