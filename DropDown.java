import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://itera-qa.azurewebsites.net/home/automation");
        WebElement drop = driver.findElement(By.className("custom-select"));
        Select select = new Select(drop);
        List<WebElement> all_values = select.getOptions();
        for(WebElement e:all_values)
        {
            System.out.println("DropDown Values : "+e.getText());
        }
        select.selectByVisibleText("Malta");
        List<WebElement> sel_values = select.getAllSelectedOptions();;
        for(WebElement e:sel_values)
        {
            System.out.println("Selected Values : "+e.getText());
        }
    }
}
