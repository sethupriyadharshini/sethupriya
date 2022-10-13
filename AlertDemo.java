import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

    public static WebDriver driver;

    public static void WithOK()
    {
        System.out.println("*********    WITH OK STARTED    *********");
        driver.findElement(By.xpath("//*[@href='#OKTab']")).click();
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();
        String msg = "I am an alert box!";
        if(msg.equalsIgnoreCase(driver.switchTo().alert().getText()))
        {
            System.out.println("String is matched");
        }
        else
        {
            System.out.println("String Not Matched");
        }
        driver.switchTo().alert().accept();
        System.out.println("*********    WITH OK ENDED     *********");
    }

    public static void WithOKandCancel()
    {
        System.out.println("*********    WITH OK AND CANCEL STARTED     *********");
        driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        driver.switchTo().alert().dismiss();
        System.out.println("*********    WITH OK AND CANCEL ENDED     *********");

    }

    public static void WithTextBox()
    {
        System.out.println("*********    WITH TEXTBOX STARTED     *********");
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();
        driver.switchTo().alert().sendKeys("hi selenium");
        driver.switchTo().alert().accept();
        System.out.println("*********    WITH TEXTBOX ENDED     *********");

    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        WithOK();
        Thread.sleep(2000);
        WithOKandCancel();
        Thread.sleep(2000);
        WithTextBox();
    }
}
