package cep.via.wipro;

import cep.via.wipro.dto.EnderecoResponseDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.http.ResponseEntity;

public class ConsultaEnderecoSteps {

    private String cep;
    private ResponseEntity<EnderecoResponseDTO> enderecoResponse;
    private Double freteCalculado;

    @Given("que eu tenha um CEP válido")
    public void que_eu_tenha_um_CEP_valido() {
        cep = "01001000";
    }

    @When("consultar o endereço e calcular o frete")
    public void consultar_o_endereco_e_calcular_o_frete() {

    }



}
