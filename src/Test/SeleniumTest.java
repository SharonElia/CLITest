package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Execution after setting ChromeDriver path in System Variables");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Se\\Chrome\\chromedriver.exe");
        WebDriver driver= (WebDriver) new ChromeDriver();
        driver.get("https://demoqa.com");
        Thread.sleep(3000);
        //driver.quit();
        System.out.println("Execution complete");

    }

}
