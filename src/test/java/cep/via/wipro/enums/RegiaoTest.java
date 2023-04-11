package cep.via.wipro.enums;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RegiaoTest {

    @Test
    void getValorFreteTestandoValorDoFreteNaRegiao() {
        BigDecimal expectedFrete = BigDecimal.valueOf(7.85);
        BigDecimal actualFrete = Regiao.getValorFrete("SP");
        assertEquals(expectedFrete, actualFrete, "Valor do frete para AM deve ser " + expectedFrete + ", mas foi " + actualFrete);
    }

    @Test
    void getValorFreteTestandoSeForUmaRegiaoDiferente() {

        Exception exception = assertThrows(RuntimeException.class, () -> Regiao.getValorFrete("AA"));
        assertEquals("Não foi possivel encontrar o estado do endereço.", exception.getMessage(), "Mensagem de exceção incorreta");
    }

}