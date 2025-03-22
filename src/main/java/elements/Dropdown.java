package elements;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    String label;

    private static final String SIMPLE_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String ACCOUNT_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//input";
    private static final String SIMPLE_DROPDOWN_OPTION_XPATH = "//*[contains(@title, '%s')]";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH =
            "//label[contains(text(),'Account Name')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//*[@title='%s']";

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOptionForSimpleDropdown(String option) {
        $x(String.format(SIMPLE_DROPDOWN_XPATH, label)).click();
        $x(String.format(SIMPLE_DROPDOWN_OPTION_XPATH, option)).click();
    }

    public void selectAccountFromDropdown(String option) {
        new Input("Account Name").writeTextInDropdownField(option);
        $x(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option)).click();
    }
}