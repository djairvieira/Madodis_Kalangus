package br.edu.facol.gestaoacademicaweb.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;

@Component
public class ConverterParaAluno implements Converter<String, Aluno> {

	@Autowired
	private AlunoService alunoService;
	
	@Override
	public Aluno convert(String id) {
		return alunoService.getAlunoById(Integer.parseInt(id));
	}

}
