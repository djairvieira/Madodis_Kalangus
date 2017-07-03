package br.edu.facol.gestaoacademicaweb.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;

@Service("secretariaValidator")
public class SecretariaValidator implements Validator {

	@Autowired
	private SecretariaService secretariaService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Secretaria.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Secretaria secretaria = (Secretaria) obj;
		
		List<Secretaria> email = secretariaService.getByEmail(secretaria.getId(), secretaria.getEmail());
		if (email != null && email.size() > 0) {
			errors.rejectValue("email", "", "Email ja esta em uso no sistema.");
		}
		
		List<Secretaria> cpf = secretariaService.getByCpf(secretaria.getId(), secretaria.getCpf());
		if (cpf != null && cpf.size() > 0) {
			errors.rejectValue("cpf", "", "Cpf ja esta em uso no sistema.");
		}
		
		List<Secretaria> rg = secretariaService.getByRg(secretaria.getId(), secretaria.getRg());
		if (rg != null && rg.size() > 0) {
			errors.rejectValue("rg", "", "Rg ja esta em uso no sistema.");
		}
		
		List<Secretaria> matricula = secretariaService.getByRg(secretaria.getId(), secretaria.getRg());
		if (matricula != null && matricula.size() > 0) {
			errors.rejectValue("matricula", "", "Matricula ja esta em uso no sistema.");
		}
		
		List<Secretaria> tituloEleitoral = secretariaService.getByTitulo(secretaria.getId(), secretaria.getTituloEleitoral());
		if (tituloEleitoral != null && tituloEleitoral.size() > 0) {
			errors.rejectValue("tituloEleitoral", "", "Titulo eleitoral ja esta em uso no sistema.");
		}
		
		List<Secretaria> ctps = secretariaService.getByCtpsNumero(secretaria.getId(), secretaria.getCtpsNumero());
		if (ctps != null && ctps.size() > 0) {
			errors.rejectValue("ctpsNumero", "", "CTPS ja esta em uso no sistema.");
		}
		
	}

}
