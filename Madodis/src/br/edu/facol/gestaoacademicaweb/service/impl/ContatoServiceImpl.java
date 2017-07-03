package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.ContatoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Contato;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.ContatoService;

@Service("contatoService")
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoDAO contatoDAO;
	
	@Transactional
	public void adicionarContato(Contato contato) {
		contatoDAO.salvar(contato);
	}

	@Transactional
	public void removerContato(int id) {
		contatoDAO.remover(id);
	}

	@Transactional
	public void atualizarContato(Contato contato) {
		contatoDAO.atualizar(contato);
	}

	@Override
	@Transactional
	public List<Contato> listarContatos() {
		return contatoDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<Contato> listarContatos(Instituicao instituicao) {
		return contatoDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public Contato getContatoById(int id) {
		return contatoDAO.getById(id);
	}

}
