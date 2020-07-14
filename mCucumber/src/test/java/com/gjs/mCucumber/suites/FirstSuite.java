package com.gjs.mCucumber.suites;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = { "com.gjs.mCucumber.definitions", "com.gjs.mCucumber.hooks", "com.gjs.mCucumber.datatypes" },
        tags = {"@UseExamples"}
        )
public class FirstSuite {
}

