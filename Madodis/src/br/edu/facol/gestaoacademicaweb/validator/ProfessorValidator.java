package br.edu.facol.gestaoacademicaweb.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;

@Service("professorValidator")
public class ProfessorValidator implements Validator {

	@Autowired
	private ProfessorService professorService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Professor.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Professor professor = (Professor) obj;
		
		List<Professor> email = professorService.getByEmail(professor.getId(), professor.getEmail());
		if (email != null && email.size() > 0) {
			errors.rejectValue("email", "", "Email ja esta em uso no sistema.");
		}
		
		List<Professor> cpf = professorService.getByCpf(professor.getId(), professor.getCpf());
		if (cpf != null && cpf.size() > 0) {
			errors.rejectValue("cpf", "", "Cpf ja esta em uso no sistema.");
		}
		
		List<Professor> rg = professorService.getByRg(professor.getId(), professor.getRg());
		if (rg != null && rg.size() > 0) {
			errors.rejectValue("rg", "", "Rg ja esta em uso no sistema.");
		}
		
		List<Professor> matricula = professorService.getByRg(professor.getId(), professor.getRg());
		if (matricula != null && matricula.size() > 0) {
			errors.rejectValue("matricula", "", "Matricula ja esta em uso no sistema.");
		}
		
		List<Professor> tituloEleitoral = professorService.getByTitulo(professor.getId(), professor.getTituloEleitoral());
		if (tituloEleitoral != null && tituloEleitoral.size() > 0) {
			errors.rejectValue("tituloEleitoral", "", "Titulo eleitoral ja esta em uso no sistema.");
		}
		
		List<Professor> ctps = professorService.getByCtpsNumero(professor.getId(), professor.getCtpsNumero());
		if (ctps != null && ctps.size() > 0) {
			errors.rejectValue("ctpsNumero", "", "CTPS ja esta em uso no sistema.");
		}
		
	}

}
