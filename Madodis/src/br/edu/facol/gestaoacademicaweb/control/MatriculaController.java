package br.edu.facol.gestaoacademicaweb.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.AlunoFrequencia;
import br.edu.facol.gestaoacademicaweb.pojo.AlunoProva;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Frequencia;
import br.edu.facol.gestaoacademicaweb.pojo.FrequenciaRetorno;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.pojo.MediaRetorno;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.pojo.Prova;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.TipoDeAula;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;
import br.edu.facol.gestaoacademicaweb.service.AulaService;
import br.edu.facol.gestaoacademicaweb.service.FrequenciaService;
import br.edu.facol.gestaoacademicaweb.service.MatriculaService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.ProvaService;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;

@Controller
public class MatriculaController {
	
	@Resource(name = "provaService")
	private ProvaService provaService;
	
	@Resource(name = "professorService")
	private ProfessorService professorService;
	
	@Resource(name = "aulaService")
	private AulaService aulaService;
	
	@Resource(name = "frequenciaService")
	private FrequenciaService frequenciaService;

	@Resource(name = "matriculaService")
	private MatriculaService matriculaService;
	
	@Resource(name = "turmaService")
	private TurmaService turmaService;
	
	@Resource(name = "alunoService")
	private AlunoService alunoService;

	@RequestMapping("/form_matriculas")
	public String formMatriculas(HttpServletRequest request, Map<String, Object> map) {
		map.put("matricula", new Matricula());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("turmas", turmaService.listaTurmas(secretaria.getInstituicao()));
			map.put("alunos", alunoService.listarAlunos(secretaria.getInstituicao()));
		} else {
			map.put("turmas", turmaService.listaTurmas());
			map.put("alunos", alunoService.listarAlunos());
		}
		
