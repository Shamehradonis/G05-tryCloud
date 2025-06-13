package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;
import java.util.List;

public class CalendarModulePage {
    public CalendarModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-view-module']")
    public WebElement menuOption;

    @FindBy(xpath = "//a[@class='fc-col-header-cell-cushion ']")
    public List<WebElement> titleList;

    @FindBy(xpath = "//div[@class='fc-daygrid-day-frame fc-scrollgrid-sync-inner']")
    public List<WebElement> monthTitleList;

    @FindBy(xpath = "//button[@class='button primary new-event']")
    public WebElement newEventButton;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventTitleBox;

    @FindBy(xpath = "(//input[@class='mx-input'])[2]")
    public WebElement fromDateBox;

    @FindBy(xpath = "//button[@class='mx-btn mx-btn-text mx-btn-current-year']")
    public WebElement year;

    @FindBy(xpath = "//button[normalize-space(text())='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@class='datepicker-button-section__datepicker-label button datepicker-label']")
    public WebElement date;

    @FindBy(xpath = "//div[@class='fc-event-title']")
    public WebElement eventTitleOnDate;

    @FindBy(xpath = "//button[normalize-space(text())='More']")
    public WebElement moreButton;

    @FindBy(xpath = "(//button[@class='icon action-item__menutoggle action-item__menutoggle--default-icon'])[5]")
    public WebElement treeDotButton;

    @FindBy(xpath = "//span[.='Delete']")
    public WebElement deleteButton;
}
