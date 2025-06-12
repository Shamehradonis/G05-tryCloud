package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilesModule_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    LoginPage loginPage = new LoginPage();


    @Given("the user should click on the Files Module")
    public void the_user_should_click_on_the_Files_Module() {

        BrowserUtils.sleep(3);
        filesPage.filesModule.click();
        BrowserUtils.sleep(3);
    }


    @Then("the user should see {string} in the title")
    public void theUserShouldSeeInTheTitle(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("the user enters valid username and password and click loginButton")
    public void theUserEntersValidUsernameAndPasswordAndClickLoginButton() {
        loginPage.login();
    }

    @When("the user should click the + sign button")
    public void theUserShouldClickTheSignButton() {
        filesPage.plusSignButton.click();
        BrowserUtils.sleep(3);
    }

    @And("the user should click on upload a file option")
    public void theUserShouldClickOnUploadAFileOption() {
        //   filesPage.uploadFile.click();
        // BrowserUtils.sleep(3);

    }

    @Then("the user should click on the file name {string} and press enter")
    public void theUserShouldClickOnTheFileNameAndPressEnter(String fileName) {
        filesPage.uploadFile.sendKeys(System.getProperty("user.dir") + "/src/test/resources/uploadedFiles/" + fileName);
        //String path = System.getProperty("user.dir") + "/src/test/resources/uploadedFiles/EmmanuelFile.txt";
        //filesPage.fileUploadInput.sendKeys(path);

        BrowserUtils.waitFor(3);

    }

    @And("the file name {string} should be visible in the list")
    public void theFileNameShouldBeVisibleInTheList(String expectedFileName) {

        //String actualName = Driver.getDriver().findElement(By.xpath("//*[@id=\"fileList\"]/tr[5]/td[2]/a/span[1]/span[1]")).getText();
        // String actualName = Driver.getDriver().findElement(By.xpath("//a[@class='name']//span[.='EmmanuelFile']")).getText();
        String actualName = Driver.getDriver().findElement(By.xpath("//a[@class='name']//span[.='" + expectedFileName + "']")).getText();
        System.out.println(actualName);
        Assert.assertEquals(actualName, expectedFileName);

    }


    @Then("the user should click on the new folder option")
    public void theUserShouldClickOnTheNewFolderOption() {
        filesPage.newFolderOption.click();
    }


    @Then("the user should name the folder {string}")
    public void theUserShouldNameTheFolder(String expectedFolderName) {

        filesPage.newFolderInput.clear();
        filesPage.newFolderInput.sendKeys(expectedFolderName + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    @And("the folder name {string} should be visible in the list")
    public void theFolderNameShouldBeVisibleInTheList(String expectedFolderName) {
        String actualFolderName = Driver.getDriver().findElement(By.xpath("//a[contains(@href, '" + expectedFolderName + "')]")).getText();
        System.out.println(actualFolderName);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(actualFolderName, expectedFolderName);
    }


    @Given("the user select the file name EmmanuelFile by clicking on the checkbox")
    public void theUserSelectTheFileNameEmmanuelFileByClickingOnTheCheckbox() {
        filesPage.selectCheckbox.click();
    }


    @When("the user click on the three dots button")
    public void theUserClickOnTheThreeDotsButton() {
        filesPage.threeDotsForEF.click();
    }

    @And("the user click on Move or Copy option")
    public void theUserClickOnMoveOrCopyOption() {

        filesPage.moveOrDelete.click();
    }

    @And("the user choose the AutomationTestingED folder from the list")
    public void theUserChooseTheAutomationTestingEDFolderFromTheList() {
        filesPage.folderNameToMove.click();
    }

    @And("the user clicks the Move button")
    public void theUserClicksTheMoveButton() {
        filesPage.moveButton.click();

    }


    @Then("the file named {string} should be visible inside the folder {string}")
    public void theFileNamedShouldBeVisibleInsideTheFolder(String expectedFileName, String expectedFolderName) {

        WebElement folder = Driver.getDriver().findElement(By.xpath("//a[contains(@href, '" + expectedFolderName + "')]"));
        folder.click();
        BrowserUtils.sleep(2);

        WebElement file = Driver.getDriver().findElement(By.xpath("//a[@class='name']//span[.='" + expectedFileName + "']"));

        Assert.assertTrue(file.isDisplayed());
    }


    @Given("the user select the {string} folder checkbox")
    public void theUserSelectTheFolderCheckbox(String expectedFolderName) {
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + expectedFolderName + "']//label"));
        checkbox.click();

    }

    @When("the user click on the three dots button by the selected folder")
    public void theUserClickOnTheThreeDotsButtonByTheSelectedFolder() {
        filesPage.threeDotsForManualTestingFolder.click();
    }

    @And("the user click on Deleted folder option")
    public void theUserClickOnDeleteFolderOption() {
        WebDriver driver = Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
        filesPage.deleteFolderOption.click();
    }

    @And("the user clicks on the Deleted files menu")
    public void theUserClicksOnTheDeletedFilesMenu() {
        filesPage.deletedFiles.click();
        BrowserUtils.sleep(2);


    }

    @Then("the {string} folder should be visible on the Deleted files list")
    public void theFolderShouldBeVisibleOnTheDeletedFilesList(String expectedFileFolderName) {

        // WebElement deletedFolderName = Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + expectedFileFolderName + "']//span[@class='nametext extra-data']"));
        WebElement deletedFolderName = Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + expectedFileFolderName + "']//span[contains(@class, 'nametext') and text()='" + expectedFileFolderName + "']"));
        // WebElement deletedFolderName = Driver.getDriver().findElement(By.xpath("//span[text()='" + expectedFileFolderName + "']"));

        System.out.println(deletedFolderName.getText());

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(deletedFolderName).perform();

        BrowserUtils.sleep(2);
        Assert.assertTrue(deletedFolderName.isDisplayed());

    }


    @Then("the user should see the total number of files and folders")
    public void theUserShouldSeeTheTotalNumberOfFilesAndFolders() {

        WebElement summaryOfFilesAndFolders = Driver.getDriver().findElement(By.xpath("//td/span[@class='info']"));
        //WebElement summaryOfFilesAndFolders = Driver.getDriver().findElement(By.;

        System.out.println(filesPage.summaryOfFiles.getText());
        //System.out.println(summaryOfFilesAndFolders.getText());

        Assert.assertTrue(summaryOfFilesAndFolders.isDisplayed());
    }

}

