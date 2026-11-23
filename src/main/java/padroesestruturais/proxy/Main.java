package padroesestruturais.proxy;

public class Main {

    public static void main(String[] args) {
        Documento publico = new DocumentoProxy("manual.pdf", false, "CONVIDADO");
        Documento sigiloso = new DocumentoProxy("folha-pagamento.xlsx", true, "CONVIDADO");
        Documento sigilosoAdmin = new DocumentoProxy("folha-pagamento.xlsx", true, "ADMIN");

        System.out.println(publico.ler());
        System.out.println(sigiloso.ler());
        System.out.println(sigilosoAdmin.ler());
    }
}
