package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface TurmaService {
	public void adicionarTurma(Turma turma);
	public void removerTurma(int id);
	public void atualizarTurma(Turma turma);
	public List<Turma> listaTurmas();
	public List<Turma> listaTurmas(Instituicao instituicao);
	public Turma getTurmaById(int id);
	public List<Turma> getTurmaByProfessorId(int id);
}
