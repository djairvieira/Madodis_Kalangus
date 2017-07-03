package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.pojo.TipoEnsino;

public interface CursoService {
	public void adicionarCurso(Curso curso);
	public void removerCurso(int id);
	public void atualizarCurso(Curso curso);
	public List<Curso> listaCursos();
	public List<Curso> listaCursos(Instituicao instituicao);
	public List<Curso> listaCursos(Instituicao instituicao, TipoEnsino tipo);
	public Curso getCursoById(int id);
}
