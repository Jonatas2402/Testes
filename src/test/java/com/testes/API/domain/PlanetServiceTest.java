package com.testes.API.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static com.testes.API.common.PlanetConstants.PLANET;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/*Padrão de nomeclatura dos testes
 * 1° Operação = A operação que está sendo testada
 * 2° Estado = Os parâmetros que a operação vai receber.
 * 3° Retorno = O retorno esperado desse teste com esses parâmetros.*/

@SpringBootTest(classes = PlanetService.class)
/*Anotação do spring é para poder utilizar a classe service no contexto dos testes.*/
public class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;
    @MockitoBean
    private PlanetRepository repository;
    //operacao_estado_retorno.
    @Test
    public void creatPlanet_withValidData_returnsPlanet(){
        /*Quando o repository for chamado no método salvar com exatamente o planeta
        * o retorno esperado deve ser ele mesmo. */
        /* AAA
        * A = Arrange*/
        when(repository.save(PLANET)).thenReturn(PLANET);
        //O objeto sob teste é chamado de sut.
        //System under test
       Planet sut = planetService.criandoPlaneta(PLANET);
       assertThat(sut).isEqualTo(PLANET);
    }
}
