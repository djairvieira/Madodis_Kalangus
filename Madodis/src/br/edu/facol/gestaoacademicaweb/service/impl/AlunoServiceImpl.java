package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.AlunoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;

@Service("alunoService")
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void adicionarAluno(Aluno aluno) {
		alunoDAO.salvar(aluno);
	}

	@Transactional
	public void removerAluno(int id) {
		alunoDAO.remover(id);
	}

	@Transactional
	public void atualizarAluno(Aluno aluno) {
		alunoDAO.atualizar(aluno);
	}

	@Override
	@Transactional
	public List<Aluno> listarAlunos() {
		return alunoDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<Aluno> listarAlunos(Instituicao instituicao) {
		return alunoDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public Aluno getAlunoById(int id) {
		return alunoDAO.getById(id);
	}
	
	@Override
	@Transactional
	public Aluno autenticarAluno(String matricula, String senha) {
		return alunoDAO.autenticar(matricula, senha);
	}
	
	@Override
	@Transactional
	public Aluno autenticarAluno(String matricula, String cpf, String rg) {
		return alunoDAO.autenticar(matricula, cpf, rg);
	}
	
	@Override
	@Transactional
	public Aluno getByEmail(String email) {
		return alunoDAO.getByEmail(email);
	}

	@Transactional
	@Override
	public List<Aluno> getByEmail(int id, String email) {
		return alunoDAO.getByFieldName(id, "email", email);
	}

	@Transactional
	@Override
	public List<Aluno> getByCpf(int id, String cpf) {
		return alunoDAO.getByFieldName(id, "cpf", cpf);
	}

	@Transactional
	@Override
	public List<Aluno> getByRg(int id, String rg) {
		return alunoDAO.getByFieldName(id, "rg", rg);
	}

	@Transactional
	@Override
	public List<Aluno> getByMatricula(int id, String matricula) {
		return alunoDAO.getByFieldName(id, "matricula", matricula);
	}

	@Transactional
	@Override
	public List<Aluno> getByTitulo(int id, String titulo) {
		return alunoDAO.getByFieldName(id, "tituloEleitoral", titulo);
	}

}
