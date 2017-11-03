package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Data;
import pages.Login_page;
import pages.Main_page;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Project_Modal {

    /*@Test
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
*/

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
        System.out.println("TEST: create_new_project_everyone_status_view");
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
        System.out.println("TEST: create_new_project_everyone_team_view");
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
        System.out.println("TEST: create_new_project_everyone_calendar_view");
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
        Main_page.wait_page_loaded();
        driver.findElement(main_page_obj.new_project3).isDisplayed();
        driver.findElement(main_page_obj.drop_down).isDisplayed();

        driver.quit();
    }

    @Test(priority = 5)
    public void create_new_project_everyone_label_view() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: create_new_project_everyone_label_view");
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
        System.out.println("TEST: create_new_project_everyone_Gantt_view");
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

    @Test(priority = 7)
    public void create_group() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: Create group");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("click on GROUPS+");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.group)));
        driver.findElement(main_page_obj.group).click();

        System.out.println("enter group name");
        driver.findElement(main_page_obj.group_name).sendKeys("Technical");

        System.out.println("check boxes for group memebers");
        driver.findElement(main_page_obj.checkbox_barb).click();
        driver.findElement(main_page_obj.checkbox_landon).click();

        System.out.println("click submit button");
        driver.findElement(main_page_obj.submit).click();

        System.out.println("check if created group displayed");
        driver.findElement(main_page_obj.technical).isDisplayed();

        driver.quit();

    }

    @Test(priority = 8)
    public void collapse_expand_group() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: collapse_expand_group");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        Main_page.wait_page_loaded();
        System.out.println("collapse");
        driver.findElement(main_page_obj.collapse).click();

        System.out.println("expand group");
        driver.findElement(main_page_obj.expand).click();

        System.out.println("check if expand");
        driver.findElement(main_page_obj.everyone_title).isDisplayed();



        driver.quit();

    }

    @Test(priority = 9)
    public void send_message() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: send_message");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("click on Landon message icon");
        driver.findElement(main_page_obj.Landon_message).click();

        System.out.println("enter message");
        driver.findElement(main_page_obj.message_field).sendKeys("Hello, Landon!" + Keys.ENTER);

        System.out.println("check if message displayed as send");
        driver.findElement((main_page_obj.message_send)).isDisplayed();

        driver.quit();
    }

    @Test(priority = 10)
    public void action_template_create_plus_verify_deadlines() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: aaction_template_create_plus_verify_deadlines");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        System.out.println("create action template");
        driver.findElement(main_page_obj.R0_icon).click();

        driver.findElement(main_page_obj.action_template).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.new_action_template)));
        driver.findElement(main_page_obj.new_action_template).click();

        driver.findElement(main_page_obj.template_name).sendKeys("Action template 1");

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.assignee_button)));
        driver.findElement(main_page_obj.assignee_button).click();

        driver.findElement(main_page_obj.multi_select).click();

        driver.findElement(main_page_obj.select_all).click();

        driver.findElement(main_page_obj.add_step).click();
        driver.findElement(main_page_obj.add_step).sendKeys("subaction 1" + Keys.ENTER);

        driver.findElement(main_page_obj.add_step).sendKeys("subaction 2");

        driver.findElement(main_page_obj.plus).click();

        driver.findElement(main_page_obj.add_step).sendKeys("subaction 3" + Keys.ENTER);

        ArrayList<WebElement> subs = (ArrayList<WebElement>) driver.findElements(main_page_obj.day_setup);
        subs.get(1).clear();
        subs.get(1).sendKeys("2");
        subs.get(2).clear();
        subs.get(2).sendKeys("3");

        driver.findElement(main_page_obj.save_action_templ).click();

        driver.findElement(main_page_obj.done).click();

        System.out.println("create new action with template");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(main_page_obj.create_action));

        driver.findElement(main_page_obj.me).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.none)));
        ArrayList<WebElement> Drop = (ArrayList<WebElement>) driver.findElements(main_page_obj.none);
        Drop.get(1).click();

        driver.findElement(main_page_obj.choose_template).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.confirm)));
        driver.findElement(main_page_obj.confirm).click();

        System.out.println("check if correct dates displayed");

        ArrayList<WebElement> SubDates = (ArrayList<WebElement>) driver.findElements(main_page_obj.sub_date);

        Main_page.wait_page_loaded();

        Assert.assertEquals(driver.findElement(main_page_obj.action_date).getText(), SubDates.get(2).getText());

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate aftertomorrow = today.plusDays(2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d");

        Assert.assertEquals(aftertomorrow.format(formatter), SubDates.get(1).getText());
        Assert.assertEquals(tomorrow.format(formatter), SubDates.get(0).getText());


        System.out.println("create new action with deadline first and then with template");
        executor.executeScript("arguments[0].click();", driver.findElement(main_page_obj.create_action));

        driver.findElement(main_page_obj.me).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.choose_deadline)));
        driver.findElement(main_page_obj.choose_deadline).click();

        driver.findElement(main_page_obj.date_28).click();

        driver.findElement(main_page_obj.action_title).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.none)));

        ArrayList<WebElement> Drop1 = (ArrayList<WebElement>) driver.findElements(main_page_obj.none);

        Main_page.wait_page_loaded();

        Drop1.get(1).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.choose_template)));
        driver.findElement(main_page_obj.choose_template).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(main_page_obj.confirm)));
        driver.findElement(main_page_obj.confirm).click();

        ArrayList<WebElement> SubDates1 = (ArrayList<WebElement>) driver.findElements(main_page_obj.sub_date);

        System.out.println("check if correct dates displayed");

        Assert.assertEquals(driver.findElement(main_page_obj.action_date).getText(), SubDates1.get(2).getText());

        Assert.assertTrue(SubDates1.get(1).getText().contains("27"));
        Assert.assertTrue(SubDates1.get(0).getText().contains("26"));

        driver.quit();

    }

    @Test(priority = 11)
    public void action_with_project() {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("TEST: action_with_project");
        Login_page sign_obj = new Login_page(driver);
        Main_page main_page_obj = new Main_page(driver);

        System.out.println("login to Hive");
        sign_obj.login_to_Hive(Data.email2);

        driver.manage().window().maximize();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(main_page_obj.create_action));

        driver.findElement(main_page_obj.me).click();
        Main_page.wait_page_loaded();

        main_page_obj.enter_text_by_char(driver.findElement(main_page_obj.action_title),"Action project");

        ArrayList<WebElement> proj = (ArrayList<WebElement>) driver.findElements(main_page_obj.select_project);

        proj.get(0).click();

        driver.findElement(main_page_obj.project_name1).click();

        driver.findElement(main_page_obj.action_title).sendKeys(Keys.ENTER);

        //new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(main_page_obj.project1)));
        main_page_obj.javascript_click(driver.findElement(main_page_obj.project1));

        driver.findElement(main_page_obj.action_proj).isDisplayed();
        driver.quit();

    }
}
