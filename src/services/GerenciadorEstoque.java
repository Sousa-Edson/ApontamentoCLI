package services;

import model.Movimentacao;
import model.Produto;
import model.Unidade;

import java.util.ArrayList;
import java.util.List;

public interface GerenciadorEstoque {
    List<Unidade> unidades = new ArrayList<>();

    List<Produto> produtos = new ArrayList<>();

    List<Movimentacao> movimentacoes = new ArrayList<>();


    public  static void preencheUnidade() {
        unidades.add(new Unidade("unidade", "un"));
        unidades.add(new Unidade("exemplares", "exs"));
        unidades.add(new Unidade("kilo", "kg"));
        unidades.add(new Unidade("pacote", "pct"));
    }

    public static void preencheProduto() {
        produtos.add(new Produto("café", 23, GerenciadorUnidade.encontrarUnidadePorId(1)));
        produtos.add(new Produto("arroz", 34, GerenciadorUnidade.encontrarUnidadePorId(2)));
        produtos.add(new Produto("açucar", 56, GerenciadorUnidade.encontrarUnidadePorId(3)));
        produtos.add(new Produto("sal", 89, GerenciadorUnidade.encontrarUnidadePorId(4)));
    }

}
