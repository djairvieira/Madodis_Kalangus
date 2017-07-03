package br.edu.facol.gestaoacademicaweb.pojo;

public class FrequenciaRetorno {

	private Aluno aluno;
	private Turma turma;
	private int faltas;
	
	public FrequenciaRetorno(Aluno aluno, Turma turma, int faltas) {
		this.aluno = aluno;
		this.turma = turma;
		this.faltas = faltas;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

}
