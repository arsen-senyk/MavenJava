package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class inbox_page {

    WebDriver driver;
    By social_mails = By.xpath("//div[@id=':2x'][@class='aKz']");
    public inbox_page(WebDriver driver) {
        this.driver = driver;
    }
    public void social_mails_click() throws InterruptedException {

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(social_mails)));
        driver.findElement(social_mails).click();
    }
}
