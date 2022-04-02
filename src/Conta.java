
public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected  int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	
		
	}

	@Override
	public void sacar(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			System.out.println("Saque efetuado com sucesso!");
		}else
			System.out.println("Saldo Insuficiente");
	}


	@Override
	public void depositar(double valor) {
		if(valor > 0) {
			this.saldo += valor;
			System.out.println("deposito efetuado com sucesso!");
		}else
			System.out.println("Não foi possível realizar o deposito!");
	}


	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(this.saldo >= valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("transferencia efetuada com sucesso!");
		}else {
			System.out.println("Transferencia nao efetuada!");
		}
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular %s ", this.cliente.getNome()));
		System.out.println(String.format("Agencia %d ", this.agencia));
		System.out.println(String.format("Numero %d ", this.numero));
		System.out.println(String.format("Saldo %.2f ", this.saldo));
	}


	public int getAgencia() {
		return agencia;
	}


	public int getNumero() {
		return numero;
	}


	public double getSaldo() {
		return saldo;
	}


	
	
	
}
