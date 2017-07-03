package br.edu.facol.gestaoacademicaweb.control;

import java.util.HashMap;
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

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Estado;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;
import br.edu.facol.gestaoacademicaweb.validator.AlunoValidator;

@Controller
public class AlunoController {

	private AlunoService alunoService;
	private AlunoValidator alunoValidator;

	@RequestMapping("/listarAlunos")
	public String listarAlunos(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("alunoList", alunoService.listarAlunos(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("alunoList", alunoService.listarAlunos(coordenador.getInstituicao()));
		} else {
			map.put("alunoList", alunoService.listarAlunos());
		}
		
		map.put("aluno", new Aluno());
		return "alunos/listar_aluno";
	}
	
	@RequestMapping("/listarAlunosOK")
	public String listarAlunosOK(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("alunoList", alunoService.listarAlunos(secretaria.getInstituicao()));
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
			map.put("alunoList", alunoService.listarAlunos(coordenador.getInstituicao()));
		} else {
			map.put("alunoList", alunoService.listarAlunos());
		}
		
		map.put("success", "Discente adicionado/alterado com sucesso.");
		map.put("aluno", new Aluno());
		return "alunos/listar_aluno";
	}

	@RequestMapping("/form_alunos")
	public String formAlunos(Map<String, Object> map) {
		map.put("aluno", new Aluno());
		map.put("sexos", Sexo.values());
		map.put("estados", Estado.values());
		return "alunos/inserir_aluno_form";
	}

	@RequestMapping(value = "/adicionarAluno", method = RequestMethod.POST)
	public String adicionarAluno(HttpServletRequest request, @Valid 
			 @ModelAttribute("aluno") Aluno aluno, BindingResult result, ModelMap model) {
		
		alunoValidator.validate(aluno, result);
		
		if (result.hasErrors()) {
			model.put("sexos", Sexo.values());
			model.put("estados", Estado.values());
			return "/alunos/inserir_aluno_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			aluno.setInstituicao(secretaria.getInstituicao());
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador =  (Coordenador) request.getSession().getAttribute("user");
			aluno.setInstituicao(coordenador.getInstituicao());
		} else {
			aluno.setInstituicao(null);
		}
		
		model.addAttribute(aluno.getNome());
		model.addAttribute(aluno.getMatricula());
		alunoService.adicionarAluno(aluno);
		return "redirect:/listarAlunosOK";
	}
	
	@RequestMapping(value = "/atualizarAluno", method = RequestMethod.POST)
	public String atualizarAluno(HttpServletRequest request, @Valid 
			@ModelAttribute("aluno") Aluno aluno, BindingResult result, ModelMap model) {
		
		alunoValidator.validate(aluno, result);
		
		if (result.hasErrors()) {
			model.put("sexos", Sexo.values());
			model.put("estados", Estado.values());
			return "/alunos/inserir_aluno_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			aluno.setInstituicao(secretaria.getInstituicao());
		} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
			Coordenador coordenador =  (Coordenador) request.getSession().getAttribute("user");
			aluno.setInstituicao(coordenador.getInstituicao());
		} else {
			aluno.setInstituicao(null);
		}
		
		model.addAttribute(aluno.getNome());
		model.addAttribute(aluno.getMatricula());
		alunoService.atualizarAluno(aluno);
		return "redirect:/listarAlunosOK";
	}
	
	@RequestMapping("/remover/aluno/{alunoId}")
	public String removerAluno(HttpServletRequest request, @PathVariable("alunoId") int id, Model model) {
		try {
			alunoService.removerAluno(id);
		} catch(Exception e) {
			model.addAttribute("error", "Este discente n�o pode ser removido por estar associado a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.addAttribute("alunoList", alunoService.listarAlunos(secretaria.getInstituicao()));
			} else if (request.getSession().getAttribute("user") instanceof Coordenador) {
				Coordenador coordenador = (Coordenador) request.getSession().getAttribute("user");
				model.addAttribute("alunoList", alunoService.listarAlunos(coordenador.getInstituicao()));
			} else {
				model.addAttribute("alunoList", alunoService.listarAlunos());
			}
			
			return "alunos/listar_aluno";
		}
		
		return "redirect:/listarAlunos";
	}

	@RequestMapping(value = "/update/aluno/{alunoId}", method = RequestMethod.GET)
	public ModelAndView getAluno(@PathVariable("alunoId") int id) {
		Aluno aluno = alunoService.getAlunoById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aluno", aluno);
		map.put("sexos", Sexo.values());
		map.put("estados", Estado.values());
		return new ModelAndView("alunos/inserir_aluno_form", map);
	}

	@Autowired
	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@Autowired
	public void setAlunoValidator(AlunoValidator alunoValidator) {
		this.alunoValidator = alunoValidator;
	}
	
}
