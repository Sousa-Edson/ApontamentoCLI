import menu.MenuMovimentacao;
import menu.MenuProduto;
import menu.MenuUnidade;
import services.GerenciadorEstoque;
import java.util.Scanner;

public class Main {


        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

            GerenciadorEstoque.preencheUnidade();
            GerenciadorEstoque.preencheProduto();

            boolean sair = false;

            while (!sair) {
                exibirMenuPrincipal();
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        MenuUnidade.menuUnidade();
                        break;
                    case 2:
                        MenuProduto.menuProduto();
                        break;
                    case 3:
                        MenuMovimentacao.menuMovimentacao();
                        break;
                    case 4:

                        break;
                    case 5:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }

        private static void exibirMenuPrincipal() {
            System.out.println("\n### Bem vindo ao ApontamentoCLI ###\n");
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Unidades");
            System.out.println("2 - Produtos");
            System.out.println("3 - Movimentações");
            System.out.println("4 - Buscar");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
        }
    }

