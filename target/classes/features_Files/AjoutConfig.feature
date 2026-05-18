@ajoutConfig
Feature: ajouter une configuration
  En tant que utilisateur je veut créer un nouveau configuration afin de préparer des configurations des temps

	Background:
	Given authentifier sur la plateforme erudaxis
	And choisir la section college
	And acceder au module configuration
	And acceder a la formulaire d ajout de configuration 
	
  @ajoutConfigCasValide
  Scenario Outline: ajouter une configuration avec cas valide
    When saisir nom de configuration <nom>
    And saisir duree de seance <duree>
    And saisire heure de debut matin dans le champ heure de debut matin <heureDebutMatin>
    And saisire heure de fin matin dans le champ heure de fin matin <heureFinMatin>
    And saisire heure de debut apres midi dans le champ heure de debut apres midi <heureDebutAprésMidi>
    And saisire heure de fin apres midi dans le champ heure de fin apres midi <heureFinAprésMidi>
    And saisire heure de debut pause dejeuner dans le champ heure de debut pause dejeuner <heureDebutDej>
    And saisire heure de fin pause dejeuner dans le champ heure de fin pause dejeuner <heureFinDej>
    And saisire heure de debut pause dans le champ heure de debut pause <heureDebutPause>
    And saisire heure de fin pause dans le champ heure de fin pause <heureFinPause>
    Then click sur le bouton ajouter
    And verifier l ajout de configuration <msg>
    
    Examples: 
      | nom    | duree | heureDebutMatin  | heureFinMatin | heureDebutAprésMidi | heureFinAprésMidi | heureDebutDej | heureFinDej | heureDebutPause | heureFinPause | msg |
      | "test" |  "60" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Success!" |
      | "    " |  "60" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Erreur!"  |
      | "/@#+-"|  "60" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Erreur!"  |
      | "test" |  "29" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Erreur!"  |
      | "test" | "541" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Erreur!"  |