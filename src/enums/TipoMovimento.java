package enums;


public enum TipoMovimento {
    ENTRADA(1,"Entrada"),
    SAIDA(2,"Saida");

    private final int id;
    private final String tipo;

    private TipoMovimento(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }
    public String tipo(){
        return  tipo;
    }
}
