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
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.pojo.TurmaLetra;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;

@Controller
public class TurmaController {

	@Resource(name = "turmaService")
	private TurmaService turmaService;
	
	@Resource(name = "disciplinaService")
	private DisciplinaService disciplinaService;

	@RequestMapping("/form_turmas")
	public String formTurmas(HttpServletRequest request, Map<String, Object> map) {
		map.put("turma", new Turma());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("disciplinas", disciplinaService.listarDisciplinas(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("disciplinas", disciplinaService.listarDisciplinas(coordenador.getInstituicao()));
		} else {
			map.put("disciplinas", disciplinaService.listarDisciplinas());
		}
		
		map.put("letras", TurmaLetra.values());
		
		return "turmas/inserir_turma_form";
	}

	@RequestMapping("/listarTurmas")
	public String listarTurmas(HttpServletRequest request, Map<String, Object> map) {
		map.put("turma", new Turma());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("turmaList", turmaService.listaTurmas(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("turmaList", turmaService.listaTurmas(coordenador.getInstituicao()));
		} else {
			map.put("turmaList", turmaService.listaTurmas());
		}
		
		return "turmas/listar_turma";
	}
	
	@RequestMapping("/listarTurmasOK")
	public String listarTurmasOK(HttpServletRequest request, Map<String, Object> map) {
		map.put("turma", new Turma());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("turmaList", turmaService.listaTurmas(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("turmaList", turmaService.listaTurmas(coordenador.getInstituicao()));
		} else {
			map.put("turmaList", turmaService.listaTurmas());
		}
		
		map.put("success", "Turma adicionada/alterada com sucesso.");
		
		return "turmas/listar_turma";
	}

	@RequestMapping(value = "/adicionarTurma", method = RequestMethod.POST)
	public String adicionarTurma(HttpServletRequest request, 
			@Valid @ModelAttribute("turma") Turma turma, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.put("disciplinas", disciplinaService.listarDisciplinas(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.put("disciplinas", disciplinaService.listarDisciplinas(coordenador.getInstituicao()));
			} else {
				model.put("disciplinas", disciplinaService.listarDisciplinas());
			}
			
			model.put("letras", TurmaLetra.values());
			
			return "/turmas/inserir_turma_form";
		}
		
		model.addAttribute("nome", turma.getNome());
		turmaService.adicionarTurma(turma);
		return "redirect:/listarTurmasOK";
	}
	
	@RequestMapping(value = "/atualizarTurma", method = RequestMethod.POST)
	public String atualizarTurma(HttpServletRequest request, 
			@Valid @ModelAttribute("turma") Turma turma, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.put("disciplinas", disciplinaService.listarDisciplinas(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.put("disciplinas", disciplinaService.listarDisciplinas(coordenador.getInstituicao()));
			} else {
				model.put("disciplinas", disciplinaService.listarDisciplinas());
			}
			
			model.put("letras", TurmaLetra.values());
			
			return "/turmas/inserir_turma_form";
		}
		
		model.addAttribute(turma.getNome());
		turmaService.atualizarTurma(turma);
		return "redirect:/listarTurmasOK";
	}
	
	@RequestMapping("/remover/turma/{turmaId}")
	public String removerTurma(HttpServletRequest request, 
			@PathVariable("turmaId") int id, Model model) {
		try {
			turmaService.removerTurma(id);
		} catch (Exception e) {
			model.addAttribute("error", "Esta turma não pode ser removida por estar associada a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.addAttribute("turmaList", turmaService.listaTurmas(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.addAttribute("turmaList", turmaService.listaTurmas(coordenador.getInstituicao()));
			} else {
				model.addAttribute("turmaList", turmaService.listaTurmas());
			}
			
			return "turmas/listar_turma";
		}
		
		return "redirect:/listarTurmas";
	}

	@RequestMapping(value = "/update/turma/{turmaId}", method = RequestMethod.GET)
	public ModelAndView getTurma(HttpServletRequest request, @PathVariable("turmaId") int id) {
		Turma turma = turmaService.getTurmaById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("turma", turma);
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("disciplinas", disciplinaService.listarDisciplinas(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("disciplinas", disciplinaService.listarDisciplinas(coordenador.getInstituicao()));
		} else {
			map.put("disciplinas", disciplinaService.listarDisciplinas());
		}
		
		map.put("letras", TurmaLetra.values());
		
		return new ModelAndView("turmas/inserir_turma_form", map);
	}

}
