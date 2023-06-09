package cep.via.wipro.cucumber.test;

import cep.via.wipro.dto.EnderecoRequestDTO;
import cep.via.wipro.dto.EnderecoResponseDTO;
import cep.via.wipro.enums.Regiao;
import cep.via.wipro.service.EnderecoService;
import cep.via.wipro.service.ViaCepService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class EnderecoSteps {

    private String cep;
    private EnderecoResponseDTO response;
    private EnderecoRequestDTO enderecoRequestDTO;

    @Given("^que um usuário consultou um endereço válido com CEP \"([^\"]*)\"$")
    public void consultarEnderecoValido(String cep) {
        this.cep = cep;
        enderecoRequestDTO = new EnderecoRequestDTO();
        enderecoRequestDTO.setCep(cep);
        EnderecoService enderecoService = new EnderecoService(new ViaCepService());
        response = enderecoService.buscaEnderecoViaCep(enderecoRequestDTO);
    }
    @Then("^o endereço deve ser retornado corretamente$")
    public void verificarEnderecoRetornado() {
        assertEquals("Praça da Sé", response.getRua());
        assertEquals("Sé", response.getBairro());
        assertEquals("São Paulo", response.getCidade());
        assertEquals("SP", response.getEstado());
        assertEquals("01001-000", response.getCep());
    }

    @And("^o valor do frete deve ser calculado corretamente de acordo com a região$")
    public void verificarValorFrete() {
        BigDecimal valorEsperado = Regiao.getValorFrete(response.getEstado());
        assertEquals(valorEsperado, response.getFrete());
    }

}
