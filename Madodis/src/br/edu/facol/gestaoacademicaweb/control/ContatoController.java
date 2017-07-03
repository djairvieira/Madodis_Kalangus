package br.edu.facol.gestaoacademicaweb.control;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Contato;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.service.ContatoService;
import br.edu.facol.gestaoacademicaweb.service.MailService;

@Controller
public class ContatoController {

	private ContatoService contatoService;
	
	@Resource(name = "mailService")
	private MailService mailService;

	@RequestMapping("/listarContatos")
	public String listarContatos(HttpServletRequest request, Map<String, Object> map) {
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("contatoList", contatoService.listarContatos(secretaria.getInstituicao()));
		} else {
			map.put("contatoList", contatoService.listarContatos());
		}
		
		map.put("contato", new Contato());
		return "contatos/listar_contato";
	}

	@RequestMapping("/form_contatos")
	public String formContatos(HttpServletRequest request, Map<String, Object> map) {
		map.put("contato", new Contato());
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			map.put("instituicao", secretaria.getInstituicao());
		} else {
			map.put("instituicao", null);
		}
		return "contatos/inserir_contato_form";
	}

	@RequestMapping(value = "/adicionarContato", method = RequestMethod.POST)
	public String adicionarContato(HttpServletRequest request, @Valid 
			 @ModelAttribute("contato") Contato contato, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "/contatos/inserir_contato_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			contato.setInstituicao(secretaria.getInstituicao());
		} else {
			contato.setInstituicao(null);
		}
		
		contatoService.adicionarContato(contato);
		mailService.sendMail(contato.getNome(), contato.getEmail(), 
				contato.getMensagem(), contato.getTelefone().getNumero(), contato.getTelefone().getDDD());
		return "redirect:/form_contatos";
	}
	
	@RequestMapping(value = "/atualizarContato", method = RequestMethod.POST)
	public String atualizarContato(HttpServletRequest request, @Valid 
			@ModelAttribute("contato") Contato contato, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "/contatos/inserir_contato_form";
		}
		
		if (request.getSession().getAttribute("user") instanceof Secretaria) {
			Secretaria secretaria = (Secretaria) request.getSession().getAttribute("user");
			contato.setInstituicao(secretaria.getInstituicao());
		} else {
			contato.setInstituicao(null);
		}
		
		contatoService.atualizarContato(contato);
		return "redirect:/form_contatos";
	}
	
	@RequestMapping("/remover/contato/{contatoId}")
	public String removerContato(@PathVariable("contatoId") int id) {
		contatoService.removerContato(id);
		return "redirect:/listarContatos";
	}

	@RequestMapping(value = "/update/contato/{contatoId}", method = RequestMethod.GET)
	public ModelAndView getContato(@PathVariable("contatoId") int id) {
		Contato contato = contatoService.getContatoById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contato", contato);
		map.put("sexos", Sexo.values());
		return new ModelAndView("contatos/inserir_contato_form", map);
	}

	@Autowired
	public void setContatoService(ContatoService contatoService) {
		this.contatoService = contatoService;
	}
	
}
