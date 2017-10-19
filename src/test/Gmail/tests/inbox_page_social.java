package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.inbox_page;
import pages.login_page;

import java.util.concurrent.TimeUnit;

public class inbox_page_social {

        @Test
        public void social_mail_check() throws InterruptedException {

            ChromeDriverManager.getInstance().setup();
            WebDriver driver = new ChromeDriver();
            login_page getObjLogin = new login_page(driver);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            getObjLogin.Login_to_Gmail();
            inbox_page objinbox = new inbox_page(driver);
            objinbox.social_mails_click();
            driver.quit();

        }
    }
