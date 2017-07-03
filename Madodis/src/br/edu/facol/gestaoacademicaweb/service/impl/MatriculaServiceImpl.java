package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.MatriculaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Matricula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.MatriculaService;

@Service("matriculaService")
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaDAO matriculaDAO;
	
	@Transactional
	public void adicionarMatricula(Matricula matricula) { 
		matriculaDAO.salvar(matricula);
	}

	@Transactional
	public void removerMatricula(int id) {
		matriculaDAO.remover(id);
	}

	@Transactional
	public void atualizarMatricula(Matricula matricula) {
		matriculaDAO.atualizar(matricula);
	}

	@Transactional
	public List<Matricula> listaMatriculas() {
		return matriculaDAO.listarTodos();
	}
	
	@Transactional
	public List<Matricula> listaMatriculas(Instituicao instituicao) {
		return matriculaDAO.listarTodos(instituicao);
	}

	@Transactional
	public Matricula getMatriculaById(int id) {
		return matriculaDAO.getById(id);
	}
	
	@Transactional
	public List<Matricula> getMatriculaByTurma(Turma turma) {
		return matriculaDAO.getByTurma(turma);
	}
	
	@Transactional
	public List<Matricula> getMatriculaByTurma(Turma turma, Aluno aluno) {
		return matriculaDAO.getByTurma(turma, aluno);
	}
	
	@Transactional
	public List<Matricula> getMatriculaByAlunoId(int alunoId) {
		return matriculaDAO.getByAlunoId(alunoId);
	}
	
	@Transactional
	public List<Matricula> getMatriculaByProfessorId(int professorId) {
		return matriculaDAO.getByProfessorId(professorId);
	}

}
