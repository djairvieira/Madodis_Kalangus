package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.FrequenciaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Frequencia;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;
import br.edu.facol.gestaoacademicaweb.service.FrequenciaService;

@Service("frequenciaService")
public class FrequenciaServiceImpl implements FrequenciaService {

	@Autowired
	private FrequenciaDAO frequenciaDAO;
	
	@Transactional
	public void adicionarFrequencia(Frequencia frequencia) {
		frequenciaDAO.salvar(frequencia);
	}
	
	@Transactional
	public Frequencia adicionarFrequenciaComRetorno(Frequencia frequencia) {
		return frequenciaDAO.salvarComRetorno(frequencia);
	}

	@Transactional
	public void removerFrequencia(int id) {
		frequenciaDAO.remover(id);
	}

	@Transactional
	public void atualizarFrequencia(Frequencia frequencia) {
		frequenciaDAO.atualizar(frequencia);
	}

	@Override
	@Transactional
	public List<Frequencia> listarFrequencias() {
		return frequenciaDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<Frequencia> listarFrequencias(Instituicao instituicao) {
		return frequenciaDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public Frequencia getFrequenciaById(int id) {
		return frequenciaDAO.getById(id);
	}
	
	@Override
	@Transactional
	public Frequencia getFrequenciaByAula(Aula aula) {
		return frequenciaDAO.getByAula(aula);
	}

	@Override
	@Transactional
	public List<Frequencia> getFrequenciaByTurma(Turma turma, int alunoId) {
		return frequenciaDAO.getByTurma(turma, alunoId);
	}

}
