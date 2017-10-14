package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_page {
    WebDriver driver;

    By login_field = By.xpath("//input[@type='email'][@id='identifierId']");
    By next_button = By.xpath("//span[@class='RveJvd snByac']");
    By password_field = By.xpath("//div[@id='password']//input[@name='password']");
    data_base data = new data_base();

    public login_page(WebDriver driver){
    this.driver = driver;
}
    public void Login_to_Gmail(){

        driver.get(data.url_gmail);
        driver.findElement(login_field).sendKeys(data.login);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(next_button)));
        driver.findElement(next_button).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(password_field));
        driver.findElement(password_field).sendKeys(data.password + Keys.ENTER);

    }

}
