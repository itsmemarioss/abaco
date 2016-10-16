package br.com.mario.abaco.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		return mv;
	}

	@PostMapping("/next")
	public ModelAndView salvar(@ModelAttribute("analise") @Validated Analise analise, 
								RedirectAttributes redirect){
		
		String pagina = proximaPagina(analise.getTipoDeContagem());
		
		ModelAndView mv = new ModelAndView(pagina);
		
		analise.setData(LocalDate.now());
		redirect.addFlashAttribute("analise", analise);
		//repo.save(analise);
		
		//mv.addObject("mensagem","Análise salva com sucesso!");
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
