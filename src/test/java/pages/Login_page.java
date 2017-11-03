package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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
    public static By continue4 = By.xpath("//button[@type='submit'][@class='hv btn btn-primary js-complete-step ladda-button']");
    By no_thanks = By.xpath("//button[@class='hv btn btn-default js-skip-step']");
    By no_thanks2 = By.xpath("//button[@class='hv btn btn-default js-complete-step']");
    By next_tip = By.xpath("//span[text()='Next tip']");
    By lets_go = By.xpath("//div[@class='js-next-step next-step']");
    By cross = By.xpath("//span[@class='fa fa-times']");

    By login_field = By.id("email-input");
    By password_field = By.id("password-input");



    public Login_page(WebDriver driver){
        this.driver = driver;
    }

    public void signup_to_Hive(String user_email) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(data.url);
        Main_page.wait_page_loaded();
        driver.findElement(join_hive).click();
        System.out.println(driver.getTitle());
        driver.findElement(continue_buton).click();
        Main_page.wait_page_loaded();
        driver.findElement(first_name).sendKeys("Rob");
        Main_page.wait_page_loaded();
        driver.findElement(last_name).sendKeys("Wilson");

        Main_page.wait_page_loaded();
        String[] B = "0981234567".split("");
        for (int i = 0; i < B.length; i++) {
            driver.findElement(phone).sendKeys(B[i]);
        }

        driver.findElement(email).click();
        Main_page.wait_page_loaded();
        String[] A = user_email.split("");
        for (int i = 0; i < A.length; i++) {
            driver.findElement(email).sendKeys(A[i]);
        }
        Main_page.wait_page_loaded();
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(data.password + Keys.ENTER);
        driver.findElement(workspace_name).sendKeys("Test_Team");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(continue4)));
        driver.findElement(continue4).click();
        driver.findElement(coffee).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(no_thanks)));
        driver.findElement(no_thanks).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(no_thanks2)));
        driver.findElement(no_thanks2).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(next_tip)));
        driver.findElement(next_tip).click();
        driver.findElement(lets_go).click();
        driver.findElement(cross).click();

    }

    public void login_to_Hive(String login) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(data.url);
        //driver.manage().window().maximize();
        driver.findElement(login_field).sendKeys(login);
        driver.findElement(password_field).sendKeys(data.password + Keys.ENTER);


    }



}
