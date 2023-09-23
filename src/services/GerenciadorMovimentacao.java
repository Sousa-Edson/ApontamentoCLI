package services;

import model.Movimentacao;
import model.Produto;

import java.util.Scanner;


public class GerenciadorMovimentacao implements GerenciadorEstoque {
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarMovimentacao() {
        System.out.println("\n--- Adicionar movimentacao ---");
        boolean sair = false;
        int codigoProduto = 0;
        while (!sair) {
            System.out.print("Digite o id do produto:");
            codigoProduto = scanner.nextInt();
            if (codigoProduto == 0) {
                GerenciadorProduto.listarProdutos();
                System.out.println("");
                sair = false;
            } else {
                sair = true;
            }
        }

        System.out.print("Digite a quantidade do item:");
        int quantidadeItem = scanner.nextInt();
        scanner.nextLine();

        Produto produto = new Produto();
        produto.setCodigo(codigoProduto);
        movimentacoes.add(new Movimentacao(produto, quantidadeItem));
        System.out.println("\n *** Movimentacao adicionada com sucesso! *** ");
    }

    public static void listarMovimentacaos() {
        System.out.println("\n--- Lista de movimentacaos ---");
        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("# " + movimentacao.getCodigo() + " Nome: " + movimentacao.getProduto() + ", Quantidade: " + movimentacao.getQuantidade());
        }
    }

    public static void atualizarMovimentacao() {
        System.out.println("\n--- Atualizar movimentacao ---");

        System.out.print("Digite o codigo da movimentacao:");
        int codigo = scanner.nextInt();

        if (GerenciadorMovimentacao.encontrarMovimentacaoPorId(codigo) != null) {
            scanner.nextLine();

            System.out.print("Digite o nome da movimentacao:");
            String nome = scanner.nextLine();

            GerenciadorUnidade.listarUnidades();

            System.out.print("\nDigite o codigo da unidade:");
            int codigoUnidade = scanner.nextInt();

            scanner.nextLine();

            for (Movimentacao movimentacao : movimentacoes) {
                if (movimentacao.getCodigo() == codigo) {

                    if (!nome.isEmpty()) {
//                        movimentacao.setNome(nome);
                    }

//                    movimentacao.setUnidade(GerenciadorUnidade.encontrarUnidadePorId(codigoUnidade));

                    System.out.println("\n *** Movimentacao alterada com sucesso! *** ");
                    break;
                }
            }
        } else {
            System.out.println("Movimentacao não encontrada");
        }
    }

    public static void deletarMovimentacao() {
        System.out.println("\n--- Deletar Movimentacao ---");
        System.out.print("Digite o codigo da movimentacao: ");
        int codigo = scanner.nextInt();
        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.getCodigo() == codigo) {
                movimentacoes.remove(movimentacao);
                System.out.println("\n*** Codigo : " + codigo + " apagado ***");
                break;
            }
        }
    }

    public static Movimentacao encontrarMovimentacaoPorId(int codigo) {
        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.getCodigo() == codigo) {
                return movimentacao;
            }
        }
        return null;
    }
}
