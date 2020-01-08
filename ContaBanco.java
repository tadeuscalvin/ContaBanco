public class ContaBanco {
	//atributos da classe conta
	private String dono, tipo;
	private int numConta;
	private float saldo;
	private boolean status;

	//construtor
	public ContaBanco() {
		this.setSaldo(0);
		this.setStatus(false);
	}

	//métodos específicos
	public void abrirConta() {
		this.setStatus(true);
	}
	public void fecharConta() {
		this.setStatus(false);
	}
	public void depositar(float dinheiro) {
		this.setSaldo(this.getSaldo() + dinheiro);
	}
	public void sacar(float dinheiro) {
		this.setSaldo(this.getSaldo() - dinheiro);
	}
	public void pagarMensalidade(float valor) {
		this.setSaldo(this.getSaldo() - valor);
	}

	//métodos setters e getters
	public int getNumConta() {
		return this.numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDono() {
		return this.dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public float getSaldo() {
		return this.saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean getStatus() {
		return this.status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}