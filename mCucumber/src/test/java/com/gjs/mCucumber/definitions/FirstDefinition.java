package com.gjs.mCucumber.definitions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;
import java.util.Map;

import com.gjs.mCucumber.models.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstDefinition {

    @Given("system print {string} line to console")
    public void printStringToConsole(final String string) {
        System.out.println("Print string: " + string);
    }

    @When("{word} actions are performed")
    public void scenarioIsStarted(final String string) {
        System.out.printf("Perform %s scenario's actions here...\n", string);
    }

    @Then("verify {word} equals {word}")
    public void verifyWordsAreEquals(final String actualWord, final String expectedWord) {
        System.out.println("Perform assertion");
        assertThat("Something went wrong!", actualWord, is(expectedWord));
    }

    @Then("verify list size is {int}:")
    public void verifyListSize(final int expectedSize, final List<String> list) {
        System.out.println(list);
        assertThat("Size is wrong!", list, hasSize(expectedSize));
    }

    @Then("verify list of list size is {int}:")
    public void verifyListOfListSize(final int expectedSize, final List<List<String>> list) {
        System.out.println(list);
        assertThat("Size is wrong!", list, hasSize(expectedSize));
    }

    @Then("verify map size is {int}:")
    public void verifyMapSize(final int expectedSize, final Map<String, String> map) {
        System.out.println(map);
        assertThat("Size is wrong!", map, aMapWithSize(expectedSize));
    }

    @Then("verify list of map size is {int}:")
    public void verifyListOfMapSize(final int expectedSize, final List<Map<String, String>> list) {
        System.out.println(list);
        assertThat("Size is wrong!", list, hasSize(expectedSize));
    }

    @Then("verify user name is {word}:")
    public void verifyUser(final String expectedName, final User user) {
        System.out.println(user);
        assertThat("Name is wrong!", user.getName(), is(expectedName));
    }

    @Then("verify user list has size {int}:")
    public void verifyListOfUsersSize(final int expectedSize, final List<User> list) {
        System.out.println(list);
        assertThat("Size is wrong!", list, hasSize(expectedSize));
    }

}
