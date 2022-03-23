import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessScenario {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prajchaudhary\\Downloads\\chromedriver.exe");
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

        launchURL(driver);
        PageTitleCheck(driver);
        loginScreen(driver);
        NavigateToPricing(driver);
        reloadPage(driver);
        driver.quit();

    }
    public static void launchURL(WebDriver driver){
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
    }
    public static void PageTitleCheck(WebDriver driver) throws InterruptedException {
        if(driver.getTitle().contains("PHPTRAVELS"))
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }
    public static void loginScreen(WebDriver driver) throws InterruptedException {
        String ParentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@class='lvl-0 sign-in btn btn-md btn-white-outline']")).click();
        if(driver.getTitle()=="PHPTRAVELS")
            System.out.println("PASS");
        else
            System.out.println("FAIL");
        Thread.sleep(5000);
        driver.switchTo().window(ParentWindow);
        String CurrentURL = driver.getCurrentUrl();
        System.out.println("Current URL : "+CurrentURL);
    }
    public static void NavigateToPricing(WebDriver driver) throws InterruptedException{
        driver.findElement(By.xpath("//a[@class='lvl-0 link nav-link' and contains(@href,'https://phptravels.com/order')]")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }
    public static void reloadPage(WebDriver driver)
    {
        driver.navigate().refresh();
    }
}
