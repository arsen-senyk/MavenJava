package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Main_page {

    public Main_page(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;

    By need_to_be_done = By.id("action-new-form-input");
    By create = By.xpath("//button[@class='btn btn-sm btn-primary']");
    public By test_action = By.xpath("//div[@class='action-item-input force-wrap needsclick  move ']");
    By drop_down_label = By.xpath("//div[@class='select toggles']//div[@class='dropdown label-picker']");
    By description = By.xpath("//div[@class='description-input needsclick']");
    By urgent = By.xpath("//div[@class='urgent-icon-action additional-toggle urgent']");
    By urgent_icon = By.xpath("//i[@class='fa fa-exclamation-circle urgent-red action-item-info-icon']");
    By urgent_enabled = By.xpath("//div[@class='urgent-icon-action additional-toggle urgent enabled']");
    By private_icon = By.xpath("//div[@class='lock-icon-action additional-toggle private enabled']");
    By ok = By.xpath("//button[@data-bb-handler='ok']");
    By private_icon_unchecked = By.xpath("//div[@class='lock-icon-action additional-toggle private']");
    public By action_title = By.xpath("//div[@class='action-item-input force-wrap needsclick   ']");
    By create_new = By.xpath("//a[@class='create-label']");
    By label_name_field = By.id("label-name");
    public By label_created = By.xpath("//span[@class='name'][text()='QA']");
    By close_buton = By.xpath("//button[text()='Close']");
    public By action_link = By.xpath("//div[@class='action-item-input force-wrap needsclick ']");

    public void new_action() {


        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(need_to_be_done)));
        driver.findElement(need_to_be_done).click();
        driver.findElement(need_to_be_done).sendKeys("Test action");
        driver.findElement(create).click();
    }

    public void make_action_urgent(){

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(test_action)));
        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(urgent)));
        driver.findElement(urgent).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(urgent_enabled)));
        driver.findElement(urgent_enabled).isDisplayed();

    }

    public void action_is_private() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(test_action)));
        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(private_icon)));
        driver.findElement(private_icon).isDisplayed();

    }

    public void change_private_status() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(test_action)));
        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(private_icon)));
        driver.findElement(private_icon).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(ok)));
        driver.findElement(ok).click();
        driver.findElement(private_icon_unchecked).isDisplayed();

    }

    public void change_action_title_press_enter(String new_title) {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(test_action)));
        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(action_title)));
        driver.findElement(action_title).clear();
        driver.findElement(action_title).sendKeys(new_title + Keys.ENTER);

    }

    public void change_action_title_press_close (String new_title) {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(test_action)));
        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(action_title)));
        driver.findElement(action_title).clear();
        driver.findElement(action_title).sendKeys(new_title);

        new Actions(driver).moveToElement(driver.findElement(close_buton)).click().perform();


    }

    public void create_new_label(String label_name) throws InterruptedException {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(test_action)));
        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(drop_down_label)));
        //Thread.sleep(500);
        new Actions(driver).moveToElement(driver.findElement(drop_down_label)).click().perform();
        driver.findElement(create_new).click();
        driver.findElement(label_name_field).sendKeys(label_name + Keys.ENTER);
        new Actions(driver).moveToElement(driver.findElement(drop_down_label)).click().perform();
    }

    public void add_link_to_action_title(String link) {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(test_action)));
        driver.findElement(test_action).click();
    }
}
