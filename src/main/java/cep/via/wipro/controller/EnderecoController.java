package cep.via.wipro.controller;

import cep.via.wipro.dto.EnderecoRequestDTO;
import cep.via.wipro.dto.EnderecoResponseDTO;
import cep.via.wipro.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.VIA;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consultar-cep")
public class EnderecoController {

    private final EnderecoService service;

    @ApiOperation(value = "Buscar endereço no VIA CEP")
    @PostMapping
    public EnderecoResponseDTO buscarEnderecoViaCep(@Valid @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        return service.buscaEnderecoViaCep(enderecoRequestDTO);
    }

}
