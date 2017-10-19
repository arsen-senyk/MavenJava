package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.login_page;

import java.util.concurrent.TimeUnit;

public class login_test {

    @Test
    public void Login_success(){

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        login_page getObjLogin = new login_page(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getObjLogin.Login_to_Gmail();
        Assert.assertEquals("Gmail", driver.getTitle());
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
