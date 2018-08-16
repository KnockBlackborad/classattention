package com.watchingy.model;

import java.util.Map;

public class ReturnInfoToAndroid {

    private Map<String, String> errors;
    private UserInfo form;

    public ReturnInfoToAndroid(Map<String, String> errors, UserInfo form) {
        this.errors = errors;
        this.form = form;
    }


    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public UserInfo getForm() {
        return form;
    }

    public void setForm(UserInfo form) {
        this.form = form;
    }
}
