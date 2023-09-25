package menu;


import cli.GerenciadorUnidade;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuUnidade {

    private static final Scanner scanner = new Scanner(System.in);
    public static void menuUnidade() {
        GerenciadorUnidade gerenciadorUnidade = new GerenciadorUnidade();

        boolean sair = false;

        while (!sair) {
            exibirMenuUnidade();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    try {
                        gerenciadorUnidade.adicionarUnidade();
                    } catch (SQLException e) {
                        System.out.println(e);
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    GerenciadorUnidade.listarUnidades();
                    break;
                case 3:
                    GerenciadorUnidade.atualizarUnidade();
                    break;
                case 4:
                    GerenciadorUnidade.deletarUnidade();
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

    public static void exibirMenuUnidade() {
        System.out.println("\n--- Menu Unidade ---");
        System.out.println("1 - Adicionar Unidade");
        System.out.println("2 - Listar Unidades");
        System.out.println("3 - Atualizar Unidade");
        System.out.println("4 - Deletar Unidade");
        System.out.println("5 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }
}



