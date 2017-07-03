package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;

public interface ProfessorService {
	
	public void adicionarProfessor(Professor aluno);
	public void removerProfessor(int id);
	public void atualizarProfessor(Professor aluno);
	public List<Professor> listarProfessors();
	public List<Professor> listarProfessors(Instituicao instituicao);
	public Professor getProfessorById(int id);
	public Professor autenticarProfessor(String matricula, String senha);
	public Professor autenticarProfessor(String matricula, String cpf, String rg);
	public Professor getByEmail(String email);
	public List<Professor> getByEmail(int id, String email);
	public List<Professor> getByCpf(int id, String cpf);
	public List<Professor> getByRg(int id, String rg);
	public List<Professor> getByMatricula(int id, String matricula);
	public List<Professor> getByTitulo(int id, String titulo);
	public List<Professor> getByCtpsNumero(int id, String ctpsNumero);
}
