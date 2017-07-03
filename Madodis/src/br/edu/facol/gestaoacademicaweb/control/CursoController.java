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

import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.TipoEnsino;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Controller
public class CursoController {

	@Resource(name = "cursoService")
	private CursoService cursoService;

	@RequestMapping("/form_cursos")
	public String formCursos(Map<String, Object> map) {
		map.put("curso", new Curso());
		map.put("tipoEnsinos", TipoEnsino.values());
		return "cursos/inserir_curso_form";
	}

	@RequestMapping("/listarCursos")
	public String listarCursos(HttpServletRequest request, Map<String, Object> map) {
		map.put("curso", new Curso());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("cursoList", cursoService.listaCursos(secretaria.getInstituicao()));
		} else {
			map.put("cursoList", cursoService.listaCursos());
		}

		return "cursos/listar_curso";
	}
	
	@RequestMapping("/listarCursosOK")
	public String listarCursosOK(HttpServletRequest request, Map<String, Object> map) {
		map.put("curso", new Curso());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("cursoList", cursoService.listaCursos(secretaria.getInstituicao()));
		} else {
			map.put("cursoList", cursoService.listaCursos());
		}
		
		map.put("success", "Curso adicionado/alterado com sucesso.");

		return "cursos/listar_curso";
	}

	@RequestMapping(value = "/adicionarCurso", method = RequestMethod.POST)
	public String adicionarCurso(HttpServletRequest request, 
			@Valid @ModelAttribute("curso") Curso curso, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.put("tipoEnsinos", TipoEnsino.values());
			return "/cursos/inserir_curso_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			curso.setInstituicao(secretaria.getInstituicao());
		} else {
			curso.setInstituicao(null);
		}
		
		model.addAttribute("nome", curso.getNome());
		cursoService.adicionarCurso(curso);
		return "redirect:/listarCursosOK";
	}
	
	@RequestMapping(value = "/atualizarCurso", method = RequestMethod.POST)
	public String atualizarCurso(HttpServletRequest request, 
			@Valid @ModelAttribute("curso") Curso curso, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.put("tipoEnsinos", TipoEnsino.values());
			return "/cursos/inserir_curso_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			curso.setInstituicao(secretaria.getInstituicao());
		} else {
			curso.setInstituicao(null);
		}
		
		model.addAttribute(curso.getNome());
		model.addAttribute(curso.getSigla());
		cursoService.atualizarCurso(curso);
		return "redirect:/listarCursosOK";
	}
	
	@RequestMapping("/remover/curso/{cursoId}")
	public String removerCurso(HttpServletRequest request, 
			@PathVariable("cursoId") int id, Model model) {
		try {
			cursoService.removerCurso(id);
		} catch (Exception e) {
			model.addAttribute("error", "Este curso não pode ser removido por estar associado a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.addAttribute("cursoList", cursoService.listaCursos(secretaria.getInstituicao()));
			} else {
				model.addAttribute("cursoList", cursoService.listaCursos());
			}

			return "cursos/listar_curso";
		}
		
		return "redirect:/listarCursos";
	}

	@RequestMapping(value = "/update/curso/{cursoId}", method = RequestMethod.GET)
	public ModelAndView getCurso(@PathVariable("cursoId") int id) {
		Curso curso = cursoService.getCursoById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("curso", curso);
		map.put("tipoEnsinos", TipoEnsino.values());
		return new ModelAndView("cursos/inserir_curso_form", map);
	}
	
	@RequestMapping("/cursos/graduacao")
	public String listarCursosGraduacao(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("cursoList", cursoService.listaCursos(secretaria.getInstituicao(), TipoEnsino.Graduacao));
		} else {
			map.put("cursoList", cursoService.listaCursos());
		}

		return "cursos/listar_curso_por_tipo";
	}
	
	@RequestMapping("/cursos/posgraduacao")
	public String listarCursosPosGraduacao(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("cursoList", cursoService.listaCursos(secretaria.getInstituicao(), TipoEnsino.Pos_Graduacao));
		} else {
			map.put("cursoList", cursoService.listaCursos());
		}

		return "cursos/listar_curso_por_tipo";
	}
	
	@RequestMapping("/cursos/tecnico")
	public String listarCursosTecnico(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("cursoList", cursoService.listaCursos(secretaria.getInstituicao(), TipoEnsino.Tecnico));
		} else {
			map.put("cursoList", cursoService.listaCursos());
		}

		return "cursos/listar_curso_por_tipo";
	}

}
