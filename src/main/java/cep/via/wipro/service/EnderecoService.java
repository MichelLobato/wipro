package cep.via.wipro.service;

import cep.via.wipro.dto.EnderecoRequestDTO;
import cep.via.wipro.dto.EnderecoResponseDTO;
import cep.via.wipro.dto.ViaCepDTO;
import cep.via.wipro.enums.Regiao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final ViaCepService viaCepService;

    public EnderecoResponseDTO buscaEnderecoViaCep(EnderecoRequestDTO enderecoRequestDTO) {
        ViaCepDTO response = viaCepService.buscarEnderecoViaCep(enderecoRequestDTO.getCep());

        BigDecimal frete = Regiao.getValorFrete(response.getUf());
        response.setFrete(frete);

        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
        enderecoResponseDTO.setCep(response.getCep());
        enderecoResponseDTO.setRua(response.getLogradouro());
        enderecoResponseDTO.setComplemento(response.getComplemento());
        enderecoResponseDTO.setBairro(response.getBairro());
        enderecoResponseDTO.setCidade(response.getLocalidade());
        enderecoResponseDTO.setEstado(response.getUf());
        enderecoResponseDTO.setFrete(response.getFrete());

        return enderecoResponseDTO;
    }
}
