package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

import java.time.Duration;

public class NewAccountModalPage extends BasePage {

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Input(driver, "Account Name").writeTextToInput(account.getAccountName());
        new Input(driver, "Website").writeTextToInput(account.getWebsite());
        new Dropdown(driver, "Type").selectOptionForSimpleDropdown(account.getType());
        new Input(driver, "Description").writeTextToTextarea(account.getDescription());
        new Input(driver, "Phone").writeTextToInput(account.getPhone());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Button(driver).clickOnSaveButton();
    }

    /**
     * This is waiting for the new account modal page to be opened.
     * @return NewAccountModalPage.
     */
    public NewAccountModalPage waitForNewAccountModalPageOpened() {
        Waiter.waitForPageLoaded(driver, Duration.ofSeconds(20));
        return this;
    }
}