package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Trabalho03 {
	
	/**
	 * Função responsável pela exibição do menu de opções do programa
	 */
	
	public static void ExibirMenu (){
		System.out.println();
		System.out.println("=======================================MENU=======================================");
		System.out.println("1 - Imprimir tabela");
		System.out.println("2 - Pesquisar produto");
		System.out.println("3 - Mostrar dados do produto mais caro");
		System.out.println("4 - Mostrar código e descrição dos produtos cuja quantidade está abaixo de 10");
		System.out.println("5 - Ativo total do estoque");
		System.out.println("6 - Efetuar uma venda");
		System.out.println("7 - Sair");
		System.out.println("==================================================================================");
		System.out.println();
		System.out.print("Qual a opção deseja acessar? ");
		}
	
	/**
	 * Função responsável por exibir a Tabela de Produtos quando o usuário selecionar a opção 1 do Menu
	 * @param N Quantidade de produtos que a tabela possúi
	 * @param vetCodigo Vetor responsável por armazenar os códigos de todos os produtos
	 * @param vetPreço Vetor responsável por armazenar os preços de todos os produtos
	 * @param vetDescriçao Vetor responsável por armazenar a descrição de todos os produtos
	 * @param vetEstoque Vetor responsável por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void MostrarTabela (int N, double[] vetCodigo, double[] vetPreço, String[] vetDescriçao, double[] vetEstoque) {
		
		System.out.println();
		System.out.println();
		System.out.println("===================== TABELA DE PRODUTOS =====================");
		System.out.println("Código | Preço | Estoque | Descrição");
		
		for (int i=0 ; i < N ; i++) {
			System.out.print(vetCodigo[i] + "  |");
			System.out.print(vetPreço[i] + "  |");
			System.out.print(vetEstoque[i] + "    |");
			System.out.println(vetDescriçao[i] + "    ");
			System.out.println("==============================================================");
		}
	}
	
	
	/**
	 * Função responsável pela localização de informações sobre o produto cujo código foi inserido pelo usuário no menu.
	 * @param N Quantidade de produtos que a tabela possúi
	 * @param Procura Código inserido pelo usuário para obter mais informações sobre o mesmo
	 * @param vetCodigo Vetor responsável por armazenar os códigos de todos os produtos
	 * @param vetPreço Vetor responsável por armazenar os preços de todos os produtos
	 * @param vetEstoque Vetor responsável por armazenar a descrição de todos os produtos
	 * @param vetDescriçao Vetor responsável por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void PesquisarProduto (int N, int Procura, double[] vetCodigo, double[] vetPreço, double[] vetEstoque, String[] vetDescriçao) {
		
		int Indisponivel = 0;
		double Total;
		
		for (int i=0 ; i < N ; i++) {
			
			if (vetCodigo[i] == Procura) {
				
			Total = vetPreço[i] * vetEstoque[i];
			System.out.println();
			System.out.println("===================== INFORMAÇÕES =====================");
			System.out.println("Código | Preço | Estoque | Total | Descrição");
			System.out.print(vetCodigo[i] + "  |");
			System.out.print(vetPreço[i] + "  |");
			System.out.print(vetEstoque[i] + "    |");
			System.out.print(Total + "    |");
			System.out.println(vetDescriçao[i] + "    ");
			System.out.println("=======================================================");
			
			Indisponivel++;
			
			} if (Indisponivel == 0) {
				System.out.println();
				System.out.println("Este produto não existe.");
				
			}
		}
		
	}
	
	/**
	 * Função responsável por exibir as informações do produto mais caro existente no cadastro do programa
	 * @param N Quantidade de produtos que a tabela possúi
	 * @param vetCodigo Vetor responsável por armazenar os códigos de todos os produtos
	 * @param vetPreço Vetor responsável por armazenar os preços de todos os produtos
	 * @param vetEstoque Vetor responsável por armazenar a descrição de todos os produtos
	 * @param vetDescriçao Vetor responsável por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void ProdutoCaro (int N, double[] vetCodigo, double[] vetPreço, double[] vetEstoque, String[] vetDescriçao) {
		
		int posiçao = 0;
		double Maior = 0.0;
		
		for (int i=0 ; i < N ; i++) {
			
			if (vetPreço[i] > Maior) {
				Maior = vetPreço[i];
				posiçao = i;
			}
		}
		
		System.out.println();
		System.out.println("===================== PRODUTO MAIS CARO =====================");
		System.out.println("Código | Preço | Estoque | Total | Descrição");
		System.out.print(vetCodigo[posiçao] + "  |");
		System.out.print(vetPreço[posiçao] + "  |");
		System.out.print(vetEstoque[posiçao] + "    |");
		System.out.println(vetDescriçao[posiçao] + "    ");
		System.out.println("=============================================================");		
		
		
	}
	
	/**
	 * Função responsável por analisar e apresentar os produtos cujo estoque está inferior a 10 peças
	 * @param N Quantidade de produtos que a tabela possúi
	 * @param vetCodigo Vetor responsável por armazenar os códigos de todos os produtos
	 * @param vetEstoque Vetor responsável por armazenar a descrição de todos os produtos
	 * @param vetDescriçao Vetor responsável por armazenar a quantidade em estoque de todos os produtos
	 */
	
	public static void EstoqueBaixo (int N,  double[] vetCodigo, double[] vetEstoque, String[] vetDescriçao) {
		
		System.out.println();
		System.out.println("===================== ESTOQUE BAIXO =====================");
		System.out.println("Código | Descrição");
		
		for (int i=0 ; i < N ; i++) {
			
			if (vetEstoque[i] < 10) {
				System.out.print(vetCodigo[i] + "  |");
				System.out.println(vetDescriçao[i] + "    ");
			}
						
		}
		
		System.out.println("=========================================================");
		
	}
	
	/**
	 * Função responsável por calcular o valor de todo o estoque, multiplicando preço de produto com quantidade em estoque
	 * @param N Quantidade de produtos que a tabela possúi
	 * @param vetPreço Vetor responsável por armazenar os preços de todos os produtos
	 * @param vetEstoque Vetor responsável por armazenar a descrição de todos os produtos
	 */
	
	public static void TotalEstoque (int N, double[] vetPreço, double[] vetEstoque) {
		
		double Total = 0.0;
		
		System.out.println();
		
		for (int i=0 ; i < N ; i++){
			
			Total = vetPreço[i] * vetEstoque[i] + Total;
			
		}
		
		System.out.println("===================== VALOR ESTOQUE =====================");
		System.out.println("Valor total do estoque: " + Total);
		System.out.println("=========================================================");
	}
	
	/**
	 * Função responsável por verificar se o produto desejado pelo consumidor esta disponivel em estoque, se tem a quantidade o suficiente e que realiza a venda.
	 * @param sc Recebe a declaração do scanner onde o usuario deve digitar o código do produto desejado
	 * @param N Quantidade de produtos que a tabela possúi
	 * @param vetCodigo Vetor responsável por armazenar os códigos de todos os produtos
	 * @param vetEstoque Vetor responsável por armazenar a descrição de todos os produtos
	 */
	
	public static void EfetuarVenda (Scanner sc, int N, double[] vetCodigo, double[] vetEstoque) {
		
		int Quantidade, Indisponivel=0;
		double Compra;
		
		System.out.println();
		
		System.out.print("Qual o código do produto que deseja adquirir? ");
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
	double vetCodigo[], vetPreço[], vetEstoque[];
	String vetDescriçao[];
	
	System.out.print("Quantos produtos você deseja inserir? ");
	N = sc.nextInt();
	
	vetCodigo = new double [N];
	vetPreço = new double [N];
	vetEstoque = new double [N];
	vetDescriçao= new String [N];
	
	System.out.println();
	
	for (i=0; i < N; i++) {
		System.out.println("Dados do " + (i+1) + "° produto:");
		System.out.println();
		System.out.print("Código: ");
		vetCodigo[i] = sc.nextDouble();
		System.out.print("Descrição: ");
		vetDescriçao[i] = sc.nextLine();
		vetDescriçao[i] = sc.nextLine();
		System.out.print("Preço: ");
		vetPreço[i] = sc.nextDouble();
		System.out.print("Quantidade em Estoque: ");
		vetEstoque[i] = sc.nextDouble();
		System.out.println();
	}
	
	ExibirMenu();
	OpMenu = sc.nextInt();
	
	while (OpMenu != 7) {
	
	switch (OpMenu) {
	
	case 1:

	MostrarTabela(N,vetCodigo, vetPreço, vetDescriçao, vetEstoque);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
	
	break; 
	
	case 2:
		
	System.out.println();
	System.out.println();
	System.out.print("Digite o código do produto: ");
	Procura = sc.nextInt();
	PesquisarProduto(N, Procura, vetCodigo, vetPreço, vetEstoque, vetDescriçao);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
		
	break;
	
	case 3:
	
	ProdutoCaro(N, vetCodigo, vetPreço, vetEstoque, vetDescriçao);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
		
	break;
	
	case 4:
		
	EstoqueBaixo(N, vetCodigo, vetEstoque, vetDescriçao);
	System.out.println();
	System.out.println();
	ExibirMenu();
	OpMenu = sc.nextInt();
		
	break;
	
	case 5:
	
	TotalEstoque(N, vetPreço, vetEstoque);
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
