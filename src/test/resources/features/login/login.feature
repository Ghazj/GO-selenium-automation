Feature: Login

  Scenario: Login with valid credentials
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales validas
    Then el usuario deberia ver el dashboard
    
  Scenario: Login error
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales validas
    Then el usuario deberia ver un error
    
  Scenario: Login skip
    Given el test se skipea    