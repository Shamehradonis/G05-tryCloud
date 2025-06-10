package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkModulePage {

    public TalkModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='toggle has-tooltip']")
    public WebElement createNewConversationButton;

    @FindBy(xpath = "//input[@placeholder='Conversation name']")
    public WebElement conversationNameBox;

    @FindBy(xpath = "//label[@for='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[normalize-space(text())='Add participants']")
    public WebElement addParticipantsButton;

    @FindBy(xpath = "//button[normalize-space(text())='Create conversation']")
    public WebElement createConversationButton;

    @FindBy(xpath = "//button[normalize-space(text())='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "//span[@class='acli__content__line-one__title']")
    public List<WebElement> conversationList;

    @FindBy(xpath = "//a[@class='app-navigation-toggle']")
    public WebElement conversationListButton;

    @FindBy(xpath = "//input[@placeholder='Add participants to the conversation']")
    public WebElement addParticipantBox;

    @FindBy(xpath = "//span[@class='participant-row__user-name']")
    public List<WebElement> participantsList;

    @FindBy(xpath = "//button[@class='top-bar__button top-bar__button primary']")
    public WebElement startCallButton;

    @FindBy(xpath = "//span[.='Delete conversation']")
    public WebElement deleteConversationButton;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement yesButtonForDelete;

    @FindBy(xpath = "//span[normalize-space(text())='You started a call']")
    public WebElement youStartedACall;

    @FindBy(xpath = "//button[@class='top-bar__button error top-bar__button']")
    public WebElement leaveCallButton;

    @FindBy(xpath = "//span[normalize-space(text())='You left the call']")
    public WebElement youLeftTheACall;
}
