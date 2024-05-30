package br.com.alura.conversor.auxiliares;

import br.com.alura.conversor.exceptions.OpcaoInvalidaException;

public class Auxiliar {
    public static String[] getCodigos(int opcao) {
        switch (opcao) {
            case 1:
                return new String[]{"BRL", "ARS"};
            case 2:
                return new String[]{"ARS", "BRL"};
            case 3:
                return new String[]{"USD", "BRL"};
            case 4:
                return new String[]{"BRL", "USD"};
            case 5:
                return new String[]{"BRL", "COP"};
            case 6:
                return new String[]{"COP", "BRL"};
            default:
                throw new OpcaoInvalidaException();
        }
    }
}
