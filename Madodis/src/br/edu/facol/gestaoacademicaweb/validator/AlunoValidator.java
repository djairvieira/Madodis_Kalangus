package br.edu.facol.gestaoacademicaweb.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;

@Service("alunoValidator")
public class AlunoValidator implements Validator {

	@Autowired
	private AlunoService alunoService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Aluno.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Aluno aluno = (Aluno) obj;
		
		List<Aluno> email = alunoService.getByEmail(aluno.getId(), aluno.getEmail());
		if (email != null && email.size() > 0) {
			errors.rejectValue("email", "", "Email ja esta em uso no sistema.");
		}
		
		List<Aluno> cpf = alunoService.getByCpf(aluno.getId(), aluno.getCpf());
		if (cpf != null && cpf.size() > 0) {
			errors.rejectValue("cpf", "", "Cpf ja esta em uso no sistema.");
		}
		
		List<Aluno> rg = alunoService.getByRg(aluno.getId(), aluno.getRg());
		if (rg != null && rg.size() > 0) {
			errors.rejectValue("rg", "", "Rg ja esta em uso no sistema.");
		}
		
		List<Aluno> matricula = alunoService.getByRg(aluno.getId(), aluno.getRg());
		if (matricula != null && matricula.size() > 0) {
			errors.rejectValue("matricula", "", "Matricula ja esta em uso no sistema.");
		}
		
		List<Aluno> tituloEleitoral = alunoService.getByTitulo(aluno.getId(), aluno.getTituloEleitoral());
		if (tituloEleitoral != null && tituloEleitoral.size() > 0) {
			errors.rejectValue("tituloEleitoral", "", "Titulo eleitoral ja esta em uso no sistema.");
		}
		
	}

}
