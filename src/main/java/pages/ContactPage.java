package pages;

import static com.codeborne.selenide.Selenide.$x;

public class ContactPage extends BasePage{

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@field-label='%s']//*[@slot]";

    public ContactPage() {
    }

    public String getFieldValueByName(String name) {
        return $x(String.format(DATA_BY_FIELD_NAME_XPATH, name)).getText();
    }

    public String getFieldLinkValueByName(String name) {
        String text = $x(String.format(DATA_BY_FIELD_NAME_XPATH, name)).getText();
        return getSecondWord(text);
    }

    public static String getSecondWord(String text) {
        String[] words = text.split("\\s+");
        if (words.length < 2) {
            throw new IllegalArgumentException("Текст содержит менее двух слов");
        }
        return words[1];
    }
}