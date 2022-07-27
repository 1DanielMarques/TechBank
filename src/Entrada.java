import java.util.Scanner;

public class Entrada {

    private String nome;
    private String cep;
    private String profissao;
    private String cpf;
    private int idade;
    private int resposta;
    protected String tipoConta;
    Scanner sc = new Scanner(System.in);

    public void entrada() {
        System.out.println("Informe seu nome: ");
        nome = sc.nextLine();

        System.out.println("Informe sua idade: ");
        idade = sc.nextInt();
        if (idade < 18 || idade > 90) {
            // Lançar uma exceção?
            throw new RuntimeException("Você deve ser maior de idade (18 anos).");
        }

        System.out.println("Informe seu CEP: ");
        cep = sc.next();

        System.out.println("Informe sua profissão: ");
        profissao = sc.next();

        System.out.println("Informe seu CPF: ");
        cpf = sc.next();

        System.out.println("Qual conta deseja criar?");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        resposta = sc.nextInt();

    }

    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public int getResposta() {
        return resposta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

}
