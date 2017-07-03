package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.CursoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.TipoEnsino;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoDAO cursoDAO;
	
	@Transactional
	public void adicionarCurso(Curso curso) { 
		cursoDAO.salvar(curso);
	}

	@Transactional
	public void removerCurso(int id) {
		cursoDAO.remover(id);
	}

	@Transactional
	public void atualizarCurso(Curso curso) {
		cursoDAO.atualizar(curso);
	}

	@Transactional
	public List<Curso> listaCursos() {
		return cursoDAO.listarTodos();
	}
	
	@Transactional
	public List<Curso> listaCursos(Instituicao instituicao) {
		return cursoDAO.listarTodos(instituicao);
	}
	
	@Transactional
	public List<Curso> listaCursos(Instituicao instituicao, TipoEnsino tipo) {
		return cursoDAO.listarTodos(instituicao, tipo);
	}

	@Transactional
	public Curso getCursoById(int id) {
		return cursoDAO.getById(id);
	}

}
