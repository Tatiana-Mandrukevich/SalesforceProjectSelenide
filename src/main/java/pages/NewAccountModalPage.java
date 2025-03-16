package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

public class NewAccountModalPage extends BasePage {

    public static final By ACCOUNT_NAME_INPUT = By.xpath("//*[contains(text(), 'Account Name')]/ancestor::div[contains(@part, 'input-text')]//input");

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    @FindBy(name = "SaveAndNew")
    public WebElement saveAndNewButton;

    @FindBy(name = "CancelEdit")
    public WebElement cancelButton;

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public NewAccountModalPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void createNewAccount(Account account) {
        new Input(driver, "Account Name").writeTextToInput(account.getAccountName());
        new Input(driver, "Website").writeTextToInput(account.getWebsite());
        new Dropdown(driver, "Type").accountSelectOption(account.getType());
        new Input(driver, "Description").writeTextToTextarea(account.getDescription());
        new Input(driver, "Phone").writeTextToInput(account.getPhone());
        new Button(driver).clickButton(saveButton);
    }

    /**
     * This is waiting for the new account modal page to be opened.
     * @return NewAccountModalPage.
     */
    public NewAccountModalPage waitForNewAccountModalPageOpened() {
        Waiter.waitForPageOpened(driver, ACCOUNT_NAME_INPUT, 15);
        return this;
    }
}