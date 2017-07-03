package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.AulaArquivo;

public interface AulaArquivoService {
	
	public AulaArquivo findById(int id);
	 
	public List<AulaArquivo> findAll();
     
	public List<AulaArquivo> findAllByAulaId(int id);
     
	public void saveDocument(AulaArquivo document);
     
	public void deleteById(int id);
	
}
