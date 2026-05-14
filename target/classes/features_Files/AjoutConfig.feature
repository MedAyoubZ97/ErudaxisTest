@ajoutConfig
Feature: ajouter une configuration
  En tant que utilisateur je veut créer un nouveau configuration afin de préparer des configurations des temps

	Background:
	Given authentifier sur la plateforme erudaxis
	And choisir la section college
	And acceder au module configuration
	And acceder a la formulaire d ajout de configuration 
	
  @ajoutConfigCasValide
  Scenario: ajouter une configuration avec cas valide
    When saisir nom de configuration
    And saisir duree de seance
    And saisire heure de debut matin dans le champ heure de debut matin
    And saisire heure de fin matin dans le champ heure de fin matin
    And saisire heure de debut apres midi dans le champ heure de debut apres midi
    And saisire heure de fin apres midi dans le champ heure de fin apres midi
    And saisire heure de debut pause dejeuner dans le champ heure de debut pause dejeuner
    And saisire heure de fin pause dejeuner dans le champ heure de fin pause dejeuner
    And saisire heure de debut pause dans le champ heure de debut pause
    And saisire heure de fin pause dans le champ heure de fin pause
    Then click sur le bouton ajouter
    And verifier l ajout de configuration