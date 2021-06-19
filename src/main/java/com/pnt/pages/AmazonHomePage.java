package com.pnt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AmazonHomePage {

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchBar;

    public void validateSearchBarIsDisplayed(){
        Assert.assertTrue(searchBar.isDisplayed());
    }

    public void typeOnSearchBar(String data){
        searchBar.sendKeys(data);
    }

    @FindBy(id="nav-search-submit-button")
    private WebElement searchButton;

    public void clickOnSearchButton(){
        searchButton.click();
    }



}
