package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Button {

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    public Button(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }
}