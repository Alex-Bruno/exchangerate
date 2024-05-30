package br.com.alura.conversor.exceptions;

public class OpcaoInvalidaException extends RuntimeException {
    public OpcaoInvalidaException() {
        super("A opção selecionada é invalida, por fazer selecione outra opção.");
    }

    public OpcaoInvalidaException(String message) {
        super(message);
    }
}
