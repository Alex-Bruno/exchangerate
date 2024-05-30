package br.com.alura.conversor.exceptions;

public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException() {
        super("A valor informado é invalido, por fazer coloque um valor maior que 0.");
    }

    public ValorInvalidoException(String message) {
        super(message);
    }
}
