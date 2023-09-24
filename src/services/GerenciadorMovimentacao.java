package services;

import enums.TipoMovimento;
import model.Movimentacao;
import model.Produto;

import java.util.Scanner;

import static enums.TipoMovimento.ENTRADA;
import static enums.TipoMovimento.SAIDA;


public class GerenciadorMovimentacao implements GerenciadorEstoque {
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarMovimentacao() {
        TipoMovimento movimento = null;
        System.out.print("Selecione o tipo de movimentação\n1:Entrada\n2:Saida\nInsira aqui:");
        int tipo = scanner.nextInt();
        switch (tipo) {
            case 1:
                movimento = ENTRADA;
                break;
            case 2:
                movimento = TipoMovimento.SAIDA;
                break;
            default:
                movimento = ENTRADA;
                System.out.println("Opção inválida.");
                break;
        }

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

        if (GerenciadorProduto.encontrarProdutoPorId(codigoProduto) != null) {
            movimentacoes.add(new Movimentacao(movimento, GerenciadorProduto.encontrarProdutoPorId(codigoProduto), quantidadeItem));
            System.out.println("\n *** Movimentacao adicionada com sucesso! *** ");
        } else {
            System.err.println("*** Erro ao adicionar movemento! *** ");
        }
    }

    public static void listarMovimentacaos() {
        System.out.println("\n--- Lista de movimentacaos ---");
        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("# " + movimentacao.getCodigo() + " Tipo:" + movimentacao.getTipoMovimento().tipo() + " Nome: " + movimentacao.getProduto().getNome() + " Un: " + movimentacao.getProduto().getUnidade().getSimbolo() + ", Quantidade: " + movimentacao.getQuantidade());
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

    public static void saldoProduto(int codigoProduto) {
        int quantidadeEntrada = 0, quantidadeSaida = 0, saldoFinal = 0;
        System.out.println("\n--- Saldo do produto " + codigoProduto + " ---");
        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.getProduto().getCodigo() == codigoProduto) {
                if (movimentacao.getTipoMovimento().equals(ENTRADA)) {
                    quantidadeEntrada = quantidadeEntrada + movimentacao.getQuantidade();
                }
                if (movimentacao.getTipoMovimento().equals(SAIDA)) {
                    quantidadeSaida = quantidadeSaida + movimentacao.getQuantidade();
                }
            }
        }
        saldoFinal = quantidadeEntrada - quantidadeSaida;
        System.out.println("Produto: " + GerenciadorProduto.encontrarProdutoPorId(codigoProduto).getNome());
        System.out.println("Un: " + GerenciadorProduto.encontrarProdutoPorId(codigoProduto).getUnidade().getSimbolo());
        System.out.println("Entradas: " + quantidadeEntrada);
        System.out.println("Saidas: " + quantidadeSaida);
        System.out.println("Saldo final: " + saldoFinal);
    }
}
