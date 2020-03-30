package com.teste;

import com.code.FonteDestino;
import com.code.FonteOrigem;
import com.code.Processor;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class ProcessadorTeste {

    FonteOrigem fonteOrigem = null;
    FonteDestino fonteDestino = null;
    @Before
    public void inicializa() {
    //Criando os Mocks
        fonteOrigem = EasyMock.createMock(FonteOrigem.class);
        fonteDestino = EasyMock.createMock(FonteDestino.class);
    }
    @Test
    public void testProcessaDados()
    {
        EasyMock.expect(fonteOrigem.leDados()).andReturn("DadoTeste");
        fonteDestino.gravaDados("DadoTeste");
        EasyMock.replay(fonteOrigem, fonteDestino);
        //Chamando a implementação
        Processor processador = new Processor(fonteOrigem, fonteDestino);
        try {
            processador.processaDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Testando
        EasyMock.verify(fonteOrigem, fonteDestino);
    }
}
