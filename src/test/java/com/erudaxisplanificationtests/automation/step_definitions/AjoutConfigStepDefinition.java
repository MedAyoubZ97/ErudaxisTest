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
	
	@When("saisir nom de configuration {string}")
	public void saisirNomDeConfiguration(String input) {
	   planifPage.fillField(PlanificationPage.configNameField,input);
	}
	
	@When("saisir duree de seance {string}")
	public void saisirDureeDeSeance(String string) {
		planifPage.fillField(PlanificationPage.durationField,string);
	}
	
	@When("saisire heure de debut matin dans le champ heure de debut matin {string}")
	public void saisireHeureDeDebutMatinDansLeChampHeureDeDebutMatin(String string) {
		planifPage.fillField(PlanificationPage.heureDebutMatinField,string);

	}
	@When("saisire heure de fin matin dans le champ heure de fin matin {string}")
	public void saisireHeureDeFinMatinDansLeChampHeureDeFinMatin(String string) {
		planifPage.fillField(PlanificationPage.heurefinMatinField,string);
	}
	@When("saisire heure de debut apres midi dans le champ heure de debut apres midi {string}")
	public void saisireHeureDeDebutApresMidiDansLeChampHeureDeDebutApresMidi(String string) {
		planifPage.fillField(PlanificationPage.heureDebutApresMidiField,string);
	}
	@When("saisire heure de fin apres midi dans le champ heure de fin apres midi {string}")
	public void saisireHeureDeFinApresMidiDansLeChampHeureDeFinApresMidi(String string) {
		planifPage.fillField(PlanificationPage.heureFinApresMidiField,"17:00");

	}
	@When("saisire heure de debut pause dejeuner dans le champ heure de debut pause dejeuner {string}")
	public void saisireHeureDeDebutPauseDejeunerDansLeChampHeureDeDebutPauseDejeuner(String string) {
	    planifPage.fillField(PlanificationPage.heureDebutDej, string);

	}
	@When("saisire heure de fin pause dejeuner dans le champ heure de fin pause dejeuner {string}")
	public void saisireHeureDeFinPauseDejeunerDansLeChampHeureDeFinPauseDejeuner(String string) {
		planifPage.fillField(PlanificationPage.heureFinDej, string);

	}
	@When("saisire heure de debut pause dans le champ heure de debut pause {string}")
	public void saisireHeureDeDebutPauseDansLeChampHeureDeDebutPause(String string) {
		planifPage.fillField(PlanificationPage.debutPause1, string);

	}
	@When("saisire heure de fin pause dans le champ heure de fin pause {string}")
	public void saisireHeureDeFinPauseDansLeChampHeureDeFinPause(String string) {
		planifPage.fillField(PlanificationPage.finPause1, string);

	}
	@Then("click sur le bouton ajouter")
	public void clickSurLeBoutonAjouter() {
		planifPage.btnClick(PlanificationPage.addNewConfigBtn);
	}
	@Then("verifier l ajout de configuration {string}")
	public void verifierLAjoutDeConfiguration(String string){
		planifPage.verification(PlanificationPage.successConfigCreationMsg, string);
		planifPage.btnClick(PlanificationPage.confirmPopupBtn);
	}

	@Then("verifier apparition d erreur case vide")
	public void verifierApparitionDErreurCaseVide() {
		planifPage.verification(PlanificationPage.nameErrMsg,"Nom est obligatoire");
		planifPage.verification(PlanificationPage.dureeVideErrMsg,"Durée est obligatoire");
	}

	@Then("verifier apparition d erreur duree")
	public void verifierApparitionDErreurDuree() {
		planifPage.verifExistance();
	}








}
