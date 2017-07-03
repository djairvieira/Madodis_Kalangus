package br.edu.facol.gestaoacademicaweb.service;

public interface MailService {
	
	public void sendMail(String nome, String email, String senha);
	
	public void sendMail(String nome, String email, String message, String telefone, String ddd);
	
}
