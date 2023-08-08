

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Produto;
import model.Unidade;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Produto> listaProdutos = new ArrayList<>();
    private static List<Unidade> listaUnidades = new ArrayList<>();
    private static Unidade unidade;

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Apontamento de Produtos!");

        boolean sair = false;

        while (!sair) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    // Lógica para mexer com produto
                    System.out.println("Você selecionou a opção Produto.");
                    break;
                case 2:
                    // Lógica para mexer com unidade
                    menuUnidade();
                    break;
                case 3:
                    // Lógica para gerar relatório
                    System.out.println("Você selecionou a opção Relatório.");
                    break;
                case 4:
                    // Sair do menu
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        System.out.println("Encerrando a aplicação. Até mais!");

    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1 - Produto");
        System.out.println("2 - Unidade");
        System.out.println("3 - Gerar Relatório");
        System.out.println("4 - Sair");
    }

    // INICIO UNIDADE
    private static void menuUnidade() {
        boolean sair = false;

        while (!sair) {
            exibirMenuUnidade();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarUnidade();
                    break;
                case 2:
                    listarUnidades();
                    break;
                case 3:
                    atualizarUnidade();
                    break;
                case 4:
                    deletarUnidade();
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

    private static void atualizarUnidade() {
        System.out.println("\n--- Atualizar Unidade ---");

        System.out.print("Digite o codigo da unidade: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o novo nome da unidade: ");
        String novoNome = scanner.nextLine();

        System.out.print("Digite o novo símbolo da unidade: ");
        String novoSimbolo = scanner.nextLine();

        for (Unidade unidade : listaUnidades) {
            if (unidade.getCodigo() == codigo) {
                unidade.setNome(novoNome);
                unidade.setSimbolo(novoSimbolo);
                break;
            }
        }
    }

    private static void deletarUnidade() {
        System.out.println("\n--- Deletar Unidade ---");
        System.out.print("Digite o codigo da unidade: ");
        int codigo = scanner.nextInt();
        for (Unidade unidade : listaUnidades) {
            if (unidade.getCodigo() == codigo) {
                listaUnidades.remove(unidade);
                System.out.println("Codigo : " + codigo + " apagado");
                break;
            }
        }
    }

    private static void exibirMenuUnidade() {
        System.out.println("\n--- Menu Unidade ---");
        System.out.println("1 - Adicionar Unidade");
        System.out.println("2 - Listar Unidades");
        System.out.println("3 - Atualizar Unidade");
        System.out.println("4 - Deletar Unidade");
        System.out.println("5 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarUnidade() {
        System.out.println("\n--- Adicionar Unidade ---");
        System.out.print("Digite o nome da unidade: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o símbolo da unidade: ");
        String simbolo = scanner.nextLine();

        Unidade unidade = new Unidade(nome, simbolo);
        listaUnidades.add(unidade);
        System.out.println("Unidade adicionada com sucesso!");
    }

    private static void listarUnidades() {
        System.out.println("\n--- Listagem de Unidades ---");
        for (Unidade unidade : listaUnidades) {
            System.out.println("Codigo: " + unidade.getCodigo() + ", Nome: " + unidade.getNome() + ", Símbolo: " + unidade.getSimbolo());
        }
    }
//FIM UNIDADE
}
