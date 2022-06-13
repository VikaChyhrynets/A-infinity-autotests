package utils;

import io.qameta.allure.Attachment;

public class AllureHelper {

    @Attachment(value = "{name}", type = "text/plain")
    public static String attachTextToReport(String name, String text) {
        return text;
    }

    @Attachment(value = "{0}", type = "application/json")
    public static String attachJSONToReport(String name, String body) {
        return body;
    }
}