package com.shijir.pages;

import com.shijir.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {


    @FindBy(css = "#twotabsearchtextbox")
    static WebElement searchInput;

    @FindBy(css = "#nav-search-submit-button")
    static WebElement searchButton;

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Opens the home page.
     */
    public void open() {
        Driver.getDriver().get("https://www.amazon.com");
    }

    /**
     * Search for an item.
     * This is a public method because we want to expose this method to the test.
     */
    public void searchForItem(String item) {
        enterSearchTerm(item);
        clickSearchButton();
    }

    /**
     * Enter text in the search input field.
     * This is a protected method because we don't want to expose this method to the
     * test.
     * We should wrap wait and other logic around this method (f.i. retry logic,
     * waits untill is visible, ...).
     */
    protected void enterSearchTerm(String item) {
        searchInput.sendKeys(item);
    }

    /**
     * Clicks the search button.
     * This is a protected method because we don't want to expose this method to the
     * test.
     * We should wrap wait and other logic around this method (f.i. retry logic,
     * waits untill is visible, ...).
     */
    protected void clickSearchButton() {
        searchButton.click();
    }
}
