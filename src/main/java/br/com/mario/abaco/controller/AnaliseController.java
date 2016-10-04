package br.com.mario.abaco.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.sisp2_2.TipoContagemSISP;
import br.com.mario.abaco.repository.AnaliseRepository;

@Controller
@RequestMapping("/analise")
public class AnaliseController {
	
	@Autowired
	private AnaliseRepository repo;
	
	@RequestMapping("/nova")
	public ModelAndView nova(){
		ModelAndView mv = new ModelAndView("nova-analise");
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(Analise analise){
		ModelAndView mv = new ModelAndView("nova-analise");
		analise.setData(LocalDate.now());
		repo.save(analise);
		mv.addObject("mensagem","Análise salva com sucesso!");
		return mv;
	}
	
	@ModelAttribute
	public List<TipoContagemSISP> tiposContagem(){
		return Arrays.asList(TipoContagemSISP.values());
	}
}
