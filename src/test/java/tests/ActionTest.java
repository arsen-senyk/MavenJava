package tests;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Data;
import pages.Login_page;
import pages.Main_page;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class ActionTest {

    //@BeforeSuite
    @Test(priority = -1)
    public void sign_up_test() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        sign_obj.signup_to_Hive(Data.email);
        driver.quit();
    }

    @Test
    public void create_new_action_from_my_Actions() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        Data data = new Data();

        sign_obj.login_to_Hive(data.email);
        main_page_object.new_action();
        driver.findElement(main_page_object.test_action).isDisplayed();

        driver.quit();

    }

    @Test(priority = 1)
    public void make_action_urgent(){

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        Data data = new Data();

        sign_obj.login_to_Hive(data.email);
        main_page_object.make_action_urgent();

        driver.quit();
    }

    @Test(priority = 2)
    public void private_action() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        Data data = new Data();

        sign_obj.login_to_Hive(data.email);
        main_page_object.action_is_private();

        driver.quit();

    }

    @Test(priority = 3)
    public void change_private_status() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        Data data = new Data();

        sign_obj.login_to_Hive(data.email);
        main_page_object.change_private_status();

        driver.quit();
    }

    @Test(priority = 4)
    public void change_action_title_press_enter() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        Data data = new Data();

        sign_obj.login_to_Hive(data.email);
        main_page_object.change_action_title_press_enter("action 2");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.test_action)));
        Assert.assertEquals("action 2", driver.findElement(main_page_object.test_action).getText());
        Thread.sleep(300);

        main_page_object.change_action_title_press_enter("");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.test_action)));
        Assert.assertEquals("", driver.findElement(main_page_object.test_action).getText());

        driver.quit();

    }

    @Test(priority = 5)
    public void change_action_title_click_close() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        Data data = new Data();

        sign_obj.login_to_Hive(data.email);
        main_page_object.change_action_title_press_close("action 3");

        Assert.assertEquals("action 3", driver.findElement(main_page_object.test_action).getText());

        driver.quit();

    }
    @Test(priority = 6)
    public void create_new_label() throws InterruptedException {

        String label_name = "QA";
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);

        sign_obj.login_to_Hive(Data.email);
        main_page_object.create_new_label(label_name);

        Assert.assertEquals(label_name, driver.findElement(main_page_object.label_created).getText());

        driver.quit();
    }
    @Test(priority = 7)
    public void add_link_to_action_title_and_click() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        String link = "https://www.google.com.ua";
        sign_obj.login_to_Hive(Data.email);
        main_page_object.change_action_title_press_close(link);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.action_link)));
        Assert.assertEquals(link, driver.findElement(main_page_object.action_link).getText());
        Thread.sleep(100);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(main_page_object.action_link)));
        driver.findElement(main_page_object.action_link).click();
        System.out.println(driver.getTitle());

        ArrayList<String> tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println(driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());

        driver.quit();
    }
}
