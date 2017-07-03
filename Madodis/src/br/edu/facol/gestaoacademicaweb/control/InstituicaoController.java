package br.edu.facol.gestaoacademicaweb.control;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Estado;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;

@Controller
@SessionAttributes("user")
public class InstituicaoController {

	@Resource(name = "instituicaoService")
	private InstituicaoService instituicaoService;

	@RequestMapping("/listarInstituicoes")
	public String listarInstituicoes(HttpServletRequest request, Map<String, Object> map) {
		map.put("user", request.getSession().getAttribute("user"));
		map.put("instituicao", new Instituicao());
		map.put("instituicaoList", instituicaoService.listarInstituicoes());
		return "instituicao/listar_instituicao";
	}
	
	@RequestMapping("/listarInstituicoesOK")
	public String listarInstituicoesOK(HttpServletRequest request, Map<String, Object> map) {
		map.put("user", request.getSession().getAttribute("user"));
		map.put("instituicao", new Instituicao());
		map.put("instituicaoList", instituicaoService.listarInstituicoes());
		map.put("success", "Instituicao adicionada/alterada com sucesso.");
		return "instituicao/listar_instituicao";
	}

	@RequestMapping("/form_instituicao")
	public String formInstituicoes(Map<String, Object> map) {
		map.put("instituicao", new Instituicao());
		map.put("estados", Estado.values());
		return "instituicao/form_instituicao";
	}

	@RequestMapping("/remover/instituicao/{instituicaoId}")
	public String removerInstituicao(HttpServletRequest request, 
			@PathVariable("instituicaoId") int id, Model model) {
		try {
			instituicaoService.removerInstituicao(id);
		} catch (Exception e) {
			model.addAttribute("error", "Esta instituicao não pode ser removido por estar associada a um outro objeto.");
			model.addAttribute("user", request.getSession().getAttribute("user"));
			model.addAttribute("instituicao", new Instituicao());
			model.addAttribute("instituicaoList", instituicaoService.listarInstituicoes());
		}
		
		return "redirect:/listarInstituicoes";
	}

	@RequestMapping(value = "/update/instituicao/{instituicaoId}", method = RequestMethod.GET)
	public ModelAndView getInstituicao(@PathVariable("instituicaoId") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Instituicao instituicao = instituicaoService.getInstituicaoById(id);
		map.put("instituicao", instituicao);
		map.put("estados", Estado.values());
		return new ModelAndView("instituicao/form_instituicao", map);
	}

	@RequestMapping(value = "/adicionarInstituicao", method = RequestMethod.POST)
	public String adicionarInstituicao(@Valid @ModelAttribute("instituicao") Instituicao instituicao, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.put("estados", Estado.values());
			return "/instituicao/form_instituicao";
		}
		
		model.addAttribute(instituicao.getNomeFantasia());
		model.addAttribute(instituicao.getNomeEmpresarial());
		model.addAttribute(instituicao.getCnpj());
		model.addAttribute(instituicao.getInscricaoEstadual());
		model.addAttribute(instituicao.getEndereco());
		model.addAttribute(instituicao.getTelefone());
		instituicaoService.adicionarInstituicao(instituicao);
		return "redirect:/listarInstituicoesOK";
	}
	
	@RequestMapping(value = "/atualizarInstituicao", method = RequestMethod.POST)
	public String atualizarInstituicao(@Valid @ModelAttribute("instituicao") Instituicao instituicao, 
			BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.put("estados", Estado.values());
			return "/instituicao/form_instituicao";
		}
		
		model.addAttribute(instituicao.getNomeFantasia());
		model.addAttribute(instituicao.getNomeEmpresarial());
		model.addAttribute(instituicao.getCnpj());
		model.addAttribute(instituicao.getInscricaoEstadual());
		model.addAttribute(instituicao.getEndereco());
		model.addAttribute(instituicao.getTelefone());
		instituicaoService.atualizarInstituicao(instituicao);
		return "redirect:/listarInstituicoesOK";
	}
}
