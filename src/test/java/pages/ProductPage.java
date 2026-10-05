package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ProductPage extends BasePage {

  public ProductPage(AndroidDriver driver) {
    super(driver);
  }

  @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[1]/android.widget.ImageView[@content-desc=\"Product Image\"]")
  private WebElement firstProductImage;

  @AndroidFindBy(accessibility = "Tap to add product to cart")
  private WebElement addToCartButton;

  @AndroidFindBy(accessibility = "Displays number of items in your cart")
  private WebElement cartIcon;

  @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
  private WebElement cartItemCount;

  public void clickFirstProduct() {
    firstProductImage.click();
  }

  public void clickAddToCart() {
    addToCartButton.click();
  }

  public void clickCart() {
    cartIcon.click();
  }

  public String getCartItemCount() {
    return cartItemCount.getText();
  }

  public boolean isFirstProductDisplayed() {
    return firstProductImage.isDisplayed();
  }
}