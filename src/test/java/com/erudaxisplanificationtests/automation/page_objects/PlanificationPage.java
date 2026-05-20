package com.erudaxisplanificationtests.automation.page_objects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erudaxisplanificationtests.automation.utils.ConfigFileReader;
import com.erudaxisplanificationtests.automation.utils.Setup;

public class PlanificationPage {
	ConfigFileReader configFileReader;
	WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
	Actions action=new Actions(Setup.getDriver());
	/* Find By */
	@FindBy(how = How.ID, using = "sign-in-email-input")
	public static WebElement emailField;

	@FindBy(how = How.ID, using = "sign-in-password-input")
	public static WebElement passwordField;

	@FindBy(how = How.ID, using = "sign-in-button")
	public static WebElement signInBtn;

	@FindBy(how = How.XPATH, using = "//img[@alt='college']")
	public static WebElement etbChoiceBtn;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Configuration']")
	public static WebElement configBtn;

	@FindBy(how = How.ID, using = "add")
	public static WebElement addConfigBtn;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	public static WebElement configNameField;

	@FindBy(how = How.XPATH, using = "//input[@name='duree']")
	public static WebElement durationField;

	@FindBy(how = How.XPATH, using = "//input[@name='heureDeDebut']")
	public static WebElement heureDebutMatinField;

	@FindBy(how = How.XPATH, using = "//input[@name='heureDeFin']")
	public static WebElement heurefinMatinField;

	@FindBy(how = How.XPATH, using = "//a[12]")
	public static WebElement planifSectioBtn;

	@FindBy(how = How.XPATH, using = "//input[@name='heureDeDebutApresMidi']")
	public static WebElement heureDebutApresMidiField;

	@FindBy(how = How.XPATH, using = "//input[@name='heureDeFinApresMidi']")
	public static WebElement heureFinApresMidiField;

	@FindBy(how = How.XPATH, using = "//input[@name='heureDeDebutDej']")
	public static WebElement heureDebutDej;

	@FindBy(how = How.XPATH, using = "//input[@name='heureDeFinDej']")
	public static WebElement heureFinDej;

	@FindBy(how = How.XPATH, using = "//input[@name='pauses[0].start']")
	public static WebElement debutPause1;

	@FindBy(how = How.XPATH, using = "//input[@name='pauses[0].end']")
	public static WebElement finPause1;

	@FindBy(how = How.ID, using = "btn-add")
	public static WebElement addNewConfigBtn;

	@FindBy(how = How.ID, using = "swal2-title")
	public static WebElement successConfigCreationMsg;
	
	@FindBy(how = How.XPATH,using="//button[normalize-space()='OK']")
	public static WebElement confirmPopupBtn;
	
	@FindBy(how =How.XPATH,using="//div[contains(text(),'Nom est obligatoire')]")
	public static WebElement nameErrMsg;
	
	/*@FindBy(how =How.XPATH,using="//div[contains(text(),'Durée minimum est de 30 minutes')]")
	public static WebElement dureeInfErrMsg;*/
	@FindBy(how =How.XPATH,using="//div[contains(text(),'Durée')]")
	public static WebElement dureeErrMsg;
	
	@FindBy(how =How.XPATH,using="//div[contains(text(),'Durée maximum est de 540 minute')]")
	public static WebElement dureeSupErrMsg;
	
	@FindBy(how =How.XPATH,using="//div[contains(text(),'Durée est obligatoire')]")
	public static WebElement dureeVideErrMsg;

	
	public PlanificationPage() {
		this.configFileReader = new ConfigFileReader();
		PageFactory.initElements(Setup.getDriver(), this);
	}
	
	public void goToUrl() {
		Setup.getDriver().get(configFileReader.getProperties("erudaxis.url"));
	}

	public void authentication() {

		fillField(emailField, configFileReader.getProperties("erudaxis.login"));
		fillField(passwordField, configFileReader.getProperties("erudaxis.password"));
		btnClick(signInBtn);
	}

	public void etbsChoice() {
		wait.until(ExpectedConditions.visibilityOf(etbChoiceBtn));
		etbChoiceBtn.click();
	}

	public void btnClick(WebElement btnToClick) {
		wait.until(ExpectedConditions.visibilityOf(btnToClick));
		action.scrollToElement(btnToClick).build().perform();
		btnToClick.click();
	}

	public void fillField(WebElement field, String input) {
		wait.until(ExpectedConditions.visibilityOf(field));
		action.scrollToElement(field).build().perform();
		field.sendKeys(Keys.CONTROL + "a");
		field.sendKeys(Keys.BACK_SPACE);
		field.sendKeys(input);
	}

	public void verification(WebElement text, String text2) {
		wait.until(ExpectedConditions.visibilityOf(text));
		action.scrollToElement(text).build().perform();
		Assert.assertEquals(text.getText(), text2);
	}
	
	public void verifExistance(String msg) {
		wait.until(ExpectedConditions.visibilityOf(dureeErrMsg));
		Assert.assertTrue(dureeErrMsg.getText().contains(msg));
	}

}
