import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BoxandRadio {
    public static WebDriver driver;

    public static void RadioButton() {
        //Radio Button
        //Thread.sleep(10000);
        List<WebElement> radiobutton = driver.findElements(By.name("optionsRadios"));
        //for(WebElement e:radiobutton)
        for (WebElement webElement : radiobutton) {
            /*String maleid = radiobutton.get(i).getAttribute("id");
            if(maleid.equalsIgnoreCase("Male"))
            {
                radiobutton.get(i).click();
                break;
            }*/
            //System.out.println(e.getText());
            // String b = radiobutton.get(i).getAttribute("id");
            // System.out.println(b);
            if (webElement.isEnabled()) {
                if (webElement.getAttribute("id").equalsIgnoreCase("female")) {
                    webElement.click();
                    break;
                }

            } else {
                System.out.println("Radiobutton is disabled : " + webElement.isEnabled());
            }

        }
    }

    public static void checkBox()
    {
        List<WebElement> checkbox = driver.findElements(By.xpath("//*[@type='checkbox' and @class='form-check-input']"));
        System.out.println("size : "+checkbox.size());
        for (WebElement webElement : checkbox) {
            //boolean b = checkbox.get(i).isSelected();
            //System.out.println(b);
            if (!webElement.isSelected()) {
                webElement.click();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        RadioButton();
        checkBox();
        driver.close();
    }




}
