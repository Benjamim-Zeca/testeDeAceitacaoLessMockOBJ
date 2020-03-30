package com.code;

public class Processor {

    private FonteOrigem fonteOrigem;
    private FonteDestino fonteDestino;
    public Processor(FonteOrigem fonteOrigem, FonteDestino fonteDestino) {
        this.fonteOrigem = fonteOrigem;
        this.fonteDestino = fonteDestino;
    }
    public void processaDados() throws Exception {
        String entrada = null;
        try {
            entrada = fonteOrigem.leDados();
        } catch (Exception ex) {
            throw new Exception("Ocorreu um problema ao ler dados da fonte de origem.");
        }
        if(entrada != null) {
            String saida = transformaDados(entrada);
            try {
                fonteDestino.gravaDados(saida);
            } catch (Exception e) {
                throw new Exception("Nao foi possível enviar os dados para fonte de destino.");
            }
        }
    }
    private String transformaDados(String entrada) {
        if( "[HoraAtual]".equals(entrada) ) {
            return "hora atual: " + System.currentTimeMillis();
        }
        return entrada;
    }
}
