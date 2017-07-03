package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Contato;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public interface ContatoService {
	
	public void adicionarContato(Contato contato);
	public void removerContato(int id);
	public void atualizarContato(Contato contato);
	public List<Contato> listarContatos();
	public List<Contato> listarContatos(Instituicao instituicao);
	public Contato getContatoById(int id);
	
}
