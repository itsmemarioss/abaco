package br.com.mario.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

		conf = new Configuracao();
		mv.addObject("conf", conf);

		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(Configuracao configuracao) {
		ModelAndView mv = new ModelAndView(PAG);
		configuracao.setId(1l);
		repo.save(configuracao);
		mv.addObject("mensagem", "Configuração salva com sucesso!");
		return mv;
	}

}
