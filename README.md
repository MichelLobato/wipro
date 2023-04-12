API de Consulta de Endereço e Cálculo de Frete
Esta é uma API RESTful desenvolvida em Java 11 e Spring Boot que permite consultar um endereço a partir de um CEP e calcular o valor do frete para esse CEP, com base nas regiões do Brasil.

Como utilizar
A API possui apenas um endpoint, que deve ser chamado através de uma requisição HTTP POST para http://localhost:8080/consultar-cep. A requisição deve conter um corpo no formato JSON, com o seguinte campo:

Formato JSON:

{
    "cep": "01001000"
}

cep: o CEP que se deseja consultar. Pode ser passado com ou sem máscara (exemplo: "01001-000" ou "01001000").
A API irá realizar uma consulta na API ViaCEP para obter o endereço correspondente ao CEP informado. Se o CEP for encontrado, a API irá retornar um objeto JSON com as seguintes informações:

cep: o CEP consultado (com máscara);
rua: a rua correspondente ao CEP;
complemento: o complemento correspondente ao CEP;
bairro: o bairro correspondente ao CEP;
cidade: a cidade correspondente ao CEP;
estado: o estado correspondente ao CEP (sigla);
frete: o valor do frete para o CEP consultado, de acordo com a região do Brasil.
Se o CEP não for encontrado, a API irá retornar uma mensagem de erro.

Regiões do Brasil e valores de frete
A API utiliza os seguintes valores para calcular o frete de acordo com a região do Brasil:

Sudeste: R$ 7,85
Centro-Oeste: R$ 12,50
Nordeste: R$ 15,98
Sul: R$ 17,30
Norte: R$ 20,83
Documentação Swagger
A documentação da API pode ser acessada em tempo de execução através do Swagger UI. Para acessar, basta abrir o seguinte endereço em um navegador web: http://localhost:8080/swagger-ui/index.html.

Testes
A API possui testes unitários desenvolvidos com o framework JUnit 5. Além disso, também foram desenvolvidos testes automatizados utilizando o framework Cucumber.
