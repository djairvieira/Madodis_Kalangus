package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.TurmaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.TurmaService;

@Service("turmaService")
public class TurmaServiceImpl implements TurmaService{

	@Autowired
	private TurmaDAO turmaDAO;
	
	@Transactional
	public void adicionarTurma(Turma turma) { 
		turmaDAO.salvar(turma);
	}

	@Transactional
	public void removerTurma(int id) {
		turmaDAO.remover(id);
	}

	@Transactional
	public void atualizarTurma(Turma turma) {
		turmaDAO.atualizar(turma);
	}

	@Transactional
	public List<Turma> listaTurmas() {
		return turmaDAO.listarTodos();
	}

	@Transactional
	public List<Turma> listaTurmas(Instituicao instituicao) {
		return turmaDAO.listarTodos(instituicao);
	}

	@Transactional
	public List<Turma> getTurmaByProfessorId(int id) {
		return turmaDAO.getByProfessorId(id);
	}
	
	@Transactional
	public Turma getTurmaById(int id) {
		return turmaDAO.getById(id);
	}

}
