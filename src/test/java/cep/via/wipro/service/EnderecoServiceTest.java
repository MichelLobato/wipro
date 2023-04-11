package cep.via.wipro.service;

import cep.via.wipro.dto.EnderecoRequestDTO;
import cep.via.wipro.dto.EnderecoResponseDTO;
import cep.via.wipro.dto.ViaCepDTO;
import cep.via.wipro.enums.Regiao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnderecoServiceTest {
    @Mock
    private ViaCepService viaCepService;
    @InjectMocks
    private EnderecoService enderecoService;
    @Test
    void buscaEnderecoViaCep() {

        EnderecoRequestDTO enderecoRequestDTO = new EnderecoRequestDTO();
        enderecoRequestDTO.setCep("01001000");

        ViaCepDTO viaCepDTO = new ViaCepDTO();
        viaCepDTO.setCep("01001000");
        viaCepDTO.setLogradouro("Praça da Sé");
        viaCepDTO.setComplemento("lado ímpar");
        viaCepDTO.setBairro("São Paulo");
        viaCepDTO.setUf("SP");
        when(viaCepService.buscarEnderecoViaCep(enderecoRequestDTO.getCep())).thenReturn(viaCepDTO);

        BigDecimal valorFrete = Regiao.getValorFrete(viaCepDTO.getUf());

        EnderecoResponseDTO enderecoResponseDTO = enderecoService.buscaEnderecoViaCep(enderecoRequestDTO);
        assertEquals(viaCepDTO.getCep(), enderecoResponseDTO.getCep());
        assertEquals(viaCepDTO.getLogradouro(), enderecoResponseDTO.getRua());
        assertEquals(viaCepDTO.getComplemento(), enderecoResponseDTO.getComplemento());
        assertEquals(viaCepDTO.getBairro(), enderecoResponseDTO.getBairro());
        assertEquals(viaCepDTO.getUf(), enderecoResponseDTO.getEstado());
        assertEquals(valorFrete, enderecoResponseDTO.getFrete());

    }
}