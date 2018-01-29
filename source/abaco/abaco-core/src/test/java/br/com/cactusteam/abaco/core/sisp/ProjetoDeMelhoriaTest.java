package br.com.cactusteam.abaco.core.sisp;

import br.com.cactusteam.abaco.core.*;
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
    public void deveCalcularTotalPorSituacao(){
        FuncaoDeDado funcaoDeDadoIncluido = new FuncaoDeDado(0, 0,TipoFuncaoDado.ALI, "ALI Incluido");
        FuncaoDeTransacao funcaoDeTransacaoIncluido = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.SE,"SE Incluido");

        FuncaoDeDado funcaoDeDadoAlterado = new FuncaoDeDado(0, 0,TipoFuncaoDado.ALI, "ALI Alterado", Situacao.ALTERADO);
        funcaoDeDadoAlterado.setFatorImpacto(0.9f);
        FuncaoDeTransacao funcaoDeTransacaoAlterado = new FuncaoDeTransacao(0, 0, TipoFuncaoTransacao.SE,"SE Alterado", Situacao.ALTERADO);
        funcaoDeTransacaoAlterado.setFatorImpacto(0.9f);

        projetoDeMelhoriaSISP.incluiFuncaoDeDado(funcaoDeDadoAlterado);
        projetoDeMelhoriaSISP.incluiFuncaoDeDado(funcaoDeDadoIncluido);

        projetoDeMelhoriaSISP.incluiFuncaoDeTransacao(funcaoDeTransacaoIncluido);
        projetoDeMelhoriaSISP.incluiFuncaoDeTransacao(funcaoDeTransacaoAlterado);



        Assert.assertEquals(22.8, projetoDeMelhoriaSISP.calculaTotal(), 0.01);
    }

}
