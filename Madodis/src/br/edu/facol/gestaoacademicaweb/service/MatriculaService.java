package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface MatriculaService {
	public void adicionarMatricula(Matricula matricula);
	public void removerMatricula(int id);
	public void atualizarMatricula(Matricula matricula);
	public List<Matricula> listaMatriculas();
	public List<Matricula> listaMatriculas(Instituicao instituicao);
	public Matricula getMatriculaById(int id);
	public List<Matricula> getMatriculaByTurma(Turma turma);
	public List<Matricula> getMatriculaByTurma(Turma turma, Aluno aluno);
	public List<Matricula> getMatriculaByAlunoId(int alunoId);
	public List<Matricula> getMatriculaByProfessorId(int professorId);
}
