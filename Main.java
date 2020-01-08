//import java.io.IOException;
import java.util.Scanner;
import java.util.Random; 

public class Main {

	public static void main(String[] args) {
		ContaBanco Conta[] = new ContaBanco[10];
		for (int i=0; i<Conta.length; i++) {
			Conta[i] = new ContaBanco();
		}
		conta(Conta);
	}

	public static void conta(ContaBanco Conta[]) {
		Scanner input = new Scanner(System.in);
		menu();
		int entrada = input.nextInt();
		switch (entrada) {
			case 1:
				abrirConta(Conta);
				break;
			case 2:
				consultarSaldo(Conta);
				break;
			case 3:
				depositarDinheiro(Conta);
				break;
			case 4:
				sacarDinheiro(Conta);
				break;
			case 5:
				pagarMensalidade(Conta);
				break;
			case 6:
				fecharConta(Conta);
				break;
			case 7: //sair
				break;
			default:
				limparTela();
				System.out.println("\n\n   Digite um número válido!\n");
				voltarAoMenu(Conta);
		}
	}

	public static void menu() {
		limparTela();
		System.out.println("\n\n\n");
		System.out.println("   Seja bem vindo ao SCB - Simulador de Contas Bancárias!");
		System.out.println("\n");
		System.out.println("   O que deseja fazer?");
		System.out.println("\n\n\n");
		System.out.println("   1. Abrir uma conta.\n");
		System.out.println("   2. Consultar saldo.\n");
		System.out.println("   3. Depositar dinheiro.\n");
		System.out.println("   4. Sacar dinheiro.\n");
		System.out.println("   5. Pagar a mensalidade.\n");
		System.out.println("   6. Fechar uma conta.\n");
		System.out.println("   7. Sair.\n");
	}

