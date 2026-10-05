package dibimbing;

import core.BaseTest;
import core.DriverManager;
import pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GlobalPage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    private GlobalPage globalPage;
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeMethod
    public void setUpPages() {
        globalPage = new GlobalPage(DriverManager.getDriver());
        loginPage = new LoginPage(DriverManager.getDriver());
        productPage = new ProductPage(DriverManager.getDriver());
    }

    @Test
    public void addProductToCart() {

        globalPage.clickHamburgerMenu();
        globalPage.clickLoginMenu();

        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("10203040");
        loginPage.clickLoginButton();

        productPage.clickFirstProduct();

        productPage.clickAddToCart();

        Assert.assertEquals(
                productPage.getCartItemCount(),
                "1",
                "Product was not added to cart"
        );
    }
}