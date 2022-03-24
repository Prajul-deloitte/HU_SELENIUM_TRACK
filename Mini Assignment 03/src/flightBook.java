import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flightBook {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prajchaudhary\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com/");
        driver.findElement(By.xpath("//span[contains(@class,'sc-gsNilK dImRia')]")).click();

    }
}
