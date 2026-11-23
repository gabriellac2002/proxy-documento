package padroesestruturais.proxy;

public class DocumentoReal implements Documento {

    private final String nome;

    public DocumentoReal(String nome) {
        this.nome = nome;
        // simula um carregamento custoso (disco, rede...)
    }

    @Override
    public String ler() {
        return "Conteudo do documento " + nome;
    }
}
