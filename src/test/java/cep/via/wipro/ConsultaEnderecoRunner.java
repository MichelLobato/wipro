package cep.via.wipro;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features/ConsultaEnderecoECalculoViaCep.feature",
        glue = "cep.via.wipro.cucumber.test")
public class ConsultaEnderecoRunner {
}
