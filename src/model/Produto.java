package model;

public class Produto {
    private static int contador = 0;
    int codigo;
    String nome;
    int quantidade;

    Unidade unidade;

    public Produto() {
    }

    public Produto( String nome, int quantidade,Unidade unidade) {
        this.codigo = ++contador;
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", unidade=" + unidade +
                '}';
    }
}
