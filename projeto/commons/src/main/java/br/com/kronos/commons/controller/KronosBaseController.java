package br.com.kronos.commons.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KronosBaseController {

	@Autowired
	private HttpSession sessao;

	public Object getSessao(String chave) {
		return sessao.getAttribute(chave);
	}
	
	public <T>T getSessao(String chave, Class<T> tipoObjeto) {
		Object atributo = sessao.getAttribute(chave);
		if(tipoObjeto.equals(atributo.getClass())){
			return tipoObjeto.cast(atributo);
		}else{
			throw new IllegalArgumentException("Chave " + chave + " não contém o objeto " + tipoObjeto.getName());
		}
	}

	public void setAttribute(String chave, Object atributo) {
		sessao.setAttribute(chave, atributo);
	}
	
	
	
}
