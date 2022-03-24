import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prajchaudhary\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        launchURL(driver);
        driver.findElement(By.xpath("//a[contains(@href,'/frames')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'/nested_frames')]")).click();
        driver.switchTo().frame("frame-left");
        System.out.println(driver.getTitle());
    }
     public static void launchURL(WebDriver driver) throws InterruptedException{
         driver.get("https://www.google.com");
         Thread.sleep(3000);
         driver.manage().window().maximize();
         driver.get("https://the-internet.herokuapp.com");

     }
}
