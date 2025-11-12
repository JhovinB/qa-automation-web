@Pruebas
Feature: Agregar productos al carrito en SauceDemo

  Background:
    Given que el usuario ha iniciado sesion correctamente

  @AgregarProductos
  Scenario: Agregar dos productos al carrito
    When agrega dos productos al carrito
    Then el icono del carrito debe mostrar el número "2"
    And los productos seleccionados deben mostrarse correctamente al abrir el carrito
