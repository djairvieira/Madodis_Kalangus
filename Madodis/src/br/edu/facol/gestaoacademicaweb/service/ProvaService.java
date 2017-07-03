package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;
import java.util.Set;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.AlunoProva;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.Prova;
import br.edu.facol.gestaoacademicaweb.pojo.TipoDeAula;
import br.edu.facol.gestaoacademicaweb.pojo.Turma;

public interface ProvaService {
	
	public void adicionarProva(Prova prova);
	public Prova adicionarProvaComRetorno(Prova prova);
	public void removerProva(int id);
	public void atualizarProva(Prova prova);
	public List<Prova> listarProvas();
	public List<Prova> listarProvas(Instituicao instituicao);
	public Prova getProvaById(int id);
	public Prova getProvaByAula(Aula aula);
	public Set<Prova> getProvaByTurma(Turma turma, int alunoId);
	public AlunoProva getProvaByTurmaAndTypeAndStudent(Turma turma, TipoDeAula tipo, Aluno aluno);
	
}
