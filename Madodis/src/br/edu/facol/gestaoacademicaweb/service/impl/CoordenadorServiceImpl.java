package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.CoordenadorDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;

@Service("coordenadorService")
public class CoordenadorServiceImpl implements CoordenadorService {

	@Autowired
	private CoordenadorDAO coordenadorDAO;
	
	@Transactional
	public void adicionarCoordenador(Coordenador coordenador) {
		coordenadorDAO.salvar(coordenador);
	}

	@Transactional
	public void removerCoordenador(int id) {
		coordenadorDAO.remover(id);
	}

	@Transactional
	public void atualizarCoordenador(Coordenador coordenador) {
		coordenadorDAO.atualizar(coordenador);
	}

	@Override
	@Transactional
	public List<Coordenador> listarCoordenadores() {
		return coordenadorDAO.listarTodos();
	}
	
	@Override
	@Transactional
	public List<Coordenador> listarCoordenadores(Instituicao instituicao) {
		return coordenadorDAO.listarTodos(instituicao);
	}

	@Override
	@Transactional
	public Coordenador getCoordenadorById(int id) {
		return coordenadorDAO.getById(id);
	}
	
	@Override
	@Transactional
	public Coordenador autenticarCoordenador(String matricula, String senha) {
		return coordenadorDAO.autenticar(matricula, senha);
	}
	
	@Override
	@Transactional
	public Coordenador autenticarCoordenador(String matricula, String cpf, String rg) {
		return coordenadorDAO.autenticar(matricula, cpf, rg);
	}
	
	@Override
	@Transactional
	public Coordenador getByEmail(String email) {
		return coordenadorDAO.getByEmail(email);
	}
	
	@Transactional
	@Override
	public List<Coordenador> getByEmail(int id, String email) {
		return coordenadorDAO.getByFieldName(id, "email", email);
	}

	@Transactional
	@Override
	public List<Coordenador> getByCpf(int id, String cpf) {
		return coordenadorDAO.getByFieldName(id, "cpf", cpf);
	}

	@Transactional
	@Override
	public List<Coordenador> getByRg(int id, String rg) {
		return coordenadorDAO.getByFieldName(id, "rg", rg);
	}

	@Transactional
	@Override
	public List<Coordenador> getByMatricula(int id, String matricula) {
		return coordenadorDAO.getByFieldName(id, "matricula", matricula);
	}

	@Transactional
	@Override
	public List<Coordenador> getByTitulo(int id, String titulo) {
		return coordenadorDAO.getByFieldName(id, "tituloEleitoral", titulo);
	}
	
	@Transactional
	@Override
	public List<Coordenador> getByCtpsNumero(int id, String ctpsNumero) {
		return coordenadorDAO.getByFieldName(id, "ctpsNumero", ctpsNumero);
	}

}
