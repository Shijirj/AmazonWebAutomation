package com.shijir.step_definition;

import com.shijir.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomePageSteps {
    private HomePage homepage;

    public HomePageSteps() {
        this.homepage = new HomePage();
    }

    @Given("the user is on the Amazon homepage")
    public void theUserIsOnTheAmazonHomepage() {
        homepage.open();
    }

    @When("the user searches for {string}")
    public void theUSerSearchesFor(String string) {
        homepage.searchForItem(string);
    }
}