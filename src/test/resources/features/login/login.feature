Feature: Login

  Scenario: Login con credenciales validas
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales validas
    Then el usuario deberia ver pantalla de inicio de GO
    