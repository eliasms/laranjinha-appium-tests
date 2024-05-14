package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {

    AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setPlatformVersion("11")
                .setDeviceName("4AF00GC04");
                //.setApp(System.getProperty("user.dir") + "/apps/ApiDemos.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void click_App_Button() {
        try {
            WebElement element = driver.findElement(By.id("br.com.userede.redeflex.l400:id/btn_action"));
            System.out.println("Elemento encontrado: " + element.getAttribute("text"));
        } catch (Exception e) {
            System.out.println("Elemento não encontrado.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
