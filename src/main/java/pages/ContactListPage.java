package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ContactListPage extends BasePage{
    public static final String TABLE_XPATH = "//table";
    public static final String ACCOUNT_NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s')]";
    public static final String PHONE_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";
    public static final String NAME_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//a[contains(@title, '%s')]";
    public static final String EMAIL_BY_ACCOUNT_NAME_XPATH = ACCOUNT_NAME_FIELD_XPATH + "/ancestor::tbody//a[contains(@class, 'emailuiFormattedEmail')]";

    public ContactListPage() {
    }

    public ContactListPage openPage(String url) {
        open(url);
        return this;
    }

    public String getExistAccountName(String accountName) {
        return $x(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName)).getText();
    }

    public String getExistPhoneNumberByAccountName(String accountName) {
        return $x(String.format(PHONE_BY_ACCOUNT_NAME_XPATH, accountName)).getText();
    }

    public String getExistAccountOwnerByAccountName(String accountName) {
        return $x(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH, accountName)).getText();
    }

    public String getExistNameByAccountName(String accountName, String contactName) {
        return $x(String.format(NAME_BY_ACCOUNT_NAME_XPATH, accountName, contactName)).getText();
    }

    public String getExistEmailByAccountName(String accountName) {
        return $x(String.format(EMAIL_BY_ACCOUNT_NAME_XPATH, accountName)).getText();
    }

    public ContactPage clickOnContactName(String accountName, String contactName) {
        $x(String.format(NAME_BY_ACCOUNT_NAME_XPATH, accountName, contactName)).click();
        return new ContactPage();
    }
}