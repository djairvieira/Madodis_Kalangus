package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.AulaArquivo;

public interface AulaArquivoDAO extends BaseDao<AulaArquivo> {
	
	List<AulaArquivo> findAll();
    
	AulaArquivo findById(int id);
     
    void save(AulaArquivo document);
     
    List<AulaArquivo> findAllByAulaId(int aulaId);
     
    void deleteById(int id);
	
}
