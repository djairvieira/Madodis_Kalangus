package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;

public interface AulaService {
	
	public void adicionarAula(Aula aula);
	public void removerAula(int id);
	public void atualizarAula(Aula aula);
	public List<Aula> listarAulas();
	public List<Aula> listarAulas(Professor professor);
	public List<Aula> listarAulas(Instituicao instituicao);
	public Aula getAulaById(int id);
	
}
