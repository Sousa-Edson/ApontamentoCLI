import menu.MenuMovimentacao;
import menu.MenuProduto;
import menu.MenuSaldo;
import menu.MenuUnidade;

import java.util.Scanner;

public class Main {


        private static final Scanner scanner = new Scanner(System.in);


        public static void main(String[] args) {
            System.out.println("\n### Bem vindo ao ApontamentoCLI ###");

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
                        MenuSaldo.menuSaldo();
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
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Unidades");
            System.out.println("2 - Produtos");
            System.out.println("3 - Movimentações");
            System.out.println("4 - Buscar");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
        }
    }

