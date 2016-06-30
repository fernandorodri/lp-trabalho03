package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Trabalho03 {
	
	/**
	 * Fun��o respons�vel pela exibi��o do menu de op��es do programa
	 */
	
	public static void ExibirMenu (){
		System.out.println();
		System.out.println("=======================================MENU=======================================");
		System.out.println("1 - Imprimir tabela");
		System.out.println("2 - Pesquisar produto");
		System.out.println("3 - Mostrar dados do produto mais caro");
		System.out.println("4 - Mostrar c�digo e descri��o dos produtos cuja quantidade est� abaixo de 10");
		System.out.println("5 - Ativo total do estoque");
		System.out.println("6 - Efetuar uma venda");
		System.out.println("7 - Sair");
		System.out.println("==================================================================================");
		System.out.println();
		System.out.print("Qual a op��o deseja acessar? ");
		}
	
	/**
	 * Fun��o respons�vel por exibir a Tabela de Produtos quando o usu�rio selecionar a op��o 1 do Menu
	 * @param N Quantidade de produtos que a tabela poss�i
	 * @param vetCodigo Vetor respons�vel por armazenar os c�digos de todos os produtos
	 * @param vetPre�o Vetor respons�vel por armazenar os pre�os de todos os produtos
	 * @param vetDescri�ao Vetor respons�vel por armazenar a descri��o de todos os produtos
	 * @param vetEstoque Vetor respons�vel por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void MostrarTabela (int N, double[] vetCodigo, double[] vetPre�o, String[] vetDescri�ao, double[] vetEstoque) {
		
		System.out.println();
		System.out.println();
		System.out.println("===================== TABELA DE PRODUTOS =====================");
		System.out.println("C�digo | Pre�o | Estoque | Descri��o");
		
		for (int i=0 ; i < N ; i++) {
			System.out.print(vetCodigo[i] + "  |");
			System.out.print(vetPre�o[i] + "  |");
			System.out.print(vetEstoque[i] + "    |");
			System.out.println(vetDescri�ao[i] + "    ");
			System.out.println("==============================================================");
		}
	}
	
	
	/**
	 * Fun��o respons�vel pela localiza��o de informa��es sobre o produto cujo c�digo foi inserido pelo usu�rio no menu.
	 * @param N Quantidade de produtos que a tabela poss�i
	 * @param Procura C�digo inserido pelo usu�rio para obter mais informa��es sobre o mesmo
	 * @param vetCodigo Vetor respons�vel por armazenar os c�digos de todos os produtos
	 * @param vetPre�o Vetor respons�vel por armazenar os pre�os de todos os produtos
	 * @param vetEstoque Vetor respons�vel por armazenar a descri��o de todos os produtos
	 * @param vetDescri�ao Vetor respons�vel por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void PesquisarProduto (int N, int Procura, double[] vetCodigo, double[] vetPre�o, double[] vetEstoque, String[] vetDescri�ao) {
		
		int Indisponivel = 0;
		double Total;
		
		for (int i=0 ; i < N ; i++) {
			
			if (vetCodigo[i] == Procura) {
				
			Total = vetPre�o[i] * vetEstoque[i];
			System.out.println();
			System.out.println("===================== INFORMA��ES =====================");
			System.out.println("C�digo | Pre�o | Estoque | Total | Descri��o");
			System.out.print(vetCodigo[i] + "  |");
			System.out.print(vetPre�o[i] + "  |");
			System.out.print(vetEstoque[i] + "    |");
			System.out.print(Total + "    |");
			System.out.println(vetDescri�ao[i] + "    ");
			System.out.println("=======================================================");
			
			Indisponivel++;
			
			} if (Indisponivel == 0) {
				System.out.println();
				System.out.println("Este produto n�o existe.");
				
			}
		}
		
	}
	
	/**
	 * Fun��o respons�vel por exibir as informa��es do produto mais caro existente no cadastro do programa
	 * @param N Quantidade de produtos que a tabela poss�i
	 * @param vetCodigo Vetor respons�vel por armazenar os c�digos de todos os produtos
	 * @param vetPre�o Vetor respons�vel por armazenar os pre�os de todos os produtos
	 * @param vetEstoque Vetor respons�vel por armazenar a descri��o de todos os produtos
	 * @param vetDescri�ao Vetor respons�vel por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void ProdutoCaro (int N, double[] vetCodigo, double[] vetPre�o, double[] vetEstoque, String[] vetDescri�ao) {
		
		int posi�ao = 0;
		double Maior = 0.0;
		
		for (int i=0 ; i < N ; i++) {
			
			if (vetPre�o[i] > Maior) {
				Maior = vetPre�o[i];
				posi�ao = i;
			}
		}
		
		System.out.println();
		System.out.println("===================== PRODUTO MAIS CARO =====================");
		System.out.println("C�digo | Pre�o | Estoque | Total | Descri��o");
		System.out.print(vetCodigo[posi�ao] + "  |");
		System.out.print(vetPre�o[posi�ao] + "  |");
		System.out.print(vetEstoque[posi�ao] + "    |");
		System.out.println(vetDescri�ao[posi�ao] + "    ");
		System.out.println("=============================================================");		
		
		
	}
	
	/**
	 * Fun��o respons�vel por analisar e apresentar os produtos cujo estoque est� inferior a 10 pe�as
	 * @param N Quantidade de produtos que a tabela poss�i
	 * @param vetCodigo Vetor respons�vel por armazenar os c�digos de todos os produtos
	 * @param vetEstoque Vetor respons�vel por armazenar a descri��o de todos os produtos
	 * @param vetDescri�ao Vetor respons�vel por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void EstoqueBaixo (int N,  double[] vetCodigo, double[] vetEstoque, String[] vetDescri�ao) {
		
		System.out.println();
		System.out.println("===================== ESTOQUE BAIXO =====================");
		System.out.println("C�digo | Descri��o");
		
		for (int i=0 ; i < N ; i++) {
			
			if (vetEstoque[i] < 10) {
				System.out.print(vetCodigo[i] + "  |");
				System.out.println(vetDescri�ao[i] + "    ");
			}
						
		}
		
		System.out.println("=========================================================");
		
	}
	
	/**
	 * Fun��o respons�vel por calcular o valor de todo o estoque, multiplicando pre�o de produto com quantidade em estoque
	 * @param N Quantidade de produtos que a tabela poss�i
	 * @param vetPre�o Vetor respons�vel por armazenar os pre�os de todos os produtos
	 * @param vetEstoque Vetor respons�vel por armazenar a descri��o de todos os produtos
	 */
	
	public static void TotalEstoque (int N, double[] vetPre�o, double[] vetEstoque) {
		
		double Total = 0.0;
		
		System.out.println();
		
		for (int i=0 ; i < N ; i++){
			
			Total = vetPre�o[i] * vetEstoque[i] + Total;
			
		}
		
		System.out.println("===================== VALOR ESTOQUE =====================");
		System.out.println("Valor total do estoque: " + Total);
		System.out.println("=========================================================");
	}
	
	/**
	 * Fun��o respons�vel por verificar se o produto desejado pelo consumidor esta disponivel em estoque, se tem a quantidade o suficiente e que realiza a venda.
	 * @param sc Recebe a declara��o do scanner onde o usuario deve digitar o c�digo do produto desejado
	 * @param N Quantidade de produtos que a tabela poss�i
	 * @param vetCodigo Vetor respons�vel por armazenar os c�digos de todos os produtos
	 * @param vetEstoque Vetor respons�vel por armazenar a descri��o de todos os produtos
	 */
	
	public static void EfetuarVenda (Scanner sc, int N, double[] vetCodigo, double[] vetEstoque) {
		
		int Quantidade, Indisponivel=0;
		double Compra;
		
		System.out.println();
		
		System.out.print("Qual o c�digo do produto que deseja adquirir? ");
		Compra = sc.nextInt();
		
		System.out.println();
		
		for (int i=0 ; i < N ; i++) {
			
			if (vetCodigo[i] == Compra) {
				Indisponivel++;
				System.out.print("Qual a quantidade? ");
				Quantidade = sc.nextInt();
				
				if (Quantidade > vetEstoque[i]) {
					System.out.println("Quantidade insuficiente de produtos.");
				} else {
					vetEstoque[i] = vetEstoque[i] - Quantidade;
					System.out.println("Venda efetuada com sucesso!");
				}
				
				}			
			}
		
			System.out.println();
		
			if (Indisponivel == 0) {
				System.out.println("Produto inexistente.");
			}
		}
		
	
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	sc.useLocale(Locale.ENGLISH);
	Locale.setDefault(new Locale("en", "us"));	
	
	int i, N, OpMenu, Procura;
	double vetCodigo[], vetPre�o[], vetEstoque[];
	String vetDescri�ao[];
	
	System.out.print("Quantos produtos voc� deseja inserir? ");
	N = sc.nextInt();
	
	vetCodigo = new double [N];
	vetPre�o = new double [N];
	vetEstoque = new double [N];
	vetDescri�ao= new String [N];
	
	System.out.println();
	
	for (i=0; i < N; i++) {
		System.out.println("Dados do " + (i+1) + "� produto:");
		System.out.println();
		System.out.print("C�digo: ");
		vetCodigo[i] = sc.nextDouble();
		System.out.print("Descri��o: ");
		vetDescri�ao[i] = sc.nextLine();
		vetDescri�ao[i] = sc.nextLine();
		System.out.print("Pre�o: ");
		vetPre�o[i] = sc.nextDouble();
		System.out.print("Quantidade em Estoque: ");
		vetEstoque[i] = sc.nextDouble();
		System.out.println();
	}
	
	ExibirMenu();
	OpMenu = sc.nextInt();
	
	while (OpMenu != 7) {
	
	switch (OpMenu) {
	
	case 1:

	MostrarTabela(N,vetCodigo, vetPre�o, vetDescri�ao, vetEstoque);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
	
	break; 
	
	case 2:
		
	System.out.println();
	System.out.println();
	System.out.print("Digite o c�digo do produto: ");
	Procura = sc.nextInt();
	PesquisarProduto(N, Procura, vetCodigo, vetPre�o, vetEstoque, vetDescri�ao);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
		
	break;
	
	case 3:
	
	ProdutoCaro(N, vetCodigo, vetPre�o, vetEstoque, vetDescri�ao);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
		
	break;
	
	case 4:
		
	EstoqueBaixo(N, vetCodigo, vetEstoque, vetDescri�ao);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
		
	break;
	
	case 5:
	
	TotalEstoque(N, vetPre�o, vetEstoque);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
			
	break;
	
	case 6:
	
	EfetuarVenda(sc, N, vetCodigo, vetEstoque);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
		
	break;
	
	case 7:
					
	sc.close();	
	break;
	
			}
		}
	
	
	System.out.println();
	System.out.println("===================== FIM DO PROGRAMA! =====================");
	sc.close();
	}
}
