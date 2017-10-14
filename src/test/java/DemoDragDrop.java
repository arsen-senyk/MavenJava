import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoDragDrop {
    @Test
    public void Demo() throws InterruptedException {

// Initiate browser
            WebDriver driver=new ChromeDriver();
// Open webpage
            driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");

// Add 5 seconds wait
            Thread.sleep(3000);

// Create object of actions class
            Actions act=new Actions(driver);

// find element which we need to drag
            WebElement drag=driver.findElement(By.xpath("//div[@id='treebox2']//span[text()='Sport']"));

// find element which we need to drop
            WebElement drop=driver.findElement(By.xpath("//div[@id='treebox1']//span[text()='History']"));

// this will drag element to destination
            act.dragAndDrop(drag, drop).build().perform();

            act.dragAndDrop(driver.findElement(By.xpath("//div[@id='treebox1']//span[text()='James Johns']")), driver.findElement(By.xpath("//div[@id='treebox2']//span[text()='Magazines']"))).build().perform();
        }
}
