package br.edu.facol.gestaoacademicaweb.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;
import br.edu.facol.gestaoacademicaweb.service.CursoService;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;
import br.edu.facol.gestaoacademicaweb.validator.CoordenadorValidator;

@Controller
public class CoordenadorController {

	private CoordenadorService coordenadorService;
	
	private CoordenadorValidator coordenadorValidator;
	
	private CursoService cursoService;
	
	@Resource(name = "professorService")
	private ProfessorService professorService;
	
	private DisciplinaService disciplinaService;
	private TurmaService turmaService;
	private AulaService aulaService;

	@RequestMapping("/listarCoordenadores")
	public String listarCoordenadores(HttpServletRequest request, Map<String, Object> map) {
		map.put("coordenador", new Coordenador());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("coordenadorList", coordenadorService.listarCoordenadores(secretaria.getInstituicao()));
		} else {
			map.put("coordenadorList", coordenadorService.listarCoordenadores());
		}
		return "coordenadores/listar_coordenador";
	}
	
	@RequestMapping("/listarCoordenadoresOK")
	public String listarCoordenadoresOK(HttpServletRequest request, Map<String, Object> map) {
		map.put("coordenador", new Coordenador());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("coordenadorList", coordenadorService.listarCoordenadores(secretaria.getInstituicao()));
		} else {
			map.put("coordenadorList", coordenadorService.listarCoordenadores());
		}
		
		map.put("success", "Coordenador adicionado/alterado com sucesso.");
		return "coordenadores/listar_coordenador";
	}

	@RequestMapping("/form_coordenadores")
	public String formCoordenadors(HttpServletRequest request, Map<String, Object> map) {
		map.put("coordenador", new Coordenador());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("coordenadorCursos", cursoService.listaCursos(secretaria.getInstituicao()));
		} else {
			map.put("coordenadorCursos", cursoService.listaCursos());
		}
		map.put("sexos", Sexo.values());
		map.put("estados", Estado.values());
		return "coordenadores/inserir_coordenador_form";
	}

	@RequestMapping(value = "/adicionarCoordenador", method = RequestMethod.POST)
	public String adicionarCoordenador(HttpServletRequest request, 
			@Valid @ModelAttribute("coordenador") Coordenador coordenador, 
			BindingResult result, ModelMap model) {
		
		coordenadorValidator.validate(coordenador, result);
		
		if (result.hasErrors()) {
			model.put("coordenadorCursos", cursoService.listaCursos());
			model.put("sexos", Sexo.values());
			model.put("estados", Estado.values());
			return "/coordenadores/inserir_coordenador_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			coordenador.setInstituicao(secretaria.getInstituicao());
		} else {
			coordenador.setInstituicao(null);
		}
		
		model.addAttribute(coordenador.getNome());
		model.addAttribute(coordenador.getMatricula());
		coordenadorService.adicionarCoordenador(coordenador);
		return "redirect:/listarCoordenadoresOK";
	}
	
	@RequestMapping(value = "/atualizarCoordenador", method = RequestMethod.POST)
	public String atualizarCoordenador(HttpServletRequest request, 
			@Valid @ModelAttribute("coordenador") Coordenador coordenador, 
			BindingResult result, ModelMap model) {
		
		coordenadorValidator.validate(coordenador, result);
		
		if (result.hasErrors()) {
			model.put("coordenadorCursos", cursoService.listaCursos());
			model.put("sexos", Sexo.values());
			model.put("estados", Estado.values());
			return "/coordenadores/inserir_coordenador_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			coordenador.setInstituicao(secretaria.getInstituicao());
		} else {
			coordenador.setInstituicao(null);
		}
		
		model.addAttribute(coordenador.getNome());
		model.addAttribute(coordenador.getMatricula());
		coordenadorService.atualizarCoordenador(coordenador);
		return "redirect:/listarCoordenadoresOK";
	}
	
	@RequestMapping("/remover/coordenador/{coordenadorId}")
	public String removerCoordenador(HttpServletRequest request, 
			@PathVariable("coordenadorId") int id, Model model) {
		try {
			coordenadorService.removerCoordenador(id);
		} catch (Exception e) {
			model.addAttribute("error", "Este coordenador n�o pode ser removido por estar associado a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.addAttribute("coordenadorList", coordenadorService.listarCoordenadores(secretaria.getInstituicao()));
			} else {
				model.addAttribute("coordenadorList", coordenadorService.listarCoordenadores());
			}

			return "coordenadores/listar_coordenador";
		}
		return "redirect:/listarCoordenadores";
	}

	@RequestMapping(value = "/update/coordenador/{coordenadorId}", method = RequestMethod.GET)
	public ModelAndView getCoordenador(HttpServletRequest request, @PathVariable("coordenadorId") int id) {
		Coordenador coordenador = coordenadorService.getCoordenadorById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("coordenador", coordenador);
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("coordenadorCursos", cursoService.listaCursos(secretaria.getInstituicao()));
		} else {
			map.put("coordenadorCursos", cursoService.listaCursos());
		}
		map.put("sexos", Sexo.values());
		map.put("estados", Estado.values());
		return new ModelAndView("coordenadores/inserir_coordenador_form", map);
	}
	
	@RequestMapping(value = "/relatorioCoordenador/{coordenadorId}")
	public ModelAndView relatorioProfessor(@PathVariable("coordenadorId") int id) {
		Coordenador coordenador = coordenadorService.getCoordenadorById(id);
		List<Disciplina> disciplinas = disciplinaService.listarDisciplinas(coordenador.getInstituicao());
		List<Turma> turmas = turmaService.listaTurmas(coordenador.getInstituicao());
		List<Aula> aulas = aulaService.listarAulas(coordenador.getInstituicao());
		List<Professor> professores = professorService.listarProfessors(coordenador.getInstituicao());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("disciplinas", disciplinas);
		map.put("turmas", turmas);
		map.put("aulas", aulas);
		map.put("professores", professores);
		return new ModelAndView("relatorio/relatorio_coordenador", map);
	}

	@Autowired
	public void setCoordenadorService(CoordenadorService coordenadorService) {
		this.coordenadorService = coordenadorService;
	}

	@Autowired
	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
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
	public void setCoordenadorValidator(CoordenadorValidator coordenadorValidator) {
		this.coordenadorValidator = coordenadorValidator;
	}
	
}
