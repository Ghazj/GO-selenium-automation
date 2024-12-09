Feature: Promociones a comercios  

  Scenario: Alta de promocion
    Given el usuario esta en la pagina de login
    When el usuario ingresa credenciales validas
    And el usuario carga promociones
    Then el usuario deberia ver el dashboard    
    