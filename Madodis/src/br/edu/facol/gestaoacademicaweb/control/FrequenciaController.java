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

import br.edu.facol.gestaoacademicaweb.pojo.AlunoFrequencia;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Frequencia;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.FrequenciaService;
import br.edu.facol.gestaoacademicaweb.service.MatriculaService;

@Controller
public class FrequenciaController {

	private AulaService aulaService;
	
	private MatriculaService matriculaService;
	
	private FrequenciaService frequenciaService;

	@RequestMapping(value = "/getFrequencia/{aulaId}", method = RequestMethod.GET)
	public String getFrequencia(@PathVariable int aulaId, Model model) {
		Aula aula = aulaService.getAulaById(aulaId);
		Frequencia frequencia = frequenciaService.getFrequenciaByAula(aula);
		
		if (frequencia == null) {
			frequencia = new Frequencia();
			List<AlunoFrequencia> frequencias = new ArrayList<AlunoFrequencia>();
			List<Matricula> matriculas = matriculaService.getMatriculaByTurma(aula.getTurma());
			
			if (matriculas != null) {
				for (Matricula matricula : matriculas) {
					AlunoFrequencia alunoFreq = new AlunoFrequencia();
					alunoFreq.setPresente(false);
					alunoFreq.setAluno(matricula.getAluno());
					
					frequencias.add(alunoFreq);
				}
			}
			
			frequencia.setAula(aula);
			frequencia.setFrequencias(frequencias);
			
			frequencia = frequenciaService.adicionarFrequenciaComRetorno(frequencia);
		}
		
		model.addAttribute("frequencia", frequencia);
		return "frequencia/form_frequencia";
	}
	
	@RequestMapping(value = "/getFrequencia2/{aulaId}", method = RequestMethod.GET)
	public String getFrequencia2(@PathVariable int aulaId, Model model) {
		Aula aula = aulaService.getAulaById(aulaId);
		Frequencia frequencia = frequenciaService.getFrequenciaByAula(aula);
		
		if (frequencia == null) {
			frequencia = new Frequencia();
			List<AlunoFrequencia> frequencias = new ArrayList<AlunoFrequencia>();
			List<Matricula> matriculas = matriculaService.getMatriculaByTurma(aula.getTurma());
			
			if (matriculas != null) {
				for (Matricula matricula : matriculas) {
					AlunoFrequencia alunoFreq = new AlunoFrequencia();
					alunoFreq.setPresente(false);
					alunoFreq.setAluno(matricula.getAluno());
					
					frequencias.add(alunoFreq);
				}
			}
			
			frequencia.setAula(aula);
			frequencia.setFrequencias(frequencias);
			
			frequencia = frequenciaService.adicionarFrequenciaComRetorno(frequencia);
		}
		
		model.addAttribute("frequencia", frequencia);
		return "frequencia/form_frequencia_professor";
	}
	
	@RequestMapping(value = "/salvarFrequencia", method = RequestMethod.POST)
	public String salvarFrequencia(@ModelAttribute("frequencia") Frequencia frequencia, 
			ModelMap model) {
		Frequencia databaseFrequencia = frequenciaService.getFrequenciaById(frequencia.getId());
		
		for (AlunoFrequencia freqData : databaseFrequencia.getFrequencias()) {
			for (AlunoFrequencia freqLocal : frequencia.getFrequencias()) {
				if (freqData.getId() == freqLocal.getId()) {
					freqData.setPresente(freqLocal.isPresente());
					break;
				}
			}
		}
		
		frequenciaService.atualizarFrequencia(databaseFrequencia);
		return "redirect:/listarAulasOKFrequencia";
	}
	
	@RequestMapping(value = "/salvarFrequencia2", method = RequestMethod.POST)
	public String salvarFrequencia2(@ModelAttribute("frequencia") Frequencia frequencia, 
			ModelMap model) {
		Frequencia databaseFrequencia = frequenciaService.getFrequenciaById(frequencia.getId());
		
		for (AlunoFrequencia freqData : databaseFrequencia.getFrequencias()) {
			for (AlunoFrequencia freqLocal : frequencia.getFrequencias()) {
				if (freqData.getId() == freqLocal.getId()) {
					freqData.setPresente(freqLocal.isPresente());
					break;
				}
			}
		}
		
		frequenciaService.atualizarFrequencia(databaseFrequencia);
		return "redirect:/getAulasFrequenciaOK/" + frequencia.getAula().getProfessor().getId();
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
	public void setFrequenciaService(FrequenciaService frequenciaService) {
		this.frequenciaService = frequenciaService;
	}
	
}
