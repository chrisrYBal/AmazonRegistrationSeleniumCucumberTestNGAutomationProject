package com.testNG.ChromeStepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.TRUE;

public class ChromeMyStepdefs {

    WebDriver driver;


    @Before
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on the Sign-in page")
    public void iAmOnTheSignInPage() throws InterruptedException {
        driver.manage();
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3F%26tag%3Dgoogleglobalp-20%26ref%3Dnav_signin%26adgrpid%3D82342659060%26hvpone%3D%26hvptwo%3D%26hvadid%3D585475370855%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D110909126262709821%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D20822%26hvtargid%3Dkwd-10573980%26hydadcr%3D2246_13468515%26gclid%3DEAIaIQobChMInufLkejW9gIVnL2WCh3aqgTnEAAYASAAEgLI6fD_BwE&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Thread.sleep(2000);

    }

    @When("I click on {string} button on the Sign-in page")
    public void iClickOnButtonOnTheSignInPage(String createAccountButton) throws InterruptedException {
        driver.findElement(By.id(createAccountButton)).click();
        Thread.sleep(2000);

    }

    @Then("I should be on the Create Account page")
    public void iShouldBeOnTheCreateAccountPage() {
        try {
            Boolean landingpage = driver.findElement(By.xpath("//h1[contains(text(), 'Create account')]")).isDisplayed();
            if(landingpage.equals(TRUE)) {
                System.out.println("Amazon Create Account page displayed successfully.");
            }else {
                System.out.println("Amazon Create Account page displayed unsuccessfully.");
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I enter {string} into all the fields on the page")
    public void iEnterIntoAllTheFieldsOnThePage(String test) throws InterruptedException {
        driver.findElement(By.id("ap_customer_name")).sendKeys(test);
        driver.findElement(By.id("ap_email")).sendKeys(test);
        driver.findElement(By.id("ap_password")).sendKeys(test);
        driver.findElement(By.id("ap_password_check")).sendKeys(test);
        Thread.sleep(3000);

    }

    @And("I clear the {string} field on the Create Account page")
    public void iClearTheFieldOnTheCreateAccountPage(String textbox) throws InterruptedException {
        driver.findElement(By.id(textbox)).clear();
        Thread.sleep(2000);

    }

    @And("I click on {string} button on the Create Account page")
    public void iClickOnButtonOnTheCreateAccountPage(String Continue) throws InterruptedException {
        driver.findElement(By.id(Continue)).click();
        Thread.sleep(3000);
    }

    @Then("the {string} message on the Create Account page for each {string} should be visible")
    public void theOnTheCreateAccountPageShouldBe(String Error, String fieldName) {
        Boolean visible = driver.findElement(By.xpath("//div[contains(text(), '"+Error+"')]")).isDisplayed();
        if(visible.equals(TRUE)){
            System.out.println("'" + Error + "'" + " error message is displayed for " + fieldName + " input box.");
        }else{
            System.out.println("'" + Error + "'" + " error message is missing for " + fieldName + " input box.");
        }



    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