	public static void abrirConta(ContaBanco Conta[]) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		limparTela();
		for (int i=0; i<Conta.length; i++) {
			if (!Conta[i].getStatus()) {
				String nome = pedirNome();
				limparTela();
				System.out.println("   Digite 1 para conta corrente, e 2 para conta poupança:\n");
				int opcao = input.nextInt();
					if (opcao==1) {
						Conta[i].setDono(nome);
						Conta[i].setNumConta(random.nextInt(1000));
						Conta[i].setTipo("cc");
						Conta[i].setStatus(true);
						limparTela();
						System.out.println("   A conta em nome de "+Conta[i].getDono()+", de número "+Conta[i].getNumConta()+", e tipo Conta Corrente, foi aberta com sucesso!\n");
					} else if (opcao==2) {
						Conta[i].setDono(nome);
						Conta[i].setNumConta(random.nextInt(1000));
						Conta[i].setTipo("cp");
						Conta[i].setStatus(true);
						limparTela();
						System.out.println("   A conta em nome de "+Conta[i].getDono()+", de número "+Conta[i].getNumConta()+", e tipo Conta poupança, foi aberta com sucesso!\n");
					} else {
						System.out.println("\n\n   Digite uma opção válida!");
					}
				break;
			}
		}
		voltarAoMenu(Conta);
	}

	public static void fecharConta(ContaBanco Conta[]) {
		boolean achouNome = false;
		limparTela();
		String nome = pedirNome();
		for (int i=0; i<Conta.length; i++) {
			if (nome.equals(Conta[i].getDono())) {
				limparTela();
				achouNome = true;
				if (Conta[i].getNumConta() == pedirNumero()) {
					limparTela();
					Conta[i].setStatus(false);
					Conta[i].setDono(null);
					Conta[i].setNumConta(0);
					System.out.println("\n\n   Conta excluída com sucesso!");
				} else {
					System.out.println("\n\n   Número da conta incorreto.");
				}
			}
		}
		if (!achouNome) {
			System.out.println("\n\n   Nenhuma conta com seu nome foi encontrada.");
		}
		voltarAoMenu(Conta);
	}

	public static void consultarSaldo(ContaBanco Conta[]) {
		boolean achouNome = false;
		limparTela();
		String nome = pedirNome();
		for (int i=0; i<Conta.length; i++) {
			if (nome.equals(Conta[i].getDono())) {
				limparTela();
				achouNome = true;
				if (Conta[i].getNumConta() == pedirNumero()) {
					limparTela();
					System.out.printf("\n\n   O seu saldo em conta é de R$ %.2f",Conta[i].getSaldo());
				}  else {
					System.out.println("\n\n   Número da conta incorreto.");
				}
			}
		}
		if (!achouNome) {
			System.out.println("\n\n   Nenhuma conta com seu nome foi encontrada.");
		}
		voltarAoMenu(Conta);
	}

	public static void depositarDinheiro(ContaBanco Conta[]) {
		Scanner input = new Scanner(System.in);
		boolean achouNome = false;
		limparTela();
		String nome = pedirNome();
		for (int i=0; i<Conta.length; i++) {
			if (nome.equals(Conta[i].getDono())) {
				limparTela();
				achouNome = true;
				if (Conta[i].getNumConta() == pedirNumero()) {
					limparTela();
					System.out.println("   Quanto você deseja depositar?");
					float valor = input.nextFloat();
					if (valor > 0) {
						limparTela();
						Conta[i].depositar(valor);
						System.out.printf("   O valor de R$ %.2f foi depositado com sucesso!", valor);
					} else {
						System.out.println("\n\n   Valor não pode ser negativo!");
					}
				} else {
					System.out.println("\n\n   Número da conta incorreto.");
				}
			}
		}
		if (!achouNome) {
			System.out.println("\n\n   Nenhuma conta com seu nome foi encontrada.");
		}
		voltarAoMenu(Conta);
	}

	public static void sacarDinheiro(ContaBanco Conta[]) {
		Scanner input = new Scanner(System.in);
		boolean achouNome = false;
		limparTela();
		String nome = pedirNome();
		for (int i=0; i<Conta.length; i++) {
			if (nome.equals(Conta[i].getDono())) {
				limparTela();
				achouNome = true;
				if (Conta[i].getNumConta() == pedirNumero()) {
					limparTela();
					System.out.println("   Quanto você deseja sacar?");
					float valor = input.nextFloat();
					if (valor > 0) {
						limparTela();
						if (valor >= Conta[i].getSaldo()) {
							System.out.println("\n\n   Não foi possível sacar, valor superior ao disponível em conta!");
						}
					} else {
						System.out.println("\n\n   Valor não pode ser negativo!");
					}
				} else {
					System.out.println("\n\n   Número da conta incorreto.");
				}
			}
		}
		if (!achouNome) {
			System.out.println("\n\n   Nenhuma conta com seu nome foi encontrada.");
		}
		voltarAoMenu(Conta);
	}

	public static void pagarMensalidade(ContaBanco Conta[]) {
		float valor = 0;
		boolean achouNome = false;
		limparTela();
		String nome = pedirNome();
		for (int i=0; i<Conta.length; i++) {
			if (nome.equals(Conta[i].getDono())) {
				limparTela();
				achouNome = true;
				if (Conta[i].getNumConta() == pedirNumero()) {
					if (Conta[i].getTipo().equals("cc")) {
						valor = 12;
						Conta[i].pagarMensalidade(valor);
						limparTela();
						System.out.printf("   Você pagou a mensalidade de R$ %.2f!\n", valor);
					} else {
						valor = 20;
						Conta[i].pagarMensalidade(valor);
						limparTela();
						System.out.printf("   Você pagou a mensalidade de R$ %.2f!\n", valor);
					}
				} else {
					System.out.println("\n\n   Número da conta incorreto.");
				}
			}
		}
		if (!achouNome) {
			System.out.println("\n\n   Nenhuma conta com seu nome foi encontrada.");
		}
		voltarAoMenu(Conta);
	}

	public static void limparTela() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static String pedirNome() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n   Digite o seu nome:\n");
		String nome = input.nextLine();
		return nome; 
	}

	public static int pedirNumero() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n   Digite o número da sua conta: \n");
		int num = input.nextInt();
		return num;
	}

	public static void voltarAoMenu(ContaBanco Conta[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n   1. Voltar ao menu anterior.");
		System.out.println("\n   2. Sair.\n");
		int opcao = input.nextInt();
		if (opcao == 1) {
			conta(Conta);
		} else if (opcao == 2) {
			System.out.println("\n\n   Até mais\n");
		}
	}
}