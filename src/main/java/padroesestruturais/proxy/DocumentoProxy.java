package padroesestruturais.proxy;

public class DocumentoProxy implements Documento {

    private final String nome;
    private final boolean confidencial;
    private final String perfil;
    private DocumentoReal documentoReal;

    public DocumentoProxy(String nome, boolean confidencial, String perfil) {
        this.nome = nome;
        this.confidencial = confidencial;
        this.perfil = perfil;
    }

    public boolean isCarregado() {
        return documentoReal != null;
    }

    @Override
    public String ler() {
        if (confidencial && !"ADMIN".equals(perfil)) {
            return "Acesso negado ao documento " + nome;
        }
        if (documentoReal == null) {
            documentoReal = new DocumentoReal(nome);
        }
        return documentoReal.ler();
    }
}
