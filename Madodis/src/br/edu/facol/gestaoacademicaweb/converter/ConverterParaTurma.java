package br.edu.facol.gestaoacademicaweb.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;

@Component
public class ConverterParaTurma implements Converter<String, Turma> {

	@Autowired
	private TurmaService turmaService;
	
	@Override
	public Turma convert(String id) {
		return turmaService.getTurmaById(Integer.parseInt(id));
	}

}
