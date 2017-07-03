package br.edu.facol.gestaoacademicaweb.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Administrador;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;
import br.edu.facol.gestaoacademicaweb.service.MailService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Resource(name = "alunoService")
	private AlunoService alunoService;
	
	@Resource(name = "coordenadorService")
	private CoordenadorService coordenadorService;
	
	@Resource(name = "professorService")
	private ProfessorService professorService;
	
	@Resource(name = "secretariaService")
	private SecretariaService secretariaService;
	
	@Resource(name = "mailService")
	private MailService mailService;
	
	@Resource(name = "instituicaoService")
	private InstituicaoService instituicaoService;

	@RequestMapping("/login/entrar")
	public ModelAndView entrar(Model model, @RequestParam(name="matricula") String matricula, 
						 @RequestParam(name="senha") String senha) {
		
		Aluno aluno = alunoService.autenticarAluno(matricula, senha);
		if (aluno != null) {
			model.addAttribute("user", aluno);
			return new ModelAndView("index", "user", aluno);
		}
		
		Coordenador coordenador = coordenadorService.autenticarCoordenador(matricula, senha);
		if (coordenador != null) {
			model.addAttribute("user", coordenador);
			return new ModelAndView("index", "user", coordenador);
		}
		
		Professor professor = professorService.autenticarProfessor(matricula, senha);
		if (professor != null) {
			model.addAttribute("user", professor);
			return new ModelAndView("index", "user", professor);
		}
		
		Secretaria secretaria = secretariaService.autenticarSecretaria(matricula, senha);
		if (secretaria != null) {
			model.addAttribute("user", secretaria);
			return new ModelAndView("index", "user", secretaria);
		}
		
		if (matricula.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			Administrador administrador = Administrador.getInstance();
			
			List<Instituicao> list = instituicaoService.listarInstituicoes();
			
			if (list != null && list.size() > 0) {
				administrador.setInstituicao(list.get(0));
			}
			
			model.addAttribute("user", administrador);
			return new ModelAndView("index", "user", administrador);
		}
		
		return new ModelAndView("login_error");
	}
	
	@RequestMapping("trocarSenha")
	public String trocarSenha() {
		return "alterar_senha";
	}
	
	@RequestMapping("getSenha")
	public String getSenha() {
		return "pegar_senha";
	}
	
	@RequestMapping("/login/mudarSenha")
	public ModelAndView mudarSenha(Model model, @RequestParam(name="matricula") String matricula, 
						 @RequestParam(name="oldSenha") String oldSenha, 
						 @RequestParam(name="newSenha") String newSenha) {
		
		Aluno aluno = alunoService.autenticarAluno(matricula, oldSenha);
		if (aluno != null) {
			aluno.setSenha(newSenha);
			alunoService.atualizarAluno(aluno);
			return new ModelAndView("login_return", "mensagem", "Senha alterada com sucesso.");
		}
		
		Coordenador coordenador = coordenadorService.autenticarCoordenador(matricula, oldSenha);
		if (coordenador != null) {
			coordenador.setSenha(newSenha);
			coordenadorService.atualizarCoordenador(coordenador);
			return new ModelAndView("login_return", "mensagem", "Senha alterada com sucesso.");
		}
		
		Professor professor = professorService.autenticarProfessor(matricula, oldSenha);
		if (professor != null) {
			professor.setSenha(newSenha);
			professorService.atualizarProfessor(professor);
			return new ModelAndView("login_return", "mensagem", "Senha alterada com sucesso.");
		}
		
		Secretaria secretaria = secretariaService.autenticarSecretaria(matricula, oldSenha);
		if (secretaria != null) {
			secretaria.setSenha(newSenha);
			secretariaService.atualizarSecretaria(secretaria);
			return new ModelAndView("login_return", "mensagem", "Senha alterada com sucesso.");
		}
		
		return new ModelAndView("login_return", "mensagem", "Usuario n�o encontrado.");
	}
	
	@RequestMapping("/login/email")
	public ModelAndView email(Model model, @RequestParam(name="email") String email) {
		
		Aluno aluno = alunoService.getByEmail(email);
		if (aluno != null) {
			mailService.sendMail(aluno.getNome(), aluno.getEmail(), aluno.getSenha());
			return new ModelAndView("login_return", "mensagem", "Sua senha foi enviada para o email: " + aluno.getEmail());
		}
		
		Coordenador coordenador = coordenadorService.getByEmail(email);
		if (coordenador != null) {
			mailService.sendMail(coordenador.getNome(), coordenador.getEmail(), coordenador.getSenha());
			return new ModelAndView("login_return", "mensagem", "Sua senha foi enviada para o email: " + coordenador.getEmail());
		}
		
		Professor professor = professorService.getByEmail(email);
		if (professor != null) {
			mailService.sendMail(professor.getNome(), professor.getEmail(), professor.getSenha());
			return new ModelAndView("login_return", "mensagem", "Sua senha foi enviada para o email: " + professor.getEmail());
		}
		
		Secretaria secretaria = secretariaService.getByEmail(email);
		if (secretaria != null) {
			mailService.sendMail(secretaria.getNome(), secretaria.getEmail(), secretaria.getSenha());
			return new ModelAndView("login_return", "mensagem", "Sua senha foi enviada para o email: " + secretaria.getEmail());
		}
		
		return new ModelAndView("login_return", "mensagem", "Usuario n�o encontrado.");
	}

}
