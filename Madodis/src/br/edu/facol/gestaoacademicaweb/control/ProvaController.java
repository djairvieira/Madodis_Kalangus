package br.edu.facol.gestaoacademicaweb.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.facol.gestaoacademicaweb.pojo.AlunoProva;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Prova;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.ProvaService;
import br.edu.facol.gestaoacademicaweb.service.MatriculaService;

@Controller
public class ProvaController {

	private AulaService aulaService;
	
	private MatriculaService matriculaService;
	
	private ProvaService provaService;

	@RequestMapping(value = "/getNotas/{aulaId}", method = RequestMethod.GET)
	public String getNotas(@PathVariable int aulaId, Model model) {
		Aula aula = aulaService.getAulaById(aulaId);
		Prova prova = provaService.getProvaByAula(aula);
		
		if (prova == null) {
			prova = new Prova();
			List<AlunoProva> provas = new ArrayList<AlunoProva>();
			List<Matricula> matriculas = matriculaService.getMatriculaByTurma(aula.getTurma());
			
			if (matriculas != null) {
				for (Matricula matricula : matriculas) {
					AlunoProva alunoFreq = new AlunoProva();
					alunoFreq.setNota(0);
					alunoFreq.setAluno(matricula.getAluno());
					
					provas.add(alunoFreq);
				}
			}
			
			prova.setAula(aula);
			prova.setProvas(provas);
			
			prova = provaService.adicionarProvaComRetorno(prova);
		}
		
		model.addAttribute("prova", prova);
		return "prova/form_prova";
	}
	
	@RequestMapping(value = "/getNotas2/{aulaId}", method = RequestMethod.GET)
	public String getNotas2(@PathVariable int aulaId, Model model) {
		Aula aula = aulaService.getAulaById(aulaId);
		Prova prova = provaService.getProvaByAula(aula);
		
		if (prova == null) {
			prova = new Prova();
			List<AlunoProva> provas = new ArrayList<AlunoProva>();
			List<Matricula> matriculas = matriculaService.getMatriculaByTurma(aula.getTurma());
			
			if (matriculas != null) {
				for (Matricula matricula : matriculas) {
					AlunoProva alunoFreq = new AlunoProva();
					alunoFreq.setNota(0);
					alunoFreq.setAluno(matricula.getAluno());
					
					provas.add(alunoFreq);
				}
			}
			
			prova.setAula(aula);
			prova.setProvas(provas);
			
			prova = provaService.adicionarProvaComRetorno(prova);
		}
		
		model.addAttribute("prova", prova);
		return "prova/form_prova_professor";
	}
	
	@RequestMapping(value = "/salvarProva", method = RequestMethod.POST)
	public String salvarProva(@ModelAttribute("prova") Prova prova, 
			ModelMap model) {
		Prova databaseProva = provaService.getProvaById(prova.getId());
		
		for (AlunoProva provaData : databaseProva.getProvas()) {
			for (AlunoProva provaLocal : prova.getProvas()) {
				if (provaData.getId() == provaLocal.getId()) {
					provaData.setNota(provaLocal.getNota());
					break;
				}
			}
		}
		
		provaService.atualizarProva(databaseProva);
		return "redirect:/listarAulasOKProva";
	}
	
	@RequestMapping(value = "/salvarProva2", method = RequestMethod.POST)
	public String salvarProva2(@ModelAttribute("prova") Prova prova, 
			ModelMap model) {
		Prova databaseProva = provaService.getProvaById(prova.getId());
		
		for (AlunoProva provaData : databaseProva.getProvas()) {
			for (AlunoProva provaLocal : prova.getProvas()) {
				if (provaData.getId() == provaLocal.getId()) {
					provaData.setNota(provaLocal.getNota());
					break;
				}
			}
		}
		
		provaService.atualizarProva(databaseProva);
		return "redirect:/getAulasProvaOK/" + prova.getAula().getProfessor().getId();
	}

	@Autowired
	public void setAulaService(AulaService aulaService) {
		this.aulaService = aulaService;
	}
	
	@Autowired
	public void setMatriculaService(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}
	
	@Autowired
	public void setProvaService(ProvaService provaService) {
		this.provaService = provaService;
	}
	
}
