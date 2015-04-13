package br.com.kronos.commons.aspect.logs;

import static java.lang.System.lineSeparator;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.kronos.commons.controller.KronosBaseController;

/**
 * @author Jefferson
 *
 */

@Aspect
@Component
public class LogarPaginasAcessadas {

	private Logger log = Logger.getLogger("casting");

	@Before("@annotation(mapping)")
	public void logarPaginasAcessadasBefore(JoinPoint joinPoint, RequestMapping mapping) throws Throwable {
		
		log.info("Controller: " + getNomeController(joinPoint) + lineSeparator());
		
		log.info("Metodo: " + getNomeMetodo(joinPoint) + lineSeparator());
		
		log.info("RequestMapping: " + getRequestMapping(mapping) + lineSeparator());
		
	}
	
	@SuppressWarnings("unchecked")
	private String getNomeController(JoinPoint joinPoint){
		Signature assinatura = joinPoint.getSignature();
		Class<? extends KronosBaseController> controller = assinatura.getDeclaringType();
		return controller.getName();
	}
	
	private String getNomeMetodo(JoinPoint joinPoint){
		return joinPoint.getSignature().getName();
	}
	
	private String getRequestMapping(RequestMapping requestMapping) throws NoSuchMethodException, SecurityException{
		return requestMapping.value()[0];		
	}

}
