import java.util.Scanner;

public class App extends Entrada {
        public static void main(String[] args) throws Exception {
                int resposta = 1;
                double valor;
                /*
                 * To create an array of 'Conta' to verify if there is any account
                 * with the same id (Because there isn't accounts with the same id)
                 */
                Entrada dados = new Entrada();
                System.out.println("---Informe seus dados abaixo---");
                dados.entrada();
                Conta cc = new ContaCorrente(dados.getNome(), 123, 1);
                Conta cp = new ContaPoupanca(dados.getNome(), 321, 2);
                // Should I put this verification in the 'Entrada' class?
                switch (dados.getResposta()) {
                        case 1:
                                // Conta Corrente
                                dados.tipoConta = "Conta Corrente";
                                break;

                        case 2:
                                // Conta Poupança
                                dados.tipoConta = "Conta Poupança";
                                break;
                }

                Pessoa p1 = new Pessoa(dados.getNome(), dados.getIdade(), dados.getCep(), dados.getProfissao(),
                                dados.getCpf(), dados.getTipoConta());

                System.out.println("-----Dados Cadastrados-----");
                System.out.println("Nome: " + p1.getNome());
                System.out.println("Idade: " + p1.getIdade());
                System.out.println("CEP: " + p1.getCep());
                System.out.println("Profissão: " + p1.getProfissao());
                System.out.println("CPF: " + p1.getCpf());
                System.out.println("Tipo de Conta: " + p1.getTipoConta());
                System.out.println("-------------------------------");

                Scanner sc = new Scanner(System.in);
                while (resposta != 0) {
                        System.out.println("Deseja realizar alguma operação?");
                        System.out.println("1 - Depositar");
                        System.out.println("2 - Sacar");
                        System.out.println("3 - Transferir");
                        System.out.println("0 - Finalizar");
                        resposta = sc.nextInt();
                        switch (resposta) {
                                case 1:
                                        System.out.println();
                                        System.out.println("-----DEPÓSITO-----");
                                        System.out.println("Saldo atual: R$" + cc.getSaldo());
                                        System.out.println("Informe o valor: ");
                                        valor = sc.nextDouble();
                                        cc.deposita(valor);
                                        System.out.println("Depositando...");
                                        Thread.sleep(800);
                                        System.out.println("Saldo: R$" + cc.getSaldo());
                                        Thread.sleep(1000);
                                        System.out.println("-----------------");

                                        break;

                                case 2:
                                        System.out.println();
                                        System.out.println("-----SAQUE-----");
                                        System.out.println("Saldo atual: R$" + cc.getSaldo());
                                        System.out.println("Informe o valor do saque: ");
                                        valor = sc.nextDouble();

                                        if (valor <= cc.getSaldo()) {
                                                cc.saca(valor);
                                                System.out.println("Saldo novo: R$" + cc.getSaldo());
                                                Thread.sleep(1500);
                                        } else {
                                                System.out.println("Saldo insuficiente!");
                                        }
                                        System.out.println("------------------");
                                        break;

                                case 3:
                                        System.out.println("Informe o valor da transferência: ");
                                        valor = sc.nextDouble();
                                        System.out.println("Informe a conta destino: ");
                                        // Maybe creating an array of accounts and looking for the number (id)

                                        break;
                        }
                }

                /*
                 * cp.deposita(100);
                 * 
                 * System.out.println("R$" + cp.getSaldo());
                 * cp.saca(50);
                 * System.out.println("R$" + cp.getSaldo());
                 * cp.rendeu();
                 * System.out.println("R$" + cp.getSaldo());
                 */
        }
}
