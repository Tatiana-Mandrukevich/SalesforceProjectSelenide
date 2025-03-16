package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import objects.Contact;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

import java.time.Duration;

public class NewContactModalPage extends BasePage{

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void createNewContact(Contact contact, Account account) {
        new Input(driver, "First Name").writeTextToInput(contact.getFirstName());
        new Input(driver, "Last Name").writeTextToInput(contact.getLastName());
        new Dropdown(driver, "Account Name").selectOptionForExtendedDropdown(account.getAccountName());
        new Input(driver, "Title").writeTextToInput(contact.getTitle());
        new Input(driver, "Description").writeTextToTextarea(contact.getDescription());
        new Input(driver, "Phone").writeTextToInput(contact.getPhone());
        new Input(driver, "Email").writeTextToInput(contact.getEmail());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Button(driver).clickOnSaveButton();
    }

    /**
     * This is waiting for the new contact modal page to be opened.
     * @return NewContactModalPage.
     */
    public NewContactModalPage waitForNewContactModalPageOpened() {
        Waiter.waitForPageLoaded(driver, Duration.ofSeconds(20));
        return this;
    }
}
