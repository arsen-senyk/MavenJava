package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Login_page {

    WebDriver driver;
    Data data = new Data();
    By continue_buton = By.xpath("//button[@class='hv btn btn-primary js-ob-video-continue']");
    By join_hive = By.id("join-hive");
    By first_name = By.id("firstName");
    By last_name = By.id("lastName");
    By phone = By.id("phone");
    By email = By.id("email");
    By password = By.id("password");
    By workspace_name = By.xpath("//input[@class='js-workspace-input input__field']");
    By coffee = By.xpath("//input[@class='js-action-input']");
    By continue4 = By.xpath("//button[@type='submit'][@class='hv btn btn-primary js-complete-step ladda-button']");
    By no_thanks = By.xpath("//button[@class='hv btn btn-default js-skip-step']");
    By no_thanks2 = By.xpath("//button[@class='hv btn btn-default js-complete-step']");
    By next_tip = By.xpath("//span[text()='Next tip']");
    By lets_go = By.xpath("//div[@class='js-next-step next-step']");
    By cross = By.xpath("//span[@class='fa fa-times']");


    public Login_page(WebDriver driver){
        this.driver = driver;
    }
    public void signup_to_Hive() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(data.url);
        driver.manage().window().maximize();
        driver.findElement(join_hive).click();
        System.out.println(driver.getTitle());
        driver.findElement(continue_buton).click();
        driver.findElement(first_name).sendKeys("Rob");
        driver.findElement(last_name).sendKeys("Wilson");
        driver.findElement(phone).sendKeys("0981234567");
        driver.findElement(email).click();
        String[] A = data.email.split("");
        for(int i = 0; i < A.length - 1; i++){
            driver.findElement(email).sendKeys(A[i]);
        }
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(data.password + Keys.ENTER);
        driver.findElement(workspace_name).sendKeys("Test_Team");
        driver.findElement(continue4).click();
        driver.findElement(coffee).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(no_thanks)));
        driver.findElement(no_thanks).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(no_thanks2)));
        driver.findElement(no_thanks2).click();
        driver.findElement(next_tip).click();
        driver.findElement(lets_go).click();
        driver.findElement(cross).click();


    }

}
