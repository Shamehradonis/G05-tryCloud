package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='user-status-menu-item__header']")
    public WebElement userStatus;

    @FindBy(id = "settings")
    public WebElement account;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "(//li[@data-id='deck'])[1]")
    public WebElement deckModule;

    @FindBy(xpath = "(//a[@aria-label='Talk'])[1]")
    public WebElement talkModule;
}
