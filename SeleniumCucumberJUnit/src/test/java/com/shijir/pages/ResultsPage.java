package com.shijir.pages;

import com.shijir.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class ResultsPage {


    @FindBy(css = ".s-search-results [data-index] .sg-col-inner .s-product-image-container")
    static List<WebElement> productImages;

    public ResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickFirstElement() {
        productImages.get(0).click();
    }
}
