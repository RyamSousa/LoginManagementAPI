package com.api.user.manage.userapimanage.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ValidateEmail {

    public static boolean validate(String email){

        if (email == null && email.length() == 0) {
            return false;
        }
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
