package com.virgingames.cucumber.steps;

import com.virgingames.virgingameinfo.VirginGamesSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    VirginGamesSteps steps;

    @When("User sends a GET request to an list endpoint")
    public void userSendsAGETRequestToAnListEndpoint() {
        response = steps.getAllJackpotsBingo();

    }

    @Then("User must get back a valid status code i.e {int}")
    public void userMustGetBackAValidStatusCodeIE(int statusCode) {
        response.statusCode(statusCode);
    }


    @Then("User must get back a valid status code {int} as per{string}")
    public void userMustGetBackAValidStatusCodeAsPer(int status, String currency) {
        HashMap<String, Object> currencyList = steps.getAllJackpotsBingoByCurrency(currency);
        Assert.assertThat(currencyList, hasValue(currency));
    }
}

