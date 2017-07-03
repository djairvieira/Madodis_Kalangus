package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.DiarioDeClasseDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.DiarioDeClasse;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.DiarioDeClasseService;

@Service("diarioDeClasseService")
public class DiarioDeClasseServiceImpl implements DiarioDeClasseService {

	@Autowired
	private DiarioDeClasseDAO diarioDeClasseDAO;
	
	@Transactional
	public void adicionarDiarioDeClasse(DiarioDeClasse diarioDeClasse) {
		diarioDeClasseDAO.salvar(diarioDeClasse);
	}
	
	@Transactional
	public DiarioDeClasse adicionarDiarioDeClasseComRetorno(DiarioDeClasse diarioDeClasse) {
		return diarioDeClasseDAO.salvarComRetorno(diarioDeClasse);
	}

	@Transactional
	public void removerDiarioDeClasse(int id) {
		diarioDeClasseDAO.remover(id);
	}

	@Transactional
	public void atualizarDiarioDeClasse(DiarioDeClasse diarioDeClasse) {
		diarioDeClasseDAO.atualizar(diarioDeClasse);
	}

	@Override
	@Transactional
	public List<DiarioDeClasse> listarDiarioDeClasses() {
		return diarioDeClasseDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<DiarioDeClasse> listarDiarioDeClasses(Instituicao instituicao) {
		return diarioDeClasseDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public DiarioDeClasse getDiarioDeClasseById(int id) {
		return diarioDeClasseDAO.getById(id);
	}
	
	@Override
	@Transactional
	public DiarioDeClasse getDiarioDeClasseByAula(Aula aula) {
		return diarioDeClasseDAO.getByAula(aula);
	}

}
