package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Frequencia;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface FrequenciaService {
	
	public void adicionarFrequencia(Frequencia frequencia);
	public Frequencia adicionarFrequenciaComRetorno(Frequencia frequencia);
	public void removerFrequencia(int id);
	public void atualizarFrequencia(Frequencia frequencia);
	public List<Frequencia> listarFrequencias();
	public List<Frequencia> listarFrequencias(Instituicao instituicao);
	public Frequencia getFrequenciaById(int id);
	public Frequencia getFrequenciaByAula(Aula aula);
	public List<Frequencia> getFrequenciaByTurma(Turma turma, int alunoId);
	
}
