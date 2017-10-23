package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main_page {

    public Main_page(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;

    By need_to_be_done = By.id("action-new-form-input");
    By create = By.xpath("//button[@class='btn btn-sm btn-primary']");
    public By test_action = By.xpath("//div[@autocomplete='off'][text()='Test action']");
    By drop_down_label = By.xpath("//div[@title='Choose labels']");
    By description = By.xpath("//div[@class='description-input needsclick']");
    By urgent = By.xpath("//div[@class='urgent-icon-action additional-toggle urgent']");
    By urgent_icon = By.xpath("//i[@class='fa fa-exclamation-circle urgent-red action-item-info-icon']");
    By urgent_enabled = By.xpath("//div[@class='urgent-icon-action additional-toggle urgent enabled']");
    By private_icon = By.xpath("//div[@class='lock-icon-action additional-toggle private enabled']");
    By ok = By.xpath("//button[@data-bb-handler='ok']");
    By private_icon_unchecked = By.xpath("//div[@class='lock-icon-action additional-toggle private']");

    public void new_action_name(){

        driver.findElement(need_to_be_done).click();
        driver.findElement(need_to_be_done).sendKeys("Test action");
        driver.findElement(create).click();
    }

    public void make_action_urgent(){

        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(urgent)));
        driver.findElement(urgent).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(urgent_enabled)));
        driver.findElement(urgent_enabled).isDisplayed();

    }

    public void action_is_private() {

        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(private_icon)));
        driver.findElement(private_icon).isDisplayed();

    }

    public void change_private_status() {

        driver.findElement(test_action).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(private_icon)));
        driver.findElement(private_icon).click();
        driver.findElement(ok).click();
        driver.findElement(private_icon_unchecked).isDisplayed();


    }
}
