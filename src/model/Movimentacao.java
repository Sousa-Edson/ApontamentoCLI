package model;

import enums.TipoMovimento;

public class Movimentacao {

    int codigo;
    TipoMovimento tipoMovimento;
    Produto produto;
    int quantidade;

    public Movimentacao() {
    }



    public Movimentacao(TipoMovimento tipoMovimento, Produto produto, int quantidade) {

        this.tipoMovimento = tipoMovimento;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
