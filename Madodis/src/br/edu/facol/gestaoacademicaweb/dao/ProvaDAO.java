package br.edu.facol.gestaoacademicaweb.dao;

import java.util.Set;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.AlunoProva;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Prova;
import br.edu.facol.gestaoacademicaweb.pojo.TipoDeAula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface ProvaDAO extends BaseDao<Prova> {
	
	public Prova getByAula(Aula aula);
	
	public Set<Prova> getByTurma(Turma turma, int alunoId);
	
	public Prova salvarComRetorno(Prova prova);
	
	public AlunoProva getProvaByTurmaAndTypeAndStudent(Turma turma, TipoDeAula tipo, Aluno aluno);
	
}
