import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableDemo {
    static WebDriver driver;

    public static void statictable()
    {
        List<WebElement> w = driver.findElements(By.xpath("//*[@name='BookTable']/descendant::th"));
        int col_size=w.size();
        System.out.println(col_size);
        /*for(WebElement e : w)
        {
            System.out.print(e.getText() + "\t");
        }*/
        List<WebElement> w1 = driver.findElements(By.xpath("//*[@name='BookTable']/descendant::tr"));
        int row_size=w1.size();
        System.out.println(row_size);
        WebElement table = driver.findElement(By.xpath("//*[@name='BookTable']"));
        WebElement singlerow = table.findElement(By.xpath("//*[@name='BookTable']/tbody/tr[3]"));
        System.out.println("single row data : "+singlerow.getText());
        WebElement columndata = singlerow.findElement(By.xpath("//*[@name='BookTable']/tbody/tr[3]/td[2]"));
        System.out.println("column data : "+columndata.getText());
        for(int i=2;i<=row_size;i++)
        {
            for(int j=1;j<=col_size;j++)
            {
                //*[@id="HTML1"]/div[1]/table/tbody/tr[3] --> row
                //*[@id="HTML1"]/div[1]/table/tbody/tr[2]/td[2] -->row+column
                System.out.print(driver.findElement
                        (By.xpath("//*[@id='HTML1']/div[1]/table/tbody/tr["   +i+   "]/td["  +j+   "]")).getText());
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        statictable();
        driver.close();
    }
}
