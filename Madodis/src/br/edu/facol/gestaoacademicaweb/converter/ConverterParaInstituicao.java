package br.edu.facol.gestaoacademicaweb.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;

@Component
public class ConverterParaInstituicao implements Converter<String, Instituicao> {

	@Autowired
	private InstituicaoService instituicaoService;
	
	@Override
	public Instituicao convert(String id) {
		return instituicaoService.getInstituicaoById(Integer.parseInt(id));
	}

}
