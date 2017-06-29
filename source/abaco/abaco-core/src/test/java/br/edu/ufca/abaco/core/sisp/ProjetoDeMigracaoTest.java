package br.edu.ufca.abaco.core.sisp;

import org.junit.Test;

import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.TipoFuncaoDado;

public class ProjetoDeMigracaoTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirInclusaoDeAIE(){
		ProjetoDeMigracao projeto = new ProjetoDeMigracao();
		projeto.incluiFuncaoDeDado(new FuncaoDeDado(0, 0, TipoFuncaoDado.AIE));
	}
	
}
