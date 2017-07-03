package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.SecretariaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;

@Service("secretariaService")
public class SecretariaServiceImpl implements SecretariaService {

	@Autowired
	private SecretariaDAO secretariaDAO;
	
	@Transactional
	public void adicionarSecretaria(Secretaria secretaria) {
		secretariaDAO.salvar(secretaria);
	}

	@Transactional
	public void removerSecretaria(int id) {
		secretariaDAO.remover(id);
	}

	@Transactional
	public void atualizarSecretaria(Secretaria secretaria) {
		secretariaDAO.atualizar(secretaria);
	}

	@Override
	@Transactional
	public List<Secretaria> listarSecretarias() {
		return secretariaDAO.listarTodos();
	}

	@Override
	@Transactional
	public Secretaria getSecretariaById(int id) {
		return secretariaDAO.getById(id);
	}
	
	@Override
	@Transactional
	public Secretaria autenticarSecretaria(String matricula, String senha) {
		return secretariaDAO.autenticar(matricula, senha);
	}
	
	@Override
	@Transactional
	public Secretaria autenticarSecretaria(String matricula, String cpf, String rg) {
		return secretariaDAO.autenticar(matricula, cpf, rg);
	}
	
	@Override
	@Transactional
	public Secretaria getByEmail(String email) {
		return secretariaDAO.getByEmail(email);
	}
	
	@Transactional
	@Override
	public List<Secretaria> getByEmail(int id, String email) {
		return secretariaDAO.getByFieldName(id, "email", email);
	}

	@Transactional
	@Override
	public List<Secretaria> getByCpf(int id, String cpf) {
		return secretariaDAO.getByFieldName(id, "cpf", cpf);
	}

	@Transactional
	@Override
	public List<Secretaria> getByRg(int id, String rg) {
		return secretariaDAO.getByFieldName(id, "rg", rg);
	}

	@Transactional
	@Override
	public List<Secretaria> getByMatricula(int id, String matricula) {
		return secretariaDAO.getByFieldName(id, "matricula", matricula);
	}

	@Transactional
	@Override
	public List<Secretaria> getByTitulo(int id, String titulo) {
		return secretariaDAO.getByFieldName(id, "tituloEleitoral", titulo);
	}
	
	@Transactional
	@Override
	public List<Secretaria> getByCtpsNumero(int id, String ctpsNumero) {
		return secretariaDAO.getByFieldName(id, "ctpsNumero", ctpsNumero);
	}

}
