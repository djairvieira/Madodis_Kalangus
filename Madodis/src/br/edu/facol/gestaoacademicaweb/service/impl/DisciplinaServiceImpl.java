package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.DisciplinaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;

@Service("disciplinaService")
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	@Transactional
	public void adicionarDisciplina(Disciplina disciplina) {
		disciplinaDAO.salvar(disciplina);
	}

	@Transactional
	public void removerDisciplina(int id) {
		disciplinaDAO.remover(id);
	}

	@Transactional
	public void atualizarDisciplina(Disciplina disciplina) {
		disciplinaDAO.atualizar(disciplina);
	}

	@Override
	@Transactional
	public List<Disciplina> listarDisciplinas() {
		return disciplinaDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<Disciplina> listarDisciplinas(Instituicao instituicao) {
		return disciplinaDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public Disciplina getDisciplinaById(int id) {
		return disciplinaDAO.getById(id);
	}
	
	@Override
	@Transactional
	public List<Disciplina> getDisciplinaByProfessorId(int id) {
		return disciplinaDAO.getByProfessorId(id);
	}

}
