package br.com.kronos.commons.aspect;

import static java.lang.System.lineSeparator;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.kronos.commons.controller.KronosBaseController;

@Aspect
@Component
public class LogarPaginasAcessadas {

	Logger log = Logger.getLogger("casting");

	@Before("execution(* br.com.kronos.casting.controller.*.*(..))")
	public void logarPaginasAcessadasBefore(JoinPoint joinPoint) throws Throwable {
		
		log.info("Controller: " + getNomeController(joinPoint) + lineSeparator());
		
		log.info("Metodo: " + getNomeMetodo(joinPoint) + lineSeparator());
		
		log.info("RequestMapping: " + getRequestMapping(joinPoint) + lineSeparator());
		
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
	
	private String getRequestMapping(JoinPoint joinPoint) throws NoSuchMethodException, SecurityException{
		Signature assinatura = joinPoint.getSignature();
		Method metodo = getMethod(assinatura);
		RequestMapping requestMapping = metodo.getAnnotation(RequestMapping.class);
		return requestMapping.value()[0];		
	}

	private Method getMethod(Signature assinatura) {
		Method metodo = null;
		Method[] metodos = assinatura.getDeclaringType().getMethods();
		for (Method metodoTemp : metodos) {
			if(metodoTemp.getName().equalsIgnoreCase(assinatura.getName())){
				metodo = metodoTemp;
				break;
			}
		}
		return metodo;
	}

}
