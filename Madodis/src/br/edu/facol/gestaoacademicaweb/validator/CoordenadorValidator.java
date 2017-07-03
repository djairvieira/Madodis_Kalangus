package br.edu.facol.gestaoacademicaweb.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;

@Service("coordenadorValidator")
public class CoordenadorValidator implements Validator {

	@Autowired
	private CoordenadorService coordenadorService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Coordenador.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Coordenador coordenador = (Coordenador) obj;
		
		List<Coordenador> email = coordenadorService.getByEmail(coordenador.getId(), coordenador.getEmail());
		if (email != null && email.size() > 0) {
			errors.rejectValue("email", "", "Email ja esta em uso no sistema.");
		}
		
		List<Coordenador> cpf = coordenadorService.getByCpf(coordenador.getId(), coordenador.getCpf());
		if (cpf != null && cpf.size() > 0) {
			errors.rejectValue("cpf", "", "Cpf ja esta em uso no sistema.");
		}
		
		List<Coordenador> rg = coordenadorService.getByRg(coordenador.getId(), coordenador.getRg());
		if (rg != null && rg.size() > 0) {
			errors.rejectValue("rg", "", "Rg ja esta em uso no sistema.");
		}
		
		List<Coordenador> matricula = coordenadorService.getByRg(coordenador.getId(), coordenador.getRg());
		if (matricula != null && matricula.size() > 0) {
			errors.rejectValue("matricula", "", "Matricula ja esta em uso no sistema.");
		}
		
		List<Coordenador> tituloEleitoral = coordenadorService.getByTitulo(coordenador.getId(), coordenador.getTituloEleitoral());
		if (tituloEleitoral != null && tituloEleitoral.size() > 0) {
			errors.rejectValue("tituloEleitoral", "", "Titulo eleitoral ja esta em uso no sistema.");
		}
		
		List<Coordenador> ctps = coordenadorService.getByCtpsNumero(coordenador.getId(), coordenador.getCtpsNumero());
		if (ctps != null && ctps.size() > 0) {
			errors.rejectValue("ctpsNumero", "", "CTPS ja esta em uso no sistema.");
		}
		
	}

}
