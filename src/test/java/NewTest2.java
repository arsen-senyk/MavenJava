import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest2 {



    @Test
    public void test1() throws Throwable {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
        WebElement el1 = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/computers-notebooks/c80253/'][@class='f-menu-l-i-link f-menu-l-i-link-arrow sprite-side novisited']"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(el1));
        System.out.println(driver.getTitle());
        el1.sendKeys(Keys.ENTER);
        if (driver.getTitle().contains("Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие")) {
            new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(el1));
            el1.click();
            System.out.println(driver.getTitle());
        }
        else
            System.out.println("0");
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='pab-h1']"))));
        System.out.println("1");
        AssertJUnit.assertEquals("Комп'ютери та ноутбуки", driver.findElement(By.xpath("//h1[@class='pab-h1']")).getText());
        System.out.println("2");
        AssertJUnit.assertEquals("Доставка та оплата", driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/ua/payments-and-deliveries/']")).getText());
        System.out.println(driver.getTitle());
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/ua/computers-notebooks/c80253/");
        driver.findElement(By.xpath("//a[@class='pab-h3-link'][@href='https://rozetka.com.ua/ua/notebooks/c80004/']")).click();
        AssertJUnit.assertEquals("Тонкі та легкі", driver.findElement(By.xpath("//a[@class='pab-h4-link'][@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie/']")).getText());
        driver.findElement(By.xpath("//a[@class='pab-h4-link'][@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie/']")).click();
        AssertJUnit.assertEquals("за рейтингом", driver.findElement(By.xpath("//a[@name='drop_link'][@class='sort-view-link sprite-side']")).getText());
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='#'][@name='drop_link']"))));
        driver.findElement(By.xpath("//a[@href='#'][@name='drop_link']")).click();
        System.out.println(driver.findElement(By.xpath("//a[@class='sort-view-l-i-link novisited sprite-side'][@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie;sort=cheap/']")).getText());
        AssertJUnit.assertEquals("від дешевих до дорогих", driver.findElement(By.xpath("//a[@class='sort-view-l-i-link novisited sprite-side'][@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie;sort=cheap/']")).getText());
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='sort-view-l-i-link novisited sprite-side'][@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie;sort=cheap/']"))));
        driver.findElement(By.xpath("//a[@class='sort-view-l-i-link novisited sprite-side'][@href='https://rozetka.com.ua/ua/notebooks/c80004/filter/preset=tonkie-i-legkie;sort=cheap/']")).click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//img[@class='sprite g-list-btn-link-icon'][@src='https://i.rozetka.ua/design/_.gif']"))));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@class='sprite g-list-btn-link-icon'][@src='https://i.rozetka.ua/design/_.gif']"))));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@class='sprite g-list-btn-link-icon'][@src='https://i.rozetka.ua/design/_.gif']"))));
        driver.findElement(By.xpath("//img[@class='sprite g-list-btn-link-icon'][@src='https://i.rozetka.ua/design/_.gif']")).click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='filter-parametrs-i-l-i-default-title'][text()='Asus']")));
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='filter-parametrs-i-l-i-default-title'][text()='Asus']")));

        driver.findElement(By.xpath("//i[@class='filter-parametrs-i-l-i-default-title'][text()='Asus']")).click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='filter-parametrs-i-l-i-default-title'][text()='Тонкі та легкі']")));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='filter-parametrs-i-l-i-default-title'][text()='Тонкі та легкі']")));
        driver.findElement(By.xpath("//i[@class='filter-parametrs-i-l-i-default-title'][text()='Тонкі та легкі']")).click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='g-i-list-title']")));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='g-i-list-title']")));
        Thread.sleep(1000);
        List<WebElement> L = driver.findElements(By.xpath("//div[@class='g-i-list-title']"));
        for (WebElement i: L) {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(i));
            AssertJUnit.assertTrue(i.getText().contains("Asus"));
            System.out.println(i.getText());
        }
        driver.quit();
    }
    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/ua/");
        driver.findElement(By.xpath("//input[@autocomplete='off'][@class='rz-header-search-input-text passive']")).sendKeys("laptop Asus");
        driver.findElement(By.xpath("//input[@autocomplete='off'][@class='rz-header-search-input-text passive']")).sendKeys(Keys.ENTER);
        List<WebElement> L = driver.findElements(By.xpath("//div[@class='g-i-tile-i-title clearfix']"));
        System.out.println(L.size());
        for (WebElement i: L) {
            System.out.println(i.getText() + " " + "---");
            AssertJUnit.assertTrue(i.getText().contains("Asus"));
        }
        driver.quit();
    }


}