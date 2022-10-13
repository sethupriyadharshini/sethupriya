import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Resizable {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/resizable/");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
        WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
        Actions act = new Actions(driver);
        //act.moveToElement(resize).dragAndDropBy(resize,120,15).build().perform();
        act.clickAndHold(resize).moveByOffset(120,17).release(resize).build().perform();
        //act.dragAndDropBy(resize,120,15).build().perform();
    }
}
