package menu;

import services.GerenciadorProduto;

import java.util.Scanner;

public class MenuProduto {

    private static Scanner scanner = new Scanner(System.in);

    public static void menuProduto() {
        boolean sair = false;

        while (!sair) {
            exibirMenuProduto();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    GerenciadorProduto.adicionarProduto();
                    break;
                case 2:
                    GerenciadorProduto.listarProdutos();
                    break;
                case 3:
                    GerenciadorProduto.atualizarProduto();
                    break;
                case 4:
                    GerenciadorProduto.deletarProduto();
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

    public static void exibirMenuProduto() {
        System.out.println("\n--- Menu produto ---");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Atualizar produto");
        System.out.println("4 - Deletar produto");
        System.out.println("5 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }
}



