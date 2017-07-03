package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public interface AlunoService {
	
	public void adicionarAluno(Aluno aluno);
	public void removerAluno(int id);
	public void atualizarAluno(Aluno aluno);
	public List<Aluno> listarAlunos();
	public List<Aluno> listarAlunos(Instituicao instituicao);
	public Aluno getAlunoById(int id);
	public Aluno autenticarAluno(String matricula, String senha);
	public Aluno autenticarAluno(String matricula, String cpf, String rg);
	public Aluno getByEmail(String email);
	public List<Aluno> getByEmail(int id, String email);
	public List<Aluno> getByCpf(int id, String cpf);
	public List<Aluno> getByRg(int id, String rg);
	public List<Aluno> getByMatricula(int id, String matricula);
	public List<Aluno> getByTitulo(int id, String titulo);
}
