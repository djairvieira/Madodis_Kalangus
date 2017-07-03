package br.edu.facol.gestaoacademicaweb.dao;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.DiarioDeClasse;

public interface DiarioDeClasseDAO extends BaseDao<DiarioDeClasse> {
	
	public DiarioDeClasse getByAula(Aula aula);
	
	public DiarioDeClasse salvarComRetorno(DiarioDeClasse diarioDeClasse);
	
}
