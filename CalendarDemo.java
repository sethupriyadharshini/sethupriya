import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

public class CalendarDemo {

    static WebDriver driver;

    static void currentdate()
    {
        //driver.findElement(By.xpath("//a[normalize-space()='12']")).click();
        Calendar cal = Calendar.getInstance();
        int con_cur_date = cal.get(Calendar.DATE);
        String cur_date = String.valueOf(con_cur_date);
        driver.findElement(By.linkText(cur_date)).click();
        //driver.findElement(By.xpath
              //  ("//table[contains(@class,'ui-datepicker-calendar')]/descendant::td"));
    }

    static void pastdate(String date,String month)
    {
        Calendar cal = Calendar.getInstance();
        int current_month=cal.get(Calendar.MONTH);
        //String m = String.valueOf(current_month);
        //System.out.println(m);
        for(int i= current_month;i>=0;i--) {
            //WebDriverWait w= (new WebDriverWait(driver, Duration.ofMillis(2000)));
            //w.until(ExpectedConditions.elementToBeClickable (By.xpath("//span[text()='Prev']")));
            driver.findElement(By.xpath("//span[text()='Prev']")).click();
            String m=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            if(m.equals(month))
            {
                List<WebElement> all_date = driver.findElements(By.xpath
                        ("//table[contains(@class,'ui-datepicker-calendar')]/descendant::td"));
                for(WebElement datee : all_date)
                {
                    String d = datee.getText();
                    if(d.equals(date))
                    {
                        datee.click();
                        break;
                    }
                }
            }
        }

    }


    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.id("datepicker")).click();
        //currentdate();
        pastdate("3","September");

    }

}
