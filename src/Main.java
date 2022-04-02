
public class Main {

	public static void main(String[] args) {
		Banco b = new Banco();
		b.setNome("Legal");
		Cliente erick = new Cliente();
		erick.setNome("Erick");
		Conta cc = new ContaCorrente(erick);
		Conta poupanca = new ContaPoupanca(erick);
		cc.depositar(100);
		cc.transferir(100, poupanca);
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		b.getContas().add(cc);
		b.getContas().add(poupanca);
		System.out.println(b);
	}

}
