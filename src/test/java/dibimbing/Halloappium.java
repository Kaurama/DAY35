package dibimbing;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Halloappium {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setApp(System.getProperty("user.dir") + "/apk/demo.apk");

        try {
            URL appiumServerUrl = new URL("http://127.0.0.1:4723");

            driver = new AndroidDriver(appiumServerUrl, options);

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            System.out.println("Driver session started!");
            System.out.println("Session ID: " + driver.getSessionId());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAppLaunch() {
        Assert.assertNotNull(driver.getSessionId());
        System.out.println("App Launch started!");
    }

    @Test
    public void helloAppium() {

        Assert.assertNotNull(driver.getSessionId());
        System.out.println("Session ID: " + driver.getSessionId());

        // 1. Klik View Menu
        WebElement viewMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("View menu")
                )
        );
        viewMenu.click();

        // 2. Klik Login Menu Item
        WebElement loginMenuItem = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Login Menu Item")
                )
        );
        loginMenuItem.click();

        // 3. Isi username / email
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id(
                                "com.saucelabs.mydemoapp.android:id/nameET"
                        )
                )
        );
        username.sendKeys("bod@example.com");

        // 4. Isi password
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id(
                                "com.saucelabs.mydemoapp.android:id/passwordET"
                        )
                )
        );
        password.sendKeys("10203040");

        // 5. Klik tombol login
        WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId(
                                "Tap to login with given credentials"
                        )
                )
        );
        loginButton.click();

        // 6. Klik cart setelah login
        WebElement cart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId(
                                "Displays number of items in your cart"
                        )
                )
        );
        cart.click();

        System.out.println("Login and cart flow completed!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver session ended.");
        }
    }
}
