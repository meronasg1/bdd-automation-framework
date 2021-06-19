package com.pnt.stepDef;

import com.pnt.base.TestBase;
import com.pnt.pages.AmazonHomePage;
import com.pnt.pages.AmazonSearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AmazonHomePageFunctionality extends TestBase {

    private AmazonHomePage amazonHomePage;
    private AmazonSearchResultPage amazonSearchResultPage;

    @Given("^user opens the browser and navigate to amazon\\.com$")
    public void user_opens_the_browser_and_navigate_to_amazon_com() {
        TestBase.setUpDriver();
        TestBase.driver.get("https://www.amazon.com/");

        amazonHomePage = PageFactory.initElements(TestBase.driver, AmazonHomePage.class);
        amazonSearchResultPage = PageFactory.initElements(TestBase.driver, AmazonSearchResultPage.class);
    }

    @When("^user can see search bar$")
    public void user_can_see_search_bar() {

        amazonHomePage.validateSearchBarIsDisplayed();

    }

    @Then("^user types Java Books in the searchh bar$")
    public void user_types_Java_Books_in_the_searchh_bar()  {

        amazonHomePage.typeOnSearchBar("Java Books");
    }

    @Then("^user clicks on search button$")
    public void user_clicks_on_search_button()  {

        amazonHomePage.clickOnSearchButton();
    }

    @Then("^user can see search result of Java Books$")
    public void user_can_see_search_result_of_Java_Books(){

        amazonSearchResultPage.validateSearchresultIsDisplayed();
    }

    @Then("^user closes the browser$")
    public void user_closes_the_browser()  {
        TestBase.driver.quit();
    }

    @Then("^user types (.*) in the search bar$")
    public void user_types_bookName_in_the_search_bar(String bookName) {
        amazonHomePage.typeOnSearchBar(bookName);
    }





}
