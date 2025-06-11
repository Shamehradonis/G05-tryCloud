package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardFunctionalityPage {


    public DashboardFunctionalityPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

  //  DashboardFunctionalityPage dashboardPage = new DashboardFunctionalityPage();


    @FindBy (xpath = "//ul[@id='appmenu']/li//span")
    public List<WebElement> moduleElements;


    public  List<String> getModulesNames(){
        return BrowserUtils.getElementsText(this.moduleElements);
    }

    @FindBy (id = "settings")
    public WebElement profileBotton;

    @FindBy (xpath = "//span[@title='Employee15']")
    public WebElement username ;


    @FindBy (xpath = "//a[.='Customize']")
    public WebElement customizeButton;

  // @FindBy()
  //  public List<WebElement> widgets;

  // public List<String> getWidgetsNames(){
  //     return BrowserUtils.getElementsText(this.widgets);
  // }


    @FindBy(id = "status-status")
    public WebElement setStatusButton;


    @FindBy (id = "set-status-modal__online-status")
    public List<WebElement> status;


    public  List<String> getStatus(){
        return BrowserUtils.getElementsText(this.status);
    }


   // @FindBy (xpath =[@class = "predefined-statuses-list"])
        public List<WebElement> statusMessages;



    public  List<String> getStatusMessages (){
        return BrowserUtils.getElementsText(this.statusMessages);
    }

   // @FindBy (class = "status-buttons__select")
    public WebElement clearStatusButton;


   // @FindBy (class = "status-buttons__primary primary")
    public WebElement setStatusBotton;






}
