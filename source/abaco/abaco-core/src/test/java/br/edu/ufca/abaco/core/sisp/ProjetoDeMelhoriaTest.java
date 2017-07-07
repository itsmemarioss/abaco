package br.edu.ufca.abaco.core.sisp;

import br.edu.ufca.abaco.core.FuncaoDeDado;
import br.edu.ufca.abaco.core.FuncaoDeTransacao;
import br.edu.ufca.abaco.core.TipoFuncaoDado;
import br.edu.ufca.abaco.core.TipoFuncaoTransacao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kelvin.santos on 06/07/17.
 */
public class ProjetoDeMelhoriaTest {

    ProjetoDeMelhoriaSISP projetoDeMelhoriaSISP;

    @Before
    public void setup(){
        projetoDeMelhoriaSISP = new ProjetoDeMelhoriaSISP(null);
    }

    @Test
    public void deveExcluirFuncoes(){
        FuncaoDeDado funcaoDeDadoAlterado = new FuncaoDeDado(0, 0, TipoFuncaoDado.AIE);
        FuncaoDeDado funcaoDeDadoExcluido = new FuncaoDeDado(0, 0, TipoFuncaoDado.ALI);
        FuncaoDeDado funcaoDeDadoIncluido = new FuncaoDeDado(0, 0, TipoFuncaoDado.AIE);
        FuncaoDeDado funcaoDeDadoConversao = new FuncaoDeDado(0, 0, TipoFuncaoDado.ALI);

        FuncaoDeTransacao funcaoDeTransacaoAlterado = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.SE);
        FuncaoDeTransacao funcaoDeTransacaoExcluido = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.SE);
        FuncaoDeTransacao funcaoDeTransacaoIncluido = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.SE);
        FuncaoDeTransacao funcaoDeTransacaoConversao = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.SE);


        projetoDeMelhoriaSISP.incluiFuncaoDeDadoPfAlterado(funcaoDeDadoAlterado);
        projetoDeMelhoriaSISP.incluiFuncaoDeDadoPfConversao(funcaoDeDadoConversao);
        projetoDeMelhoriaSISP.incluiFuncaoDeDadoPfIncluido(funcaoDeDadoIncluido);
        projetoDeMelhoriaSISP.incluiFuncaoDeDadoPfExcluido(funcaoDeDadoExcluido);

        projetoDeMelhoriaSISP.removeFuncaoDeDadoPfAlterado(funcaoDeDadoAlterado);
        projetoDeMelhoriaSISP.removeFuncaoDeDadoPfConversao(funcaoDeDadoConversao);
        projetoDeMelhoriaSISP.removeFuncaoDeDadoPfIncluido(funcaoDeDadoIncluido);
        projetoDeMelhoriaSISP.removeFuncaoDeDadoPfExcluido(funcaoDeDadoExcluido);
        Assert.assertEquals(0, projetoDeMelhoriaSISP.totalFuncaoDeDados());

        projetoDeMelhoriaSISP.incluiFuncaoDeTransacaoPfAlterado(funcaoDeTransacaoAlterado);
        projetoDeMelhoriaSISP.incluiFuncaoDeTransacaoPfConversao(funcaoDeTransacaoConversao);
        projetoDeMelhoriaSISP.incluiFuncaoDeTransacaoPfIncluido(funcaoDeTransacaoIncluido);
        projetoDeMelhoriaSISP.incluiFuncaoDeTransacaoPfExcluido(funcaoDeTransacaoExcluido);

        projetoDeMelhoriaSISP.removeFuncaoDeTransacaoPfAlterado(funcaoDeTransacaoAlterado);
        projetoDeMelhoriaSISP.removeFuncaoDeTransacaoPfConversao(funcaoDeTransacaoConversao);
        projetoDeMelhoriaSISP.removeFuncaoDeTransacaoPfIncluido(funcaoDeTransacaoIncluido);
        projetoDeMelhoriaSISP.removeFuncaoDeTransacaoPfExcluido(funcaoDeTransacaoExcluido);
        Assert.assertEquals(0, projetoDeMelhoriaSISP.totalFuncaoDeTransacao());
    }

}
