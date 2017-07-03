package br.edu.facol.gestaoacademicaweb.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	@RequestMapping("/home")
	public String inicial() {
		return "login";
	}
	
	@RequestMapping("/inicio")
	public ModelAndView inicio(HttpServletRequest request, ModelMap map) {
		return new ModelAndView("index", "user", request.getSession().getAttribute("user"));
	}
	
	@RequestMapping("/sair")
	public String sair(HttpServletRequest request, ModelMap map) {
		return "login";
	}
	
	@RequestMapping("/sobre")
	public String sobre(HttpServletRequest request, ModelMap map) {
		return "sobrepage";
	}
	
	@RequestMapping("/recursos")
	public String recursos(HttpServletRequest request, ModelMap map) {
		return "recursos";
	}

}
