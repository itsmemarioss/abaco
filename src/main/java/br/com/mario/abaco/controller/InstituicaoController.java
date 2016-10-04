package br.com.mario.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Instituicao;
import br.com.mario.abaco.repository.InstituicaoRepository;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {

	private Instituicao inst;

	@Autowired
	private InstituicaoRepository repo;

	@GetMapping
	public ModelAndView pagina() {
		ModelAndView mv = new ModelAndView("instituicao");

		inst = new Instituicao();
		mv.addObject("instituicao", inst);

		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(Instituicao instituicao) {
		ModelAndView mv = new ModelAndView("instituicao");
		instituicao.setId(1l);
		repo.save(instituicao);
		mv.addObject("mensagem", "Análise salva com sucesso!");
		return mv;
	}

}
