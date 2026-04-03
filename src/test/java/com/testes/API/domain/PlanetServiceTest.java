package com.testes.API.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.testes.API.common.PlanetConstants.INVALID_PLANET;
import static com.testes.API.common.PlanetConstants.PLANET;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

/*Padrão de nomeclatura dos testes
 * 1° Operação = A operação que está sendo testada
 * 2° Estado = Os parâmetros que a operação vai receber.
 * 3° Retorno = O retorno esperado desse teste com esses parâmetros.*/

@ExtendWith(MockitoExtension.class)
/*Anotação do spring é para poder utilizar a classe service no contexto dos testes.*/
public class PlanetServiceTest {
/*Nosso objeto sob test aqui é o service, precisamos da instância dele implementado*/
    @InjectMocks
    private PlanetService planetService;
    @Mock
    private PlanetRepository repository;
    //operacao_estado_retorno.
    @Test
    public void creatPlanet_withValidData_returnsPlanet(){
        /*Quando o repository for chamado no método salvar com exatamente o planeta
        * o retorno esperado deve ser ele mesmo. */
        /* AAA
        * A = Arrange = Onde é arrumando os dados para os testes e faz toda preparação.*/
        when(repository.save(PLANET)).thenReturn(PLANET);
        //O objeto sob teste é chamado de sut.
        //System under test
        // A = Act = quando agimos de fato, para implementação dos testes.
       Planet sut = planetService.criandoPlaneta(PLANET);
       // A = Assert = Aferimos se o sistema sob teste está retornando o esperado.
       assertThat(sut).isEqualTo(PLANET);
    }
    @Test
    public void createPlanet_withInvalidData_throwsException(){
        when(repository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() ->planetService.criandoPlaneta(INVALID_PLANET))
                .isInstanceOf(RuntimeException.class);
    }
    @Test
    public void getPlanet_ByExistingId_ReturnsPlanet(){
        when(repository.findById(1L)).thenReturn(Optional.of(PLANET));

        Optional<Planet> sut = planetService.buscaPorId(1L);

        assertThat(sut).isNotEmpty();
        assertThat(sut).contains(PLANET);
    }
    @Test
    public void getPlanet_ByUnexistingId_ReturnsEmpty(){
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Optional<Planet> sut = planetService.buscaPorId(1L);

        assertThat(sut).isEmpty();
    }
}
