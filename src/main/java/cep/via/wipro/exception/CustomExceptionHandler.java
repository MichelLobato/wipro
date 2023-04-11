package cep.via.wipro.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    public static final String ENDERECO_NAO_ENCONTRADO = "Endereço não encontrado!";

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EnderecoNaoEncontrato.class)
    public ResponseError handle(EnderecoNaoEncontrato ex) {

        ex.printStackTrace();

        return new ResponseError(ex.getMessage());
    }
}
