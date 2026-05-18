package com.erudaxisplanificationtests.automation.step_definitions;

import com.erudaxisplanificationtests.automation.page_objects.PlanificationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjoutConfigStepDefinition {
	private PlanificationPage planifPage = new PlanificationPage();
	
	@Given("authentifier sur la plateforme erudaxis")
	public void authentifierSurLaPlateformeErudaxis() {
		planifPage.goToUrl();
		planifPage.authentication(); 
	}
	
	@Given("choisir la section college")
	public void choisirLaSectionCollege() throws InterruptedException{
	    planifPage.etbsChoice();
	}
	
	@Given("acceder au module configuration")
	public void accederAuModuleConfiguration() {
		planifPage.btnClick(PlanificationPage.planifSectioBtn);
	    planifPage.btnClick(PlanificationPage.configBtn);
	}
	
	@Given("acceder a la formulaire d ajout de configuration")
	public void accederALaFormulaireDAjoutDeConfiguration() {
	   planifPage.btnClick(PlanificationPage.addConfigBtn);
	}
	
	@When("saisir nom de configuration")
	public void saisirNomDeConfiguration() {
	   planifPage.fillField(PlanificationPage.configNameField,"test");
	}
	
	@When("saisir duree de seance")
	public void saisirDureeDeSeance() {
		planifPage.fillField(PlanificationPage.durationField,"60");
	}
	
	@When("saisire heure de debut matin dans le champ heure de debut matin")
	public void saisireHeureDeDebutMatinDansLeChampHeureDeDebutMatin() {
		planifPage.fillField(PlanificationPage.heureDebutMatinField,"08:00");

	}
	@When("saisire heure de fin matin dans le champ heure de fin matin")
	public void saisireHeureDeFinMatinDansLeChampHeureDeFinMatin() {
		planifPage.fillField(PlanificationPage.heurefinMatinField,"12:00");
	}
	@When("saisire heure de debut apres midi dans le champ heure de debut apres midi")
	public void saisireHeureDeDebutApresMidiDansLeChampHeureDeDebutApresMidi() {
		planifPage.fillField(PlanificationPage.heureDebutApresMidiField,"12:00");

	}
	@When("saisire heure de fin apres midi dans le champ heure de fin apres midi")
	public void saisireHeureDeFinApresMidiDansLeChampHeureDeFinApresMidi() {
		planifPage.fillField(PlanificationPage.heureFinApresMidiField,"17:00");

	}
	@When("saisire heure de debut pause dejeuner dans le champ heure de debut pause dejeuner")
	public void saisireHeureDeDebutPauseDejeunerDansLeChampHeureDeDebutPauseDejeuner() {
	    planifPage.fillField(PlanificationPage.heureDebutDej, "12:00");

	}
	@When("saisire heure de fin pause dejeuner dans le champ heure de fin pause dejeuner")
	public void saisireHeureDeFinPauseDejeunerDansLeChampHeureDeFinPauseDejeuner() {
		planifPage.fillField(PlanificationPage.heureFinDej, "13:00");

	}
	@When("saisire heure de debut pause dans le champ heure de debut pause")
	public void saisireHeureDeDebutPauseDansLeChampHeureDeDebutPause() {
		planifPage.fillField(PlanificationPage.debutPause1, "10:00");

	}
	@When("saisire heure de fin pause dans le champ heure de fin pause")
	public void saisireHeureDeFinPauseDansLeChampHeureDeFinPause() {
		planifPage.fillField(PlanificationPage.finPause1, "10:10");

	}
	@Then("click sur le bouton ajouter")
	public void clickSurLeBoutonAjouter() {
		planifPage.btnClick(PlanificationPage.addNewConfigBtn);
	}
	@Then("verifier l ajout de configuration")
	public void verifierLAjoutDeConfiguration() throws InterruptedException {
		planifPage.verification(PlanificationPage.successConfigCreationMsg, "Success!");
		planifPage.btnClick(PlanificationPage.confirmPopupBtn);
	}



}
