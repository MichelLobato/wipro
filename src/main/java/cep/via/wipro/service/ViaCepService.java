package cep.via.wipro.service;

import cep.via.wipro.dto.ViaCepDTO;
import cep.via.wipro.exception.EnderecoNaoEncontrato;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static cep.via.wipro.exception.CustomExceptionHandler.ENDERECO_NAO_ENCONTRADO;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    public static final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";

    private final RestTemplate restTemplate = new RestTemplate();

    public ViaCepDTO buscarEnderecoViaCep(String cep) {
        String url = String.format(VIA_CEP_URL, cep);

        try {
            return restTemplate.getForObject(url, ViaCepDTO.class);
        }catch (Exception ex) {
            throw new EnderecoNaoEncontrato(String.format(ENDERECO_NAO_ENCONTRADO));
        }
    }
}
