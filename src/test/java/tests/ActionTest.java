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
        System.out.println("TEST: sign_up_test");
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
        System.out.println("TEST: create_new_action_from_my_Actions");

        sign_obj.login_to_Hive(Data.email);
        main_page_object.new_action("Test Action");
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
        System.out.println("TEST: make_action_urgent");

        sign_obj.login_to_Hive(Data.email);
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

        System.out.println("TEST: private_action");

        sign_obj.login_to_Hive(Data.email);
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
        System.out.println("TEST: change_private_status");

        sign_obj.login_to_Hive(Data.email);
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
        System.out.println("TEST: change_action_title_press_enter");

        sign_obj.login_to_Hive(Data.email);
        main_page_object.change_action_title_press_enter("action 2");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.test_action)));

        Assert.assertEquals(driver.findElement(main_page_object.test_action).getText(),"action 2");
        Thread.sleep(300);

        main_page_object.change_action_title_press_enter("");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.test_action)));
        Assert.assertEquals(driver.findElement(main_page_object.test_action).getText(), "");

        driver.quit();

    }

    @Test(priority = 5)
    public void change_action_title_click_close() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        System.out.println("TEST: change_action_title_click_close");

        sign_obj.login_to_Hive(Data.email);
        main_page_object.change_action_title_press_close("action 3");

        Assert.assertEquals(driver.findElement(main_page_object.test_action).getText(), "action 3");

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
        System.out.println("TEST: create_new_label");

        sign_obj.login_to_Hive(Data.email);
        main_page_object.create_new_label(label_name);

        Assert.assertEquals(driver.findElement(main_page_object.label_created).getText(), label_name);

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

        System.out.println("TEST: add_link_to_action_title_and_click");
        sign_obj.login_to_Hive(Data.email);
        main_page_object.change_action_title_press_close(link);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.action_link)));

        Assert.assertEquals(driver.findElement(main_page_object.action_link).getText(), link);

        Thread.sleep(100);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(main_page_object.action_link)));
        driver.findElement(main_page_object.action_link).click();
        ArrayList<String> tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Assert.assertEquals(driver.getTitle(), "Google");

        driver.quit();
    }
    @Test(priority = 8)
    public void create_new_subaction() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        System.out.println("TEST: create new subaction");

        System.out.println("Login to Hive");
        sign_obj.login_to_Hive(Data.email);

        System.out.println("Create new action");
        main_page_object.new_action("Action with subtaction");

        System.out.println("enter new subaction name");
        driver.findElement(main_page_object.test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.new_subaction)));
        driver.findElement(main_page_object.new_subaction).click();
        driver.findElement(main_page_object.new_subaction).sendKeys("subaction 1" + Keys.ENTER);

        System.out.println("enter second new subaction name");
        driver.findElement(main_page_object.new_subaction).click();
        driver.findElement(main_page_object.new_subaction).sendKeys("subaction 2" + Keys.ENTER);

        System.out.println("check if second subaction displayed");
        driver.findElement(By.xpath("//div[@class='action-item-input force-wrap needsclick  move '][text()='subaction 2']")).isDisplayed();
        driver.findElement(main_page_object.close_buton).click();

        System.out.println("check if subaction icon displayed on action");
        driver.findElement(By.xpath("//div[@class='subactions-count']")).isDisplayed();

        driver.quit();

    }
    @Test(priority = 9)
    public void go_to_subaction() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_object = new Main_page(driver);
        System.out.println("TEST: go to subaction");

        System.out.println("Login to Hive");
        sign_obj.login_to_Hive(Data.email);

        System.out.println("open action");
        driver.findElement(main_page_object.test_action).click();

        System.out.println("click on subaction title");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.created_subaction)));
        driver.findElement(main_page_object.created_subaction).click();

        System.out.println("Check if correct subaction modal opened");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_object.subaction_title)));
        Assert.assertEquals(driver.findElement(main_page_object.subaction_title).getText(), "subaction 1");

        driver.quit();



    }
}
