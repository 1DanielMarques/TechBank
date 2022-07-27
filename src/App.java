
/**
         * TechBank
         * @version 3.0
         * @author Daniel Marques <daniel.marques@edu.unifil.br>
         * Date: 2022-07-27
         */

import java.util.ArrayList;
import java.util.Scanner;

public class App extends Entrada {

        public static void main(String[] args) throws Exception {
                int resposta = 1;

                /*
                 * To create an array of 'Conta' to verify if there is any account
                 * with the same id (Because there isn't accounts with the same id)
                 */
                Entrada dados = new Entrada();
                System.out.println("---Informe seus dados abaixo---");
                dados.entrada();
                ArrayList<Conta> listaContas = new ArrayList<Conta>();
                Conta cc = new ContaCorrente(dados.getNome(), 123, 1);

                Conta cp = new ContaPoupanca(dados.getNome(), 321, 2);

                listaContas.add(cc);
                listaContas.add(cp);
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
                        if (p1.getTipoConta().equals("Conta Poupança")) {
                                System.out.println("4 - Rentabilidade");
                        }
                        System.out.println("0 - Finalizar");
                        resposta = sc.nextInt();

                        if (p1.getTipoConta().equals("Conta Corrente")) {
                                cc.operacao(resposta, listaContas);
                        } else if (p1.getTipoConta().equals("Conta Poupança")) {
                                cp.operacao(resposta, listaContas);
                        }

                }

        }
}
