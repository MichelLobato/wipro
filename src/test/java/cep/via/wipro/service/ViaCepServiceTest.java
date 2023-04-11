package cep.via.wipro.service;

import cep.via.wipro.dto.ViaCepDTO;
import cep.via.wipro.exception.EnderecoNaoEncontrato;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static cep.via.wipro.exception.CustomExceptionHandler.ENDERECO_NAO_ENCONTRADO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ViaCepServiceTest {

    @Autowired
    private ViaCepService viaCepService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    void buscarEnderecoViaCep() {
        // Given
        String cep = "01001000";
        ViaCepDTO expectedResponse = new ViaCepDTO();
        expectedResponse.setCep("01001-000");
        expectedResponse.setLogradouro("Praça da Sé");
        expectedResponse.setLocalidade("São Paulo");
        expectedResponse.setComplemento("lado ímpar");
        expectedResponse.setBairro("Sé");
        expectedResponse.setUf("SP");

        ResponseEntity<ViaCepDTO> responseEntity = new ResponseEntity<>(expectedResponse, HttpStatus.OK);
        when(restTemplate.exchange(String.format(ViaCepService.VIA_CEP_URL, cep), HttpMethod.GET, null, ViaCepDTO.class))
                .thenReturn(responseEntity);

        // When
        ViaCepDTO response = viaCepService.buscarEnderecoViaCep(cep);

        // Then
        assertEquals(expectedResponse.getCep(), response.getCep());
        assertEquals(expectedResponse.getLogradouro(), response.getLogradouro());
        assertEquals(expectedResponse.getLocalidade(), response.getLocalidade());
        assertEquals(expectedResponse.getComplemento(), response.getComplemento());
        assertEquals(expectedResponse.getBairro(), response.getBairro());
        assertEquals(expectedResponse.getUf(), response.getUf());
    }

}