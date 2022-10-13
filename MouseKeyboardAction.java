import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseKeyboardAction {
    public static WebDriver driver;

    public static void doubleclick()
    {
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement dclick = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        Actions act = new Actions(driver);
        act.doubleClick(dclick).perform();
        String field2 = driver.findElement(By.id("field2")).getText();
        String field1 = driver.findElement(By.id("field1")).getText();
        if(field1.equals(field2))
            System.out.println("Matched");
        else
            System.out.println("Not Matched");
    }

    public static void keyboardtext()
    {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.switchTo().frame(driver.findElement
                (By.xpath("//iframe[@id='frame-one1434677811']")));
       WebElement Fname= driver.findElement(By.id("RESULT_TextField-1"));
       Actions act = new Actions(driver);
       act.click().keyDown(Keys.SHIFT).sendKeys(Fname,"se").perform();
    }

    public static void color()
    {
        driver.get("https://testautomationpractice.blogspot.com/");
        String name =driver.findElement(By.xpath("//name[@from='CA']"))
                .getCssValue("color");
        System.out.println(name);
    }

    public static void rightclick(){
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rclick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions act = new Actions(driver);
        act.contextClick(rclick).keyDown(Keys.ARROW_DOWN).
                click(driver.findElement(By.xpath("//span[text()='Edit']"))).perform();
        driver.switchTo().alert().accept();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //doubleclick();
        //keyboardtext();
        rightclick();
        //color();
    }

}
