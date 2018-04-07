package br.com.cactusteam.abaco.core.report;

import br.com.cactusteam.abaco.core.Projeto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.*;
import java.util.*;

/**
 * Created by mario on 29/01/18.
 */
public class ReportadorDeAnalise {

    private Collection<Projeto> projetos;
    protected JasperPrint relatorio;
    protected InputStream templateJasper;

    protected Map<String,Object> parametros = new HashMap<String,Object>();

    public ReportadorDeAnalise(Projeto... projeto){
        this.projetos = Arrays.asList(projeto);

        templateJasper = ReportadorDeAnalise.class.getResourceAsStream("/br/com/cactusteam/abaco/core/templates/report.jasper");
        parametros.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));

    }

    public void geraPdf(String arquivo){
        OutputStream out = null;

        try {
            out = new FileOutputStream(arquivo);
            geraPDF(out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void geraPDF(OutputStream out){
        try {
            JasperPrint relatorio = geraRelatorio();
            JasperExportManager.exportReportToPdfStream(relatorio, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected JasperPrint geraRelatorio(){
        try{
            if(relatorio == null){
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projetos);
                relatorio = JasperFillManager.fillReport(templateJasper,parametros,	dataSource);
            }
            return relatorio;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
