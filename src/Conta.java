import java.util.ArrayList;

public abstract class Conta {

    private String titular;
    private int numeroConta;
    protected double saldo;
    private int agencia;

    public Conta(String titular, int numeroConta, int agencia) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.agencia = agencia;

    }

    public void operacao(int resposta, ArrayList<Conta> litaContas) throws InterruptedException {
    }

    public void saca(double valor) {
        if (valor > this.saldo) {
            throw new RuntimeException("Saldo INSUFICIENTE");
        } else {
            this.saldo -= valor;
        }
    }

    public void transfere(double valor, Conta destino) {

        if (valor > this.saldo) {
            throw new RuntimeException("Saldo INSUFICIENTE");
        } else {
            this.saldo -= valor;
            destino.deposita(valor);
        }
    }

    public abstract void deposita(double valor);

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

}
