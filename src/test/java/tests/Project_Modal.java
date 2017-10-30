package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.Data;
import pages.Login_page;
import pages.Main_page;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Project_Modal {

    @Test
    public void google_signin() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: google sign in");
        driver.get(Data.url);
        driver.findElement(By.xpath("//div[@class='connect-google']")).click();
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.id("identifierId")).sendKeys("arsen@jssolutionsdev.com" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf'][@name='password']")).sendKeys("burunduk20107" + Keys.ENTER);

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='RveJvd snByac']")));
        new WebDriverWait(driver, 5).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//span[@class='RveJvd snByac']"))));
        driver.findElement(By.xpath("//span[@class='RveJvd snByac'][text()='ALLOW']")).click();

        //Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password'][@class='input__field']")).sendKeys("burunduk20107" + Keys.ENTER);

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='js-workspace-input input__field']"))));
        driver.findElement(By.xpath("//input[@class='js-workspace-input input__field']")).sendKeys("Hiveteam" + Keys.ENTER);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='js-action-input']"))));
        driver.findElement(By.xpath("//input[@class='js-action-input']")).sendKeys("Coffee" + Keys.ENTER);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='hv btn btn-default js-skip-step']"))));
        driver.findElement(By.xpath("//button[@class='hv btn btn-default js-skip-step']")).click();


        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='hv btn btn-default js-complete-step anything-connected']")));

        driver.findElement(By.xpath("//span[text()='Welcome to Hive']")).isDisplayed();

        driver.quit();
    }

    @Test(priority = 1)
    public void sign_up_test() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: sign_up_test");
        Login_page sign_obj = new Login_page(driver);
        sign_obj.signup_to_Hive(Data.email2);
        driver.quit();
    }

    @Test(priority = 2)
    public void create_new_project() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: Create new project");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);
        sign_obj.login_to_Hive(Data.email2);
        driver.findElement(main_page_obj.project_icon).click();
        driver.findElement(main_page_obj.new_project_button).click();
        driver.findElement(main_page_obj.project_name).sendKeys("New project 1");
        driver.findElement(main_page_obj.next).click();
        driver.findElement(main_page_obj.next).click();
        driver.findElement(main_page_obj.create1).click();
        driver.findElement(main_page_obj.new_project).isDisplayed();
        driver.quit();


    }
}
