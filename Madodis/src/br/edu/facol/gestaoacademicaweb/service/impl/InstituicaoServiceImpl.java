package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.InstituicaoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;

@Service("instituicaoService")
public class InstituicaoServiceImpl implements InstituicaoService {

	@Autowired
	private InstituicaoDAO instituicaoDAO;
	
	@Transactional
	public void adicionarInstituicao(Instituicao instituicao) {
		instituicaoDAO.salvar(instituicao);
	}

	@Transactional
	public void removerInstituicao(int id) {
		instituicaoDAO.remover(id);
	}

	@Transactional
	public void atualizarInstituicao(Instituicao instituicao) {
		instituicaoDAO.atualizar(instituicao);
	}

	@Override
	@Transactional
	public List<Instituicao> listarInstituicoes() {
		return instituicaoDAO.listarTodos();
	}

	@Override
	@Transactional
	public Instituicao getInstituicaoById(int id) {
		return instituicaoDAO.getById(id);
	}

}
