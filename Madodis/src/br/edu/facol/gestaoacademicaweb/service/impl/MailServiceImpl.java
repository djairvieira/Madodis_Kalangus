package br.edu.facol.gestaoacademicaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import br.edu.facol.gestaoacademicaweb.service.MailService;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	private MailSender mailSender;
	
	@Override
	public void sendMail(String nome, String email, String senha) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("suportekalangus@gmail.com");
		message.setTo(email);
		message.setSubject("Senha Madodis");
		message.setText("Ola " + nome + ", Tudo bem? \n "
				+ "Estamos enviando para voce a sua senha: " + senha + ". \n "
				+ "Equipe Madodis.");
		mailSender.send(message);
	}
	
	@Override
	public void sendMail(String nome, String email, String mensagem, String telefone, String ddd) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(email);
		message.setTo("suportekalangus@gmail.com");
		message.setSubject("Contato - " + nome + " - " + ddd + " - " + telefone);
		message.setText(mensagem + "\n\n"
				+ "Nome: " + nome + "\n"
				+ "E-mail: " + email + "\n"
				+ "Telefone: " + ddd + " - " + telefone);
		mailSender.send(message);
	}

}
