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
import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.pojo.Estado;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;
import br.edu.facol.gestaoacademicaweb.validator.SecretariaValidator;

@Controller
public class SecretariaController {

	private SecretariaService secretariaService;
	
	private SecretariaValidator secretariaValidator;
	
	@Resource(name = "instituicaoService")
	private InstituicaoService instituicaoService;
	
	@Resource(name = "professorService")
	private ProfessorService professorService;
	
	private DisciplinaService disciplinaService;
	private TurmaService turmaService;
	private AulaService aulaService;

	@RequestMapping("/listarSecretarias")
	public String listarSecretarias(Map<String, Object> map) {
		map.put("secretaria", new Secretaria());
		map.put("secretariaList", secretariaService.listarSecretarias());
		map.put("instituicoes", instituicaoService.listarInstituicoes());
		return "secretaria/listar_secretaria";
	}
	
	@RequestMapping("/listarSecretariasOK")
	public String listarSecretariasOK(Map<String, Object> map) {
		map.put("secretaria", new Secretaria());
		map.put("secretariaList", secretariaService.listarSecretarias());
		map.put("instituicoes", instituicaoService.listarInstituicoes());
		map.put("success", "Secretaria adicionada/alterada com sucesso.");
		return "secretaria/listar_secretaria";
	}

	@RequestMapping("/form_secretarias")
	public String formSecretarias(Map<String, Object> map) {
		map.put("secretaria", new Secretaria());
		map.put("sexos", Sexo.values());
		map.put("estados", Estado.values());
		map.put("instituicoes", instituicaoService.listarInstituicoes());
		return "secretaria/inserir_secretaria_form";
	}

	@RequestMapping(value = "/adicionarSecretaria", method = RequestMethod.POST)
	public String adicionarSecretaria(@Valid @ModelAttribute("secretaria") Secretaria secretaria, 
			BindingResult result, ModelMap model) {
		
		secretariaValidator.validate(secretaria, result);
		
		if (result.hasErrors()) {
			model.addAttribute("instituicoes", instituicaoService.listarInstituicoes());
			model.put("secretaria", secretaria);
			model.put("sexos", Sexo.values());
			model.put("estados", Estado.values());
			return "/secretaria/inserir_secretaria_form";
		}
		
		model.addAttribute(secretaria.getNome());
		model.addAttribute(secretaria.getMatricula());
		secretariaService.adicionarSecretaria(secretaria);
		return "redirect:/listarSecretariasOK";
	}
	
	@RequestMapping(value = "/atualizarSecretaria", method = RequestMethod.POST)
	public String atualizarSecretaria(@Valid @ModelAttribute("secretaria") Secretaria secretaria, 
			BindingResult result, ModelMap model) {
		
		secretariaValidator.validate(secretaria, result);
		
		if (result.hasErrors()) {
			model.addAttribute("instituicoes", instituicaoService.listarInstituicoes());
			model.put("secretaria", secretaria);
			model.put("sexos", Sexo.values());
			model.put("estados", Estado.values());
			return "/secretaria/inserir_secretaria_form";
		}
		
		model.addAttribute(secretaria.getNome());
		model.addAttribute(secretaria.getMatricula());
		secretariaService.atualizarSecretaria(secretaria);
		return "redirect:/listarSecretariasOK";
	}
	
	@RequestMapping("/remover/secretaria/{secretariaId}")
	public String removerSecretaria(HttpServletRequest request, 
			@PathVariable("secretariaId") int id, Model model) {
		try {
			secretariaService.removerSecretaria(id);
		} catch(Exception e) {
			model.addAttribute("error", "Esta secretaria não pode ser removida por estar associada a um outro objeto.");
			model.addAttribute("secretaria", new Secretaria());
			model.addAttribute("secretariaList", secretariaService.listarSecretarias());
			model.addAttribute("instituicoes", instituicaoService.listarInstituicoes());
			model.addAttribute("success", "Secretaria adicionada/alterada com sucesso.");
			return "secretaria/listar_secretaria";
		}
		
		return "redirect:/listarSecretarias";
	}

	@RequestMapping(value = "/update/secretaria/{secretariaId}", method = RequestMethod.GET)
	public ModelAndView getSecretaria(@PathVariable("secretariaId") int id) {
		Secretaria secretaria = secretariaService.getSecretariaById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secretaria", secretaria);
		map.put("sexos", Sexo.values());
		map.put("estados", Estado.values());
		map.put("instituicoes", instituicaoService.listarInstituicoes());
		return new ModelAndView("secretaria/inserir_secretaria_form", map);
	}
	
	@RequestMapping(value = "/relatorioSecretaria/{secretariaId}")
	public ModelAndView relatorioProfessor(@PathVariable("secretariaId") int id) {
		Secretaria secretaria = secretariaService.getSecretariaById(id);
		List<Disciplina> disciplinas = disciplinaService.listarDisciplinas(secretaria.getInstituicao());
		List<Turma> turmas = turmaService.listaTurmas(secretaria.getInstituicao());
		List<Aula> aulas = aulaService.listarAulas(secretaria.getInstituicao());
		List<Professor> professores = professorService.listarProfessors(secretaria.getInstituicao());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("disciplinas", disciplinas);
		map.put("turmas", turmas);
		map.put("aulas", aulas);
		map.put("professores", professores);
		return new ModelAndView("relatorio/relatorio_secretaria", map);
	}

	@Autowired
	public void setSecretariaService(SecretariaService secretariaService) {
		this.secretariaService = secretariaService;
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
	public void setSecretariaValidator(SecretariaValidator secretariaValidator) {
		this.secretariaValidator = secretariaValidator;
	}
	
}
