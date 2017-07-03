package br.edu.facol.gestaoacademicaweb.control;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.DiarioDeClasse;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.DiarioDeClasseService;

@Controller
public class DiarioDeClasseController {

	private AulaService aulaService;
	
	private DiarioDeClasseService diarioDeClasseService;

	@RequestMapping(value = "/getDiarioDeClasse/{aulaId}", method = RequestMethod.GET)
	public String getDiarioDeClasse(@PathVariable int aulaId, Model model) {
		Aula aula = aulaService.getAulaById(aulaId);
		DiarioDeClasse diarioDeClasse = diarioDeClasseService.getDiarioDeClasseByAula(aula);
		
		if (diarioDeClasse == null) {
			diarioDeClasse = new DiarioDeClasse();
			
			diarioDeClasse.setAula(aula);
			diarioDeClasse.setConteudoProgramado("Programado...");
			diarioDeClasse.setConteudoRealizado("Realizado...");
			
			diarioDeClasse = diarioDeClasseService.adicionarDiarioDeClasseComRetorno(diarioDeClasse);
		}
		
		model.addAttribute("diarioDeClasse", diarioDeClasse);
		return "diarioDeClasse/form_diario_de_classe";
	}
	
	@RequestMapping(value = "/salvarDiarioDeClasse", method = RequestMethod.POST)
	public String salvarDiarioDeClasse(HttpServletRequest request, 
			@Valid @ModelAttribute("diarioDeClasse") DiarioDeClasse diarioDeClasse, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.addAttribute("diarioDeClasse", diarioDeClasse);
			return "diarioDeClasse/form_diario_de_classe";
		}
		
		DiarioDeClasse databaseDiarioDeClasse = diarioDeClasseService.getDiarioDeClasseById(diarioDeClasse.getId());
		
		databaseDiarioDeClasse.setConteudoRealizado(diarioDeClasse.getConteudoRealizado());
		databaseDiarioDeClasse.setConteudoProgramado(diarioDeClasse.getConteudoProgramado());
		diarioDeClasseService.atualizarDiarioDeClasse(databaseDiarioDeClasse);
		return "redirect:/listarAulasOKDiario";
	}

	@Autowired
	public void setAulaService(AulaService aulaService) {
		this.aulaService = aulaService;
	}
	
	@Autowired
	public void setDiarioDeClasseService(DiarioDeClasseService diarioDeClasseService) {
		this.diarioDeClasseService = diarioDeClasseService;
	}
	
}
