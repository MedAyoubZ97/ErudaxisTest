@ajoutConfig
Feature: ajouter une configuration
  En tant que utilisateur je veut créer un nouveau configuration afin de préparer des configurations des temps

	Background:
	Given authentifier sur la plateforme erudaxis
	And choisir la section college
	And acceder au module configuration
	And acceder a la formulaire d ajout de configuration 
	
  @ajoutConfig
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
      | "test2"|  "60" | "08:00" | "08:15" | "08:15" | "08:25" | "08:05" | "08:10" | "10:00" | "10:05" | "Erreur!"  |
      | "test" |  "60" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Erreur!"  |
      
   @ajoutConfigCaseVide
   Scenario: ajouter une configuration avec cas non valide
    When saisir nom de configuration ""
    And saisir duree de seance ""
    And saisire heure de debut matin dans le champ heure de debut matin ""
    And saisire heure de fin matin dans le champ heure de fin matin ""
    And saisire heure de debut apres midi dans le champ heure de debut apres midi ""
    And saisire heure de fin apres midi dans le champ heure de fin apres midi ""
    And saisire heure de debut pause dejeuner dans le champ heure de debut pause dejeuner ""
    And saisire heure de fin pause dejeuner dans le champ heure de fin pause dejeuner ""
    And saisire heure de debut pause dans le champ heure de debut pause ""
    And saisire heure de fin pause dans le champ heure de fin pause ""
    Then click sur le bouton ajouter
    And verifier apparition d erreur case vide 
    
   @ajoutConfigDureeInvalide
   Scenario Outline: ajouter une configuration avec cas non valide
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
    And verifier apparition d erreur duree <msg>
    Examples: 
      | nom    | duree | heureDebutMatin  | heureFinMatin | heureDebutAprésMidi | heureFinAprésMidi | heureDebutDej | heureFinDej | heureDebutPause | heureFinPause | msg |
      | "test duree1" |  "29" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Durée minimum est de 30 minutes"  |
      | "test duree2" | "541" | "08:00" | "12:00" | "12:00" | "17:00" | "12:00" | "13:00" | "10:00" | "10:05" | "Durée maximum est de 540 minutes"  |