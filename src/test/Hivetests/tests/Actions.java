package tests;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Login_page;
import pages.Main_page;


import java.util.concurrent.TimeUnit;


public class Actions {

    //@BeforeSuite
    @Test(priority = -1)
    public void sign_up_test() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        sign_obj.signup_to_Hive();
        driver.quit();
    }

    @Test
    public void create_new_action_from_my_Actions() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);

        sign_obj.login_to_Hive();
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

        sign_obj.login_to_Hive();
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

        sign_obj.login_to_Hive();
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

        sign_obj.login_to_Hive();
        main_page_object.change_private_status();

        driver.quit();
    }

    @Test(priority = 4)
    public void change_action_title() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);

        sign_obj.login_to_Hive();
        main_page_object.change_action_title();

        Assert.assertEquals("action 2", driver.findElement(main_page_object.test_action).getText());
        driver.quit();
    }
    @Test(priority = 5)
    public void create_new_label() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);

        sign_obj.login_to_Hive();
        main_page_object.create_new_label();

        Assert.assertEquals("QA", driver.findElement(main_page_object.label_created).getText());

        driver.quit();

    }

}
