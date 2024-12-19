@EjecutarSoloEsta
Feature: Promociones a comercios  

	Background:   
		Given el usuario esta en la pagina de login   
		When el usuario ingresa credenciales validas  
		Then el usuario deberia ver el dashboard 

  Scenario: Alta de promocion
    Given el usuario ingresa a pantalla de promociones
    Then el usuario carga formulario de pantalla promociones
    And el usuario carga formulario de pantalla Comercios
    And el usuario carga formulario de pantalla Tarjetas
    Then el usuario deberia ver el dashboard con alta de promociones   
    