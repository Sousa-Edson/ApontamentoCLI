package formatar;


import java.text.DecimalFormat;

public class FormatarNumero {
    public static String returnaMilhar(int valorInteiro) {

        // Cria um objeto DecimalFormat para formatar o número com separador de milhares
        DecimalFormat formato = new DecimalFormat("#,###");

        // Formata o número
        return  formato.format(valorInteiro);

    }
}
