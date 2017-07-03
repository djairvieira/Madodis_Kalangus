package br.edu.facol.gestaoacademicaweb.dao;

import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;

public interface CoordenadorDAO extends BaseDao<Coordenador> {
		
	public Coordenador autenticar(String matricula, String senha);
	public Coordenador autenticar(String matricula, String cpf, String rg);
	public Coordenador getByEmail(String email);

}
