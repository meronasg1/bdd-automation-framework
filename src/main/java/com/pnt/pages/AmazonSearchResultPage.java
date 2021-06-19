package com.pnt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AmazonSearchResultPage {

    @FindBy(xpath="//span[@class='a-color-state a-text-bold']")
    private WebElement searchedItem;

    public void validateSearchresultIsDisplayed(){
        Assert.assertTrue(searchedItem.isDisplayed());
    }



}
