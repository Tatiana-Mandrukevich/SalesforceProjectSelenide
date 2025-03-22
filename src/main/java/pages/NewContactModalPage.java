package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import objects.Contact;
import waiters.Waiter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static pages.ContactPage.DATA_BY_FIELD_NAME_XPATH;

public class NewContactModalPage extends BasePage{

    public static final SelenideElement SAVE_BUTTON = $x("//*[@name = 'SaveEdit']");
    private String modalWindowPath = "//*[@class=\"record-layout-container\"]";
    private static final String warningMessage = "//*[@aria-label='Similar Records Exist']";

    public NewContactModalPage() {
    }

    public NewContactModalPage openPage(String url) {
        open(url);
        return this;
    }

    public void createNewContact(Contact contact, Account account) {
        new Input("First Name").writeTextToInput(contact.getFirstName());
        new Input("Last Name").writeTextToInput(contact.getLastName());
        new Dropdown("Account Name").selectAccountFromDropdown(account.getAccountName());
        new Input("Title").writeTextToInput(contact.getTitle());
        new Input("Description").writeTextToTextarea(contact.getDescription());
        new Input("Phone").writeTextToInput(contact.getPhone());
        new Input("Email").writeTextToInput(contact.getEmail());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $x(modalWindowPath).shouldBe(Condition.visible, Duration.ofSeconds(10));
        new Button().clickOnButton(SAVE_BUTTON);
        Waiter.waitForElementToBeVisible(DATA_BY_FIELD_NAME_XPATH, "Name");
    }
}