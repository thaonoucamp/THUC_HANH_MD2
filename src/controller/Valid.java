package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
    public static final String REGEX_PHONE = "^[0-9]{10}$";
    public static final String REGEX_EMAIL = "^[a-z]+@[a-z]+[.]{1}[a-z]*$";

    public static boolean validate(String regex, String every){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(every);
        return matcher.matches();
    }
}
