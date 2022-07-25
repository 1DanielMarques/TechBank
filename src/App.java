public class App {
    public static void main(String[] args) throws Exception {

        Pessoa p1 = new Pessoa("Daniel", 18, "Londrina/PR", "Estudante", "111");
        System.out.println(
                p1.getNome() + " - " + p1.getIdade() + " - " + p1.getCep() + " - " + p1.getProfissao() + " - "
                        + p1.getCpf());
        /*
         * Criar um array de Contas para verificar se há alguma
         * conta com o mesmo numero (Pois não existem contas com o mesmo número)
         */
        Conta c1 = new Conta(p1.getNome(), 123, 100.51);
        System.out.println(c1.getNome() + " - " + c1.getNumeroConta() + " - " + c1.getSaldo());

    }
}
