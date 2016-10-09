package br.com.mario.abaco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Sistema;
import br.com.mario.abaco.repository.SistemaRepository;

@Controller
@RequestMapping("/sistema")
public class SistemaController {
	
	@Autowired
	private SistemaRepository repo;
	
	@GetMapping
	public ModelAndView pesquisar(){
		List<Sistema> sistemas = repo.findAll();
		ModelAndView mv = new ModelAndView("sistemas");
		mv.addObject("sistemas",sistemas);
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView nova(){
		ModelAndView mv = new ModelAndView("novo-sistema");
		mv.addObject(new Sistema());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvar(@Validated Sistema sistema, Errors err, RedirectAttributes attributes){
		String retorno = "novo-sistema";
		
		if(!err.hasErrors()){		
			repo.save(sistema);
			retorno="redirect:/sistema/novo";
		}
		
		attributes.addFlashAttribute("mensagem","Sistema salvo com sucesso!");
		return retorno;
	}
	

}