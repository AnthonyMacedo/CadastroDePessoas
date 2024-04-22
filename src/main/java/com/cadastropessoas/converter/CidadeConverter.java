package com.cadastropessoas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.cadastropessoas.model.Cidade;
import com.cadastropessoas.service.CidadeService;

@FacesConverter(forClass = Cidade.class,value = "cidadeConverter" )
public class CidadeConverter implements Converter {

	@Inject
	private CidadeService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		try {
			Long id = Long.parseLong(value);
			Cidade retorno = service.buscarPorId(id);
			return retorno;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		try {
			Cidade retorno = (Cidade) value;
			Long codigo = retorno.getId();
			return codigo.toString();

		} catch (Exception e) {
			return null;
		}
	}

}
