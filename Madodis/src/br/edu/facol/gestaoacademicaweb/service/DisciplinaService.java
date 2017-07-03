package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public interface DisciplinaService {
	
	public void adicionarDisciplina(Disciplina disciplina);
	public void removerDisciplina(int id);
	public void atualizarDisciplina(Disciplina disciplina);
	public List<Disciplina> listarDisciplinas();
	public List<Disciplina> listarDisciplinas(Instituicao instituicao);
	public Disciplina getDisciplinaById(int id);
	public List<Disciplina> getDisciplinaByProfessorId(int id);
	
}
