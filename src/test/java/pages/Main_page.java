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

    public By need_to_be_done = By.id("action-new-form-input");
    By create = By.xpath("//button[@class='btn btn-sm btn-primary'][text()='Create']");
    public By test_action = By.xpath("//div[@class='action-item-input force-wrap needsclick  move ']");
    By drop_down_label = By.xpath("//div[@class='select toggles']//div[@class='dropdown label-picker']");
    By urgent = By.xpath("//div[@class='urgent-icon-action additional-toggle urgent']");
    By urgent_enabled = By.xpath("//div[@class='urgent-icon-action additional-toggle urgent enabled']");
    By private_icon = By.xpath("//div[@class='lock-icon-action additional-toggle private enabled']");
    public By ok = By.xpath("//button[@data-bb-handler='ok']");
    By private_icon_unchecked = By.xpath("//div[@class='lock-icon-action additional-toggle private']");
    public By action_title = By.xpath("//div[@class='action-item-input force-wrap needsclick   ']");
    By create_new = By.xpath("//a[@class='create-label']");
    By label_name_field = By.id("label-name");
    public By label_created = By.xpath("//span[@class='name'][text()='QA']");
    public By close_buton = By.xpath("//button[text()='Close']");
    public By action_link = By.xpath("//div[@class='action-item-input force-wrap needsclick ']");
    public By new_subaction = By.xpath("//div[@class='js-subaction-new-text needsclick']");
    public By created_subaction = By.xpath("//div[@class='action-item modal-subaction ui-sortable-handle ui-droppable']");
    public By subaction_title = By.xpath("//div[@class='action-item-input force-wrap needsclick   '][text()='subaction 1']");
    public By new_subaction_link = By.xpath("//a[@class='autolink autolink-url']");
    public By subaction = By.xpath("//div[@class='action-item modal-subaction ui-droppable']");
    public By complite_box = By.xpath("//div[@class='checkbox-custom']//i[@class='fa fa-check']");
    public By status = By.xpath("//div[@class='pipeline-dropdown dropdown text-center']//span[@class='truncate']");
    public By action_created = By.xpath("//div[@class='action-item-flex-container']");
    public By assignee_icon = By.xpath("//div[@class='img img-rounded-square initials-thumb hv-img-thumbnail person-thumb thumb-small']");
    public By unassigned = By.xpath("//div[@class='label-select choose-label choose-assignee']//span[text()='Unassigned']");
    public By assignee_icon2 = By.xpath("//div[@class='img img-rounded-square hv-img-thumbnail person-thumb thumb-small']");
    public By unassignee_icon = By.xpath("//i[@class='fa fa-check-circle icon-right isChecked']");
    public By add_comment = By.xpath("//div[@class='comment-input needsclick']");
    public By delete_icon = By.xpath("//i[@class='message-delete fa fa-trash-o']");
    public By project_icon = By.xpath("//div[@class='project-navigation-toggle'][@id='projectNavigator']");
    public By new_project_button = By.xpath("//div[@class='new-project-btn']");
    public By project_name = By.xpath("//input[@name='project-name'][@id='project-name']");
    public By next = By.xpath("//div[@class='footer-buttons']//div[@class='js-next-step btn btn-primary']");
    public By create1 = By.xpath("//div[@class='js-submit-form btn btn-primary'][text()='Create']");
    public By new_project = By.xpath("//div[@class='title'][text()='New project 1']");

    public static void wait_page_loaded() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void new_action(String name) {


        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(need_to_be_done));
        driver.findElement(need_to_be_done).click();
        driver.findElement(need_to_be_done).sendKeys(name + Keys.ENTER);
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
        new Actions(driver).moveToElement(driver.findElement(drop_down_label)).click().perform();
        driver.findElement(create_new).click();
        driver.findElement(label_name_field).sendKeys(label_name + Keys.ENTER);
        new Actions(driver).moveToElement(driver.findElement(drop_down_label)).click().perform();
    }


}
