package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeckModulePage {
    public DeckModulePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@title='Add board']")
    public WebElement addBoardButton;

    @FindBy(xpath = "//input[@placeholder='Board name']")
    public WebElement boardNameBox;

    @FindBy(xpath ="//input[@class='icon-confirm']" )
    public WebElement arrow;
    @FindBy(xpath = "//a[@class='app-navigation-toggle']")
    public WebElement upcomingCards;

    @FindBy(xpath = "//span[@class='app-navigation-entry__title']")
    public List<WebElement> allBoards;

    @FindBy(xpath = "//span[.='Delete board']")
    public WebElement deleteBoardButton;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement deleteButton;

    @FindBy(id = "stack-add")
    public WebElement addListButton;

    @FindBy(id = "new-stack-input-main")
    public WebElement listNameBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement listNameArrow;

    @FindBy(xpath = "//h3[@class='stack__title has-tooltip']")
    public List<WebElement> listNames;

    @FindBy(xpath = "//input[@placeholder='Card name']")
    public WebElement cardNameBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement cardNameArrow;

    @FindBy(xpath = "//div[@class='avatardiv popovermenu-wrapper has-tooltip']")
    public WebElement accountIcon;

    @FindBy(xpath = "//input[@placeholder='Select a board']")
    public WebElement selectBoardButton;

    @FindBy(xpath = "//input[@placeholder='Select a list']")
    public WebElement selectListButton;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement moveCardButton;

    @FindBy(xpath = "//span[.='Delete list']")
    public WebElement deleteListButton;

    @FindBy(xpath = "//span[.='Delete card']")
    public WebElement deleteCardButton;
}

