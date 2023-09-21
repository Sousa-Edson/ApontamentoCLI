package services;

import model.Produto;
import model.Unidade;

import java.util.Scanner;


public class GerenciadorProduto implements GerenciadorEstoque {
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarProduto() {
        System.out.println("\n--- Adicionar produto ---");
        System.out.print("Digite o nome da produto:");
        String nome = scanner.nextLine();

        GerenciadorUnidade.listarUnidades();

        System.out.print("\nDigite o codigo da unidade:");
        int codigoUnidade = scanner.nextInt();
        scanner.nextLine();
        produtos.add(new Produto(nome, GerenciadorUnidade.encontrarUnidadePorId(codigoUnidade)));
        System.out.println("\n *** Produto adicionada com sucesso! *** ");
    }

    public static void listarProdutos() {
        System.out.println("\n--- Lista de produtos ---");
        for (Produto produto : produtos) {
            System.out.println("# " + produto.getCodigo() + " Nome: " + produto.getNome() + ", Un: " + produto.getUnidade().getSimbolo());
        }
    }

    public static void atualizarProduto() {
        System.out.println("\n--- Atualizar produto ---");

        System.out.print("Digite o codigo da produto:");
        int codigo = scanner.nextInt();

        if (GerenciadorProduto.encontrarProdutoPorId(codigo) != null) {
            scanner.nextLine();

            System.out.print("Digite o nome da produto:");
            String nome = scanner.nextLine();

            GerenciadorUnidade.listarUnidades();

            System.out.print("\nDigite o codigo da unidade:");
            int codigoUnidade = scanner.nextInt();

            scanner.nextLine();

            for (Produto produto : produtos) {
                if (produto.getCodigo() == codigo) {

                    if (!nome.isEmpty()) {
                        produto.setNome(nome);
                    }

                    produto.setUnidade(GerenciadorUnidade.encontrarUnidadePorId(codigoUnidade));

                    System.out.println("\n *** Produto alterada com sucesso! *** ");
                    break;
                }
            }
        } else {
            System.out.println("Produto não encontrada");
        }
    }

    public static void deletarProduto() {
        System.out.println("\n--- Deletar Produto ---");
        System.out.print("Digite o codigo da produto: ");
        int codigo = scanner.nextInt();
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
                System.out.println("\n*** Codigo : " + codigo + " apagado ***");
                break;
            }
        }
    }

    public static Produto encontrarProdutoPorId(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }
}
