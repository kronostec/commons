package br.com.kronos.commons.aspect;

import static org.mockito.Mockito.when;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LogarExceptionsTest {

	@InjectMocks
	private LogarExceptions logarExceptions;
	
	@Mock
	private JoinPoint joinPoint;
	
	@Mock
	private Signature signatore;
	
	@Mock
	private Throwable throwable;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deveLogarErro() {
		
		when(joinPoint.getSignature()).thenReturn(signatore);
		when(joinPoint.getSignature().getDeclaringTypeName()).thenReturn("Classe teste");
		when(joinPoint.getSignature().getName()).thenReturn("metodoTeste");
		
		logarExceptions.interceptException(joinPoint, throwable);
	}

}