		return "matriculas/inserir_matricula_form";
	}

	@RequestMapping("/listarMatriculas")
	public String listarMatriculas(HttpServletRequest request, Map<String, Object> map) {
		map.put("matricula", new Matricula());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("matriculaList", matriculaService.listaMatriculas(secretaria.getInstituicao()));
		} else {
			map.put("matriculaList", matriculaService.listaMatriculas());
		}
		
		return "matriculas/listar_matricula";
	}
	
	@RequestMapping("/listarMatriculasOK")
	public String listarMatriculasOK(HttpServletRequest request, Map<String, Object> map) {
		map.put("matricula", new Matricula());
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("matriculaList", matriculaService.listaMatriculas(secretaria.getInstituicao()));
		} else {
			map.put("matriculaList", matriculaService.listaMatriculas());
		}
		
		map.put("success", "Matricula adicionado/alterado com sucesso.");
		
		return "matriculas/listar_matricula";
	}

	@RequestMapping(value = "/adicionarMatricula", method = RequestMethod.POST)
	public String adicionarMatricula(@ModelAttribute("matricula") Matricula matricula, 
			ModelMap model, HttpServletRequest request) {
		
		List<Matricula> savedMatriculas = 
				matriculaService.getMatriculaByTurma(matricula.getTurma(), matricula.getAluno());
		
		if (savedMatriculas != null && savedMatriculas.size() > 0) {
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.put("turmas", turmaService.listaTurmas(secretaria.getInstituicao()));
				model.put("alunos", alunoService.listarAlunos(secretaria.getInstituicao()));
			} else {
				model.put("turmas", turmaService.listaTurmas());
				model.put("alunos", alunoService.listarAlunos());
			}
			model.addAttribute("error", "Ja existe matricula para este aluno nesta turma.");
			return "matriculas/inserir_matricula_form";
		}
		
		matriculaService.adicionarMatricula(matricula);
		return "redirect:/listarMatriculasOK";
	}
	
	@RequestMapping(value = "/atualizarMatricula", method = RequestMethod.POST)
	public String atualizarMatricula(@ModelAttribute("matricula") Matricula matricula, 
			ModelMap model, HttpServletRequest request) {
		matriculaService.atualizarMatricula(matricula);
		return "redirect:/listarMatriculasOK";
	}
	
	@RequestMapping("/remover/matricula/{matriculaId}")
	public String removerMatricula(HttpServletRequest request, 
			@PathVariable("matriculaId") int id, Model model) {
		try {
			matriculaService.removerMatricula(id);
		}catch(Exception e) {
			if (request.getSession().getAttribute("user") instanceof Secretaria) {
				Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
				model.addAttribute("matriculaList", matriculaService.listaMatriculas(secretaria.getInstituicao()));
			} else {
				model.addAttribute("matriculaList", matriculaService.listaMatriculas());
			}
			
			model.addAttribute("error", "Esta matricula n�o pode ser removida por estar associada a um outro objeto.");
			
			return "matriculas/listar_matricula";
		}
		return "redirect:/listarMatriculas";
	}

	@RequestMapping(value = "/update/matricula/{matriculaId}", method = RequestMethod.GET)
	public ModelAndView getMatricula(HttpServletRequest request, @PathVariable("matriculaId") int id) {
		Matricula matricula = matriculaService.getMatriculaById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("matricula", matricula);
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("turmas", turmaService.listaTurmas(secretaria.getInstituicao()));
			map.put("alunos", alunoService.listarAlunos(secretaria.getInstituicao()));
		} else {
			map.put("turmas", turmaService.listaTurmas());
			map.put("alunos", alunoService.listarAlunos());
		}
		return new ModelAndView("matriculas/inserir_matricula_form", map);
	}
	
	@RequestMapping("/minhasNotas/{userId}")
	public ModelAndView minhasNotas(@PathVariable("userId") int id) {
		Map<Matricula, Map<Integer, AlunoProva>> dados = new HashMap<Matricula, Map<Integer, AlunoProva>>();
		List<Matricula> matriculas = matriculaService.getMatriculaByAlunoId(id);
		Aluno aluno = alunoService.getAlunoById(id);
		
		if (matriculas != null && matriculas.size() > 0) {
			for (Matricula matricula : matriculas) {
				AlunoProva prova1 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Prova_1, aluno);
				
				AlunoProva prova2 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Prova_2, aluno);
				
				AlunoProva segundaChamadaProva1 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Segunda_Chamada_Prova_1, aluno);
				
				AlunoProva segundaChamadaProva2 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Segunda_Chamada_Prova_2, aluno);
				
				AlunoProva provaFinal = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Prova_Final, aluno);
				
				Map<Integer, AlunoProva> provas = new HashMap<>();
				provas.put(1, prova1);
				provas.put(2, prova2);
				provas.put(3, segundaChamadaProva1);
				provas.put(4, segundaChamadaProva2);
				provas.put(5, provaFinal);
				
				dados.put(matricula, provas);
			}
		}
		
		List<MediaRetorno> retornos = new ArrayList<MediaRetorno>();
		
		for (Matricula matri : dados.keySet()) {
			float nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0, nota5 = 0;
			MediaRetorno retorno = new MediaRetorno(matri.getAluno(), matri.getTurma(), 
					nota1, nota2, nota3, nota4, nota5);
			Map<Integer, AlunoProva> provas = dados.get(matri);
			
			if (provas.get(1) != null && provas.get(1).getNota() > 0f) {
				retorno.setNota1(provas.get(1).getNota());
			}
			
			if (provas.get(2) != null && provas.get(2).getNota() > 0f) {
				retorno.setNota2(provas.get(2).getNota());
			}
			
			if (provas.get(3) != null && provas.get(3).getNota() > 0f) {
				retorno.setNota3(provas.get(3).getNota());
			}
			
			if (provas.get(4) != null && provas.get(4).getNota() > 0f) {
				retorno.setNota4(provas.get(4).getNota());
			}
			
			if (provas.get(5) != null && provas.get(5).getNota() > 0f) {
				retorno.setNota5(provas.get(5).getNota());
			}
			
			retornos.add(retorno);
		}
		
		
		return new ModelAndView("matriculas/minhas_notas", "dados", retornos);
	}
	
	@RequestMapping("/medias/{userId}")
	public ModelAndView medias(@PathVariable("userId") int id) {
		Professor professor = professorService.getProfessorById(id);
		List<Aula> aulas = aulaService.listarAulas(professor);
		
		Set<Prova> provas = new HashSet<Prova>();
		
		if (aulas != null) {
			for (Aula aula : aulas) {
				Prova aux = provaService.getProvaByAula(aula);
				if (aux != null) {
					provas.add(aux);
				}
			}
		}
		
		List<MediaRetorno> retornos = new ArrayList<MediaRetorno>();
		
		if (provas != null) {
			for (Prova prova : provas) {
				for (AlunoProva alunoProva : prova.getProvas()) {
					MediaRetorno retorno = null;
					boolean find = false;
					
					for (MediaRetorno mr : retornos) {
						if (mr.getAluno().getCpf().equals(alunoProva.getAluno().getCpf())) {
							find = true;
							retorno = mr;
						}
					}
					
					if (find) {
						if (prova.getAula().getTipoDeAula() == TipoDeAula.Prova_1) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								retorno.setNota1(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Prova_2) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								retorno.setNota2(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Segunda_Chamada_Prova_1) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								retorno.setNota3(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Segunda_Chamada_Prova_2) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								retorno.setNota4(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Prova_Final) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								retorno.setNota5(alunoProva.getNota());
							}
						}
					} else {
						MediaRetorno novo = new MediaRetorno(alunoProva.getAluno(), prova.getAula().getTurma(), 
								0f, 0f, 0f, 0f, 0f);
						
						if (prova.getAula().getTipoDeAula() == TipoDeAula.Prova_1) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								novo.setNota1(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Prova_2) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								novo.setNota2(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Segunda_Chamada_Prova_1) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								novo.setNota3(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Segunda_Chamada_Prova_2) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								novo.setNota4(alunoProva.getNota());
							}
						} else if (prova.getAula().getTipoDeAula() == TipoDeAula.Prova_Final) {
							if (alunoProva != null && alunoProva.getNota() > 0f) {
								novo.setNota5(alunoProva.getNota());
							}
						}
						
						retornos.add(novo);
					}
					
				}
			}
		}
		
		return new ModelAndView("matriculas/minhas_notas", "dados", retornos);
	}
	
	@RequestMapping("/minhasFrequencias/{userId}")
	public ModelAndView minhasFrequencias(@PathVariable("userId") int id) {
		Map<Matricula, List<Frequencia>> dados = new HashMap<Matricula, List<Frequencia>>();
		List<Matricula> matriculas = matriculaService.getMatriculaByAlunoId(id);
		
		if (matriculas != null && matriculas.size() > 0) {
			for (Matricula matricula : matriculas) {
				List<Frequencia> frequencias = frequenciaService.getFrequenciaByTurma(matricula.getTurma(), id);
				if (frequencias != null && frequencias.size() > 0) {
					dados.put(matricula, frequencias);
				}
				
			}
		}
		
		List<FrequenciaRetorno> retornos = new ArrayList<FrequenciaRetorno>();
		
		for (Matricula matri : dados.keySet()) {
			int count = 0;
			for (Frequencia frequencia : dados.get(matri)) {
				for (AlunoFrequencia alunoFrequencia : frequencia.getFrequencias()) {
					if (!alunoFrequencia.isPresente()) {
						count++;
					}
				}
			}
			
			FrequenciaRetorno retorno = 
					new FrequenciaRetorno(matri.getAluno(), matri.getTurma(), count);
			retornos.add(retorno);
		}
		
		return new ModelAndView("matriculas/minhas_frequencias", "dados", retornos);
	}
	
	@RequestMapping("/relatorioAluno/{userId}")
	public ModelAndView relatorioAluno(@PathVariable("userId") int id) {
		Map<Matricula, List<Frequencia>> dados = new HashMap<Matricula, List<Frequencia>>();
		List<Matricula> matriculas = matriculaService.getMatriculaByAlunoId(id);
		
		if (matriculas != null && matriculas.size() > 0) {
			for (Matricula matricula : matriculas) {
				List<Frequencia> frequencias = frequenciaService.getFrequenciaByTurma(matricula.getTurma(), id);
				if (frequencias != null && frequencias.size() > 0) {
					dados.put(matricula, frequencias);
				}
				
			}
		}
		
		List<FrequenciaRetorno> retornos = new ArrayList<FrequenciaRetorno>();
		
		for (Matricula matri : dados.keySet()) {
			int count = 0;
			for (Frequencia frequencia : dados.get(matri)) {
				for (AlunoFrequencia alunoFrequencia : frequencia.getFrequencias()) {
					if (!alunoFrequencia.isPresente()) {
						count++;
					}
				}
			}
			
			FrequenciaRetorno retorno = 
					new FrequenciaRetorno(matri.getAluno(), matri.getTurma(), count);
			retornos.add(retorno);
		}
		
		Map<Matricula, Map<Integer, AlunoProva>> dados2 = new HashMap<Matricula, Map<Integer, AlunoProva>>();
		Aluno aluno = alunoService.getAlunoById(id);
		
		if (matriculas != null && matriculas.size() > 0) {
			for (Matricula matricula : matriculas) {
				AlunoProva prova1 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Prova_1, aluno);
				
				AlunoProva prova2 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Prova_2, aluno);
				
				AlunoProva segundaChamadaProva1 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Segunda_Chamada_Prova_1, aluno);
				
				AlunoProva segundaChamadaProva2 = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Segunda_Chamada_Prova_2, aluno);
				
				AlunoProva provaFinal = provaService.getProvaByTurmaAndTypeAndStudent(
						matricula.getTurma(), TipoDeAula.Prova_Final, aluno);
				
				Map<Integer, AlunoProva> provas = new HashMap<>();
				provas.put(1, prova1);
				provas.put(2, prova2);
				provas.put(3, segundaChamadaProva1);
				provas.put(4, segundaChamadaProva2);
				provas.put(5, provaFinal);
				
				dados2.put(matricula, provas);
			}
		}
		
		List<MediaRetorno> retornos2 = new ArrayList<MediaRetorno>();
		
		for (Matricula matri : dados.keySet()) {
			float nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0, nota5 = 0;
			MediaRetorno retorno = new MediaRetorno(matri.getAluno(), matri.getTurma(), 
					nota1, nota2, nota3, nota4, nota5);
			Map<Integer, AlunoProva> provas = dados2.get(matri);
			
			if (provas.get(1) != null && provas.get(1).getNota() > 0f) {
				retorno.setNota1(provas.get(1).getNota());
			}
			
			if (provas.get(2) != null && provas.get(2).getNota() > 0f) {
				retorno.setNota2(provas.get(2).getNota());
			}
			
			if (provas.get(3) != null && provas.get(3).getNota() > 0f) {
				retorno.setNota3(provas.get(3).getNota());
			}
			
			if (provas.get(4) != null && provas.get(4).getNota() > 0f) {
				retorno.setNota4(provas.get(4).getNota());
			}
			
			if (provas.get(5) != null && provas.get(5).getNota() > 0f) {
				retorno.setNota5(provas.get(5).getNota());
			}
			
			retornos2.add(retorno);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("prova", retornos2);
		map.put("frequencia", retornos);
		
		return new ModelAndView("relatorio/relatorio_aluno", map);
		
	}

}
