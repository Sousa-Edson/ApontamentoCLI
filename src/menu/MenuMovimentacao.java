package menu;


import cli.GerenciadorMovimentacao;

import java.util.Scanner;

public class MenuMovimentacao {

    private static Scanner scanner = new Scanner(System.in);

    public static void menuMovimentacao() {
        boolean sair = false;

        while (!sair) {
            exibirMenuMovimentacao();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    GerenciadorMovimentacao.adicionarMovimentacao();
                    break;
                case 2:
                    GerenciadorMovimentacao.listarMovimentacaos();
                    break;
                case 3:
//                    GerenciadorMovimentacao.atualizarMovimentacao();
                    break;
                case 4:
//                    GerenciadorMovimentacao.deletarMovimentacao();
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

    public static void exibirMenuMovimentacao() {
        System.out.println("\n--- Menu movimentacao ---");
        System.out.println("1 - Adicionar movimentacao");
        System.out.println("2 - Listar movimentacaos");
        System.out.println("5 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }
}



