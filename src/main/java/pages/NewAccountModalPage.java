package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import waiters.Waiter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class NewAccountModalPage extends BasePage {

    public static final SelenideElement SAVE_BUTTON = $x("//*[@name = 'SaveEdit']");
    public static final SelenideElement SAVE_AND_NEW = $x("//*[@name = 'SaveEdit']");
    public static final SelenideElement CANCEL_EDIT = $x("//*[@name = 'CancelEdit']");
    private String modalWindowPath = "//*[@class=\"record-layout-container\"]";

    public NewAccountModalPage() {
    }

    public NewAccountModalPage openPage(String url) {
        open(url);
        return this;
    }

    public void createNewAccount(Account account) {
        Waiter.waitForPageLoad();
        new Input("Account Name").writeTextToInput(account.getAccountName());
        new Input("Website").writeTextToInput(account.getWebsite());
        new Dropdown("Type").selectOptionForSimpleDropdown(account.getType());
        new Input("Description").writeTextToTextarea(account.getDescription());
        new Input("Phone").writeTextToInput(account.getPhone());
        $x(modalWindowPath).shouldBe(Condition.visible, Duration.ofSeconds(10));
        new Button().clickOnButton(SAVE_BUTTON);
    }
}