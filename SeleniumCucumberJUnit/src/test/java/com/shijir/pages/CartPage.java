package com.shijir.pages;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.shijir.utilities.CartEntryInfo;
import com.shijir.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


public class CartPage {


    @FindBy(css = "[data-name=\"Active Items\"] [data-asin]")
    static WebElement firstElementInCart;

    @FindBy(css = "select[name=\"quantity\"]")
    static WebElement quantityDropdown;

    @FindBy(css = "select[name=\"quantity\"] [selected]")
    static WebElement optionSelected;


    public CartPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void open() {
        Driver.getDriver().get("https://www.amazon.com/cart");
    }

    public CartEntryInfo getCartEntryInfoForFirstProduct() {
        return getCartEntryInfoForProduct(firstElementInCart);
    }

    public void updateQuantity(int quantity) {
        getQuantityDropdown().selectByValue(String.valueOf(quantity));

        // This wait ensure that the quantity is updated in the page before continue since
        // the component is not updated immediately.
        Wait<WebDriver> wait= new FluentWait<WebDriver>(Driver.getDriver()).withTimeout(java.time.Duration.ofSeconds(10));
        wait.until(driver -> optionSelected.getText().equals(String.valueOf(quantity)));
    }

    private Select getQuantityDropdown() {
        return new Select(quantityDropdown);
    }

    private CartEntryInfo getCartEntryInfoForProduct(WebElement product) {
        String dataSubtotal = product.getAttribute("data-subtotal");
        JsonObject jsonObject = new Gson().fromJson(dataSubtotal, JsonObject.class);
        int quantity = jsonObject.get("numberOfItems").getAsInt();
        double amount = jsonObject.getAsJsonObject("subtotal").get("amount").getAsDouble();
        return new CartEntryInfo(quantity, amount);
    }
}