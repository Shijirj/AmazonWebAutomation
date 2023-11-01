package com.shijir.step_definition;


import com.shijir.pages.ProductPage;
import com.shijir.pages.ResultsPage;
import com.shijir.utilities.CartEntryInfo;
import com.shijir.utilities.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class ResultsPageSteps {
    private ResultsPage resultsPage;
    private ProductPage productPage;

    public ResultsPageSteps() {
        this.resultsPage = new ResultsPage();
        this.productPage = new ProductPage();
    }

    @Given("the user adds the first product appearing to Cart with quantity {int}")
    public void theUserAddsTheFirstProductAppearingToCartWithQuantity(Integer quantity) {
        resultsPage.clickFirstElement();
        productPage.addProductToCartWithQuantity(quantity);
    }

}