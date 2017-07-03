package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.ProvaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.AlunoProva;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Prova;
import br.edu.facol.gestaoacademicaweb.pojo.TipoDeAula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.ProvaService;

@Service("provaService")
public class ProvaServiceImpl implements ProvaService {

	@Autowired
	private ProvaDAO provaDAO;
	
	@Transactional
	public void adicionarProva(Prova prova) {
		provaDAO.salvar(prova);
	}
	
	@Transactional
	public Prova adicionarProvaComRetorno(Prova prova) {
		return provaDAO.salvarComRetorno(prova);
	}

	@Transactional
	public void removerProva(int id) {
		provaDAO.remover(id);
	}

	@Transactional
	public void atualizarProva(Prova prova) {
		provaDAO.atualizar(prova);
	}

	@Override
	@Transactional
	public List<Prova> listarProvas() {
		return provaDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<Prova> listarProvas(Instituicao instituicao) {
		return provaDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public Prova getProvaById(int id) {
		return provaDAO.getById(id);
	}
	
	@Override
	@Transactional
	public Prova getProvaByAula(Aula aula) {
		return provaDAO.getByAula(aula);
	}
	
	@Override
	@Transactional
	public Set<Prova> getProvaByTurma(Turma turma, int alunoId) {
		return provaDAO.getByTurma(turma, alunoId);
	}
	
	@Override
	@Transactional
	public AlunoProva getProvaByTurmaAndTypeAndStudent(Turma turma, TipoDeAula tipo, Aluno aluno) {
		return provaDAO.getProvaByTurmaAndTypeAndStudent(turma, tipo, aluno);
	}

}
