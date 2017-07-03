package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface MatriculaDAO extends BaseDao<Matricula> {

	public List<Matricula> getByTurma(Turma turma);
	public List<Matricula> getByAlunoId(int alunoId);
	public List<Matricula> getByProfessorId(int professorId);
	public List<Matricula> getByTurma(Turma turma, Aluno aluno);
}
