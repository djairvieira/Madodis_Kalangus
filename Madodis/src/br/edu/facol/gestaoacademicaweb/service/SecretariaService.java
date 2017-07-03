package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;

public interface SecretariaService {
	
	public void adicionarSecretaria(Secretaria aluno);
	public void removerSecretaria(int id);
	public void atualizarSecretaria(Secretaria aluno);
	public List<Secretaria> listarSecretarias();
	public Secretaria getSecretariaById(int id);
	public Secretaria autenticarSecretaria(String matricula, String senha);
	public Secretaria autenticarSecretaria(String matricula, String cpf, String rg);
	public Secretaria getByEmail(String email);
	public List<Secretaria> getByEmail(int id, String email);
	public List<Secretaria> getByCpf(int id, String cpf);
	public List<Secretaria> getByRg(int id, String rg);
	public List<Secretaria> getByMatricula(int id, String matricula);
	public List<Secretaria> getByTitulo(int id, String titulo);
	public List<Secretaria> getByCtpsNumero(int id, String ctpsNumero);
}
