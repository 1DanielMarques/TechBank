public class Pessoa {

    private String nome;
    private int idade;
    private String cep;
    private String profissao;
    private String cpf;

    public Pessoa(String nome, int idade, String cep, String profissao, String cpf) {

        if (idade < 18 || idade > 90) {
            // Lançar uma exceção?
            throw new RuntimeException("Idade não aceita");

        } else {
            this.nome = nome;
            this.idade = idade;
            this.cep = cep;
            this.profissao = profissao;
            this.cpf = cpf;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
