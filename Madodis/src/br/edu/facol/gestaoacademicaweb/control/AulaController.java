package br.edu.facol.gestaoacademicaweb.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.AulaArquivo;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.pojo.TipoDeAula;
import br.edu.facol.gestaoacademicaweb.service.AulaArquivoService;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.MatriculaService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;

@Controller
public class AulaController {

	private AulaService aulaService;
	
	private AulaArquivoService aulaArquivoService;
	
	private TurmaService turmaService;
	
	private ProfessorService professorService;
	
	private MatriculaService matriculaService;

	@RequestMapping("/getAulas/{professorId}")
	public String getAulas(HttpServletRequest request, 
			@PathVariable("professorId") int id, 
			Map<String, Object> map) {
		
			Professor professor = professorService.getProfessorById(id);
		if (professor != null) {
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("aula", new Aula());
		return "aulas/listar_aula_professor";
	}
	
	@RequestMapping("/getAulas/alunos/{professorId}")
	public String getAulasAlunos(HttpServletRequest request, 
			@PathVariable("professorId") int id, 
			Map<String, Object> map) {
		
			Professor professor = professorService.getProfessorById(id);
		if (professor != null) {
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("aula", new Aula());
		return "aulas/listar_aula_professor_aluno";
	}
	
	@RequestMapping("/getAulasFrequenciaOK/{professorId}")
	public String getAulasFrequenciaOK(HttpServletRequest request, 
			@PathVariable("professorId") int id, 
			Map<String, Object> map) {
		
			Professor professor = professorService.getProfessorById(id);
		if (professor != null) {
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("success", "Frequencia adicionada/alterada com sucesso.");
		map.put("aula", new Aula());
		return "aulas/listar_aula_professor";
	}
	
	@RequestMapping("/getAulasProvaOK/{professorId}")
	public String getAulasProvaOK(HttpServletRequest request, 
			@PathVariable("professorId") int id, 
			Map<String, Object> map) {
		
			Professor professor = professorService.getProfessorById(id);
		if (professor != null) {
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("success", "Notas da prova adicionada/alterada com sucesso.");
		map.put("aula", new Aula());
		return "aulas/listar_aula_professor";
	}
	
	@RequestMapping("/listarAulas")
	public String listarAulas(HttpServletRequest request, Map<String, Object> map) {
		
		if (request.getSession().getAttribute("user") instanceof Professor) {
			Professor professor = (Professor) request.getSession().getAttribute("user");
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("aula", new Aula());
		return "aulas/listar_aula";
	}
	
	@RequestMapping("/listarAulasOK")
	public String listarAulasOK(HttpServletRequest request, Map<String, Object> map) {
		
		if (request.getSession().getAttribute("user") instanceof Professor) {
			Professor professor = (Professor) request.getSession().getAttribute("user");
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("success", "Aula adicionado/alterado com sucesso.");
		map.put("aula", new Aula());
		return "aulas/listar_aula";
	}
	
	@RequestMapping("/listarAulasOKDiario")
	public String listarAulasOKDiario(HttpServletRequest request, Map<String, Object> map) {
		
		if (request.getSession().getAttribute("user") instanceof Professor) {
			Professor professor = (Professor) request.getSession().getAttribute("user");
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("success", "Diario de classe adicionado/alterado com sucesso.");
		map.put("aula", new Aula());
		return "aulas/listar_aula";
	}
	
	@RequestMapping("/listarAulasOKFrequencia")
	public String listarAulasOKFrequencia(HttpServletRequest request, Map<String, Object> map) {
		
		if (request.getSession().getAttribute("user") instanceof Professor) {
			Professor professor = (Professor) request.getSession().getAttribute("user");
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("success", "Frequencia adicionada/alterada com sucesso.");
		map.put("aula", new Aula());
		return "aulas/listar_aula";
	}
	
	@RequestMapping("/listarAulasOKProva")
	public String listarAulasOKProva(HttpServletRequest request, Map<String, Object> map) {
		
		if (request.getSession().getAttribute("user") instanceof Professor) {
			Professor professor = (Professor) request.getSession().getAttribute("user");
			map.put("aulaList", aulaService.listarAulas(professor));
		} else {
			map.put("aulaList", aulaService.listarAulas());
		}
		
		map.put("success", "Notas de prova adicionada/alterada com sucesso.");
		map.put("aula", new Aula());
		return "aulas/listar_aula";
	}

	@RequestMapping("/form_aulas")
	public String formAulas(HttpServletRequest request, Map<String, Object> map) {
		map.put("aula", new Aula());
		map.put("tipos", TipoDeAula.values());
		map.put("turmas", turmaService.listaTurmas());
		
		return "aulas/inserir_aula_form";
	}

	@RequestMapping(value = "/adicionarAula", method = RequestMethod.POST)
	public String adicionarAula(HttpServletRequest request, 
			@Valid @ModelAttribute("aula") Aula aula, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.put("turmas", turmaService.listaTurmas());
			return "/aulas/inserir_aula_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Professor) {
			Professor professor = (Professor) request.getSession().getAttribute("user");
			Professor prof = professorService.getProfessorById(professor.getId());
			aula.setProfessor(prof);
		}
		
		model.addAttribute(aula.getAssunto());
		model.addAttribute(aula.getDataAula());
		aulaService.adicionarAula(aula);
		return "redirect:/listarAulasOK";
	}
	
	@RequestMapping(value = "/atualizarAula", method = RequestMethod.POST)
	public String atualizarAula(HttpServletRequest request, 
			@Valid @ModelAttribute("aula") Aula aula, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.put("turmas", turmaService.listaTurmas());
			return "/aulas/inserir_aula_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Professor) {
			Professor professor = (Professor) request.getSession().getAttribute("user");
			aula.setProfessor(professor);
		}
		
		model.addAttribute(aula.getAssunto());
		model.addAttribute(aula.getDataAula());
		aulaService.atualizarAula(aula);
		return "redirect:/listarAulasOK";
	}
	
	@RequestMapping("/remover/aula/{aulaId}")
	public String removerAula(HttpServletRequest request, @PathVariable("aulaId") int id, Model model) {
		try {
			aulaService.removerAula(id);
		} catch(Exception e) {
			model.addAttribute("error", "Esta aula n�o pode ser removida por estar associado a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Professor) {
				Professor professor = (Professor) request.getSession().getAttribute("user");
				model.addAttribute("aulaList", aulaService.listarAulas(professor));
			} else {
				model.addAttribute("aulaList", aulaService.listarAulas());
			}
			
			return "aulas/listar_aula";
		}
		return "redirect:/listarAulas";
	}
	
	@RequestMapping("/remover/arquivo/{arquivoId}")
	public String removerArquivo(HttpServletRequest request, @PathVariable("arquivoId") int id, Model model) {
		try {
			aulaArquivoService.deleteById(id);
		} catch(Exception e) {
			model.addAttribute("error", "Este arquivo n�o pode ser removida por estar associado a um outro objeto.");
			
			if (request.getSession().getAttribute("user") instanceof Professor) {
				Professor professor = (Professor) request.getSession().getAttribute("user");
				model.addAttribute("aulaList", aulaService.listarAulas(professor));
			} else {
				model.addAttribute("aulaList", aulaService.listarAulas());
			}
			
			return "aulas/listar_aula";
		}
		return "redirect:/listarAulas";
	}

	@RequestMapping(value = "/update/aula/{aulaId}", method = RequestMethod.GET)
	public ModelAndView getAula(@PathVariable("aulaId") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Aula aula = aulaService.getAulaById(id);
		map.put("aula", aula);
		map.put("tipos", TipoDeAula.values());
		map.put("turmas", turmaService.listaTurmas());
		return new ModelAndView("aulas/inserir_aula_form", map);
	}
	
	@RequestMapping(value = "/aula/upload/{aulaId}", method = RequestMethod.GET)
	public ModelAndView getUploadAula(@PathVariable("aulaId") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Aula aula = aulaService.getAulaById(id);
		List<AulaArquivo> arquivos = aulaArquivoService.findAllByAulaId(id);
		map.put("aula", aula);
		map.put("arquivos", arquivos);
		return new ModelAndView("aulas/upload", map);
	}
	
	@RequestMapping(value = "/aula/aluno/download/{aulaId}", method = RequestMethod.GET)
	public ModelAndView getDownloadAula(@PathVariable("aulaId") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Aula aula = aulaService.getAulaById(id);
		List<AulaArquivo> arquivos = aulaArquivoService.findAllByAulaId(id);
		map.put("aula", aula);
		map.put("arquivos", arquivos);
		return new ModelAndView("aulas/upload_aluno", map);
	}
	
	@RequestMapping(value = "/aula/download/{arquivoId}/{aulaId}", method = RequestMethod.GET)
	public void getDownloadFile(@PathVariable("arquivoId") int id, 
			@PathVariable("aulaId") int aulaId, HttpServletResponse response) throws IOException {
		AulaArquivo arquivo = aulaArquivoService.findById(id);
		
		response.setContentType(arquivo.getType());
	    response.setContentLength(arquivo.getContent().length);
	    response.setHeader("Content-Disposition","attachment; filename=\"" + arquivo.getName() +"\"");
	  
	    FileCopyUtils.copy(arquivo.getContent(), response.getOutputStream());
	}
	
	@RequestMapping(value = "/aula/salvarArquivo", method = RequestMethod.POST)
	public ModelAndView submit(
	  @RequestParam MultipartFile content, @RequestParam int aulaId, @RequestParam String name,
	  @RequestParam String description, ModelMap modelMap) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Aula aula = aulaService.getAulaById(aulaId);
		AulaArquivo aulaArquivo = new AulaArquivo();
		aulaArquivo.setAula(aula);
		aulaArquivo.setName(name);
		aulaArquivo.setDescription(description);
		aulaArquivo.setContent(content.getBytes());
		aulaArquivoService.saveDocument(aulaArquivo);
		List<AulaArquivo> arquivos = aulaArquivoService.findAllByAulaId(aulaId);
		map.put("aula", aula);
		map.put("arquivos", arquivos);
		return new ModelAndView("aulas/upload", map);
	}
	
	@RequestMapping(value="/materiais/{alunoId}")
	public ModelAndView materiais(@PathVariable("alunoId") int alunoId) {
		List<Matricula> matriculas = matriculaService.getMatriculaByAlunoId(alunoId);
		List<Professor> professores = new ArrayList<Professor>();
		
		if (matriculas != null) {
			for (Matricula matricula : matriculas) {
				professores.add(matricula.getTurma().getDisciplina().getProfessor());
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("professorList", professores);
		
		return new ModelAndView("professor/listar_professor_aluno", map);
	}

	@Autowired
	public void setAulaService(AulaService aulaService) {
		this.aulaService = aulaService;
	}
	
	@Autowired
	public void setAulaArquivoService(AulaArquivoService aulaArquivoService) {
		this.aulaArquivoService = aulaArquivoService;
	}
	
	@Autowired
	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	
	@Autowired
	public void setProfessorService(ProfessorService professorService) {
		this.professorService = professorService;
	}
	
	@Autowired
	public void setMatriculaService(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}
	
}
