package services;

import enums.TipoMovimento;
import model.Movimentacao;
import model.Produto;
import model.Unidade;

import java.util.ArrayList;
import java.util.List;

public interface GerenciadorEstoque {
    List<Unidade> unidades = new ArrayList<>();

    List<Produto> produtos = new ArrayList<>();

    List<Movimentacao> movimentacoes = new ArrayList<>();


    static void preencheUnidade() {
        unidades.add(new Unidade("unidade", "un"));
        unidades.add(new Unidade("exemplares", "exs"));
        unidades.add(new Unidade("kilo", "kg"));
        unidades.add(new Unidade("pacote", "pct"));
    }

    static void preencheProduto() {
        produtos.add(new Produto("café",   GerenciadorUnidade.encontrarUnidadePorId(1)));
        produtos.add(new Produto("arroz",   GerenciadorUnidade.encontrarUnidadePorId(2)));
        produtos.add(new Produto("açucar",  GerenciadorUnidade.encontrarUnidadePorId(3)));
        produtos.add(new Produto("sal",   GerenciadorUnidade.encontrarUnidadePorId(4)));
    }

    static void preencheMovimento() {
        movimentacoes.add(new Movimentacao(TipoMovimento.ENTRADA,   GerenciadorProduto.encontrarProdutoPorId(1),159));
        movimentacoes.add(new Movimentacao(TipoMovimento.SAIDA,   GerenciadorProduto.encontrarProdutoPorId(1),98));
        movimentacoes.add(new Movimentacao(TipoMovimento.ENTRADA,   GerenciadorProduto.encontrarProdutoPorId(2),900));
        movimentacoes.add(new Movimentacao(TipoMovimento.ENTRADA,   GerenciadorProduto.encontrarProdutoPorId(2),120));

        movimentacoes.add(new Movimentacao(TipoMovimento.ENTRADA,   GerenciadorProduto.encontrarProdutoPorId(3),200));
        movimentacoes.add(new Movimentacao(TipoMovimento.SAIDA,   GerenciadorProduto.encontrarProdutoPorId(3),77));
        movimentacoes.add(new Movimentacao(TipoMovimento.SAIDA,   GerenciadorProduto.encontrarProdutoPorId(2),24));
        movimentacoes.add(new Movimentacao(TipoMovimento.ENTRADA,   GerenciadorProduto.encontrarProdutoPorId(4),450));
    }


}
