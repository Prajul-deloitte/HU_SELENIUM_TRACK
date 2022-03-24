import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class DragandDrop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prajchaudhary\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        Actions builder = new Actions(driver);
        WebElement from = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
        WebElement to = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
        int xOffset1 = from.getLocation().getX();
        int yOffset1 =  from.getLocation().getY();
        int xOffset = to.getLocation().getX();
        int yOffset =  to.getLocation().getY();
        xOffset =(xOffset-xOffset1)+10;
        yOffset=(yOffset-yOffset1)+20;
        builder.dragAndDropBy(from, xOffset,yOffset).perform();


    }
}
