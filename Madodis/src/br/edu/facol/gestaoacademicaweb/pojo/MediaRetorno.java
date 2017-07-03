package br.edu.facol.gestaoacademicaweb.pojo;

public class MediaRetorno {

	private Aluno aluno;
	private Turma turma;
	private float nota1;
	private float nota2;
	private float nota3;
	private float nota4;
	private float nota5;
	
	
	public MediaRetorno(Aluno aluno, Turma turma, float nota1, float nota2, float nota3, float nota4, float nota5) {
		super();
		this.aluno = aluno;
		this.turma = turma;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.nota5 = nota5;
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
	
	public float getNota1() {
		return nota1;
	}
	
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	
	public float getNota2() {
		return nota2;
	}
	
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	
	public float getNota3() {
		return nota3;
	}
	
	public void setNota3(float nota3) {
		this.nota3 = nota3;
	}
	
	public float getNota4() {
		return nota4;
	}
	
	public void setNota4(float nota4) {
		this.nota4 = nota4;
	}
	
	public float getNota5() {
		return nota5;
	}
	
	public void setNota5(float nota5) {
		this.nota5 = nota5;
	}

	public float getMedia() {
		if (getNota5() > 0) {
			return getNota5();
		} else if (getNota1() > 0 && getNota2() > 0) {
			return (getNota1() + getNota2()) / 2;
		} else if (getNota1() > 0 && getNota2() == 0 && getNota4() > 0) {
			return (getNota1() + getNota4()) / 2;
		} else if (getNota1() == 0 && getNota2() > 0 && getNota3() > 0) {
			return (getNota2() + getNota3()) / 2;
		} else if (getNota1() == 0 && getNota2() == 0 && getNota4() > 0 && getNota3() > 0) {
			return (getNota3() + getNota4()) / 2;
		}
		
		return 0f;
	}

	public String getSituacao() {
		float media = getMedia();
		
		if (media >= 7f) {
			return "Aprovado";
		} else {
			return "Reprovado";
		}
		
	}

}
