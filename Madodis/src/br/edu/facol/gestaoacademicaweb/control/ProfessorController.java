package br.edu.facol.gestaoacademicaweb.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.pojo.Estado;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.pojo.Titulacao;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;
import br.edu.facol.gestaoacademicaweb.validator.ProfessorValidator;

@Controller
public class ProfessorController {

	private ProfessorService professorService;
	private ProfessorValidator professorValidator;
	private DisciplinaService disciplinaService;
	private TurmaService turmaService;
	private AulaService aulaService;

	@RequestMapping("/listarProfessores")
	public String listarProfessors(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("professorList", professorService.listarProfessors(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("professorList", professorService.listarProfessors(coordenador.getInstituicao()));
		} else {
			map.put("professorList", professorService.listarProfessors());
		}
		
		map.put("professor", new Professor());
		return "professor/listar_professor";
	}
	
	@RequestMapping("/listarProfessoresOK")
	public String listarProfessoresOK(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("professorList", professorService.listarProfessors(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("professorList", professorService.listarProfessors(coordenador.getInstituicao()));
		} else {
			map.put("professorList", professorService.listarProfessors());
		}
		
		map.put("success", "Docente adicionado/alterado com sucesso.");
		map.put("professor", new Professor());
		return "professor/listar_professor";
	}

	@RequestMapping("/form_professores")
	public String formProfessors(Map<String, Object> map) {
		map.put("professor", new Professor());
		map.put("sexos", Sexo.values());
		map.put("titulacoes", Titulacao.values());
		map.put("estados", Estado.values());
		return "professor/inserir_professor_form";
	}

	@RequestMapping(value = "/adicionarProfessor", method = RequestMethod.POST)
	public String adicionarProfessor(HttpServletRequest request, @Valid @ModelAttribute("professor") Professor professor, 
			BindingResult result, ModelMap model) {
		
		professorValidator.validate(professor, result);
		
		if (result.hasErrors()) {
			model.put("sexos", Sexo.values());
			model.put("titulacoes", Titulacao.values());
			model.put("estados", Estado.values());
			return "/professor/inserir_professor_form";
		}
		
		model.addAttribute(professor.getNome());
		model.addAttribute(professor.getMatricula());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			professor.setInstituicao(secretaria.getInstituicao());
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			professor.setInstituicao(coordenador.getInstituicao());
		} else {
			professor.setInstituicao(null);
		}
		
		professorService.adicionarProfessor(professor);
		return "redirect:/listarProfessoresOK";
	}
	
	@RequestMapping(value = "/atualizarProfessor", method = RequestMethod.POST)
	public String atualizarprofessor(HttpServletRequest request, 
			@Valid @ModelAttribute("professor") Professor professor, 
			BindingResult result, ModelMap model) {
		
		professorValidator.validate(professor, result);
		
		if (result.hasErrors()) {
			model.put("sexos", Sexo.values());
			model.put("titulacoes", Titulacao.values());
			model.put("estados", Estado.values());
			return "/professor/inserir_professor_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			professor.setInstituicao(secretaria.getInstituicao());
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			professor.setInstituicao(coordenador.getInstituicao());
		} else {
			professor.setInstituicao(null);
		}
		
		model.addAttribute(professor.getNome());
		model.addAttribute(professor.getMatricula());
		professorService.atualizarProfessor(professor);
		return "redirect:/listarProfessoresOK";
	}
	
	@RequestMapping("/remover/professor/{professorId}")
	public String removerProfessor(HttpServletRequest request, 
			@PathVariable("professorId") int id, Model model) {
		try {
			professorService.removerProfessor(id);
		} catch (Exception e) {
			model.addAttribute("error", "Este docente n�o pode ser removido por estar associado a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.addAttribute("professorList", professorService.listarProfessors(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.addAttribute("professorList", professorService.listarProfessors(coordenador.getInstituicao()));
			} else {
				model.addAttribute("professorList", professorService.listarProfessors());
			}
			
			model.addAttribute("professor", new Professor());
			return "professor/listar_professor";
		}
		
		return "redirect:/listarProfessores";
	}

	@RequestMapping(value = "/update/professor/{professorId}", method = RequestMethod.GET)
	public ModelAndView getprofessor(@PathVariable("professorId") int id) {
		Professor professor = professorService.getProfessorById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("professor", professor);
		map.put("sexos", Sexo.values());
		map.put("titulacoes", Titulacao.values());
		map.put("estados", Estado.values());
		return new ModelAndView("professor/inserir_professor_form", map);
	}
	
	@RequestMapping(value = "/relatorioProfessor/{professorId}")
	public ModelAndView relatorioProfessor(@PathVariable("professorId") int id) {
		Professor professor = new Professor();
		professor.setId(id);
		List<Disciplina> disciplinas = disciplinaService.getDisciplinaByProfessorId(id);
		List<Turma> turmas = turmaService.getTurmaByProfessorId(id);
		List<Aula> aulas = aulaService.listarAulas(professor);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("disciplinas", disciplinas);
		map.put("turmas", turmas);
		map.put("aulas", aulas);
		return new ModelAndView("relatorio/relatorio_professor", map);
	}

	@Autowired
	public void setProfessorService(ProfessorService professorService) {
		this.professorService = professorService;
	}
	
	@Autowired
	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}
	
	@Autowired
	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	
	@Autowired
	public void setAulaService(AulaService aulaService) {
		this.aulaService = aulaService;
	}

	@Autowired
	public void setProfessorValidator(ProfessorValidator professorValidator) {
		this.professorValidator = professorValidator;
	}
	
}
