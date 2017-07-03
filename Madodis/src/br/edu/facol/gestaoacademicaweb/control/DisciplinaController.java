package br.edu.facol.gestaoacademicaweb.control;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;

@Controller
public class DisciplinaController {

	@Resource(name = "disciplinaService")
	private DisciplinaService disciplinaService;
	
	@Resource(name = "professorService")
	private ProfessorService professorService;

	@RequestMapping("/listarDisciplinas")
	public String listarDisciplinas(HttpServletRequest request, Map<String, Object> map) {
		map.put("disciplina", new Disciplina());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("disciplinaList", disciplinaService.listarDisciplinas(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("disciplinaList", disciplinaService.listarDisciplinas(coordenador.getInstituicao()));
		} else {
			map.put("disciplinaList", disciplinaService.listarDisciplinas());
		}
		return "disciplinas/listar_disciplina";
	}
	
	@RequestMapping("/listarDisciplinasOK")
	public String listarDisciplinasOK(HttpServletRequest request, Map<String, Object> map) {
		map.put("disciplina", new Disciplina());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("disciplinaList", disciplinaService.listarDisciplinas(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("disciplinaList", disciplinaService.listarDisciplinas(coordenador.getInstituicao()));
		} else {
			map.put("disciplinaList", disciplinaService.listarDisciplinas());
		}
		
		
		map.put("success", "Disciplina adicionada/alterada com sucesso.");
		return "disciplinas/listar_disciplina";
	}

	@RequestMapping("/form_disciplinas")
	public String formDisciplinas(HttpServletRequest request, Map<String, Object> map) {
		map.put("disciplina", new Disciplina());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("professores", professorService.listarProfessors(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("professores", professorService.listarProfessors(coordenador.getInstituicao()));
		} else {
			map.put("professores", professorService.listarProfessors());
		}

		return "disciplinas/inserir_disciplina_form";
	}

	@RequestMapping(value = "/adicionarDisciplina", method = RequestMethod.POST)
	public String adicionarDisciplina(HttpServletRequest request, 
			@Valid @ModelAttribute("disciplina") Disciplina disciplina, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.put("professores", professorService.listarProfessors(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.put("professores", professorService.listarProfessors(coordenador.getInstituicao()));
			} else {
				model.put("professores", professorService.listarProfessors());
			}
			
			return "/disciplinas/inserir_disciplina_form";
		}
		
		model.addAttribute(disciplina.getNome());
		model.addAttribute(disciplina.getDescricao());
		disciplinaService.adicionarDisciplina(disciplina);
		return "redirect:/listarDisciplinasOK";
	}
	
	@RequestMapping(value = "/atualizarDisciplina", method = RequestMethod.POST)
	public String atualizarDisciplina(HttpServletRequest request, 
			@Valid @ModelAttribute("disciplina") Disciplina disciplina, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.put("professores", professorService.listarProfessors(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.put("professores", professorService.listarProfessors(coordenador.getInstituicao()));
			} else {
				model.put("professores", professorService.listarProfessors());
			}
			
			return "/disciplinas/inserir_disciplina_form";
		}
		
		model.addAttribute(disciplina.getNome());
		model.addAttribute(disciplina.getDescricao());
		disciplinaService.atualizarDisciplina(disciplina);
		return "redirect:/listarDisciplinasOK";
	}
	
	@RequestMapping("/remover/disciplina/{disciplinaId}")
	public String removerDisciplina(HttpServletRequest request, 
			@PathVariable("disciplinaId") int id, Model model) {
		try {
			disciplinaService.removerDisciplina(id);
		} catch (Exception e) {
			model.addAttribute("error", "Esta disciplina não pode ser removida por estar associada a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.addAttribute("disciplinaList", disciplinaService.listarDisciplinas(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.addAttribute("disciplinaList", disciplinaService.listarDisciplinas(coordenador.getInstituicao()));
			} else {
				model.addAttribute("disciplinaList", disciplinaService.listarDisciplinas());
			}
			
			return "disciplinas/listar_disciplina";
		}
		
		return "redirect:/listarDisciplinas";
	}

	@RequestMapping(value = "/update/disciplina/{disciplinaId}", method = RequestMethod.GET)
	public ModelAndView getDisciplina(HttpServletRequest request, @PathVariable("disciplinaId") int id) {
		Disciplina disciplina = disciplinaService.getDisciplinaById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("disciplina", disciplina);
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("professores", professorService.listarProfessors(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("professores", professorService.listarProfessors(coordenador.getInstituicao()));
		} else {
			map.put("professores", professorService.listarProfessors());
		}
		
		return new ModelAndView("disciplinas/inserir_disciplina_form", map);
	}
	
}
