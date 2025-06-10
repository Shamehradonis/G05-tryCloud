package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesPage {
    public FilesPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@aria-label='Files'])[1]")
    public WebElement filesModule;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusSignButton;

    @FindBy(css = "#file_upload_start")
    public WebElement uploadFile;

    @FindBy (xpath = "(//a[@class='name']//span[.='EmmanuelFile']")
    public WebElement nameFileUploaded;

    @FindBy(xpath = "//span[@class='icon icon-folder svg']")
    public WebElement newFolderOption;

    @FindBy (xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderInput;

    @FindBy (xpath = "//a[contains(@href, 'AutomationTestingED')]")
    public WebElement folderName;

    @FindBy (xpath = "//tr[@data-file='EmmanuelFile.txt']//label")
    public WebElement selectCheckbox;


    @FindBy (xpath = "//tr[@data-file='EmmanuelFile.txt']//span[@class='icon icon-more']")
    public WebElement threeDotsForEF;

    @FindBy (xpath = "//tr[@data-file='EmmanuelFile.txt']//span[.='Move or copy']")
    public WebElement moveOrDelete;

    @FindBy (xpath = "//tr[@data-file='Manual testing']//label")
    public WebElement manualTestingFolderCheckbox;

    @FindBy (xpath = "//tr[@data-file='Manual testing']//span[@class='nametext']")
    public WebElement manualTestingFolderName;

    @FindBy (xpath = "//tr[@data-file='Manual testing']//span[@class='icon icon-more']")
    public WebElement threeDotsForManualTestingFolder;

    @FindBy (xpath = "//tr[@data-file='Manual testing']//span[.='Delete folder']")
    public WebElement deleteFolderOption;

    @FindBy (xpath = "//tr[@data-id='176586']//span[@data-original-title='Manual testing']")
    public WebElement deletedManualTestingFolder;

    @FindBy (xpath = "//a[.='Deleted files']")
    public WebElement deletedFiles;

    @FindBy (xpath = "//td/span[@class='info']")
    public WebElement summaryOfFiles;

    @FindBy(xpath = "//tr[@data-entryname='AutomationTestingED']")
    public WebElement folderNameToMove;

    @FindBy(xpath = "//button[.='Move to AutomationTestingED']")
    public WebElement moveButton;








//td/span[@class='info']


//*[@id="fileList"]/tr[3]/td[2]/a/span[1]/span
    //html/body/div[3]/div[2]/div[2]/table/tbody/tr[3]/td[2]/a/span[1]/span



}
//span[@class='icon icon-add']

//a[@class='button new']

//span[.='Upload file']

//*[@id="fileList"]/tr[5]/td[2]/a/span[1]/span[1]

//span[@class='icon icon-folder svg']

