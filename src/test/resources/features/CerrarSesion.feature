@Pruebas
Feature: Cerrar sesión en la tienda

  @CerrarSesion
  Scenario: Cerrar sesion correctamente
    Given que el usuario completo la compra
    When abre el menu lateral y selecciona Logout
    Then debe ser redirigido nuevamente a la pagina de login