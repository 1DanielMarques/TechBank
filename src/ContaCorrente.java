public class ContaCorrente extends Conta {

    public ContaCorrente(String titular, int numeroConta, int agencia) {
        super(titular, numeroConta, agencia);

    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

    @Override
    public void saca(double valor) {
        super.saca(valor);
    }

    @Override
    public void transfere(double valor, Conta destino) {
        super.transfere(valor, destino);
    }

}
