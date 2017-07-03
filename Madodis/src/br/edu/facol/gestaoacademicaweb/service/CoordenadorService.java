package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

public interface CoordenadorService {
	
	public void adicionarCoordenador(Coordenador coordenador);
	public void removerCoordenador(int id);
	public void atualizarCoordenador(Coordenador aluno);
	public List<Coordenador> listarCoordenadores();
	public List<Coordenador> listarCoordenadores(Instituicao instituicao);
	public Coordenador getCoordenadorById(int id);
	public Coordenador autenticarCoordenador(String matricula, String senha);
	public Coordenador autenticarCoordenador(String matricula, String cpf, String rg);
	public Coordenador getByEmail(String email);
	public List<Coordenador> getByEmail(int id, String email);
	public List<Coordenador> getByCpf(int id, String cpf);
	public List<Coordenador> getByRg(int id, String rg);
	public List<Coordenador> getByMatricula(int id, String matricula);
	public List<Coordenador> getByTitulo(int id, String titulo);
	public List<Coordenador> getByCtpsNumero(int id, String ctpsNumero);
}
