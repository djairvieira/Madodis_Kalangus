package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Frequencia;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface FrequenciaDAO extends BaseDao<Frequencia> {
	
	public Frequencia getByAula(Aula aula);
	
	public Frequencia salvarComRetorno(Frequencia frequencia);
	
	public List<Frequencia> getByTurma(Turma turma, int alunoId);
	
}
