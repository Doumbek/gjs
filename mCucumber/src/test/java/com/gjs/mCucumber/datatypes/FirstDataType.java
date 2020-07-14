package com.gjs.mCucumber.datatypes;

import java.util.Map;

import com.gjs.mCucumber.models.User;

import io.cucumber.java.DataTableType;

public class FirstDataType {

    @DataTableType
    public User populateUser(final Map<String, String> entry) {
        return new User(
            entry.get("name"),
            entry.get("age"));
    }
}
