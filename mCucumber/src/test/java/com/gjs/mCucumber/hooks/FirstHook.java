package com.gjs.mCucumber.hooks;

import io.cucumber.java.*;

public class FirstHook {

    @Before("not @ignoreHook")
    public void beforeScenario(final Scenario scenario) {
        System.out.println("Run before each scenario | " + scenario.getName());
    }

    @BeforeStep("not @ignoreHook")
    public void beforeStep(final Scenario scenario) {
        System.out.println("Run before each step | " + scenario.getName());
    }

    @AfterStep("not @ignoreHook")
    public void afterStep(final Scenario scenario) {
        System.out.println("Run after each step | " + scenario.getName());
    }

    @After("not @ignoreHook")
    public void afterScenario(final Scenario scenario) {
        System.out.println("Run after each scenario | " + scenario.getName());
    }

}
