import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

    static WebDriver driver;

    public static void singleIFrame()
    {
        System.out.println("***********     Started SingleIFrame     **********");
        driver.findElement(By.xpath("//a[@href='#Single']")).click();
        driver.switchTo().frame("singleframe");
        //driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Hello to the world");
        driver.switchTo().defaultContent();
        System.out.println("***********     End of SingleIFrame     **********");
    }

    public static void nestedFrame()
    {
        System.out.println("***********     Started NestedIFrame     **********");
        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        WebElement outerframe = driver.findElement(By.xpath("//*[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outerframe);
        //driver.switchTo().defaultContent();--> it moved to initial webpage
        //driver.switchTo().parentFrame();--> it moved to nested frame of current parent page
        WebElement innerframe = driver.findElement(By.xpath("//*[@src='SingleFrame.html']"));
        driver.switchTo().frame(innerframe);
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Hello");
        System.out.println("***********     End of NestedIFrame     **********");
    }

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.navigate().to("https://demo.automationtesting.in/Frames.html");
        singleIFrame();
        nestedFrame();
        driver.quit();
    }

}
