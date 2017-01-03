package br.com.mario.abaco.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mario.abaco.model.Analise;
import br.com.mario.abaco.model.Sistema;
import br.com.mario.abaco.model.sisp2_2.TipoContagemSISP;
import br.com.mario.abaco.repository.AnaliseRepository;
import br.com.mario.abaco.repository.SistemaRepository;

@Controller
@RequestMapping("/analise")
public class AnaliseController {
	
	@Autowired
	private AnaliseRepository repo;
	@Autowired
	private SistemaRepository sistemaRepo;
	
	@RequestMapping("/nova")
	public ModelAndView nova(){
		ModelAndView mv = new ModelAndView("nova-analise");
		mv.addObject("analise", new Analise());
		return mv;
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("nova-analise");
		Analise a = repo.findOne(id);
		
		mv.addObject(a);
		mv.addObject("projeto", a.getProjeto());
		
		return mv;
	}

	@PostMapping("/next")
	public ModelAndView next(@ModelAttribute("analise") @Validated Analise analise, 
								RedirectAttributes redirect){
		
		String pagina = proximaPagina(analise.getTipoDeContagem());
		ModelAndView mv = new ModelAndView(pagina);
		
		Long id =analise.getId(); 
		if(id!=null)
			analise.setProjeto(repo.getOne(id).getProjeto());
		
		analise.setData(LocalDate.now());
		
		redirect.addFlashAttribute("analise", analise);
		return mv;
	}
	
	@RequestMapping("/resumo/{id}")
	public ModelAndView resumo(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("resumo-analise");
		mv.addObject(repo.findOne(id));
		return mv;
	}
	
	private String proximaPagina(TipoContagemSISP tipoDeContagem) {
		String pagina = "redirect:/contagem";
		switch (tipoDeContagem) {
		case APLICACAO:
			pagina += "/aplicacao";
			break;
		case DESENVOLVIMENTO:
			pagina += "/desenvolvimento";
			break;
		case MELHORIA:
			pagina += "/melhoria";
			break;
		case MIGRACAO:
			pagina += "/migracao";
			break;
		}
		return pagina;
	}

	@ModelAttribute(name="tipoContagemList")
	public List<TipoContagemSISP> tiposContagem(){
		return Arrays.asList(TipoContagemSISP.values());
	}
	
	@ModelAttribute
	public List<Sistema> sistemas(){
		return sistemaRepo.findAll();
	}
	
	@RequestMapping("/contagem")
	public ModelAndView contagem(){
		ModelAndView mv = new ModelAndView("contagem-aplicacao");
		
		return mv;
	}
}
