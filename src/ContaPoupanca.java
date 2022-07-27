import java.util.ArrayList;
import java.util.Scanner;

public class ContaPoupanca extends Conta {
    private double valorOperacao;
    private int contaDestino;

    public ContaPoupanca(String titular, int numeroConta, int agencia) {
        super(titular, numeroConta, agencia);

    }

    @Override
    public void saca(double valor) {

        if (valor > (super.saldo / 2)) {
            throw new RuntimeException("Não é permitido sacar mais de 50% do saldo total.");
        } else {
            double imposto = valor * 0.05;
            valor += imposto;
            super.saca(valor);

        }

    }

    public void rendeu() {
        double porcentagem = 0.05;
        super.saldo = (super.saldo * porcentagem) + super.saldo;

    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;

    }

    @Override
    public void operacao(int resposta, ArrayList<Conta> listaContas) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        switch (resposta) {
            case 1:
                System.out.println();
                System.out.println("-----DEPÓSITO-----");
                System.out.println("Saldo atual: R$" + super.getSaldo());
                System.out.println("Informe o valor: ");
                valorOperacao = sc.nextDouble();
                this.deposita(valorOperacao);
                System.out.println("Depositando...");
                Thread.sleep(900);
                System.out.println("Saldo: R$" + super.getSaldo());
                System.out.println("-----------------");
                Thread.sleep(500);

                break;

            case 2:
                System.out.println();
                System.out.println("-----SAQUE-----");
                System.out.println("Saldo atual: R$" + super.getSaldo());
                System.out.println("Informe o valor do saque: ");
                valorOperacao = sc.nextDouble();

                if (valorOperacao <= this.getSaldo()) {
                    this.saca(valorOperacao);
                    System.out.println("Saldo novo: R$" + super.getSaldo());
                } else {
                    System.out.println("Saldo insuficiente!");
                }
                System.out.println("------------------");
                Thread.sleep(500);
                break;

            case 3:
                System.out.println("-----TRANSFERÊNCIA-----");
                System.out.println("Saldo atual: R$" + super.getSaldo());
                System.out.println("Informe o valorOperacao da transferência: ");
                valorOperacao = sc.nextDouble();
                System.out.println("Informe o número da conta destino: ");
                contaDestino = sc.nextInt();
                System.out.println("Transferindo...");
                for (int i = 0; i < listaContas.size(); i++) {
                    if (listaContas.get(i).getNumeroConta() == contaDestino) {
                        this.transfere(valorOperacao, listaContas.get(i));
                        System.out.println("Saldo atual: R$" + super.getSaldo());

                    }
                }
                System.out.println("----------------------");
                Thread.sleep(500);

                break;

            case 4:
                System.out.println("-----RENTABILIDADE-----");
                System.out.println("Saldo anterior:" + super.getSaldo());
                this.rendeu();
                System.out.println("Calculando...");
                Thread.sleep(900);
                System.out.println("Saldo 5% rentabilidade: " + super.getSaldo());
                System.out.println("-------------------------");
                Thread.sleep(500);
                break;
        }
    }

}
