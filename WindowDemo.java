import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class WindowDemo {
    static WebDriver driver;

    public static void newTabbedWindows() throws InterruptedException {
        String current_window_name1 = driver.getWindowHandle();
        System.out.println("current_window_name1 : "+current_window_name1);
        driver.findElement(By.xpath("//*[@href='#Tabbed']")).click(); //Parent Window

        //System.out.println(driver.findElement(By.xpath("//*[@href='#Tabbed']")).getText());

        driver.findElement(By.xpath("//a[contains(.,'click')]")).click(); //Child Window
        Set<String> all_window_name = driver.getWindowHandles();
        System.out.println("all window names : "+all_window_name);
        for (String childwindow : all_window_name) {
            if (current_window_name1.equalsIgnoreCase(childwindow)) {
                driver.switchTo().window(current_window_name1);
                driver.close();
                System.out.println("main window closed");
                Thread.sleep(3000);
            } else {
                driver.switchTo().window(childwindow);
                driver.close();
                System.out.println("child window closed");
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://demo.automationtesting.in/Windows.html");
        newTabbedWindows();
    }
}
