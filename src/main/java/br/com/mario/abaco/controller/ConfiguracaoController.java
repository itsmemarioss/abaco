package br.com.mario.abaco.controller;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Configuracao;
import br.com.mario.abaco.repository.ConfiguracaoRepository;

@Controller
@RequestMapping("/configuracao")
public class ConfiguracaoController {

	private final String PAG = "configuracao";
	private Configuracao conf;

	@Autowired
	private ConfiguracaoRepository repo;

	@GetMapping
	public ModelAndView pagina() {
		ModelAndView mv = new ModelAndView(PAG);

		try {
			conf = repo.getOne(1l);
		} catch (EntityNotFoundException e) {
			conf = new Configuracao();
		}
		mv.addObject("conf", conf);

		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(Configuracao configuracao, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView("redirect:/");
		configuracao.setId(1l);
		repo.save(configuracao);
		attr.addFlashAttribute("mensagem", "Configuração salva com sucesso!");
		return mv;
	}
	
	 @ExceptionHandler(value = Exception.class)
	  public ModelAndView
	  defaultErrorHandler(HttpServletRequest req, Exception e){
	    ModelAndView mav = new ModelAndView(PAG);
	    mav.addObject("conf", new Configuracao());
	    return mav;
	  }

}
