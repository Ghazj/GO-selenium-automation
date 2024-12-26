@EjecutarSoloEsta
Feature: Promociones a comercios  

	Background:   
    Given El usuario esta en la pagina de login
    When El usuario ingresa credenciales validas
    Then El usuario deberia ver pantalla de inicio de GO

  	Scenario: Alta de promocion MasterCard
    Given El usuario ingresa a pantalla de promociones
    When El usuario carga formulario de pantalla promociones - Campo Descripcion "PruebaAutomatizada"
    And El usuario carga formulario de pantalla promociones - Campo FechaDesde
    And El usuario carga formulario de pantalla promociones - Campo FechaHasta
    And El usuario carga formulario de pantalla promociones - Campo CuotasDesde "1" 
    And El usuario carga formulario de pantalla promociones - Campo CuotasHasta "12"
    And El usuario carga formulario de pantalla promociones - Campo SistemaFinanciacion "FINANCIACION ADQUIRENTE"
    And El usuario carga formulario de pantalla promociones - Campo TasaPromo "0"
    And El usuario carga formulario de pantalla promociones - Campo HoraDesde
    And El usuario carga formulario de pantalla promociones - Campo HoraHasta
    And El usuario carga formulario de pantalla promociones - Campo Modoentrada "CONTACTLESS"
    And El usuario carga formulario de pantalla promociones - Campo PorcentajeDescuento "50"
    And El usuario carga formulario de pantalla promociones - Campo TopeDescuento "50000"
    And El usuario carga formulario de pantalla promociones - Campo TopeTotal "50000"
    And El usuario carga formulario de pantalla promociones - Campo ParteEmisor "30"
    And El usuario carga formulario de pantalla promociones - Campo ParteComercio "30"
    And El usuario carga formulario de pantalla promociones - Campo ParteAdquirente "40"
    And El usuario carga formulario de pantalla promociones - Campo Prioridad "1"
    And El usuario carga formulario de pantalla promociones - Campo SeleccionarMarca "Todas"
    And El usuario carga formulario de pantalla promociones - Campo SeleccionarDiasPromo
    And El usuario carga formulario de pantalla Comercios
    And El usuario carga formulario de pantalla Comercios - Campo SeleccionarComercios "Rubro"
    And El usuario carga formulario de pantalla Comercios - Campo SeleccionarTiposComercios "97 - Furia"
    And El usuario carga formulario de pantalla Tarjetas
    And El usuario carga formulario de pantalla Tarjetas - Campo TarjetaDesde "5450290000000000"
    And El usuario carga formulario de pantalla Tarjetas - Campo TarjetaHasta "5450299999999999"
    Then El usuario deberia ver la pantalla con alta de promociones
    
    Scenario: Alta de promocion Visa
    Given El usuario ingresa a pantalla de promociones
    When El usuario carga formulario de pantalla promociones - Campo Descripcion "PruebaAutomatizada"
    And El usuario carga formulario de pantalla promociones - Campo FechaDesde
    And El usuario carga formulario de pantalla promociones - Campo FechaHasta
    And El usuario carga formulario de pantalla promociones - Campo CuotasDesde "1" 
    And El usuario carga formulario de pantalla promociones - Campo CuotasHasta "12"
    And El usuario carga formulario de pantalla promociones - Campo SistemaFinanciacion "FINANCIACION ADQUIRENTE"
    And El usuario carga formulario de pantalla promociones - Campo TasaPromo "0"
    And El usuario carga formulario de pantalla promociones - Campo HoraDesde
    And El usuario carga formulario de pantalla promociones - Campo HoraHasta
    And El usuario carga formulario de pantalla promociones - Campo Modoentrada "CONTACTLESS"
    And El usuario carga formulario de pantalla promociones - Campo PorcentajeDescuento "50"
    And El usuario carga formulario de pantalla promociones - Campo TopeDescuento "50000"
    And El usuario carga formulario de pantalla promociones - Campo TopeTotal "50000"
    And El usuario carga formulario de pantalla promociones - Campo ParteEmisor "30"
    And El usuario carga formulario de pantalla promociones - Campo ParteComercio "30"
    And El usuario carga formulario de pantalla promociones - Campo ParteAdquirente "40"
    And El usuario carga formulario de pantalla promociones - Campo Prioridad "1"
    And El usuario carga formulario de pantalla promociones - Campo SeleccionarMarca "Todas"
    And El usuario carga formulario de pantalla promociones - Campo SeleccionarDiasPromo
    And El usuario carga formulario de pantalla Comercios
    And El usuario carga formulario de pantalla Comercios - Campo SeleccionarComercios "Rubro"
    And El usuario carga formulario de pantalla Comercios - Campo SeleccionarTiposComercios "97 - Furia"
    And El usuario carga formulario de pantalla Tarjetas
    And El usuario carga formulario de pantalla Tarjetas - Campo TarjetaDesde "4761220000000000"
    And El usuario carga formulario de pantalla Tarjetas - Campo TarjetaHasta "4761229999999999"
    Then El usuario deberia ver la pantalla con alta de promociones
    
    Scenario: Alta de promocion datos por archivo
    Given El usuario ingresa a pantalla de promociones
    When El usuario carga formulario de pantalla promociones - Campo Descripcion dinamico
    And El usuario carga formulario de pantalla promociones - Campo FechaDesde dinamico
    And El usuario carga formulario de pantalla promociones - Campo FechaHasta dinamico
    And El usuario carga formulario de pantalla promociones - Campo CuotasDesde dinamico
    And El usuario carga formulario de pantalla promociones - Campo CuotasHasta dinamico
    And El usuario carga formulario de pantalla promociones - Campo SistemaFinanciacion dinamico
    And El usuario carga formulario de pantalla promociones - Campo TasaPromo dinamico
    And El usuario carga formulario de pantalla promociones - Campo HoraDesde dinamico
    And El usuario carga formulario de pantalla promociones - Campo HoraHasta dinamico
    And El usuario carga formulario de pantalla promociones - Campo Modoentrada dinamico
    And El usuario carga formulario de pantalla promociones - Campo PorcentajeDescuento dinamico
    And El usuario carga formulario de pantalla promociones - Campo TopeDescuento dinamico
    And El usuario carga formulario de pantalla promociones - Campo TopeTotal dinamico
    And El usuario carga formulario de pantalla promociones - Campo ParteEmisor dinamico
    And El usuario carga formulario de pantalla promociones - Campo ParteComercio dinamico
    And El usuario carga formulario de pantalla promociones - Campo ParteAdquirente dinamico
    And El usuario carga formulario de pantalla promociones - Campo Prioridad dinamico
    And El usuario carga formulario de pantalla promociones - Campo SeleccionarMarca dinamico
    And El usuario carga formulario de pantalla promociones - Campo SeleccionarDiasPromo
    And El usuario carga formulario de pantalla Comercios
    And El usuario carga formulario de pantalla Comercios - Campo SeleccionarComercios dinamico
    And El usuario carga formulario de pantalla Comercios - Campo SeleccionarTiposComercios dinamico
    And El usuario carga formulario de pantalla Tarjetas
    And El usuario carga formulario de pantalla Tarjetas - Campo TarjetaDesde dinamico
    And El usuario carga formulario de pantalla Tarjetas - Campo TarjetaHasta dinamico
    Then El usuario deberia ver la pantalla con alta de promociones
    