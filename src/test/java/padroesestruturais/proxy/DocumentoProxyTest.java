package padroesestruturais.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DocumentoProxyTest {

    @Test
    void naoDeveCarregarDocumentoRealAntesDaLeitura() {
        DocumentoProxy proxy = new DocumentoProxy("manual.pdf", false, "CONVIDADO");
        assertFalse(proxy.isCarregado());
    }

    @Test
    void deveCarregarDocumentoRealSomenteNaPrimeiraLeitura() {
        DocumentoProxy proxy = new DocumentoProxy("manual.pdf", false, "CONVIDADO");
        assertEquals("Conteudo do documento manual.pdf", proxy.ler());
        assertTrue(proxy.isCarregado());
        assertEquals("Conteudo do documento manual.pdf", proxy.ler());
    }

    @Test
    void deveNegarAcessoAConfidencialParaNaoAdmin() {
        DocumentoProxy proxy = new DocumentoProxy("folha.xlsx", true, "CONVIDADO");
        assertEquals("Acesso negado ao documento folha.xlsx", proxy.ler());
        assertFalse(proxy.isCarregado());
    }

    @Test
    void devePermitirAcessoAConfidencialParaAdmin() {
        DocumentoProxy proxy = new DocumentoProxy("folha.xlsx", true, "ADMIN");
        assertEquals("Conteudo do documento folha.xlsx", proxy.ler());
    }
}
