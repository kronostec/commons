package br.com.kronos.commons.aspect;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.lang.annotation.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.reflect.Whitebox;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.kronos.commons.controller.KronosBaseController;

public class LogarPaginasAcessadasTest {

	@Mock
	private JoinPoint jointPoint;
	
	@Mock
	private Signature signature;
	
	@Mock
	private RequestMapping request;
	
	@InjectMocks
	private LogarPaginasAcessadas logarPaginasAcessadas;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() throws Throwable {
		request = getRequest();
		when(jointPoint.getSignature()).thenReturn(signature);
		when(signature.getName()).thenReturn("getSessao");
		when(signature.getDeclaringType()).thenReturn(new KronosBaseController().getClass());
		
		logarPaginasAcessadas.logarPaginasAcessadasBefore(jointPoint, request);
		
		Object metodoGetNomeController = Whitebox.invokeMethod(logarPaginasAcessadas, "getNomeController", jointPoint);
		Object metodoGetPaginasAcessadas = Whitebox.invokeMethod(logarPaginasAcessadas, "getNomeMetodo", jointPoint);
		Object metodoGetRequestMapping = Whitebox.invokeMethod(logarPaginasAcessadas, "getRequestMapping", request);
		
		assertNotNull(metodoGetNomeController);		
		assertNotNull(metodoGetPaginasAcessadas);
		assertNotNull(metodoGetRequestMapping);
		
	}

	private RequestMapping getRequest(){
		RequestMapping request = new RequestMapping() {
			
			public Class<? extends Annotation> annotationType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String[] value() {
				String[] request = new String[1];
				request[0] = "nomeMetodo";
				return request;
			}
			
			public String[] produces() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String[] params() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public RequestMethod[] method() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String[] headers() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String[] consumes() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return request;
	}

}
