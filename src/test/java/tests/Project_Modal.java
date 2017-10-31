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
        Main_page.wait_page_loaded();
        driver.findElement(By.xpath("//div[@class='connect-google']")).click();
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.id("identifierId")).sendKeys("arsen@jssolutionsdev.com" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf'][@name='password']")).sendKeys("burunduk20107" + Keys.ENTER);

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='RveJvd snByac']")));
        new WebDriverWait(driver, 5).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//span[@class='RveJvd snByac']"))));
        driver.findElement(By.xpath("//span[@class='RveJvd snByac'][text()='ALLOW']")).click();

        driver.switchTo().window(tabs.get(0));

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
    public void create_new_project_everyone_status_view() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: Create new project");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("click on project navigator icon");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.project_icon)));
        driver.findElement(main_page_obj.project_icon).click();

        System.out.println("click on '+ New Project' icon ");
        driver.findElement(main_page_obj.new_project_button).click();

        System.out.println("enter project name");
        driver.findElement(main_page_obj.project_name).sendKeys("New project 1");

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click on everyone");
        driver.findElement(main_page_obj.everyone).click();

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click create button");
        driver.findElement(main_page_obj.create1).click();

        System.out.println("check if created project displayed and has status view");
        driver.findElement(main_page_obj.new_project1).isDisplayed();
        driver.findElement(main_page_obj.Unstarted_title).isDisplayed();
        driver.quit();
    }

    @Test(priority = 3)
    public void create_new_project_everyone_team_view() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: Create new project");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("click on project navigator icon");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.project_icon)));
        driver.findElement(main_page_obj.project_icon).click();

        System.out.println("click on '+ New Project' icon ");
        driver.findElement(main_page_obj.new_project_button).click();

        System.out.println("enter project name");
        driver.findElement(main_page_obj.project_name).sendKeys("New project 2");

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click on everyone");
        driver.findElement(main_page_obj.everyone).click();

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click team view");
        driver.findElement(main_page_obj.team_view).click();

        System.out.println("click create button");
        driver.findElement(main_page_obj.create1).click();

        System.out.println("check if created project displayed and has team view");
        driver.findElement(main_page_obj.new_project2).isDisplayed();
        driver.findElement(main_page_obj.Unassigned_title).isDisplayed();

        driver.quit();
    }

    @Test(priority = 4)
    public void create_new_project_everyone_calendar_view() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: Create new project");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("click on project navigator icon");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.project_icon)));
        driver.findElement(main_page_obj.project_icon).click();

        System.out.println("click on '+ New Project' icon ");
        driver.findElement(main_page_obj.new_project_button).click();

        System.out.println("enter project name");
        driver.findElement(main_page_obj.project_name).sendKeys("New project 3");

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click on everyone");
        driver.findElement(main_page_obj.everyone).click();

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click team view");
        driver.findElement(main_page_obj.calendar_view).click();

        System.out.println("click create button");
        driver.findElement(main_page_obj.create1).click();

        System.out.println("check if created project displayed and has team view");
        driver.findElement(main_page_obj.new_project3).isDisplayed();
        driver.findElement(main_page_obj.drop_down).isDisplayed();

        driver.quit();
    }

    @Test(priority = 5)
    public void create_new_project_everyone_label_view() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: Create new project");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("click on project navigator icon");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.project_icon)));
        driver.findElement(main_page_obj.project_icon).click();

        System.out.println("click on '+ New Project' icon ");
        driver.findElement(main_page_obj.new_project_button).click();

        System.out.println("enter project name");
        driver.findElement(main_page_obj.project_name).sendKeys("New project 4");

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click on everyone");
        driver.findElement(main_page_obj.everyone).click();

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click label view");
        driver.findElement(main_page_obj.label_view).click();

        System.out.println("click create button");
        driver.findElement(main_page_obj.create1).click();

        System.out.println("check if created project displayed and has label view");
        driver.findElement(main_page_obj.new_project4).isDisplayed();
        driver.findElement(main_page_obj.Unlabeled_title).isDisplayed();

        driver.quit();
    }

    @Test(priority = 6)
    public void create_new_project_everyone_Gantt_view() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: Create new project");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("click on project navigator icon");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.project_icon)));
        driver.findElement(main_page_obj.project_icon).click();

        System.out.println("click on '+ New Project' icon ");
        driver.findElement(main_page_obj.new_project_button).click();

        System.out.println("enter project name");
        driver.findElement(main_page_obj.project_name).sendKeys("New project 5");

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click on everyone");
        driver.findElement(main_page_obj.everyone).click();

        System.out.println("click next button");
        driver.findElement(main_page_obj.next).click();

        System.out.println("click Gantt view");
        driver.findElement(main_page_obj.Gantt_view).click();

        System.out.println("click create button");
        driver.findElement(main_page_obj.create1).click();

        System.out.println("check if created project displayed and has Gantt view");
        driver.findElement(main_page_obj.new_project5).isDisplayed();
        driver.findElement(main_page_obj.details_icon).isDisplayed();

        driver.quit();
    }

}
