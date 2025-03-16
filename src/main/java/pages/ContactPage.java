package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage{

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@class='record-body-container']//*[text()='%s']//parent::div//parent::dt//parent::div//*[@slot]";
    public static final String DATA_LINK_BY_FIELD_NAME_XPATH = "//*[@class='record-body-container']//*[text()='%s']//parent::div//parent::dt//parent::div//a//span//span//span";

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValueByName(String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }

    public String getFieldLinkValueByName(String name) {
        return driver.findElement(By.xpath(String.format(DATA_LINK_BY_FIELD_NAME_XPATH, name))).getText();
    }
}
