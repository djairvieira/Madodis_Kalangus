package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public interface InstituicaoService {
	
	public void adicionarInstituicao(Instituicao instituicao);
	public void removerInstituicao(int id);
	public void atualizarInstituicao(Instituicao instituicao);
	public List<Instituicao> listarInstituicoes();
	public Instituicao getInstituicaoById(int id);
	
}
