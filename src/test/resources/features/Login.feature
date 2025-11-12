@Pruebas
Feature: Comprar un producto exitosamente en SauceDemo

  @login
  Scenario: El usuario inicia sesion correctamente
    Given que el usuario está en la pagina de inicio de sesion
    When ingresa credenciales validas
    Then es redirigido a la pagina de inventario
    And visualiza la lista de productos disponibles