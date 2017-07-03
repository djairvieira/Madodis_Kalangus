package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.ProfessorDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorDAO;
	
	@Transactional
	public void adicionarProfessor(Professor professor) {
		professorDAO.salvar(professor);
	}

	@Transactional
	public void removerProfessor(int id) {
		professorDAO.remover(id);
	}

	@Transactional
	public void atualizarProfessor(Professor professor) {
		professorDAO.atualizar(professor);
	}

	@Override
	@Transactional
	public List<Professor> listarProfessors() {
		return professorDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<Professor> listarProfessors(Instituicao instituicao) {
		return professorDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public Professor getProfessorById(int id) {
		return professorDAO.getById(id);
	}
	
	@Override
	@Transactional
	public Professor autenticarProfessor(String matricula, String senha) {
		return professorDAO.autenticar(matricula, senha);
	}
	
	@Override
	@Transactional
	public Professor autenticarProfessor(String matricula, String cpf, String rg) {
		return professorDAO.autenticar(matricula, cpf, rg);
	}
	
	@Override
	@Transactional
	public Professor getByEmail(String email) {
		return professorDAO.getByEmail(email);
	}
	
	@Transactional
	@Override
	public List<Professor> getByEmail(int id, String email) {
		return professorDAO.getByFieldName(id, "email", email);
	}

	@Transactional
	@Override
	public List<Professor> getByCpf(int id, String cpf) {
		return professorDAO.getByFieldName(id, "cpf", cpf);
	}

	@Transactional
	@Override
	public List<Professor> getByRg(int id, String rg) {
		return professorDAO.getByFieldName(id, "rg", rg);
	}

	@Transactional
	@Override
	public List<Professor> getByMatricula(int id, String matricula) {
		return professorDAO.getByFieldName(id, "matricula", matricula);
	}

	@Transactional
	@Override
	public List<Professor> getByTitulo(int id, String titulo) {
		return professorDAO.getByFieldName(id, "tituloEleitoral", titulo);
	}
	
	@Transactional
	@Override
	public List<Professor> getByCtpsNumero(int id, String ctpsNumero) {
		return professorDAO.getByFieldName(id, "ctpsNumero", ctpsNumero);
	}

}
