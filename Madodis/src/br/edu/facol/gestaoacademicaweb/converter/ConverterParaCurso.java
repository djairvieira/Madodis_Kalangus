package br.edu.facol.gestaoacademicaweb.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Component
public class ConverterParaCurso implements Converter<String, Curso> {

	@Autowired
	private CursoService cursoService;
	
	@Override
	public Curso convert(String id) {
		return cursoService.getCursoById(Integer.parseInt(id));
	}

}
