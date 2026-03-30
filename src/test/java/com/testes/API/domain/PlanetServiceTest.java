package com.testes.API.domain;
import static com.testes.API.common.PlanetConstants.PLANET;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*Padrão de nomeclatura dos testes
 * 1° Operação = A operação que está sendo testada
 * 2° Estado = Os parâmetros que a operação vai receber.
 * 3° Retorno = O retorno esperado desse teste com esses parâmetros.*/

@SpringBootTest(classes = PlanetService.class)
/*Anotação do spring é para poder utilizar a classe service no contexto dos testes.*/
public class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;
    //operacao_estado_retorno.
    @Test
    public void creatPlanet_withValidData_returnsPlanet(){
        //O objeto sob teste é chamado de sut.
        //System under test
       Planet sut = planetService.criandoPlaneta(PLANET);
       assertThat(sut).isEqualTo(PLANET);
    }
}
