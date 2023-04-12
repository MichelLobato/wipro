Feature: Consulta de Endereço e Cálculo de Frete

  Scenario: Consultar endereço e calcular frete para um CEP válido
    Given que eu tenha um CEP válido
    When eu consultar o endereço e calcular o frete
    Then o serviço deve retornar o endereço e o frete corretos