package tests;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login_page;


import java.util.concurrent.TimeUnit;


public class Actions {

    @Test
    public void sign_up_test() throws InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Login_page sign_obj = new Login_page(driver);
        sign_obj.signup_to_Hive();
    }

    @Test
    public void

}
