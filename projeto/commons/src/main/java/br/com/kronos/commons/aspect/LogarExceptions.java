/**
 * 
 */
package br.com.kronos.commons.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Jefferson
 *
 */

@Aspect
@Component
public class LogarExceptions {
	
	Logger logger = Logger.getLogger("casting");
	
	@AfterThrowing(pointcut = "execution(* br.com.kronos..*.*.*(..))", throwing = "ex")
	public void interceptException(JoinPoint ponto, Throwable ex) {
		logger.error("Erro ao executar metodo: " + ponto.getThis().toString() + "." + ponto.getSignature().getName(), ex);
	}

}
