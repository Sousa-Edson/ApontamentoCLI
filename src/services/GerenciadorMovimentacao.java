package services;

import conexao.ConexaoMySQL;
import enums.TipoMovimento;
import model.Movimentacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static enums.TipoMovimento.ENTRADA;
import static enums.TipoMovimento.SAIDA;


public class GerenciadorMovimentacao {
    private static final Scanner scanner = new Scanner(System.in);

    public static void adicionarMovimentacao() {
        TipoMovimento movimento;
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
                System.out.println();
            } else {
                sair = true;
            }
        }

        System.out.print("Digite a quantidade do item:");
        int quantidadeItem = scanner.nextInt();
        scanner.nextLine();

        if (GerenciadorProduto.encontrarProdutoPorId(codigoProduto) != null) {
            try (Connection conexao = ConexaoMySQL.obterConexao()) {
                MovimentacaoService movimentacaoService = new MovimentacaoService(conexao);
                movimentacaoService.adicionarMovimentacao(new Movimentacao(movimento, GerenciadorProduto.encontrarProdutoPorId(codigoProduto), quantidadeItem));
                System.out.println("\n *** Movimentacao adicionada com sucesso! *** ");
            } catch (SQLException e) {
                System.out.println("*** Erro ao adicionar movemento! *** ");
                e.printStackTrace();
            }
        } else {
            System.err.println("*** Produto não encontrado! *** ");
        }
    }

    public static void listarMovimentacaos() {
        System.out.println("\n--- Lista de movimentacaos ---");

        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            MovimentacaoService movimentacaoService = new MovimentacaoService(conexao);
            List<Movimentacao> movimentacoes = movimentacaoService.listarMovimentacoes();
            for (Movimentacao movimentacao : movimentacoes) {
                System.out.println("# " + movimentacao.getCodigo()
                        + " Tipo:" + movimentacao.getTipoMovimento().tipo()
                        + " Nome: " + movimentacao.getProduto().getNome()
                        + " Un: " + movimentacao.getProduto().getUnidade().getSimbolo()
                        + ", Quantidade: " + movimentacao.getQuantidade());
            }
        } catch (SQLException e) {
            System.out.println("*** Erro ao adicionar movemento! *** ");
            e.printStackTrace();
        }
    }


    public static void saldoProduto(int codigoProduto) {
        int quantidadeEntrada = 0, quantidadeSaida = 0, saldoFinal;
        System.out.println("\n--- Saldo do produto " + codigoProduto + " ---");

        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            MovimentacaoService movimentacaoService = new MovimentacaoService(conexao);
            List<Movimentacao> movimentacoes = movimentacaoService.listarMovimentacoes();

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

        } catch (SQLException e) {
            System.out.println("*** Erro ao adicionar movemento! *** ");
            e.printStackTrace();
        }



    }
}
