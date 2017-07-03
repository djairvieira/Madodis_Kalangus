package br.edu.facol.gestaoacademicaweb.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;

@Component
public class ConverterParaProfessor implements Converter<String, Professor> {

	@Autowired
	private ProfessorService professorService;
	
	@Override
	public Professor convert(String id) {
		return professorService.getProfessorById(Integer.parseInt(id));
	}

}
