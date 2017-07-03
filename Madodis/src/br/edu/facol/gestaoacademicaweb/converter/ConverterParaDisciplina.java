package br.edu.facol.gestaoacademicaweb.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;

@Component
public class ConverterParaDisciplina implements Converter<String, Disciplina> {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@Override
	public Disciplina convert(String id) {
		return disciplinaService.getDisciplinaById(Integer.parseInt(id));
	}

}
