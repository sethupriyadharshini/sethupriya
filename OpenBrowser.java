import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class OpenBrowser {

    /*public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C://SeleniumDriver//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }*/

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","C://SeleniumDriver//chromedriver_win32//chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/browser-windows");

            // Opening all the child window
            driver.findElement(By.id("windowButton")).click();
            driver.findElement(By.id("messageWindowButton")).click();

            String MainWindow = driver.getWindowHandle();
            System.out.println("Main window handle is " + MainWindow);

            // To handle all new opened window
            Set<String> s1 = driver.getWindowHandles();
            System.out.println("Child window handle is" + s1);
            Iterator<String> i1 = s1.iterator();

            // Here we will check if child window has other child windows and when child window
            //is the main window it will come out of loop.
            while (i1.hasNext()) {
                String ChildWindow = i1.next();
                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    driver.close();
                    System.out.println("Child window closed");
                }
            }
        }
    }


