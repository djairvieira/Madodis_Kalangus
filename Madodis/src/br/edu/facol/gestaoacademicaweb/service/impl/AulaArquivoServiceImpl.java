package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.AulaArquivoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.AulaArquivo;
import br.edu.facol.gestaoacademicaweb.service.AulaArquivoService;

@Service("aulaArquivoService")
public class AulaArquivoServiceImpl implements AulaArquivoService {

	@Autowired
	private AulaArquivoDAO aulaArquivoDAO;
	
	@Transactional
	@Override
	public AulaArquivo findById(int id) {
		return aulaArquivoDAO.findById(id);
	}

	@Transactional
	@Override
	public List<AulaArquivo> findAll() {
		return aulaArquivoDAO.findAll();
	}

	@Transactional
	@Override
	public List<AulaArquivo> findAllByAulaId(int id) {
		return aulaArquivoDAO.findAllByAulaId(id);
	}

	@Transactional
	@Override
	public void saveDocument(AulaArquivo document) {
		aulaArquivoDAO.save(document);
		
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		aulaArquivoDAO.deleteById(id);
	}

}
