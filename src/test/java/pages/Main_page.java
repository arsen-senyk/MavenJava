package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main_page {

    public Main_page(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;

    public By need_to_be_done = By.id("action-new-form-input");
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
    public By new_project1 = By.xpath("//div[@class='title'][text()='New project 1']");
    public By new_project2 = By.xpath("//div[@class='title'][text()='New project 2']");
    public By everyone = By.xpath("//span[@class='sub-title'][text()='All members of this workspace will be able to view this project and its actions']");
    public By team_view = By.xpath("//span[@class='main-title'][text()='Team View']");
    public By label_view = By.xpath("//span[@class='main-title'][text()='Label View']");
    public By calendar_view = By.xpath("//span[@class='main-title'][text()='Calendar']");
    public By Gantt_view = By.xpath("//span[@class='main-title'][text()='Gantt View']");
    public By Unassigned_title = By.xpath("//h4[@class='kanban-list-title'][@title='Unassigned']");
    public By Unstarted_title = By.xpath("//h4[@class='kanban-list-title'][@title='Unstarted']");
    public By Unlabeled_title = By.xpath("//h4[@class='kanban-list-title'][@title='Unlabeled']");
    public By new_project3 = By.xpath("//div[@class='title'][text()='New project 3']");
    public By new_project4 = By.xpath("//div[@class='title'][text()='New project 4']");
    public By drop_down = By.xpath("//div[@class='dropdown row-item view-by-dropdown']");
    public By new_project5 = By.xpath("//div[@class='title'][text()='New project 5']");
    public By details_icon = By.xpath("//span[@class='icon-title'][text()='Details']");
    public By group = By.xpath("//span[@id='new-group']//i[@class='fa fa-plus']");
    public By group_name = By.xpath("//input[@id='new-group-name']");
    public By checkbox_barb = By.xpath("//div[@class='person-select'][text()='Barb (Demo)']");
    public By checkbox_landon = By.xpath("//div[@class='person-select'][text()='Landon (Demo)']");
    public By submit = By.xpath("//button[@class='btn btn-primary'][text()='Save']");
    public By technical = By.xpath("//div[@class='group-text']//span[text()='Technical']");
    public By expand = By.xpath("//i[@class='fa fa-angle-double-right expand-panel']");
    public By everyone_title = By.xpath("//span[@class='group-name truncate'][text()='Everyone']");
    public By collapse = By.xpath("//i[@class='fa fa-angle-double-left']");
    public By Landon_message = By.xpath("//div[@class='group-text make-strong unread']//span[text()='Landon (Demo)']");
    public By message_field = By.xpath("//div[@id='message-input-box-new'][@class='needsclick']");
    public By message_send = By.xpath("//p[@class='no-padding message-text def-body-text-msg-act'][text()='Hello, Landon!']");
    public By RW_icon = By.xpath("//span[@class='initials'][text()='RW']");
    public By action_template = By.xpath("//a[@class='manage-workflows'][text()='Action templates']");
    public By new_action_template = By.xpath("//a[@class='new-action-template'][text()='+ Create New Action Template']");
    public By template_name = By.xpath("//input[@id='workflow-name'][@placeholder='Action template name']");
    public By assignee_button = By.xpath("//div[@class='img img-rounded-square hv-img-thumbnail person-thumb thumb-small']");
    public By multi_select = By.xpath("//div[@class='multi-select']");
    public By select_all = By.xpath("//div[@class='all-select']");
    public By add_step = By.xpath("//div[@id='add-action'][@placeholder='Add step']");
    public By plus = By.xpath("//i[@class='fa fa-plus-circle item-button add-item']");
    public By day_setup = By.xpath("//input[@class='day-offset-input']");
    public By save_action_templ = By.xpath("//button[@id='save'][text()='Save action template']");
    public By done = By.xpath("//button[@class='done btn btn-primary'][text()='Done']");
    public By create_action = By.xpath("//li[@class='create-action-icon']//a[@class='dropdown-toggle']");
    public By me = By.xpath("//span[@class='assignee-name'][text()='Me']");
    public By none = By.xpath("//div[@class='pipeline-dropdown dropdown text-center']//a[@data-toggle='dropdown']");
    public By choose_template = By.xpath("//li[@class='workflow-option']");
    public By confirm = By.xpath("//button[@data-bb-handler='confirm'][text()='Yes']");
    public By action_date = By.xpath("//div[@class='btn selected']");
    public By sub_date = By.xpath("//span[@class='hive-green']");
    public By choose_deadline = By.xpath("//span[@title='Choose deadline']");
    public By date_28 = By.xpath("//td[@class='available'][text()='28']");
    public By select_project = By.xpath("//div[@class='tag dropdown-toggle']//span[text()='Select project']");
    public By project_name1 = By.xpath("//span[@class='project-name'][text()='New project 1']");
    public By project1 = By.xpath("//div[@class='row-item picker-btn js-sortable-tab  project-view ui-droppable'][@title='New project 1']");
    public By action_proj = By.xpath("//div[@class='action-item-title def-body-text-msg-act'][text()='Action project']");


    public static void wait_page_loaded() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void javascript_click (WebElement el) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", el);
    }

    public void enter_text_by_char(WebElement elem, String str) {

        wait_page_loaded();
        String[] A = str.split("");
        for (int i = 0; i < A.length; i++) {
            driver.findElement(action_title).sendKeys(A[i]);
        }

    }

    public void new_action(String name) {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(need_to_be_done)));
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
