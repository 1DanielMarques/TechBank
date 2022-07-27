public class ContaPoupanca extends Conta {

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

}
