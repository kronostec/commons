package br.com.kronos.commons.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class KronosBaseControllerTest {

	private static final String STRING_ATRIBUTO = "Atributo teste";

	private static final String STRING_TESTE = "teste";

	@InjectMocks
	private KronosBaseController controller;

	@Mock
	private HttpSession sessao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveSetarDadoNaSessao() {
		controller.setSessao(STRING_TESTE, STRING_ATRIBUTO);
		verify(sessao).setAttribute(
				eq(STRING_TESTE), eq(STRING_ATRIBUTO)
			);
	}
	
	@Test
	public void deveRetornarTtipoEspecificoDaSessao() {
		when(sessao.getAttribute(STRING_TESTE)).thenReturn(STRING_ATRIBUTO);
		String stringTeste = controller.getSessao(STRING_TESTE, String.class);
 		assertEquals(String.class, stringTeste.getClass());
	}
	
	@Test
	public void deveEstourarExceptionDeClasseErrada() {
		when(sessao.getAttribute(STRING_TESTE)).thenReturn(STRING_ATRIBUTO);
		try{
			controller.getSessao(STRING_TESTE, Object.class);
		}catch(IllegalArgumentException ex){
			assertEquals(IllegalArgumentException.class, ex.getClass());
			assertEquals("Chave " + STRING_TESTE + " não contém o objeto " + Object.class.getName(), ex.getMessage());
		}
	}

	@Test
	public void deveRetornarUmObject() {
		when(sessao.getAttribute(STRING_TESTE)).thenReturn(STRING_ATRIBUTO);
		Object classeTeste = controller.getSessao(STRING_TESTE);
		assertNotNull(classeTeste);
	}
	
}
