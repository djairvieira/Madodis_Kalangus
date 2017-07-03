package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.DiarioDeClasse;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public interface DiarioDeClasseService {
	
	public void adicionarDiarioDeClasse(DiarioDeClasse diarioDeClasse);
	public DiarioDeClasse adicionarDiarioDeClasseComRetorno(DiarioDeClasse diarioDeClasse);
	public void removerDiarioDeClasse(int id);
	public void atualizarDiarioDeClasse(DiarioDeClasse diarioDeClasse);
	public List<DiarioDeClasse> listarDiarioDeClasses();
	public List<DiarioDeClasse> listarDiarioDeClasses(Instituicao instituicao);
	public DiarioDeClasse getDiarioDeClasseById(int id);
	public DiarioDeClasse getDiarioDeClasseByAula(Aula aula);
	
}
