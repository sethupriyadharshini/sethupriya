import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragAndDropDemo {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.get("https://demoqa.com/droppable");
        /*driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        //driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
                //driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
            //driver.findElement(By.xpath("//*[@class='accept-drop-container']/div[2]"));
        Actions actions = new Actions(driver);
        //actions.clickAndHold(drag).pause(Duration.ofSeconds(2000)).moveToElement(drop).pause(Duration.ofSeconds(2000)).release().perform();
        actions.dragAndDrop(drag, drop).build().perform();

        String textTo = drop.getText();
        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: File is dropped to target as expected");
        }else {
            System.out.println("FAIL: File couldn't be dropped to target as expected");
        }*/

        /*driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element which needs to drag.
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Element on which need to drop.
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Using Action class for drag and drop.
        Actions act=new Actions(driver);

        //Dragged and dropped.
        act.dragAndDrop(From, To).build().perform();*/

        //--------------DRAGGABLE------------
        driver.get("https://jqueryui.com/draggable/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions act = new Actions(driver);
        act.dragAndDropBy(from,107,105).build().perform();

    }

}
