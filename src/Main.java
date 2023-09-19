

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Produto;
import model.Unidade;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Produto> listaProdutos = new ArrayList<>();
    private static final List<Unidade> listaUnidades = new ArrayList<>();
    private static Unidade unidade;

    public static void main(String[] args) {
        preencheUnidade();
        preencheProduto();
        System.out.println("Bem-vindo ao Apontamento de Produtos!");

        boolean sair = false;

        while (!sair) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    // Lógica para mexer com produto
//                    System.out.println("Você selecionou a opção Produto.");
                    menuProduto();
                    break;
                case 2:
                    // Lógica para mexer com unidade
                    menuUnidade();
                    break;
                case 3:
                    // Lógica para movimento
                    menuMovimento();
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
        System.out.println("3 - Gerar Movimento");
        System.out.println("4 - Sair");
    }

    // INICIO PRODUTO
    private static void menuProduto() {
        boolean sair = false;

        while (!sair) {
            exibirMenuProduto();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    deletarProduto();
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


    private static void exibirMenuProduto() {
        System.out.println("\n--- Menu Produto ---");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Deletar Produto");
        System.out.println("5 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void preencheProduto() {
        listaProdutos.add(new Produto("café", 23, unidade = encontrarUnidadePorId(1)));
        listaProdutos.add(new Produto("arroz", 34, unidade = encontrarUnidadePorId(2)));
        listaProdutos.add(new Produto("açucar", 56, unidade = encontrarUnidadePorId(3)));
        listaProdutos.add(new Produto("sal", 89, unidade = encontrarUnidadePorId(4)));
    }

    private static void adicionarProduto() {
        System.out.println("\n--- Adicionar Produto ---");
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        listarUnidades();

        System.out.print("Digite a unidade do produto: ");
        int un = scanner.nextInt();
        unidade = encontrarUnidadePorId(un);

        Produto produto = new Produto(nome, unidade);
        listaProdutos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        System.out.println("\n--- Listagem de Produtos ---");
        for (Produto produto : listaProdutos) {
            System.out.println("Codigo: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Un: " + produto.getUnidade().getSimbolo() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    private static void atualizarProduto() {
        System.out.println("\n--- Atualizar Produto ---");

        System.out.print("Digite o id do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String novoNome = scanner.nextLine();

        listarUnidades();

        System.out.print("Digite a unidade do produto: ");
        int un = scanner.nextInt();
        unidade = encontrarUnidadePorId(un);

        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                produto.setNome(novoNome);
                produto.setUnidade(unidade);
                break;
            }
        }

        System.out.println("Produto adicionado com sucesso!");
    }

    private static void deletarProduto() {
        System.out.println("\n--- Deletar Produto ---");

        System.out.print("Digite o id do produto: ");
        int codigo = scanner.nextInt();

        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                listaProdutos.remove(produto);
                System.out.println("Codigo : " + codigo + " apagado");
                break;
            }
        }
    }


//FIM PRODUTO

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


    private static void exibirMenuUnidade() {
        System.out.println("\n--- Menu Unidade ---");
        System.out.println("1 - Adicionar Unidade");
        System.out.println("2 - Listar Unidades");
        System.out.println("3 - Atualizar Unidade");
        System.out.println("4 - Deletar Unidade");
        System.out.println("5 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void preencheUnidade() {
        listaUnidades.add(new Unidade("unidade", "un"));
        listaUnidades.add(new Unidade("exemplares", "exs"));
        listaUnidades.add(new Unidade("kilo", "kg"));
        listaUnidades.add(new Unidade("pacote", "pct"));
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

    private static Unidade encontrarUnidadePorId(int codigo) {
        Unidade u = new Unidade();
        for (Unidade unidade : listaUnidades) {
            if (unidade.getCodigo() == codigo) {
                u = unidade;
                break;
            }
        }
        return u;
    }

//FIM UNIDADE

    // INICIO UNIDADE
    private static void menuMovimento() {
        boolean sair = false;

        while (!sair) {
            exibirMenuMovimento();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
//                    adicionarUnidade();
                    break;
                case 2:
//                    listarUnidades();
                    break;
                case 3:
//                    atualizarUnidade();
                    break;
                case 4:
//                    deletarUnidade();
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
    private static void exibirMenuMovimento() {
        System.out.println("\n--- Menu Movimento ---");
        System.out.println("1 - Adicionar Movimento");
        System.out.println("2 - Listar Movimentos");
        System.out.println("3 - Atualizar Movimento");
        System.out.println("4 - Deletar Movimento");
        System.out.println("5 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }
}
